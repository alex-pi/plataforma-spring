define(['dojo/dom','dojo/cookie', "dojo/_base/xhr", 'dijit/form/Button', 'dijit/form/Form', 'dijit/registry'],
		function(dom, cookie, xhr, Button, Form, registry){
		
	var modConfig;
	
	function init(config){
		console.log('En init de módulo...');
		config.contenedor.set('content', config.template);
		modConfig = config;
   
		var btnErrSimple = new Button({
			id: 'btnErrSimple',
            iconClass: 'dijitIconError',
            type: 'button',
            label: 'Error Simple',
            onClick: function(){
        		xhr.get({
        			handleAs: "json",
        			url: dojo.config.app.urlBase + "ejemplos/error/simple",
        			load: function(response){
        				
        			}
        		});	            	
            }
        }).placeAt(config.contenedor.containerNode, "last");
	}

	return{
    	init: init
    };
});

