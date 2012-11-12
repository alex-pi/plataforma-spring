define([
	"dojo/_base/xhr",
	"dijit/form/ValidationTextBox",
	"dijit/form/Button",
	"dojo/data/ObjectStore",
	"dojox/data/JsonRestStore",
	"dojo/on",
	"dojo/_base/json",
	"app/util/constants",
	"dojox/grid/EnhancedGrid",
	"app/juicios/civil/reqjudicial/initCaptura",
	"dojox/grid/enhanced/plugins/Pagination"
	],
function(
	xhr,
	ValidationTextBox,
	Button,
	ObjectStore,
	JsonRestStore,
	on,
	dojo,
	constants,
	EnhancedGrid,
	initCaptura
){
	var gridCharolaReqJudiciales;
	var configModule = null;
	
	function init( config ){
		configModule = config;
		configModule.contenedor.set('content', configModule.template);
		initFormFiltro();
		initGrid();
		initBotones();
		buscar();
	}
	
	function initFormFiltro(){
		
		
	}
	
	function initGrid(){
		var layout = [
			{ name: "A\u00D1O", field: "anio", width: "5%" },
			{ name: "NO. EXPEDIENTE INTERNO", field: "noExpInterno", width: "15%" },
			{ name: "NOMBRE ACTOR", field: "nombreActor", width: "40%" },
			{ name: "NOMBRE DEMANDADO", field: "nombreDemandado", width: "40%" }
		];
		
		//var store = new JsonRestStore({target: dojo.config.app.urlBase + "/juicios/util/asunto?none=none"});
		//var dataStore = new ObjectStore({ objectStore: store });

		gridCharolaReqJudiciales = new EnhancedGrid({
			structure: layout,
			selectionMode: "single",
			rowsPerPage: 10,
			rowSelector: '20px',
			style: {height: '350px', width: '100%'},
			plugins: {
				pagination: {
				    description: true,
				    sizeSwitch: false,
				    pageStepper: true,
				    gotoButton: true,
					    /*page step to be displayed*/
				    maxPageStep: 4,
					    /*position of the pagination bar*/
				    position: "bottom"
				}
			}
		}, "gridCharolaReqJudiciales");
		gridCharolaReqJudiciales.startup();
		gridCharolaReqJudiciales.resize();
	}
	
	function buscar(){
		var criterios = "";
		criterios += "?none=" + 0 + "&";
		criterios += "&none=1";
		//var store = new JsonRestStore({target: dojo.config.app.urlBase + "/juicios/util/asunto" + criterios });
		//gridCharolaReqJudiciales.setStore( store );
		//gridCharolaReqJudiciales.currentPage(1);
	}
	
	function initBotones(){
		new Button({
			type: 'button',
			label: 'Agregar',
			onClick: function(){
				var asunto = {
					idTipoAsunto: 6,
					idTipoJuicio: 1
				}
				configModule.recursive({
					url: 'juicios/civil/reqjudicial/initCaptura', 
					id:'newReqJudiciales', 
					opcion:'Nuevo requerimiento juducial',
					data: asunto,
					mode: 'add'
				}, null,null );
			}
		}, 'btnAgregarDpto');
		
		new Button({
			type: 'button',
			label: 'Modificar', 
			onClick: function(){
				var items = gridCharolaReqJudiciales.selection.getSelected();
				if(items.length) {
					configModule.recursive({
						url: 'juicios/civil/reqjudicial/initCaptura',
						id:'ReqJudiciales' + items[0].idAsunto, 
						opcion:'Modificaci\u00F3n de: ' + items[0].idAsunto,
						data: items[0],
						mode: 'edit'
					}, null,null );
				}else{
					alert("Seleccione un registro");
				}
				
			}
		}, 'btnModificarDpto');
		
		new Button({
			type: 'button',
			label: 'Consultar', 
			onClick: function(){
				var items = gridCharolaReqJudiciales.selection.getSelected();
				if(items.length) {
					configModule.recursive({
						url: 'juicios/civil/reqjudicial/initCaptura',
						id:'ReqJudiciales' + items[0].idAsunto, 
						opcion:'Modificaci\u00F3n de: ' + items[0].idAsunto,
						data: items[0],
						mode: 'view'
					}, null,null );
				}else{
					alert("Seleccione un registro");
				}
				
			}
		}, 'btnConsultarDpto');
		
		
		//codigo para desplegar en Dialog, pendiente ajustar a los cambios
		/*new Button({
			type: 'button',
			label: 'Limpiar3', 
			onClick: function(){
				configModule.isDialog = true;
				configModule.opcion = 'Captura de requerimiento judicial',
				initCaptura.init( configModule );
			}
		}, 'btnEliminarDpto');*/
		
	}

	return {
		init: init
	};
});

