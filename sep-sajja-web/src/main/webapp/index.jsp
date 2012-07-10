<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
  	<title>Sistema de Administración de Juicios Jurídico Administrativos.</title>
	<link rel="stylesheet" href="static/css/style.css" media="screen">
  	<link rel="stylesheet" href="static/js/libs/dijit/themes/soria/soria.css" media="screen">  
  	<script>
  		dojoConfig= {
  	        app: {
  	        	urlBase: '<c:url value="/mvc/"/>',
  	        	urlStatic: '<c:url value="/static/"/>'
  	        	},
  	        async: true,
  	      	cacheBust: true
  	    };  		
  	</script>
  	<script src="static/js/libs/dojo/dojo.js"></script>
	<script>
		require(["dijit/registry", "dijit/layout/BorderContainer",
		            "dijit/layout/TabContainer", "dijit/layout/ContentPane",
		            "dijit/layout/AccordionContainer", "dijit/Tree", "dojo/data/ItemFileReadStore", 
		            "dijit/tree/ForestStoreModel", "dojo/domReady!"],
		        function(registry, BorderContainer, TabContainer, ContentPane, 
		        		AccordionContainer, Tree, ItemFileReadStore, ForestStoreModel){
			
					function crearTree(){
						var store = new ItemFileReadStore({
					        url: "static/json/ejemplos.json"
					    });

					    var treeModel = new ForestStoreModel({
					        store: store,
					        query: {"type": "subModulo"},
					        rootId: "root",
					        rootLabel: "Ejemplos",
					        childrenAttrs: ["opciones"]
					    });

					    return new Tree({
					        model: treeModel,
					        showRoot: false,
					        onClick: function(item, node, evt){
					        	var url = store.getValue(item, "url");
					        	var idOp = store.getValue(item, "id");
					        	if(url && url !== ''){
								    var panel = new ContentPane({
								        href: dojo.config.app.urlBase + url,
								        title: "AMD simple",
								        id: 'contentTabs_' + idOp,
								        closable: true,
								        onDownloadEnd: function(){
								        	require([url], function(modulo){
								        		if(modulo.init){
								        			modulo.init({
								        				contenedor: panel, 
								        				idContendor: 'contentTabs_' + idOp
							        				});
								        		}
								        	});										        	
								        }
								    });					        		
									contentTabs.addChild(panel);
									contentTabs.selectChild(panel);
					        	}
					        }
					    });						
					};
					
					var layoutPrincipal = new BorderContainer({
					    design: "headline"
					}, "layoutPrincipal");			
					var contentAccordion = new AccordionContainer();
					 
					 
					var contentTabs = new TabContainer({
					    region: "center",
					    id: "contenedorTabs",
					    tabPosition: "top"
					});
					 
					layoutPrincipal.addChild( contentTabs );
					 
					layoutPrincipal.addChild(
					    new ContentPane({
					        region: "top",
					        id: "panelEncabezado", 
					        content: "Contenido del encabezado."
					    })
					);
					layoutPrincipal.addChild(
					    new ContentPane({
					        region: "left",
					        id: "panelMenu", 
					        content: contentAccordion,
					        splitter: true,
					        minSize: 200
					    })
					);
					 
					contentTabs.addChild(
					    new ContentPane({
					        content: "Contenido de Tab1",
					        title: "Tab 1"
					    })
					);
					
					contentAccordion.addChild(new ContentPane({
				        title:"Ejemplos",
				        content: crearTree()
				    }));	
					contentAccordion.addChild(new ContentPane({
				        title:"Módulo 1",
				        content:"Aqui otro árbol sin raíz"
				    }));					
					contentAccordion.addChild(new ContentPane({
				        title:"Módulo 2",
				        content:"Aqui otro árbol sin raíz"
				    }));					 
					
					layoutPrincipal.startup();
		        });
	</script>               
</head>
	<body class="soria">
        <div id="layoutPrincipal">

        </div>
    </body>
</html>
