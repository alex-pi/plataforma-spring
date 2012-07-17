<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">	
  	<title>Sistema de Administración de Juicios Jurídico Administrativos.</title>
	<link rel="stylesheet" href="static/css/style.css" media="screen">
  	<link rel="stylesheet" href="static/js/libs/dijit/themes/soria/soria.css" media="screen">  
  	<script>
  		dojoConfig= {
			has: {
	            "dojo-firebug": true,
	            "dojo-debug-messages": true
	        },  				
  	        app: {
  	        	urlBase: '<c:url value="/mvc/"/>',
  	        	urlStatic: '<c:url value="/static/"/>'
  	        	},
  	        packages:[{
  	        	name: 'app',
  	        	location: '<c:url value="/static/"/>js/app'
  	        },{
  	        	name: 'content',
  	        	location: '<c:url value="/mvc"/>'
  	        }],
  	        async: true,
  	      	cacheBust: true
  	    };  		
  	</script>
  	<script src="static/js/libs/dojo/dojo.js"></script>
	<script>
		require(["dijit/registry", "dijit/layout/BorderContainer",
		            "dijit/layout/TabContainer", "dijit/layout/ContentPane",
		            "dijit/layout/AccordionContainer", "dijit/Tree", "dojo/data/ItemFileReadStore", 
		            "dijit/tree/ForestStoreModel", "dijit/form/Button", "dojox/widget/Standby", "dojo/domReady!"],
		        function(registry, BorderContainer, TabContainer, ContentPane, 
		        		AccordionContainer, Tree, ItemFileReadStore, ForestStoreModel, Button, Standby){
			
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
					        	var titulo = store.getValue(item, "name");
					        	if(url && url !== ''){
					        		var idPanel = 'contentTabs_' + idOp;
					        		if(registry.byId(idPanel)){
					        			contentTabs.selectChild(registry.byId(idPanel));
					        			return;
					        		}
								    var panel = new ContentPane({
// 								    	href: dojo.config.app.urlBase + url,
								        title: titulo,
								        id: idPanel,
								        closable: true
								    });
									contentTabs.addChild(panel);
									contentTabs.selectChild(panel);
									var standby = new Standby({
									    target: idPanel,
									    'class': "dijitContentPaneLoading"
									});
									document.body.appendChild(standby.domNode);
									standby.startup();
									standby.show();
									
						        	require(['app/'+url,'dojo/text!content/'+url], function(modulo,template){
						        		if(modulo.init){
						        			modulo.init({
						        				contenedor: panel, 
						        				idContendor: 'contentTabs_' + idOp,
						        				template: template
					        				});
						        			// Usar aqui deferreds para saber cuándo quitar el standby
						        			standby.hide();
						        		}
						        	});						        						        		
					        	}
					        }
					    });						
					};									
					
			        var btnLogout = new Button({
			        	id: 'btnLogout',
		                iconClass: 'dijitIconUsers',
		                type: 'button',
		                label: 'Logout',
		                onClick: function(){
		                	window.location.href='j_spring_security_logout';
		                }
		            });
			        // btnLogout.startup();					
					
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
					    	style: 'text-align: right;',
					        region: "top",
					        id: "panelEncabezado", 
					        content: btnLogout
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
