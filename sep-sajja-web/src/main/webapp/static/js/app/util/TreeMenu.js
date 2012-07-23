define(["dojo/_base/xhr", "dojo/_base/array",
		         "dijit/registry", "dijit/layout/ContentPane", "dijit/Tree",  
		            "dijit/tree/TreeStoreModel", "dojox/widget/Standby", 
		            "dojo/store/JsonRest", "dojo/string"],
	function(xhr, arrayUtil, registry, ContentPane, 
			Tree, TreeStoreModel, 
			Standby, JsonRest, string){
	
		function TreeMenu(idModulo, onClickOpcion){
			
			var storeMenu = new JsonRest({
			    target: dojo.config.app.urlBase + "seguridad/menu/",
			    mayHaveChildren: function(object){
			        return !!object.opciones;
			    },
			    getChildren: function(object, onComplete, onError){
			        this.get(object.id).then(function(fullObject){
			            object.opciones = fullObject.opciones;
			            onComplete(fullObject.opciones);
			        }, function(error){
			            console.error(error);
			            onComplete([]);
			        });
			    },
			    getRoot: function(onItem, onError){
			        this.get("modulo/"+idModulo).then(onItem, onError);
			    },
			    getLabel: function(object){
			        return object.opcion;
			    }
			});						
	
		    var tree = new Tree({
		        model: storeMenu,
		        showRoot: false,
		        onClick: onClickOpcion
		    });
		    
		    this.idModulo = idModulo;
		    this.getTree = function(){return tree;};
		    this.getStore = function(){return storeMenu;};
		    
		};		
		
		return TreeMenu;
		
});