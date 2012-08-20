define(['dojo/dom','dojo/cookie', 'dojo/parser', 'dijit/form/Button', 'dijit/form/Select', 'dijit/form/CheckBox', 'dijit/form/Form', 'dijit/registry',
        'dojox/form/uploader/FileList', 'dojo/_base/xhr', 'app/util/jsUtils', 'dojox/form/Uploader', 'dojox/form/uploader/plugins/Flash'],
		function(dom, cookie, parser, Button, Select, CheckBox, Form, registry, FileList, xhr, jsUtils){
		
	var modConfig,
		forma,
		btnCargar,
		btnReset,
		uploader,
		list;
	
	function init(config){
		config.contenedor.set('content', config.template);
		modConfig = config;
		
		xhr.get({
			handleAs: "json",
			url: dojo.config.app.urlBase + "archivos/paths",
			load: function(paths){
				if(jsUtils.isEmpty(paths)){
					btnCargar.set('disabled', true);
		    		dojo.publish("/app/notificacion",[{
		    			message: 'No se encontró ningún directorio.',
		    			type: "error",
		    			duration: 4000
		    		}]);		
		    		// Sin directorios no podemos hacer nada, así que cerramos el Tab.
		    		modConfig.cerrarTab();
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
				new Select({
					id: 'sltDirectorioCarga',
	                name: "path",
	                options: opciones,
				}, 'sltDirectorioCarga');
			}
		});		
		
		new CheckBox({
			name: "guardaBD",
			checked: true
		}, 'chkGuardarEnBase');		
		
		forma = new Form({
			method: 'post',
			enctype: 'multipart/form-data',
			'class': 'Uploader',
			action: dojo.config.app.urlBase + 'archivos/upload'
		}, 'cargaForm');
		
	    btnCargar = new Button({
	        type: 'submit',
	        label: 'Cargar'
	    }, 'submitCarga');	
	    
	    btnReset = new Button({
	    	type: 'reset',
	    	label: 'Limpiar',
	    	onClick: function(){
	    		// limpiamos el array de archivos agregados
	    		uploader.reset();
	    		console.log(uploader.getFileList());
	    	}
	    }, 'resetForm');
	    
	    uploader = new dojox.form.Uploader({
	    	id: 'uploader',
	    	name: 'uploadedfile',
	    	showInput: 'before',
	    	isDebug: true,
	    	url: dojo.config.app.urlBase + 'archivos/upload',
	    	multiple: true,
	    	force: '',
	    	onComplete: function(respuesta){
	    		console.log(respuesta);
	    		if(respuesta.claveError){
		    		dojo.publish("/app/notificacion",[{
		    			message: respuesta.mensaje,
		    			type: "error",
		    			duration: 4000
		    		}]);	    			
		    		return;
	    		}
	    		dojo.publish("/app/notificacion",[{
	    			message: "Archivos guardados correctamente.",
	    			type: "message",
	    			duration: 4000
	    		}]);
	    	},
	    	onChange: function(archivos){
	    		// Aquí se podrían listar los archivos en alguna tabla. 
	    		console.log(archivos);
	    	}
	    }, 'uploader');
	    uploader.startup();	    
	    
	}

	return{
    	init: init
    };
});

