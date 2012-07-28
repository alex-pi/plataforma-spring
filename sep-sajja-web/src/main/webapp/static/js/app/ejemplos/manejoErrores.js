define(['dojo/dom', "dojo/_base/xhr", 'dijit/form/Button', 
        'dijit/form/Form', 'dijit/registry', 'dojo/dom-construct', 'dojo/_base/json'],
		function(dom, xhr, Button, Form, registry, domConstruct, json){
		
	var modConfig;
	
	function init(config){
		console.log('En init de módulo...');
		config.contenedor.set('content', config.template);
		var panel = config.contenedor;
		modConfig = config;
   
		new Button({
			id: 'btnErrSimple',
            iconClass: 'dijitIconError',
            type: 'button',
            label: 'Error Simple',
            onClick: function(){
        		xhr.get({
        			handleAs: "json",
        			url: dojo.config.app.urlBase + "ejemplos/error/simple/1",
        			load: function(response){
        				
        			}
        		});	            	
            }
        }).placeAt(panel.containerNode, "last");
		
		var btnErrExtraInfo = new Button({
			id: 'btnErrExtraInfo',
			iconClass: 'dijitIconError',
			type: 'button',
			label: 'Error Con Info Extra',
			onClick: function(){
				xhr.get({
					handleAs: "json",
					url: dojo.config.app.urlBase + "ejemplos/error/simple/2",
					load: function(response){
						
					},
					error: function(resp){
						var infoError = json.fromJson(resp.responseText);
						var nodoInfo = domConstruct.create("div", {id:'divInfo', style: {display: 'block'}});
						domConstruct.create("p", { innerHTML: 'Este error es manejado en este módulo.' }, nodoInfo);
						domConstruct.create("p", { innerHTML: 'Mensaje: ' + infoError.mensaje }, nodoInfo);
						domConstruct.create("p", { innerHTML: 'Info extra: ' + infoError.extraInfo.campo1 }, nodoInfo);
//						nodoInfo.innerHTML = resp.responseText; 
						domConstruct.place(nodoInfo, btnErrExtraInfo.domNode, 'after');
					    setTimeout(function(){
					        domConstruct.destroy('divInfo');
					    }, 8000);						
					}
				});	            	
			}
		}).placeAt(panel.containerNode, "last");
	}

	return{
    	init: init
    };
});

