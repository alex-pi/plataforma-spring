define(['dojo/dom','dojo/cookie', 'dojo/parser', 'dijit/form/Button', 'dijit/form/Form', 'dijit/registry',
        'dojox/form/uploader/FileList', 'dojox/form/Uploader', 'dojox/form/uploader/plugins/Flash'],
		function(dom, cookie, parser, Button, Form, registry, FileList){
		
	var modConfig,
		forma,
		btnCargar,
		btnReset,
		uploader,
		list;
	
	function init(config){
		config.contenedor.set('content', config.template);
		modConfig = config;
		
		forma = new Form({
			method: 'post',
			enctype: 'multipart/form-data',
			'class': 'Uploader',
			action: dojo.config.app.urlBase + 'upload/cargaArchivos'
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
	    	url: dojo.config.app.urlBase + 'upload/cargaArchivos',
	    	multiple: true,
	    	force: '',
	    	onComplete: function(respuesta){
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

