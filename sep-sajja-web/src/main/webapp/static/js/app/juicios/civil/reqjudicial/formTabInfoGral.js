define([
	"app/util/text!static/html/juicios/civil/reqjudicial/formTabInfoGral.html!strip;no-cache",
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
	"dojox/timing/doLater"
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
	doLater
){
	var formInfoGral, requerimientoSol, fechaNotificacion, fechaVencimiento, atendidoVencimien;
	var unidadResp, especifique, fechaAcuse, fechaRecepcion, fechaEntrega;
	var fechaRecordatorio, atendidoRecordato, observaciones, idDepto, idAbogado, idAsunto;
	
	var objectWidget = function(){
		return {
			//formInfoGral: formInfoGral,
			requerimientoSol: requerimientoSol,
			fechaNotificacion: fechaNotificacion,
			fechaVencimiento: fechaVencimiento,
			atendidoVencimien: atendidoVencimien,
			unidadResp: unidadResp,
			especifique: especifique,
			fechaAcuse: fechaAcuse,
			fechaRecepcion: fechaRecepcion,
			fechaEntrega: fechaEntrega,
			fechaRecordatorio: fechaRecordatorio,
			atendidoRecordato: atendidoRecordato,
			observaciones: observaciones,
			idDepto: idDepto,
			idAbogado: idAbogado,
			idAsunto: idAsunto
			
		}
	};
	
	var _idAbogadoLoad = null;
	
	var aleatorio = null;
	var _configModule;
	
	function init( configModule, tab ){
		_configModule = configModule;
		aleatorio = Math.floor(Math.random() * 1000);
		var output = lang.replace(
			template,
			{ aleatorio: aleatorio }
		      );
		//divPruebaRender
		domConstruct.place( output, tab);
		//tab.set('content', output);
		//tab.startup();
		initForm();
		
	}
	
	function initForm(){
		formInfoGral = new Form({ id: 'formInfoGral' + aleatorio }, 'formInfoGral' + aleatorio);
		requerimientoSol = new ValidationTextBox({
			name: 'requerimientoSol',
			id: 'requerimientoSol' + aleatorio,
			placeHolder: 'Ingresa el requerimiento solicitado',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.BIG_BIG_STYLE,
			required: false,
			uppercase: true,
			maxLength: 250
		}, 'requerimientoSol'+ aleatorio);
		
		fechaNotificacion = new DateTextBox({
			name: 'fechaNotificacion',
			id:"fechaNotificacion" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha de notificaci\u00F3n a la UAJ',
			required: false,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaNotificacion' + aleatorio);
		
		fechaVencimiento = new DateTextBox({
			name: 'fechaVencimiento',
			id:"fechaVencimiento" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha de vencimiento',
			required: false,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaVencimiento' + aleatorio);
		
		atendidoVencimien = new CheckBox({
			name: "atendidoVencimien",
			id: 'atendidoVencimien' + aleatorio,
			checked: false,
			value: "1"
			}
		, "atendidoVencimien"+ aleatorio);
		
//		jsUtils.getMemory({
//			urlBase: _configModule.urlBase,
//			requestMapping: 'administracion/unidadResponsable/todos',
//			load: function( object ){
//				unidadResp = new FilteringSelect({
//					name: "unidadResp",
//					id: 'unidadResp' + aleatorio,
//					store: object,
//					searchAttr: "descripcion",
//					placeHolder: 'Seleccione la Unidad Administrativa a solicitar la informaci\u00F3n',
//					style: constants.BIG_BIG_STYLE,
//					required: false
//				}, "unidadResp"+ aleatorio);
//			}
//		});
		
		
		
		especifique = new ValidationTextBox({
			name: 'especifique',
			id: 'especifique' + aleatorio,
			placeHolder: 'Especifique brevemente la informaci\u00F3n del requerimiento',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.BIG_BIG_STYLE,
			required: false,
			uppercase: true,
			maxLength: 100	
		}, 'especifique'+ aleatorio);
		
		fechaAcuse = new DateTextBox({
			name: 'fechaAcuse',
			id:"fechaAcuse" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha de acuse',
			required: false,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaAcuse' + aleatorio);
		
		fechaRecepcion = new DateTextBox({
			name: 'fechaRecepcion',
			id:"fechaRecepcion" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha de recepci\u00F3n de la informaci\u00F3n por parte de la UA',
			required: false,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaRecepcion' + aleatorio);
		
		fechaEntrega = new DateTextBox({
			name: 'fechaEntrega',
			id:"fechaEntrega" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha de entrega al \u00F3rgano jurisdiccional',
			required: false,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaEntrega' + aleatorio);
		
		fechaRecordatorio = new DateTextBox({
			name: 'fechaRecordatorio',
			id:"fechaRecordatorio" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha recordatorio',
			required: false,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaRecordatorio' + aleatorio);
		
		atendidoRecordato = new CheckBox({
			name: "atendidoRecordato",
			id: 'atendidoRecordato' + aleatorio,
			checked: false,
			value: "1"
			}
		, "atendidoRecordato"+ aleatorio);
		
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
			placeHolder: 'Ingresa las observaciones del requerimiento judicial'
		}, "observaciones"  + aleatorio);
		
		idAbogado = new FilteringSelect({
			name: "idAbogado",
			id: 'idAbogado' + aleatorio,
			searchAttr: "nombreCompleto",
			placeHolder: 'Seleccione el abogado asignado al caso',
			style: constants.DEFAULT_STYLE,
			required: false
		}, "idAbogado"+ aleatorio);
		
//		jsUtils.getMemory({
//			urlBase: _configModule.urlBase,
//			requestMapping: 'administracion/departamento/todos',
//			load: function( object ){
//				idDepto = new FilteringSelect({
//					name: "idDepto",
//					id: 'idDepto' + aleatorio,
//					store: object,
//					searchAttr: "descripcion",
//					placeHolder: 'Seleccione el departamento donde se realiz\u00F3 la asignaci\u00F3n',
//					style: constants.DEFAULT_STYLE,
//					required: false
//				}, "idDepto"+ aleatorio);
//				idDepto.startup();
//				var signalEvent = aspect.after(idDepto, "openDropDown", function() {
//				idDepto.dropDown.on("click", function() {
//					//idAbogado.set('store', null);
//					_idAbogadoLoad = null;
//					changeIdAbogado( idDepto.item.idDepto );
//				});        
//				signalEvent.remove();            
//			    });
//				
//			}
//		});
				
		idAsunto = new ValidationTextBox({
			name: 'idAsunto',
			id: 'idAsunto' + aleatorio,
			type: 'hidden'
		}, 'idAsunto'+ aleatorio);
		
		new Button({
			type: 'button',
			label: 'Test',
			id: 'btnFormAsuntoTest' + aleatorio,
			onClick: function(){
				console.log(getObject());
				idAbogado.set('readOnly', true);
				//idAbogado.setDisabled(true);
				setDisabled();
			}
		}, 'btnFormAsuntoTest' + aleatorio);
		
		formInfoGral.startup();
		var formJson = domForm.toJson( 'formInfoGral' + aleatorio );
		console.log("Termino OK");
		console.log(formJson);
		
		
	}
	
	function changeIdAbogado( idDepto ){
		if ( idDepto == null ) return;
		jsUtils.getMemory({
			urlBase: _configModule.urlBase,
			requestMapping: 'administracion/abogado/buscaPorDepartamento?idDepto=' + idDepto,
			load: function( object ){
				idAbogado.set('store', object);
				if ( _idAbogadoLoad != null ){
					jsUtils.setVarWidgetFromObject( {idAbogado: _idAbogadoLoad}, objectWidget(), aleatorio );
				}
			}
		});
	}
	
	function validate(){
		var _validate = formInfoGral.validate();
		console.log( formInfoGral.validate() );
		return formInfoGral.validate();
	}
	
	function reset(){
		formInfoGral.reset();
	}
	
	//retorna un objeto para despues se pasado por dojo.toJson
	function getObject(){
		var formObject = domForm.toObject( 'formInfoGral' + aleatorio );
		if (idDepto.item != null){
			formObject.idDepto = idDepto.item.idDepto;
		}
		if (idAbogado.item != null){
			formObject.idAbogado = idAbogado.item.idAbogado;
		}
		if (unidadResp.item != null){
			formObject.unidadResp = unidadResp.item.unidadResp;
		}
		if ( !formObject.atendidoVencimien ){
			formObject.atendidoVencimien = '0';
		}
		if ( !formObject.atendidoRecordato ){
			formObject.atendidoRecordato = '0';
		}
		return formObject;
	}
	
	function setObject( object ){
		jsUtils.submitUrl({
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
		});
	}
	
	function setDisabled(){
		setTimeout(function(){
			if( doLater( (registry.byId( 'idDepto' + aleatorio ) != undefined) && (registry.byId( 'unidadResp' + aleatorio ) != undefined) ) ){ 
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
	}
	
	return{
		init: init,
		validate: validate,
		getObject: getObject,
		setObject: setObject,
		reset: reset,
		setDisabled: setDisabled
	}
});

