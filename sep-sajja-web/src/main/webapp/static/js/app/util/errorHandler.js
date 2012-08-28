/**
 * Al ser cargado, este módulo suscribe al evento "/dojo/io/error" publicado por dojo
 * cuando una petición vuelve con error.
 * 
 * Sólo si la petición realizada desde cualquier lugar de la aplicación no define un callback de
 * error se mostrará un diálogo con la información del error.
 * 
 * Al colocar un callback de error para nuestras peticiones provocamos que este diálogo no se muestre-
 * 
 */
define(["dojo/_base/xhr", "dojo/_base/array", "dojo/dom",
		         "dijit/registry", "dijit/Dialog", "dojo/topic", "dojo/_base/json", 
		         "dojo/text!static/html/util/mensaje.html", "dijit/form/Button"],
	function(xhr, arrayUtil, dom, registry, Dialog, topic, json, template, Button){
	
	topic.subscribe("/dojo/io/error", function(deferred, response){
		// Si la petición definió callback de error no se muestra mensaje genérico.
		if(deferred.ioArgs.args.error)
			return;
		
		var error = json.fromJson(response.responseText || null);
        
		if(!registry.byId('dlgMensajeError')) {
	        var dialog = new Dialog({
	        	id: 'dlgMensajeError',
	            title: error.nivelError,	
	            content: template,
	            iconClass: 'dijitIconError'
	        });		      
	        dialog.show();
	        
			var btnLogin = new Button({
	            iconClass: 'dijitIconError',
	            type: 'button',
	            label: 'Cerrar',
	            onClick: function(){
	            	dialog.hide();
	            }
	        }, 'btnCerrarDlg');
			btnLogin.startup();
		} else {
			registry.byId('dlgMensajeError').show();
		}
		
		var node = dom.byId("nivelError");
        node.innerHTML = 'Tipo error: ' + error.nivelError;
        dom.byId("claveError").innerHTML = 'Clave error: ' + error.claveError;
        dom.byId("horaError").innerHTML = 'Hora: ' + error.momentoErrorFrmt;
        dom.byId("mensaje").innerHTML = error.mensaje;
    
	});
});