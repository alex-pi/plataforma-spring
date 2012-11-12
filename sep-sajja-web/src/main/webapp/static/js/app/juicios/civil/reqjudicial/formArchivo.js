define([
	"app/util/text!static/html/juicios/civil/reqjudicial/formArchivo.html!strip;no-cache",
	"app/util/constants",
	"dijit/form/Form",
	"dijit/form/ValidationTextBox",
	"dijit/form/FilteringSelect",
	"dijit/form/DateTextBox",
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
	DateTextBox,
	jsUtils,
	domConstruct,
	lang,
	domForm,
	Button,
	aspect,
	registry,
	doLater
){
	var formArchivo, fechaConclusion, fechaArchivoFin, caja;
	var idDepto, idAbogado, idAsunto;
	
	var objectWidget = function(){
		return {
			formArchivo: formArchivo,
			fechaConclusion: fechaConclusion,
			fechaArchivoFin: fechaArchivoFin,
			caja: caja,
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
		domConstruct.place( output, tab);
		initForm();
		
	}
	
	function initForm(){
		formArchivo = new Form({ id: 'formArchivo' + aleatorio }, 'formArchivo' + aleatorio);
		
		fechaConclusion = new DateTextBox({
			name: 'fechaConclusion',
			id:"fechaConclusion" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha de conclusi\u00F3n del asunto',
			required: false,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaConclusion' + aleatorio);
		
		fechaArchivoFin = new DateTextBox({
			name: 'fechaArchivoFin',
			id:"fechaArchivoFin" + aleatorio,
			missingMessage: 'Obligatorio',
			invalidMessage: "Fecha invalida.",
			placeHolder: 'Selecciona la fecha del archivo final',
			required: false,
			style: constants.DEFAULT_STYLE,
			type: 'text'
		}, 'fechaArchivoFin' + aleatorio);
		
		caja = new ValidationTextBox({
			name: 'caja',
			id: 'caja' + aleatorio,
			placeHolder: 'Capture la referencia de la caja donde quedo archivado el asunto',
			regExp: constants.CHARACTERS_VALID,
			type: 'text',
			style: constants.BIG_BIG_STYLE,
			required: false,
			uppercase: true,
			maxLength: 20	
		}, 'caja'+ aleatorio);
		
		idAbogado = new FilteringSelect({
			name: "idAbogado",
			id: 'idAbogado' + aleatorio,
			searchAttr: "nombreCompleto",
			placeHolder: 'Seleccione el abogado que concluy\u00F3 al caso',
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
//					placeHolder: 'Seleccione el departamento donde se concluy\u00F3 el asunto',
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
			id: 'btnFormArchivoTest' + aleatorio,
			onClick: function(){
				console.log(getObject());
			}
		}, 'btnFormArchivoTest' + aleatorio);
		
		formArchivo.startup();
		var formJson = domForm.toJson( 'formArchivo' + aleatorio );
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
		var _validate = formArchivo.validate();
		console.log( formArchivo.validate() );
		return formArchivo.validate();
	}
	
	function reset(){
		formArchivo.reset();
	}
	
	//retorna un objeto para despues se pasado por dojo.toJson
	function getObject(){
		var formObject = domForm.toObject( 'formArchivo' + aleatorio );
		if (idDepto.item != null){
			formObject.idDepto = idDepto.item.idDepto;
		}
		if (idAbogado.item != null){
			formObject.idAbogado = idAbogado.item.idAbogado;
		}
		return formObject;
	}
	
	function setObject( object ){
		jsUtils.submitUrl({
			urlBase: _configModule.urlBase,
			requestMapping: 'juicios/util/archivo/consulta?idAsunto=' + object.idAsunto,
			configModule: _configModule,
			load: function( data ){
				if ( data != null ){
					_idAbogadoLoad = data.idAbogado;
					console.log(data);
					jsUtils.setVarWidgetFromObject( data, objectWidget(), aleatorio );
					changeIdAbogado( data.idDepto );
				}
			}
		});
	}
	
	function setDisabled(){
		setTimeout(function(){
			//if( doLater( idOrganoJuris != undefined ) ){  
			if( doLater( (registry.byId( 'idDepto' + aleatorio ) != undefined) ) ){ 
				console.log("widget::" , idDepto );
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

