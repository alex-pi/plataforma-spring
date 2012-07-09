// Este código define un módulo 
 
define([
    // Aqui se agregan las dependencias para este módulo.
    "dojo/dom"
], function(dom){
    // Una vez que todas las dependencias son cargadas (asíncronamente claro)
	// este callback recibe el objeto retonado por cada una de estas dependencias.
 
    var oldText = {};
 
    // Este sería el objeto que este módulo en particular regresa.
    return {
        setText: function(id, text){
            var node = dom.byId(id);
            oldText[id] = node.innerHTML;
            node.innerHTML = text;
        },
        restoreText: function(id){
            var node = dom.byId(id);
            node.innerHTML = oldText[id];
            delete oldText[id];
        }
    };
});