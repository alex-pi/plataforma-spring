// Aqui se usa el módulo de ejemplo.

djConfig = {
			async:1,
			isDebug:true,
			parseOnLoad: false
		};


define(["dijit/form/ValidationTextBox","dojox/validate/us", "dojox/validate/web","dijit/form/Button", "dijit/form/Form", "dojo/dom", "dojo/domReady!"], function(ValidationTextBox,us,web, Button, Form, dom) {
			
		function init(config) {
			console.log('Modulo cargado...' + config.template);
			
			config.contenedor.set('content', config.template);
			
		};

		return {
			
			init : init
			
		};

});
		