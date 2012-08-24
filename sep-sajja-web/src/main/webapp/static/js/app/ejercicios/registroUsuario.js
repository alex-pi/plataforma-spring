define(["dijit/form/ValidationTextBox", "dojox/validate/web", 
        "dojo/_base/xhr", "dijit/form/Button", "dijit/form/Form", 
        "dijit/form/CheckBox",
        "dojo/dom", "dojo/query", "dojo/dom-form", "dojo/on"], 
    		function(ValidationTextBox, validate, xhr, 
        				Button, Form, CheckBox, dom, query, domForm, on) {
	
	var configModulo,
		forma,
		btnRegistrar;
	
	function registroCorrecto(data){
		configModulo.standby.hide();
		dojo.publish("/app/notificacion",[{
			message: "Usuario registrado con id: " + data,
			type: "message",
			duration: 4000
		}]);		
	}
	
	function initEvents(){
		on(btnRegistrar, "click" ,function(){
			if(!forma.validate()){
				return;
			}
			configModulo.standby.show();
			console.log('Objeto json a enviar : ' + domForm.toJson(forma.domNode));
			xhr.post({
				url: configModulo.urlBase + 'ejercicios/usuarios/guardar',
				postData: dojo.formToJson(forma.domNode),
				headers : {
				     "Content-Type" : "application/json; charset=UTF-8"
				},					
				handleAs: 'json',
				load: registroCorrecto
			});		        	
		});
	}
	
	function init(config){
		configModulo = config;
		config.contenedor.set('content', config.template);
		
		forma = new Form({
			method: 'post'
//			action: config.urlBase + '/ejercicios/usuarios/guardar'
		}, dom.byId('usuarioSeguridadForm'));
		
		new ValidationTextBox({
			id: "usernameUsuSeg",
	    	name: 'username',
			placeHolder: 'username',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text'
		}, 'usernameUsuSeg');
		
		new ValidationTextBox({
			id: "nombreUsuSeg",
	    	name: 'nombre',
			placeHolder: 'Nombre del usuario',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'text'
		}, 'nombreUsuSeg');
				
		new ValidationTextBox({
			id: "passwordUsuSeg",
	    	name: 'password',
			placeHolder: 'password',
			missingMessage: 'Obligatorio',
			required: true,
			type: 'password'
		}, 'passwordUsuSeg');		
		
		var checkBox = new CheckBox({
			id: "activoUsuSeg",
			name: "activo",
			checked: true,
			value: "true",
			onChange: function(isChecked){
				checkBox.set("value", isChecked? "true" : "false");
			}
		}, 'activoUsuSeg');
		
		btnRegistrar = new Button({
			id: "btnRegistrarUsuSeg",
			type: 'button',
			label: 'Registrar'	
		}, 'btnRegistrarUsuSeg');
		
		initEvents();
	}
	
	return {
		init: init
	};
	
});