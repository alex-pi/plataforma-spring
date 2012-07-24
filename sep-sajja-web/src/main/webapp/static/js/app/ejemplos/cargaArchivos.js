define(['dojo/dom','dojo', 'dojo/domReady!', 'dojo/parser', 'dijit/form/Button', 'dijit/form/Form', 'dijit/registry',
        'dojox/form/Uploader', 'dojox/form/uploader/FileList', 'dojox/form/uploader/plugins/Flash',],
		function(util, dojo, dr, parser, Button, Form, registry, Uploader, FileList, uFlash){
		
	var modConfig,
		forma,
		btnCargar,
		btnReset,
		uploader,
		list;
    
//	parser.parse();

//	var handleUpload = function(upl, node){
//		dojo.connect(upl, "onComplete", function(dataArray){
//			dojo.forEach(dojo.isArray(dataArray)?dataArray:[dataArray], function(file){
//				console.log("display:", file);
//
//				var div = dojo.create('div', {className:'thumb'});
//				var span = dojo.create('span', {className:'thumbbk'}, div);
//				var img = dojo.create('img', {src:file.file}, span);
//				node.appendChild(div);
//			});
//		});
//	},
//	
//	handleDnD = function(domnode, uploader){
//		if(uploader.addDropTarget && uploader.uploadType=='html5'){
//			dojo.create('div',{innerHTML:'Drag and Drop files to this fieldset'}, domnode,'last');
//			uploader.addDropTarget(domnode);
//		}
//	};
	


//	var uploader = new Uploader({
//		
//	}).placeAt();
//	dojo.connect(registry.byId("remBtn"), "onclick", uploader,"reset");
	
//	handleUpload(uploader, dojo.byId('colImages'));
//	if(require.has('file-multiple')){
//		handleDnD(uploader.domNode.parentNode, uploader);
//	}
	
	function init(config){
		config.contenedor.set('content', config.template);
		modConfig = config;
		
		forma = new Form({
			method: 'post',
			enctype: 'multipart/form-data',
			'class': 'Uploader',
			action: dojo.config.app.urlBase + 'upload/cargaArchivos'
		}, 'cargaForm');
		forma.startup();
		
		dojo.connect(forma, "onsubmit", function(event){
		    dojo.stopEvent(event);
		});
		
	    btnCargar = new Button({
//	        iconClass: 'dijitIconKey',
	        type: 'submit',
	        label: 'Cargar',
	        onClick: function(event){
	        	alert('sdasdsa');
	        	dojo.stopEvent(event);
//	        	uploader.upload();
	        }
	    }, 'submitGarga');	
	    
	    btnReset = new Button({
//	        iconClass: 'dijitIconKey',
	    	type: 'button',
	    	label: 'Limpiar',
	    	onClick: function(){
	    	}
	    }, 'resetForm');	
	    
	    uploader = new Uploader({
	    	name: 'uploadedfile',
	    	showInput: 'before',
	    	isDebug: true,
	    	label: 'Seleccione archivos.',
	    	url: dojo.config.app.urlBase + 'upload/cargaArchivos',
	    	multiple: true
	    }, 'uploader');
	    uploader.startup();
	    
	    list = new FileList({
	    	uploader: uploader
	    }, 'listaArchivos');
	    list.startup();
	}

	return{
    	init: init
    };
});

