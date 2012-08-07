define(["dijit/form/ValidationTextBox", "dojox/validate/web", 
        "dijit/form/Button", "dijit/form/Form", "dojo/dom", "dojo/query"], function(ValidationTextBox, validate, Button, Form, dom, query) {

	var contenedor;
	
	function registroCorrecto(data){
		dojo.publish("/app/notificacion",[{
			message: "Formulario registrado con id: " + data,
			type: "message",
			duration: 4000
		}]);		
	}
	
	function registroError(resp){
		
	}
	
	function init(config) {
		config.contenedor.set('content', config.template);
		contenedor = config.contenedor;
		
		var forma = new Form({
			method: 'post',
			action: dojo.config.app.urlBase + 'formulario/guardar'
		}, query('#formularioForm', config.idContenedor)[0]);
		
		var txtNombre = new ValidationTextBox({
	    	name: 'nombre',
			placeHolder: 'Nombre',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text'
		}, 'nombre');		
		 
		var txtApellido = new ValidationTextBox({
	    	name: 'apellido',
			placeHolder: 'Apellido',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text'
		}, 'apellido');
		 
		var txtEmail = new ValidationTextBox({
	    	name: 'email',
			placeHolder: 'Ingresa tu correo electrónico',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text',
			validator: validate.isEmailAddress
		}, 'email');
		 
		var txtBoxPass = new ValidationTextBox({
	    	name: 'password',
			placeHolder: 'Contraseña',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'password'	    	
		}, 'password');			
		
		var txtTelefono = new ValidationTextBox({
			id: 'telefono',
        	name: 'telefono',
            placeHolder: '(##) ####-####',
            missingMessage: 'Teléfono: (##) ####-####',
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
				dojo.xhrPost({
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
				console.log('Objeto json a enviar : ' + dojo.formToJson(forma.domNode));
					({
					url: dojo.config.app.urlBase + 'formulario/guardar/json',
					postData: dojo.formToJson(forma.domNode),
					headers : {
					     "Content-Type" : "application/json; charset=UTF-8"
					},					
					handleAs: 'json',
					load: registroCorrecto
				});		        	
			}
		
		}, 'btnEnviarJson');	
			
			
	};

	return {
		init : init			
	};

});
		