<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Sistema de Administración de Juicios Jurídico Administrativos.</title>
	<style>
	    .soria .dijitDialogUnderlay { background:#000; }
	</style>	
	<link rel="stylesheet" href="static/js/libs/dijit/themes/soria/soria.css" media="screen"> 
	<script src="static/js/libs/dojo/dojo.js"></script>
	<script>
		require(["dijit/Dialog", "dijit/form/ValidationTextBox", "dijit/form/Button", "dijit/form/Form", "dojo/dom", "dojo/domReady!"], function(Dialog, ValidationTextBox, Button, Form, dom) {
			new Form({
				method: 'POST',
				action: 'j_spring_security_check'
			}, 'loginForm');
			
	        var txtBoxUsuario = new ValidationTextBox({
	        	name: 'j_username',
                placeHolder: 'Nombre de usuario',
                missingMessage: 'Obligatorio',
                required: true
            }, 'username');
	        
	        var txtBoxPass = new ValidationTextBox({
	        	name: 'j_password',
                placeHolder: 'Constraseña',
                missingMessage: 'Obligatorio',
                required: true,
                type: 'password'
            }, 'password');
	        	        
	        var btnLogin = new Button({
                iconClass: 'dijitIconKey',
                type: 'submit',
                label: 'Login!'
            }, 'btnLogin');    
	        
	        txtBoxPass.startup();	        
	        txtBoxUsuario.startup();
	        btnLogin.startup();		        
	        
	        var dialog = new Dialog({
	            // Dialog title
	            title: "Login a SAJJA...",	
	            content: dom.byId('formContent'),
	            onCancel: function(){console.log('*******');}
	        });
	        dialog.closeButtonNode.style.display = "none";
	        dialog._onKey = function(evt){
	            key = evt.keyCode;
	            if (key == dojo.keys.ESCAPE) {
	            	dojo.stopEvent(evt);
	            }
	        }; 
	        
	        dialog.show();
	        
		});
	</script>
</head>
<body class="soria">
<div id="formContent">
<form id="loginForm">
	<table>
		<tr>
			<td><label for="username">Usuario:</label></td>
			<td><input id="username"></td>
		</tr>
		<tr>
			<td><label for="password">Contraseña:</label></td> 
			<td><input id="password"><br></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: right;"><input id="btnLogin" type="submit" value="Login"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>