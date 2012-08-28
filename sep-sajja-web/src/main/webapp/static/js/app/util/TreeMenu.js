/**
 * Crea un árbol sin nodo raíz con el componente dijit/Tree para representar las opciones de un módulo
 * de la aplicación.
 * 
 * Se debe proporcionar el id del módulo cuyas opciones se quieren mostrar y un callback para
 * ejecutar cuando el usuario da click en alguna rama del árbol.
 * 
 * Se usa un store tipo JsonRest para obtener las opciones bajo demanda y evitar cargar toda la información
 * de inicio.
 * 
 */
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