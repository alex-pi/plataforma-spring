// Aqui se usa el módulo de ejemplo.
define(["dojo/dom"], function(util){

	function init(config){
		config.contenedor.set('content', config.template);
	}
    
    return{
    	init: init
    };
});