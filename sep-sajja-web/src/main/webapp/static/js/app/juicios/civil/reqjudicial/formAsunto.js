define([
	"app/util/text!static/html/juicios/civil/reqjudicial/formAsunto.html!strip;no-cache",
	"app/util/constants",
	"dijit/form/Form",
	"dijit/form/NumberTextBox",
	"dijit/form/ValidationTextBox",
	"dijit/form/FilteringSelect",
	"dijit/form/CheckBox",
	"app/util/jsUtils",
	"dojo/dom-construct",
	"dojo/dom",
	"dojo/_base/lang",
	"dojo/dom-form",
	"dijit/form/Button",
	"dojox/timing/doLater",
	"dijit/registry"
], function(
	template,
	constants,
	Form,
	NumberTextBox,
	ValidationTextBox,
	FilteringSelect,
	CheckBox,
	jsUtils,
	domConstruct,
	dom,
	lang,
	domForm,
	Button,
	doLater,
	registry
){
	var formAsunto, anio, relevante, noExpInterno, noExp, nombreActor;
	var nombreDemandado, idOrganoJuris, idAsunto, idTipoJuicio, idTipoAsunto;
	
	var objectWidget = function(){
		return {
			formAsunto: formAsunto,
			anio: anio,
			relevante: relevante,
			noExpInterno: noExpInterno,
			noExp: noExp,
			nombreActor: nombreActor,
			nombreDemandado: nombreDemandado,
			idOrganoJuris: idOrganoJuris,
			idAsunto: idAsunto,
			idTipoJuicio: idTipoJuicio,
			idTipoAsunto: idTipoAsunto
		}
	};
	
	var aleatorio = null;
	var _configModule;
	var _asunto = null;
	
	function init( configModule, content , asunto){
		_asunto = asunto;
		_configModule = configModule;
		aleatorio = Math.floor(Math.random() * 1000);
		var output = lang.replace(
			lang.clone(template +""),
			{ aleatorio: aleatorio }
		      );
		var divContent = dom.byId( content );
		domConstruct.place( output, divContent );
		initForm();
	}
	
	function initForm(){
		formAsunto = new Form({ id: 'formAsunto' + aleatorio }, 'formAsunto' + aleatorio);
		idAsunto = new ValidationTextBox({
			name: 'idAsunto',
			id: 'idAsunto' + aleatorio,
			type: 'hidden'
		}, 'idAsunto'+ aleatorio);
		
		idTipoJuicio = new ValidationTextBox({
			name: 'idTipoJuicio',
			id: 'idTipoJuicio' + aleatorio,
			type: 'hidden',
			value: _asunto.idTipoJuicio
		}, 'idTipoJuicio'+ aleatorio);
		idTipoAsunto = new ValidationTextBox({
			name: 'idTipoAsunto',
			id: 'idTipoAsunto' + aleatorio,
			type: 'hidden',
			value: _asunto.idTipoAsunto
		}, 'idTipoAsunto'+ aleatorio);
		
		anio = new NumberTextBox({
			name: 'anio',
			id: 'anio' + aleatorio,
			placeHolder: 'Ingresa el a\u00F1o',
			missingMessage: 'Obligatorio',
			invalidMessage: "N\u00FAmero invalido.",
			required: true,
			maxLength: 8,
			type: 'text',
			style: constants.DEFAULT_STYLE,
			constraints: {
				places: 0,
				pattern: '####',
				min: 1950,
				max: 2100
			}
		}, 'anio'+ aleatorio);
		
		relevante = CheckBox({
			name: "relevante",
			id: 'relevante' + aleatorio,
			value: "1",
			checked: false
			}
		, "relevante"+ aleatorio);
		
		noExpInterno = new ValidationTextBox({
			name: 'noExpInterno',
			id: 'noExpInterno' + aleatorio,
			placeHolder: 'Ingresa el expediente interno',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.DEFAULT_STYLE,
			required: true,
			uppercase: true,
			maxLength: 20
		}, 'noExpInterno'+ aleatorio);
		
		noExp = new ValidationTextBox({
			name: 'noExp',
			id: 'noExp' + aleatorio,
			placeHolder: 'Ingresa el expediente',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.DEFAULT_STYLE,
			required: true,
			uppercase: true,
			maxLength: 20
		}, 'noExp'+ aleatorio);
		
		nombreActor = new ValidationTextBox({
			name: 'nombreActor',
			id: 'nombreActor' + aleatorio,
			placeHolder: 'Ingresa el nombre del actor',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.LONG_STYLE,
			required: true,
			uppercase: true,
			maxLength: 100
		}, 'nombreActor'+ aleatorio);
		
		nombreDemandado = new ValidationTextBox({
			name: 'nombreDemandado',
			id: 'nombreDemandado' + aleatorio,
			placeHolder: 'Ingresa el nombre del demandado',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.LONG_STYLE,
			required: true,
			uppercase: true,
			maxLength: 100
		}, 'nombreDemandado'+ aleatorio);
		
		
				
//		jsUtils.getMemory({
//			urlBase: _configModule.urlBase,
//			requestMapping: 'administracion/organoJurisdiccional/porTipoAsunto?idTipoAsunto=' + _asunto.idTipoAsunto,
//			load: function( object ){
//				idOrganoJuris = new FilteringSelect({
//					name: "idOrganoJuris",
//					id: 'idOrganoJuris' + aleatorio,
//					searchAttr: "descripcion",
//					placeHolder: 'Seleccione el organo jurisdiccional',
//					style: constants.LONG_STYLE,
//					required: true
//				}, "idOrganoJuris"+ aleatorio);
//				idOrganoJuris.set('store', object);
//			}
//		});
		//formAsunto.startup();
		
		new Button({
			type: 'button',
			label: 'Test',
			id: 'btnFormAsuntoTest' + aleatorio,
			onClick: function(){
				console.log(getObject());
				
			}
		}, 'btnFormAsuntoTest' + aleatorio);
		
	}
	
	
	
	function validate(){
		var _validate = formAsunto.validate();
		console.log( formAsunto.validate() );
		return formAsunto.validate();
	}
	
	function reset(){
		formAsunto.reset();
	}
	
	//retorna un objeto para despues se pasado por dojo.toJson
	function getObject(){
		var formObject = domForm.toObject( 'formAsunto' + aleatorio );
		if (idOrganoJuris.item != null){
			formObject.idOrganoJuris = idOrganoJuris.item.idOrganoJuris;
		}
		if( !formObject.relevante ){
			formObject.relevante = '0';
		}
		return formObject;
	}
	
	function setObject( object ){
		setTimeout(function(){
			//if( doLater( idOrganoJuris != undefined ) ){  
			if( doLater( registry.byId( 'idOrganoJuris' + aleatorio ) != undefined ) ){  
				console.log("widget::" , idOrganoJuris);
				return;
			}
			console.log("Listo!!!!");
			jsUtils.setVarWidgetFromObject( object, objectWidget(), aleatorio );
		}, 100);
		
		
	}
	
	function setDisabled(){
		setTimeout(function(){
			//if( doLater( idOrganoJuris != undefined ) ){  
			if( doLater( registry.byId( 'idOrganoJuris' + aleatorio ) != undefined ) ){ 
				console.log("widget::" , idOrganoJuris);
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
	};
});

