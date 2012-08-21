define(["dijit/form/ValidationTextBox", "dojox/validate/web", "dojo/_base/xhr",
        "dijit/form/Button", "dijit/form/Form", "dojo/dom", "dojo/query", "dojo/dom-form"], 
        		function(ValidationTextBox, validate, xhr, Button, Form, dom, query, domForm) {

	var modConfig;
	
	function registroCorrecto(data){
		modConfig.standby.hide();
		dojo.publish("/app/notificacion",[{
			message: "Usuario registrado con id: " + data,
			type: "message",
			duration: 4000
		}]);		
	}
	
	function registroError(resp){
		
	}
	
	function init(config) {
		modConfig = config;
		config.contenedor.set('content', config.template);
			
		var forma = new Form({
			method: 'post',
			action: dojo.config.app.urlBase + 'usuarios/guardar'
		}, dom.byId('usuarioForm'));
		
		new ValidationTextBox({
	    	name: 'nombre',
			placeHolder: 'Nombre',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text'
		}, 'nombre');		
		 
		new ValidationTextBox({
	    	name: 'apellido',
			placeHolder: 'Apellido',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text'
		}, 'apellido');
		 
		new ValidationTextBox({
	    	name: 'extra.email',
			placeHolder: 'Ingresa tu correo electrónico',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text',
			validator: validate.isEmailAddress
		}, 'email');
		 
		new ValidationTextBox({
	    	name: 'password',
			placeHolder: 'Contraseña',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'password'	    	
		}, 'password');			
		
		new ValidationTextBox({
			id: 'telefono',
        	name: 'telefono',
            placeHolder: '(##) ####-####',
            missingMessage: 'Obligatorio',
            invalidMessage: 'Teléfono: (##) ####-####',
            required: true,
            type: 'text',
            constraints: {format: "(##) ####-####"},
            validator: validate.isNumberFormat
        }, 'telefono');			
		 
		new Button({
		    type: 'button',
		    label: 'Enviar',
		    onClick: function(){
		    	if(!forma.validate()){
					return;
				}
		    	xhr.post({
					form: forma.domNode,
					handleAs: 'json',
					load: registroCorrecto,
					error: registroError
				});		        	
		    }
		    	
		}, 'btnEnviar');	
		
		new Button({
			type: 'button',
			label: 'Enviar Json',
			onClick: function(){
				if(!forma.validate()){
					return;
				}
				config.standby.show();
				console.log('Objeto json a enviar : ' + domForm.toJson(forma.domNode));
				xhr.post({
					url: dojo.config.app.urlBase + 'usuarios/guardar/json',
					postData: dojo.formToJson(forma.domNode),
					headers : {
					     "Content-Type" : "application/json; charset=UTF-8"
					},					
					handleAs: 'json',
					load: registroCorrecto
				});		        	
			}
		
		}, 'btnEnviarJson');	
		forma.startup();
			
	};

	return {
		init : init			
	};

});
		