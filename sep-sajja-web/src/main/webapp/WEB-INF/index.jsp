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
  	<link rel="stylesheet" href="static/js/libs/dojox/widget/Toaster/Toaster.css" />
  	<link rel="stylesheet" href="static/js//libs/dojox/grid/resources/soriaGrid.css" />
  	<link rel="stylesheet" href="static/js//libs/dojox/grid/enhanced/resources/EnhancedGrid.css" />
  	<link rel="stylesheet" href="static/js//libs/dojox/grid/enhanced/resources/EnhancedGrid_rtl.css" />
  	
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
  	        },{
  	        	name: 'static',
  	        	location: '<c:url value="/static"/>'
  	        }],
  	      	parseOnLoad: false,
  	        async: true,
  	      	debugAtAllCosts: true,
  	      	ioPublish: true,
  	      	cacheBust: true
  	    };  		
  	</script>
  	<script src="static/js/libs/dojo/dojo.js"></script>
	<script>
		require(["app/util/TreeMenu", "dojo/_base/xhr", "dojo/_base/array", "dojo/_base/lang",
		         "dijit/registry", "dijit/layout/BorderContainer",
		            "dijit/layout/TabContainer", "dijit/layout/ContentPane",
		            "dijit/layout/AccordionContainer", "dijit/form/Button", "dojox/widget/Standby", 
		            "dojo/string", "dojox/widget/Toaster", "dojo/_base/Deferred", 
		            "app/util/errorHandler", "dojo/domReady!"],
		        function(TreeMenu, xhr, arrayUtil, lang, registry, BorderContainer, TabContainer, ContentPane, 
		        		AccordionContainer, Button, Standby, string, Toaster, Deferred){					
					
					/**
					 * Callback para el evento de click sobre las opciones del menú
					 */
					 var onClickOpcion = function onClickOpcion(item, node, evt){
			        	var url = item.url;
			        	var idOp = item.id;
			        	var titulo = item.opcion;
			        	// se verifica que la opción tenga un url
			        	if(url && string.trim(url) !== ''){
			        		var idPanel = 'contentTab_' + idOp;
			        		// Si ya existe un panel con ese id, simplemente se muestra.
			        		if(registry.byId(idPanel)){
			        			contentTabs.selectChild(registry.byId(idPanel));
			        			return;
			        		}
			        		// Creamos el panel principal para la opción de menú seleccionada.
						    var panel = new ContentPane({
						        title: titulo,
						        id: idPanel,
						        closable: true,
						        onClose: function(){
 						        	standby.destroy();
 						        	return true;
						        }
						    });
			        		// Se agrega y se muestra el nuevo panel en el contenedor de tabs.
							contentTabs.addChild(panel);
							contentTabs.selectChild(panel);
							// Creamos y mostramos un bloqueo en pantalla para esperar la carga del
							// contenido del panel.
							var standby = new Standby({
								id: 'standby_contentTab_' + idOp,
							    target: idPanel,
							    'class': "dijitContentPaneLoading"
							});
							document.body.appendChild(standby.domNode);
							standby.startup();
							standby.show();
							// Cargamos el módulo responsable de la opción seleccionada y el template que le corresponde.
				        	require(['app/'+url,'app/util/text!content/'+url + '!strip;no-cache'], function(modulo,template){
				        		
				        		// Si el módulo devuelve un objeto con una función init la llamamos pasando
				        		// al módulo un objeto con información útil.
				        		if(modulo.init && lang.isFunction(modulo.init)){
				        			var deferred = modulo.init({
				        				contenedor: panel, 
				        				idContenedor: idPanel,
				        				template: template,
				        				urlBase: dojo.config.app.urlBase,
				        				standby: standby,
				        				cerrarTab: function(){
				        					contentTabs.closeChild(panel);
				        				},
				        				recursive: onClickOpcion,
				        				item: item
			        				});
				        			//contentTabs.selectChild(panel);
				        			
				        			// Si el init devuelve un objeto deferred válido lo utilizamos
				        			// para saber cupando retirar el bloqueo visual del panel.
				        			if(deferred && lang.isFunction(deferred.then)){
					        			deferred.then(function(result){
					        				standby.hide();
					        			}); 				        			
				        			} else {
				        				//si no se devolvió algún deferred quitamos el bloqueo de inmediato
				        				standby.hide();
				        			}
				        		} else {
				        			// si no hay init quitamos el bloqueo de inmediato
				        			standby.hide();
				        		}
				        	});	
			        	}
			        };
			        
			        // Botón para provocar un logout de la aplicación. 
			        var btnLogout = new Button({
			        	id: 'btnLogout',
		                iconClass: 'dijitIconUsers',
		                type: 'button',
		                label: 'Logout',
		                onClick: function(){
		                	window.location.href='j_spring_security_logout';
		                }
		            });			
					
			        // Layout principal de la aplicación.
					var layoutPrincipal = new BorderContainer({
					    design: "headline"
					}, "layoutPrincipal");			
			        
			        // Cada sección del acordeón contendrá un objeto Tree para mostrar las opciones
			        // de un módulo de la aplicación.
					var contentAccordion = new AccordionContainer();
					 
					// En la parte dentral del layout se mostrará un contenedor de tabs.
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
					
					// Del la izquierdo se coloca el panel tipo acordeón como parte de nuestro menú principal.
					layoutPrincipal.addChild(
					    new ContentPane({
					        region: "left",
					        id: "panelMenu", 
					        content: contentAccordion,
					        splitter: true,
					        minSize: 200
					    })
					);
					
					// Agregamos un panel de bienvenida al contenedor de tabs. 
					contentTabs.addChild(
					    new ContentPane({
					        content: "<pre>Al dar click en las opciones del menú se mostrarán nuevos tabs.</pre>",
					        title: "Bienvenido"
					    })
					);
					
					// Obtenemos todos los módulos que el usuario podrá visualizar.
					xhr.get({
						handleAs: "json",
						url: dojo.config.app.urlBase + "seguridad/menu/modulos",
						load: function(data){
							// Por cada módulo agregamos un panel al acordeón.
							arrayUtil.forEach(data, function(mod){
								contentAccordion.addChild(new ContentPane({
							        title: mod.modulo,
							        idModulo: mod.id,
							        // Dentro de cada panel del acordeón creamos un menú en forma de árbol para
							        // mostrar las opciones del módulo.
							        content: new TreeMenu(mod.id, onClickOpcion).getTree()
							    }));										
							});
							layoutPrincipal.startup();
						}
					});
					
					// Publicamos un mecanismo para generar mensajes no intrusivos en la aplicación,
					// estos pueden ser utilizados desde cualquier módulo de la aplicación.
					new Toaster({
						id: 'panelMensaje',
						positionDirection: 'tl-down',
						messageTopic: '/app/notificacion'
					}, 'panelNotificaciones');
					
		        });
	</script>               
</head>
	<body class="soria">
		<div id="panelNotificaciones"></div>	
        <div id="layoutPrincipal">

        </div>
    </body>
</html>
