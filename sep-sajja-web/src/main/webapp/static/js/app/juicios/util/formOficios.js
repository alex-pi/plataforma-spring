define([
	"app/util/text!static/html/juicios/util/formOficios.html!strip;no-cache",
	"app/util/constants",
	"dijit/form/Form",
	"dijit/form/ValidationTextBox",
	"dijit/form/FilteringSelect",
	"dijit/form/CheckBox",
	"dijit/form/DateTextBox",
	"dijit/form/SimpleTextarea",
	"app/util/jsUtils",
	"dojo/dom-construct",
	"dojo/_base/lang",
	"dojo/dom-form",
	"dijit/form/Button",
	"dojo/aspect",
	"dijit/registry",
	"dojox/timing/doLater",
	"dijit/Dialog",
	'dojox/form/Uploader',
	'dojox/form/uploader/FileList', 
	'dojo/_base/xhr', 'dojo/dom','dojo/cookie', 'dojo/parser',
	"dojo/on",
	"dojo/dom", "dojo/dom-style",
	"dojo/io/iframe",
	//"dojox/form/uploader/plugins/IFrame"
	"dojox/form/uploader/plugins/Flash"
], function(
	template,
	constants,
	Form,
	ValidationTextBox,
	FilteringSelect,
	CheckBox,
	DateTextBox,
	SimpleTextarea,
	jsUtils,
	domConstruct,
	lang,
	domForm,
	Button,
	aspect,
	registry,
	doLater,
	Dialog,
	Uploader,FileList, xhr,dom, cookie, parser,
	on,
	dom,
	domStyle,
	ioIframe
){
	var formOficio, idSubdireccion, idDepto, idAbogado, noOficio, idTipoAsunto;
	var fechaOficio, asunto, destinatario, observaciones, idAsunto, uploader, anio, idOficio;
	var _idSubdireccion, _idDepto, _idTipoAsunto, _idAbogado; 
	
	var dialogFormOficio;
	var _idDeptoLoad, _idAbogadoLoad;
	var objectWidget = function(){
		return {
			idSubdireccion: idSubdireccion,
			idDepto: idDepto,
			idTipoAsunto: idTipoAsunto,
			idAbogado: idAbogado,
			noOficio: noOficio,
			asunto: asunto,
			destinatario: destinatario,
			fechaOficio: fechaOficio,
			observaciones: observaciones,
			idAsunto: idAsunto,
			anio: anio,
			referencia: idOficio
		}
	};
	
	
		
	var aleatorio = null;
	var _configModule;
	
	function init( configModule ){
		_configModule = configModule;
		if ( registry.byId("dialogFormOficio") ){
			dialogFormOficio = registry.byId("dialogFormOficio");
		}else{
			aleatorio = Math.floor(Math.random() * 1000);
			var output = lang.replace(
				template,
				{ aleatorio: aleatorio }
			);
			dialogFormOficio = new Dialog({
				title: "Departamento",
				content: output,
				//style: "width: 700px",
				id: 'dialogFormOficio'
			});
			initForm();
			initBotones();
		}
	}
	
	function initForm(){
		formOficio = new Form({ 
			id: 'formOficio' + aleatorio , 
			method: 'post',	
			enctype: 'multipart/form-data',	
			'class': 'Uploader', 
			action: dojo.config.app.urlBase + 'juicios/util/oficios/agregar',
			target: 'hiddenIFrame'
		}, 'formOficio' + aleatorio);
		
		idAsunto = new ValidationTextBox({
			name: 'idAsunto',
			id: 'idAsunto' + aleatorio,
			type: 'hidden'
		}, 'idAsunto'+ aleatorio);
		anio = new ValidationTextBox({
			name: 'anio',
			id: 'anio' + aleatorio,
			type: 'hidden'
		}, 'anio'+ aleatorio);
		idOficio = new ValidationTextBox({
			name: 'idOficio',
			id: 'idOficio' + aleatorio,
			type: 'hidden'
		}, 'idOficio'+ aleatorio);
		_idSubdireccion = new ValidationTextBox({
			name: '_idSubdireccion',
			id: '_idSubdireccion' + aleatorio,
			type: 'hidden'
		}, '_idSubdireccion'+ aleatorio);
		_idDepto = new ValidationTextBox({
			name: '_idDepto',
			id: '_idDepto' + aleatorio,
			type: 'hidden'
		}, '_idDepto'+ aleatorio);
		_idTipoAsunto = new ValidationTextBox({
			name: '_idTipoAsunto',
			id: '_idTipoAsunto' + aleatorio,
			type: 'hidden'
		}, '_idTipoAsunto'+ aleatorio);
		_idAbogado = new ValidationTextBox({
			name: '_idAbogado',
			id: '_idAbogado' + aleatorio,
			type: 'hidden'
		}, '_idAbogado'+ aleatorio);
		
		idAbogado = new FilteringSelect({
			name: "idAbogado",
			id: 'idAbogado' + aleatorio,
			searchAttr: "nombreCompleto",
			placeHolder: 'Seleccione el abogado asignado al caso',
			style: constants.DEFAULT_STYLE,
			required: true
		}, "idAbogado"+ aleatorio);
		
		idDepto = new FilteringSelect({
			name: "idDepto",
			id: 'idDepto' + aleatorio,
			searchAttr: "descripcion",
			placeHolder: 'Seleccione el departamento',
			style: constants.DEFAULT_STYLE,
			required: true
		}, "idDepto"+ aleatorio);
		var signalEventIdDepto = aspect.after(idDepto, "openDropDown", function() {
			idDepto.dropDown.on("click", function() {
				//idAbogado.set('store', null);
				_idAbogadoLoad = null;
				changeIdDepto( idDepto.item.idDepto );
			});        
			signalEventIdDepto.remove();            
		});
		
//		jsUtils.getMemory({
//			urlBase: _configModule.urlBase,
//			requestMapping: 'administracion/subdireccion/todos',
//			load: function( object ){
//				idSubdireccion = new FilteringSelect({
//					name: "idSubdireccion",
//					id: 'idSubdireccion' + aleatorio,
//					store: object,
//					searchAttr: "descripcion",
//					placeHolder: 'Seleccione la subdirecci\u00F3n',
//					style: constants.DEFAULT_STYLE,
//					required: true
//				}, "idSubdireccion"+ aleatorio);
//				var signalEvent = aspect.after(idSubdireccion, "openDropDown", function() {
//					idSubdireccion.dropDown.on("click", function() {
//						//idAbogado.set('store', null);
//						_idDeptoLoad = null;
//						changeIdSubDireccion( idSubdireccion.item.idSubdireccion );
//					});        
//					signalEvent.remove();            
//				});
//			}
//		});
		
//		jsUtils.getMemory({
//			urlBase: _configModule.urlBase,
//			requestMapping: 'administracion/tipoAsunto/todos',
//			load: function( object ){
//				idTipoAsunto = new FilteringSelect({
//					name: "idTipoAsunto",
//					id: 'idTipoAsunto' + aleatorio,
//					store: object,
//					searchAttr: "descripcion",
//					placeHolder: 'Seleccione el tipo de asunto',
//					style: constants.DEFAULT_STYLE,
//					required: true
//				}, "idTipoAsunto"+ aleatorio);
//			}
//		});
		
		noOficio = new ValidationTextBox({
			name: 'noOficio',
			id: 'noOficio' + aleatorio,
			placeHolder: 'Ingresa el n\u00FAmero de oficio',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.DEFAULT_STYLE,
			required: true,
			uppercase: true,
			maxLength: 250
		}, 'noOficio'+ aleatorio);
		
		fechaOficio = new DateTextBox({
			name: 'fechaOficio',
			id:"fechaOficio" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha del oficio',
			required: true,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaOficio' + aleatorio);
		
		asunto = new ValidationTextBox({
			name: 'asunto',
			id: 'asunto' + aleatorio,
			placeHolder: 'Especifique brevemente el asunto',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.BIG_BIG_STYLE,
			required: true,
			uppercase: true,
			maxLength: 100	
		}, 'asunto'+ aleatorio);
		
		destinatario = new ValidationTextBox({
			name: 'destinatario',
			id: 'destinatario' + aleatorio,
			placeHolder: 'Especifique el destinatario del oficio',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.BIG_BIG_STYLE,
			required: true,
			uppercase: true,
			maxLength: 100	
		}, 'destinatario'+ aleatorio);
		
		observaciones = new SimpleTextarea({
			name: "observaciones",
			id: 'observaciones'  + aleatorio,
			rows: "3",
			cols: "93",
			style: constants.BIG_BIG_STYLE,
			regExp: constants.CHARACTERS_VALID,
			required: false,
			missingMessage: 'Obligatorio',
			invalidMessage: "La informaci\u00F3n capturada contiene caracteres invalidos.",
			placeHolder: 'Ingresa las observaciones del oficio'
		}, "observaciones"  + aleatorio);
		
		uploader = new dojox.form.Uploader({
			id: 'uploader',
			name: 'uploadedfile',
			showInput: 'before',
			isDebug: true,
			multiple: false,
			force: '',
			uploadOnSelect: false,
			label: "Seleccione el archivo para adjuntar",
			fileMask:[
				["Documento MsWord", "*.doc;*.docx"],
				["Hoja de c\u00E1lculo MsExcel", "*.xls;*.xlsx"],
				["PDF", "*.pdf"]
			],
			onComplete: function(respuesta){
				console.log('Completado: ',respuesta);
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
				console.log('Seleccinando: ' , archivos);
				var result = jsUtils.validFileFilter( archivos[0].type );
				if ( result != true ){
					alert('Solo se permiten archivos con extenciones: ' + result );
					uploader.reset();
					uploader.startup();
				}
				
			}
		}, 'archivo' + aleatorio);
		uploader.startup();
		
		/*on(uploader, 'complete', function( data ){
			console.log('----Completado: ',data);
			if(data.claveError){
				dojo.publish("/app/notificacion",[{
					message: data.mensaje,
					type: "error",
					duration: 4000
				}]);	    			
				return;
			}
			dojo.publish("/app/notificacion",[{
				message: "El Oficio fue guardado correctamente.",
				type: "message",
				duration: 4000
			}]);
		} );
		on(uploader, 'complete', function( data ){
			console.log(' on Seleccinando: ' , data);
		} );*/
		
		formOficio.startup();
		var formJson = domForm.toJson( 'formOficio' + aleatorio );
		console.log("Termino OK");
		console.log(formJson);		
	}
	
	function initBotones(){
		new Button({
			type: 'button',
			label: 'Aceptar',
			id: 'btnAceptarOficio' + aleatorio,
			onClick: function(){
				getObject();
				uploader.submit();
			}			
		}, 'btnAceptarOficio' + aleatorio);
		new Button({
			type: 'button',
			label: 'Cancelar',
			id: 'btnCancelarOficio' + aleatorio,
			onClick: function(){
				dialogFormOficio.hode();
				reset();
			}
		}, 'btnCancelarOficio' + aleatorio);
		new Button({
			type: 'button',
			label: 'Test',
			id: 'btnTestOficio' + aleatorio,
			onClick: function(){
				console.log(getObject());
				
			}
		}, 'btnTestOficio' + aleatorio);
		new Button({
			type: 'button',
			label: 'Descargar el archivo adjunto',
			id: 'btnDescargarOficio' + aleatorio,
			onClick: function(){
				downloadOficio();
			}
		}, 'btnDescargarOficio' + aleatorio);
	}
	
	function changeIdSubDireccion( idSubDireccion ){
		if ( idSubDireccion == null ) return;
		jsUtils.getMemory({
			urlBase: _configModule.urlBase,
			requestMapping: 'administracion/departamento/buscaPorSubdireccion?idSubDireccion=' + idSubDireccion,
			load: function( object ){
				idDepto.reset();
				idDepto.set('store', object);
				if ( _idDeptoLoad != null ){
					jsUtils.setVarWidgetFromObject( { idDepto: _idDeptoLoad }, objectWidget(), aleatorio );
				}
			}
		});
	}
	
	function changeIdDepto( idDepto ){
		if ( idDepto == null ) return;
		jsUtils.getMemory({
			urlBase: _configModule.urlBase,
			requestMapping: 'administracion/abogado/buscaPorDepartamento?idDepto=' + idDepto,
			load: function( object ){
				idAbogado.reset();
				idAbogado.set('store', object);
				if ( _idAbogadoLoad != null ){
					jsUtils.setVarWidgetFromObject( { idAbogado: _idAbogadoLoad }, objectWidget(), aleatorio );
				}
			}
		});
	}
	
	function downloadOficio(){
		ioIframe.send({
			url: _configModule.urlBase + 'juicios/util/oficios/descargar',
			content: {
				idOficio: idOficio.get('value')
			},
			method: "GET",
			load: function(response, ioArgs){
				return response;
			},
			error: function(response, ioArgs){
				console.log(response);
				return response;
			}
		    });
	}
	
	function validate(){
		var _validate = formOficio.validate();
		if ( uploader.get('value') == "" ){
			return false;
		}
		console.log( formOficio.validate() );
		return formOficio.validate();
	}
	
	function reset(){
		var divDescargarOficio = dom.byId("divDescargarOficio"+ aleatorio);
		domStyle.set(divDescargarOficio, "display", "none");
		formOficio.reset();
	}
	
	//retorna un objeto para despues se pasado por dojo.toJson
	function getObject(){
		var formObject = domForm.toObject( 'formOficio' + aleatorio );
		if (idSubdireccion.item != null){
			formObject.idSubdireccion = idSubdireccion.item.idSubdireccion;
			_idSubdireccion.set('value', idSubdireccion.item.idSubdireccion);
		}
		if (idDepto.item != null){
			formObject.idDepto = idDepto.item.idDepto;
			_idDepto.set('value', idDepto.item.idDepto);
		}
		if (idAbogado.item != null){
			formObject.idAbogado = idAbogado.item.idAbogado;
			_idAbogado.set('value', idAbogado.item.idAbogado);
		}
		if (idTipoAsunto.item != null){
			formObject.idTipoAsunto = idTipoAsunto.item.idTipoAsunto;
			_idTipoAsunto.set('value', idTipoAsunto.item.idTipoAsunto);
		}
		return formObject;
	}
	
	function setObject( object ){
		/*jsUtils.submitUrl({
			urlBase: _configModule.urlBase,
			requestMapping: 'juicios/util/requerimiento/consulta?idAsunto=' + object.idAsunto,
			configModule: _configModule,
			load: function( data ){
				if ( data != null ){
					_idAbogadoLoad = data.idAbogado;
					console.log(data);
					jsUtils.setVarWidgetFromObject( data, objectWidget(), aleatorio  );
					changeIdAbogado( data.idDepto );
				}
			}
		});*/
		var data = {
			asunto: 'ASUNTO',
			destinatario: 'DESTINATARIO',
			fechaOficio: '2012-10-06',
			idAbogado: 1,
			idDepto: 2,
			idSubdireccion: 2,
			idTipoAsunto: 1,
			noOficio: 'NU OFICIO',
			observaciones: 'OBSERVACIONES',
			idAsunto: 12,
			anio: 2012,
			idOficio: 1
		}
		jsUtils.setVarWidgetFromObject( data, objectWidget(), aleatorio  );
		_idDeptoLoad = data.idDepto;
		_idAbogadoLoad = data.idAbogado;
		setTimeout(function(){
			if( doLater( ( idSubdireccion.item != null || idSubdireccion.item != undefined ) ) ){ 
				console.log("widget::" , idSubdireccion.item );
				return;
			}
			console.log("Listo!!!! changed idSubdireccion");
			changeIdSubDireccion( data.idSubdireccion );
		}, 100);
		setTimeout(function(){
			if( doLater( ( idDepto.item != null ) ) ){ 
				console.log("widget::" , idDepto.item );
				return;
			}
			console.log("Listo!!!! changed idDepto");
			changeIdDepto( data.idDepto );
		}, 100);
		var divDescargarOficio = dom.byId("divDescargarOficio"+ aleatorio);
		domStyle.set(divDescargarOficio, "display", "inline");
		
	}
	
	function setDisabled(){
		setTimeout(function(){
			if( doLater( (registry.byId( 'idDepto' + aleatorio ) != undefined) && (registry.byId( 'idSubdireccion' + aleatorio ) != undefined) && (registry.byId( 'idAbogado' + aleatorio ) != undefined) ) ){ 
				console.log("widget::" , idDepto, unidadResp );
				return;
			}
			console.log("Listo!!!! setDisabled");
			var widget = null;
			for (var property in objectWidget() ) {
				widget = registry.byId( property + ((aleatorio)?aleatorio:"") );
				if ( widget == null || widget == undefined ){
					console.log("Invalid Setter property a " + property);
					continue;
				}
				widget.set( 'readOnly', true );
			}
		}, 100);
		uploader.set('disabled', true);
	}
	
	function show(){
		dialogFormOficio.show();
	}
	
	return{
		init: init,
		validate: validate,
		getObject: getObject,
		setObject: setObject,
		reset: reset,
		setDisabled: setDisabled,
		show: show
	}
});

