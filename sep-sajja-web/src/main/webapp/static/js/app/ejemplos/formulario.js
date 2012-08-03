// Aqui se usa el módulo de ejemplo.

define(["dijit/form/ValidationTextBox","dojox/validate/us","dojox/validate/web","dijit/form/Button", "dijit/form/Form", "dojo/dom", "dojo/domReady!"], function(ValidationTextBox,us,web, Button, Form, dom) {
			
		function init(config) {
			console.log('Modulo cargado...' + config.template);
			config.contenedor.set('content', config.template);
			
			forma = new Form({
				method: 'post',
				'class': 'Uploader',
				action: dojo.config.app.urlBase + 'formulario/guardar'
			}, 'formularioForm');
			
			 var txtNombre = new ValidationTextBox({
		        	name: 'Nombre',
	                placeHolder: 'Nombre',
	                missingMessage: 'Ingresa tú nombre',
	                required: true,
	                type: 'text'
	            }, 'nombre');
			 
			 
			 var txtApellido = new ValidationTextBox({
		        	name: 'Apellido',
	                placeHolder: 'Apellido',
	                missingMessage: 'Ingresa tus Apellido Paterno',
	                required: true,
	                type: 'text'
	            }, 'apellido');
			 
			 var txtEmail = new ValidationTextBox({
		        	name: 'email',
	                placeHolder: 'Ingresa tu correo electrónico',
	                missingMessage: 'Obligatorio',
	                required: true,
	                type: 'text',
	                validator: function(val){ return !val || dojox.validate.isEmailAddress(val)}
	            }, 'email');
			 
			 var txtBoxPass = new ValidationTextBox({
		        	name: 'Password',
	                placeHolder: 'Contraseña',
	                missingMessage: 'Ingresa tú password',
	                required: true,
	                type: 'password'
	                	
	            }, 'password');			
			
			 var txtEmail = new ValidationTextBox({
		        	name: 'Telefono',
	                placeHolder: 'Teléfono',
	                missingMessage: 'Ingresa tú teléfono',
	                required: true,
	                type: 'text'
	            }, 'telefono');
			 
		    btnEnviar= new Button({
		        type: 'submit',
		        label: 'Enviar',
		        onSubmit: function(){
		        	if(this.validate()){
						return confirm('El formulario es válido, favor de presionar ok para continuar');
					}else{
						alert('El formulario contiene datos incorrectos, favor de corregirlos');
						return false;
					}
					return true;		        	
		        }
		        	
		    }, 'submitEnviar');	
			
			
		};

		return {
			
			init : init
			
		};

});
		