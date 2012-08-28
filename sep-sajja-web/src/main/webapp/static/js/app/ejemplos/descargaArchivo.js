define(['dojo/dom', 'dijit/form/Button', 'dojo/on',
        'dijit/form/Select','dijit/form/Form', 'dijit/registry',
        'dojo/_base/xhr', 'dojo/_base/array', 'app/util/jsUtils'],
		function(dom, Button, on, Select, Form, registry, xhr, arrayUtil, jsUtils){
		
	var modConfig,
		forma,
		btnDescarga,
		sltArchivos,
		sltDirectorio;
	
	// No se usa en el ejemplo, pero muestra una configuración básica
	// de iframe que puede ser usada para cargar y descargar archivos.
	function descargar(){
		iframe.send({
		    form: forma.domNode,
		    // Callback on successful call:
		    load: function(response, ioArgs){

		        // return the response for succeeding callbacks
		        return response;
		    },
		    error: function(response, ioArgs){
		        console.log(response);

		        // return the response for succeeding callbacks
		        return response;
		    }		    
		});		
	}
	
	function mostrarListaArchivos(pathId){
		if(!pathId)
			return;
		
		return xhr.get({
			handleAs: "json",
			url: dojo.config.app.urlBase + "archivos/listar/" + pathId,
			preventCache: true,
			load: function(archivos){
				sltArchivos.removeOption(sltArchivos.getOptions());
				if(!archivos || archivos.length === 0){
					btnDescarga.set('disabled', true);
					return;
				}
				btnDescarga.set('disabled', false);
				arrayUtil.forEach(archivos, function(archivo){
					sltArchivos.addOption({
						value: archivo,
						label: archivo
					});					
				});
			}
		});			
	}
	
	function init(config){
		config.contenedor.set('content', config.template);
		modConfig = config;
		
		xhr.get({
			handleAs: "json",
			url: dojo.config.app.urlBase + "archivos/paths",
			preventCache: true,
			load: function(paths){
				if(jsUtils.isEmpty(paths)){
					btnDescarga.set('disabled', true);
		    		dojo.publish("/app/notificacion",[{
		    			message: 'No se encontró ningún directorio.',
		    			type: "error",
		    			duration: 4000
		    		}]);
		    		return;
				}
				var opciones = [];
				for (var prop in paths) {
					opciones.push({
						value: prop,
						label: paths[prop]
					});
				}
				opciones[0].selected =  true;
				sltDirectorio = new Select({
	                name: "path",
	                options: opciones,
	                onChange: mostrarListaArchivos
				}, 'sltDirectorio');
				mostrarListaArchivos(sltDirectorio.get('value'));
			}
		});		
		
		sltArchivos = new Select({
            name: "nombreArchivo",
            onChange: function(nom){
            	forma.set('action', dojo.config.app.urlBase + 'archivos/download/' + nom);            	
            }
		}, 'sltArchivo');
		
		forma = new Form({
			method: 'get',
			target: '_blank'
		}, 'descargaForm');
		
	    btnDescarga = new Button({
	        type: 'submit',
	        label: 'Descargar',
	        disabled: true
	    }, 'btnDescarga');	    	   	    
	}

	return{
    	init: init
    };
});

