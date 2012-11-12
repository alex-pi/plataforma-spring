define(["dojox/grid/DataGrid", "dojo/store/Memory","dojo/data/ObjectStore",
        "dojo/_base/xhr","dijit/layout/TabContainer", "dijit/layout/ContentPane",
        "dijit/form/Select", "dijit/layout/BorderContainer"], 
        	function(DataGrid, Memory, ObjectStore, xhr, TabContainer, ContentPane, Select, BorderContainer){
	
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
		console.log('creando tab');
		//config.contenedor.set('content', config.template);
			
		var layoutPrincipal = new BorderContainer({
//		    design: "headline",
		    style: "height: 100%;"
		});	
		
		layoutPrincipal.addChild(
		    new ContentPane({
		    	style: 'text-align: right;',
		        region: "top",
		        content: config.template
		    })
		);
				
		var contentTabs = new TabContainer({region: "center"});
		layoutPrincipal.addChild(contentTabs);
		
		contentTabs.addChild(
			new ContentPane({
		        content: "<pre>Aqui un nuevo subtab.</pre>",
		        title: "Nuevo subtab"
		    })
		);		
		
		contentTabs.addChild(
			new ContentPane({
				content: '<div id="gridEscuelas"></div>',
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
				
//		contentTabs.startup();
//		c1.startup();
		//config.contenedor.startup();
		
		//contentTabs.selectChild(tabGrid);
		
		config.contenedor.set('content', layoutPrincipal);
		
		var slt = new Select({
            name: "sltPrueba"
		}, "sltPrueba");		
	
	}
	
	return {
		init: init
	};
});