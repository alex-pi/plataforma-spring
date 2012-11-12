define([
	"dojo/ready",
	"dojo/_base/xhr",
	"dijit/form/ValidationTextBox",
	"dijit/form/Button",
	"dojo/data/ObjectStore",
	"dojox/data/JsonRestStore",
	"dojo/on",
	"dojo/_base/json",
	"app/util/constants",
	"dojox/grid/EnhancedGrid",
	"app/juicios/civil/reqjudicial/formAsunto",
	"app/juicios/civil/reqjudicial/formTabInfoGral",
	"app/juicios/civil/reqjudicial/formArchivo",
	"app/juicios/util/gridOficios",
	"dijit/layout/TabContainer",
	"dijit/layout/ContentPane",
	"dijit/Dialog",
	"app/util/text!content/juicios/civil/reqjudicial/initCaptura.jsp!strip;no-cache",
	"dojo/_base/lang",
	"app/util/jsUtils"
	],
function(
	ready,
	xhr,
	ValidationTextBox,
	Button,
	ObjectStore,
	JsonRestStore,
	on,
	dojo,
	constants,
	EnhancedGrid,
	formAsunto,
	formTabInfoGral,
	formArchivo,
	gridOficios,
	TabContainer,
	ContentPane,
	Dialog,
	template,
	lang,
	jsUtils
){
	var configModule = null;
	var tabContainer, dialogForm;
	var aleatorio = null;
	var layoutPrincipal;
	
	function init( config ){
		configModule = config;
		aleatorio = Math.floor(Math.random() * 1000);
//		layoutPrincipal = new BorderContainer({
//		    style: "height: 100%;"
//		});		
		console.log( configModule.isDialog + " && " + configModule.isDialog == true + "=" + configModule.isDialog && configModule.isDialog == true);
		if ( configModule.isDialog && configModule.isDialog == true ){
			var output = lang.replace(
				template ,
				{ aleatorio: aleatorio }
			);
			dialogForm = new Dialog({
				title: config.opcion,
				content: output,
				//style: "width: 700px",
				id: 'dialogCapReqJudicial' + aleatorio
			});
			dialogForm.show();
		}else{
			var output = lang.replace(
				configModule.template ,
				{ aleatorio: aleatorio }
			);
			configModule.contenedor.set('content', output);
		}
		var asunto = config.item.data;
		//console.log( config );
		formAsunto.init( config , 'divFormAsunto' + aleatorio, asunto );
		
		initTabContainerSecundario();
		initBotones();
//		configModule.contenedor.resize();
		configModule.contenedor.resize();
		//configModule.contenedor.startup();
		if (config.item.mode == 'add' ){
//			formAsunto.reset( );
//			formTabInfoGral.reset( );
//			formArchivo.reset( );
		}
		if ( config.item.mode == 'edit' ){
			formAsunto.setObject( asunto );
			formTabInfoGral.setObject( asunto );
			formArchivo.setObject( asunto );
		}
		
		if ( config.item.mode == 'view' ){
			formAsunto.setObject( asunto );
			formTabInfoGral.setObject( asunto );
			formArchivo.setObject( asunto );
			
			formAsunto.setDisabled( );
			formTabInfoGral.setDisabled( );
			formArchivo.setDisabled( );
		}
		
	}
	
	function initTabContainerSecundario(){
		tabContainer = new TabContainer({
			style: "width: 100%; height: 500px; border-color: #005ce5;",
			id: 'tabContainer' + aleatorio
		}, 'divTabConteinerReqJudicial' + aleatorio );
		var cpInfoGeneral = new ContentPane({
			title: "Informaci\u00F3n general"
		}, 'divTabInfoGral' + aleatorio );
		formTabInfoGral.init( configModule, 'contentDivTabInfoGral' + aleatorio );
		tabContainer.addChild(cpInfoGeneral);
		var cpArchivo = new ContentPane({
			title: "Archivo"
		}, 'divTabArchivo' + aleatorio);
		formArchivo.init( configModule, 'contentDivTabArchivo' + aleatorio );
		tabContainer.addChild(cpArchivo);
		
		var cpOficios = new ContentPane({
			title: "Oficios"
		}, 'divTabOficios' + aleatorio );
		gridOficios.init( configModule, 'contentDivTabOficios' + aleatorio );
		tabContainer.addChild(cpOficios);
		/*var cpVolantes = new dijit.layout.ContentPane({
			title: "Volantes",
			content: "We offer amazing food"
		});
		tabContainer.addChild(cpVolantes);
		*/
		tabContainer.startup();
		tabContainer.resize();
	}
	
	function initBotones(){
		new Button({
			type: 'button',
			label: 'Guardar',
			id: 'btnAceptarReqJudicial' + aleatorio,
			onClick: function(){
				guardar();
			}
		}, 'btnAceptarReqJudicial' + aleatorio);
		new Button({
			type: 'button',
			label: 'Cancelar',
			id: 'btnCancelarReqJudicial' + aleatorio,
			onClick: function(){
				alert("nada");
			}
		}, 'btnCancelarReqJudicial' + aleatorio);
		
	}
	
	function guardar(){
		if ( formAsunto.validate() && formTabInfoGral.validate() && formArchivo.validate() ){
			var object = {
				tja031Asunto: formAsunto.getObject(),
				tja042Requerimientos: formTabInfoGral.getObject(),
				tja039Conclusion: formArchivo.getObject()
			};
			//guardar la información del formulario
			jsUtils.submitObject({
				urlBase: configModule.urlBase,
				requestMapping: '/juicios/civil/reqjudicial/agregar',
				data: object,
				configModule: configModule,
				load: function( data ){
					dojo.publish("/app/notificacion",[{
						message: "Se agreg\u00F3 correctamente el requerimiento judicial con FOLIO: " + data,
						type: "message",
						duration: 4000
					}]);
				}
			});
		}
	}
	
	
	return {
		init: init
	};
});
