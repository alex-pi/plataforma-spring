define(['dojo/dom', "dojo/_base/xhr", 'dijit/form/Button', 
        'dijit/form/Form', 'dijit/registry', 'dojo/dom-construct', 'dojo/_base/json'],
		function(dom, xhr, Button, Form, registry, domConstruct, json){
		
	var modConfig;
	
	function init(config){
		config.contenedor.set('content', config.template);
		var panel = config.contenedor;
		modConfig = config;
   
		new Button({
			id: 'btnErrTransaccion',
            iconClass: 'dijitIconError',
            type: 'button',
            label: 'Error Transaccion',
            onClick: function(){
        		xhr.post({
        			handleAs: "json",
        			url: dojo.config.app.urlBase + "ejemplos/error/trans/1",
        			load: function(response){
        				
        			}
        		});	            	
            }
        }).placeAt(panel.containerNode, "last");

		new Button({
            iconClass: 'dijitIconError',
            type: 'button',
            label: 'Registro Parcial',
            onClick: function(){
        		xhr.post({
        			handleAs: "json",
        			url: dojo.config.app.urlBase + "ejemplos/error/trans/2",
        			load: function(response){

        			}
        		});
            }
        }).placeAt(panel.containerNode, "last");
	}

	return{
    	init: init
    };
});

