// Aqui se usa el módulo de ejemplo.
define(["ejemplos/util_ejemplo"], function(util){

	function init(panel){
		// Aqui ya podemos usar el objeto devuelto por nuestro módulo ejemplo.
	    util.setText("saludo", "Este texto cambiará en 5 segundos.");
	 		
	    setTimeout(function(){
	        util.restoreText("saludo");
	    }, 5000);
	}
    
    return{
    	init: init
    };
});