define(["dojox/grid/DataGrid", "dojo/store/Memory","dojo/data/ObjectStore","dojo/_base/xhr",], function(DataGrid, Memory, ObjectStore, xhr){
	
	var gridSimple;
	
	function crearGrid(items){
		var store = new Memory({ data: items });
		var dataStore = new ObjectStore({ objectStore: store });

		gridSimple = new DataGrid({
			store: dataStore,
			query: { id: "*" },
			structure: [
				{ name: "Nombre", field: "nombre", width: "84px" },
				{ name: "Apellido", field: "apellido", width: "84px" },
				{ name: "e-mail", field: "email", width: "120px" },
				{ name: "Password", field: "password", width: "70px" },
				{ name: "Teléfono", field: "telefono", width: "90px" }
			],
			style: {width: '600px'},
			selectionMode: "single"
		}, "gridSimple");
		
		gridSimple.on('SelectionChanged', function(){
			var itemSeleccionado = this.selection.getSelected()[0];
			
			console.log(itemSeleccionado);
		}, true);
		
		gridSimple.startup();
	}
	
	function init(config){
		config.contenedor.set('content', config.template);
		
		xhr.get({
			handleAs: "json",
			url: dojo.config.app.urlBase + "usuarios/listar",
			load: crearGrid
		});		
	}
	
	return {
		init: init
	};
});