define(["dojo/_base/xhr", "dojo/_base/array",
        "dijit/registry", "dijit/Tree", "dijit/tree/TreeStoreModel", "dojo/store/JsonRest"],
	function(xhr, arrayUtil, registry, 
			Tree, TreeStoreModel, JsonRest){
	
		function TreeMenu(idModulo, onClickOpcion){
			
			var storeMenu = new JsonRest({
			    target: dojo.config.app.urlBase + "seguridad/menu/",
			    mayHaveChildren: function(opcion){
			        return !!opcion.opciones;
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