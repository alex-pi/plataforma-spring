define(["dojox/grid/DataGrid", "dojo/store/Memory","dojo/data/ObjectStore", "dojox/data/JsonRestStore", "dojo/store/JsonRest", "dojo/_base/xhr"], 
		function(DataGrid, Memory, ObjectStore, JsonRestStore, JsonRest, xhr){
	
	var gridSimple,
		store,
		dataStore;
	
	function crearGrid(){

		gridSimple = new DataGrid({
			store: store,
			structure: [
				{ name: "Nombre", field: "nombre", width: "84px" },
				{ name: "Apellido", field: "apellido", width: "84px" },
				{ name: "e-mail", field: "email", width: "120px" },
				{ name: "Password", field: "password", width: "70px" },
				{ name: "Teléfono", field: "telefono", width: "90px" }
			],
			columnReordering: true, 
			rowsPerPage: 20,
			style: {height: '450px', width: '600px'},
			selectionMode: "single"
		}, "gridPaginado");
		
		gridSimple.on('SelectionChanged', function(){
			var itemSeleccionado = this.selection.getSelected()[0];
			
			console.log(itemSeleccionado);
		}, true);
		
		gridSimple.startup();
	}
	
	function init(config){
		config.contenedor.set('content', config.template);
//        store = new JsonRest({target: dojo.config.app.urlBase + "usuarios"});
//        dataStore = ObjectStore({objectStore: store}); 		
		store = new JsonRestStore({target: dojo.config.app.urlBase + "usuarios"});
		crearGrid();
	}
	
	return {
		init: init
	};
});