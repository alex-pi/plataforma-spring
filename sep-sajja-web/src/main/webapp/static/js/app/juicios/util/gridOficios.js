define([
	"app/util/text!static/html/juicios/util/gridOficios.html!strip;no-cache",
	"dojo/_base/lang",
	"dojo/dom",
	"dojo/dom-construct",
	"dojo/data/ObjectStore",
	"dojox/data/JsonRestStore",
	"dojox/grid/EnhancedGrid",
	"dijit/form/Button",
	"dijit/form/ValidationTextBox",
	"app/juicios/util/formOficios",
	"dojox/grid/enhanced/plugins/Pagination"
],function(
	template,
	lang,
	dom,
	domConstruct,
	ObjectStore,
	JsonRestStore,
	EnhancedGrid,
	Button,
	ValidationTextBox,
	formOficios
){
	var _configModule = null;
	var aleatorio = null;
	
	var gridOficios;
	var idAsunto;
	
	function init( config , content){
		_configModule = config;
		aleatorio = Math.floor(Math.random() * 1000);
		var output = lang.replace(
			lang.clone(template +""),
			{ aleatorio: aleatorio }
		      );
		var divContent = dom.byId( content );
		domConstruct.place( output, divContent );
		initGrid();
		initForm();
		initBotones();
		formOficios.init( config );
	}
	
	function initForm(){
		idAsunto = new ValidationTextBox({
			name: 'idAsunto',
			id: 'idAsunto' + aleatorio,
			type: 'hidden'
		}, 'idAsunto'+ aleatorio);
	}
	
	function initGrid(){
		var layout = [
			{ name: "NO. OFICIO", field: "anio", width: "15%" },
			{ name: "FECHA DEL OFICIO", field: "noExpInterno", width: "15%" },
			{ name: "ASUNTO", field: "nombreActor", width: "70%" }
		];
		
		//var store = new JsonRestStore({target: _configModule.urlBase + "/juicios/util/asunto?none=none"});
		//var dataStore = new ObjectStore({ objectStore: store });

		gridOficios = new EnhancedGrid({
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
		}, "gridOficios" + aleatorio);
		gridOficios.startup();
		gridOficios.resize();
	}
	
	function initBotones(){
		new Button({
			type: 'button',
			label: 'Agregar',
			id: 'btnAddOficio' + aleatorio,
			onClick: function(){
				formOficios.show();
			}
		}, 'btnAddOficio' + aleatorio);
		new Button({
			type: 'button',
			label: 'Modificar',
			id: 'btnUpdOficio' + aleatorio,
			onClick: function(){
				formOficios.show();
				formOficios.setObject( null );
			}
		}, 'btnUpdOficio' + aleatorio);
		new Button({
			type: 'button',
			label: 'Eliminar',
			id: 'btnDelOficio' + aleatorio,
			onClick: function(){
				alert("nada");
			}
		}, 'btnDelOficio' + aleatorio);		
	}
	
	return {
		init: init
	}
});
