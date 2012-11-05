define(["dojox/grid/DataGrid", "dojo/store/Memory","dojo/data/ObjectStore",
        "dojo/_base/xhr","dijit/layout/TabContainer", "dijit/layout/ContentPane"], 
        	function(DataGrid, Memory, ObjectStore, xhr, TabContainer, ContentPane){
	
	var gridEscuelas;
	
	function crearGrid(items){		
		var store = new Memory({ data: items });
		var dataStore = new ObjectStore({ objectStore: store });

		gridEscuelas = new DataGrid({
			store: dataStore,
			query: { id: "*" },
			structure: [
				{ name: "Nombre", field: "nombre", width: "200px" },
				{ name: "Antigüedad", field: "antiguedad", width: "84px" }
			],
			style: {width: '400px'},
			selectionMode: "single"
		}, "gridEscuelas");
		
		gridEscuelas.on('SelectionChanged', function(){
			var itemSeleccionado = this.selection.getSelected()[0];
			
			console.log(itemSeleccionado);
		}, true);
		
		gridEscuelas.startup();
	}
	
	function init(config){
		//config.contenedor.set('content', config.template);
		console.log('creando tab');
		var contentTabs = new TabContainer();		
		
		contentTabs.addChild(
		    new ContentPane({
		        content: "<pre>Aqui un nuevo subtab.</pre>",
		        title: "Nuevo subtab"
		    })
		);
		
		contentTabs.addChild(
			new ContentPane({
				content: config.template,
				title: "Subtab con grid.",
				initialized: false,
				onShow: function(){				
					console.log('onShow');
					if(this.initialized) return;
					xhr.get({
						handleAs: "json",
						url: dojo.config.app.urlBase + "catalogos",
						load: crearGrid
					});					
					this.startup();
					this.initialized = true;
				}
			})
		);
		
		//contentTabs.selectChild(tabGrid);
		
		config.contenedor.set('content', contentTabs);
	
	}
	
	return {
		init: init
	};
});