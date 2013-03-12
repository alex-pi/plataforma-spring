define(["dijit/form/ValidationTextBox", "dojox/validate/web", "dojo/_base/xhr",
        "dijit/form/Button", "dijit/form/Form", "dojo/dom", "dojo/query", "dojo/dom-form", "dojo/json"],
        		function(ValidationTextBox, validate, xhr, Button, Form, dom, query, domForm, json) {

	var modConfig;
	
	function registroCorrecto(data){
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
            value: 'pi',
			placeHolder: 'Nombre',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text'
		}, 'nombre');		
		 
		new ValidationTextBox({
	    	name: 'apellido',
            value: 'pi',
			placeHolder: 'Apellido',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text'
		}, 'apellido');
		 
		new ValidationTextBox({
	    	name: 'email',
            value: 'pi@pi.com',
			placeHolder: 'Ingresa tu correo electrónico',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text',
			validator: validate.isEmailAddress
		}, 'email');
		 
		new ValidationTextBox({
	    	name: 'password',
            value: '123',
			placeHolder: 'Contraseña',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'password'	    	
		}, 'password');			
		
		new ValidationTextBox({
			id: 'telefono',
            value: '(12) 1236-7896',
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
                var data = domForm.toJson(forma.domNode);
                var dataObj = domForm.toObject(forma.domNode);
                dataObj.fecha = new Date().getTime();
                var data = json.stringify(dataObj);
				xhr.post({
					url: dojo.config.app.urlBase + 'usuarios/guardar/json',
					postData: data,
					headers : {
					     "Content-Type" : "application/json; charset=UTF-8"
					},					
					handleAs: 'json',
					load: registroCorrecto,
                    handle: function(){modConfig.standby.hide();}
				});		        	
			}
		
		}, 'btnEnviarJson');	
		forma.startup();
			
	};

	return {
		init : init			
	};

});
		