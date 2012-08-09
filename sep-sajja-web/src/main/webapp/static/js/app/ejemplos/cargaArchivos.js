define(['dojo/dom','dojo/cookie', 'dojo/parser', 'dijit/form/Button', 'dijit/form/Select', 'dijit/form/CheckBox', 'dijit/form/Form', 'dijit/registry',
        'dojox/form/uploader/FileList', 'dojo/_base/xhr', 'dojox/form/Uploader', 'dojox/form/uploader/plugins/Flash'],
		function(dom, cookie, parser, Button, Select, CheckBox, Form, registry, FileList, xhr){
		
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
				var opciones = [];
				for (var prop in paths) {
					opciones.push({
						value: prop,
						label: paths[prop]
					});
				}
				opciones[0].selected =  true;
				new Select({
	                name: "path",
	                options: opciones,
				}, 'sltDirectorio');
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
	    		dojo.publish("/app/notificacion",[{
	    			message: "Archivos guardados correctamente.",
	    			type: "message",
	    			duration: 4000
	    		}]);	    		
	    		// Aqui se puede hacer algo con el objeto de respuesta que se devuelve.
	    		console.log(respuesta);
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

