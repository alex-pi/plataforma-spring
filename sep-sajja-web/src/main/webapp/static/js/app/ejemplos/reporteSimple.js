define(['dijit/form/Button','dijit/form/Form'], function(Button, Form){
	
	var forma,
	btnGenerarReporte;

	function init(config){
		config.contenedor.set('content', config.template);

		forma = new Form({
			method: 'get',
			target: '_blank',
			action: dojo.config.app.urlBase + 'reportes/usuarios'
		}, 'generaReporteForm');
		
		btnGenerarReporte = new Button({
	        type: 'submit',
	        label: 'Generar'
	    }, 'btnGenerarReporte');			
	    
	}
    
    return{
    	init: init
    };
});