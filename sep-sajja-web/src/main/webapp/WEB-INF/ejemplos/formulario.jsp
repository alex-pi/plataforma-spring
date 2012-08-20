<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<pre>
El siguiente ejemplo hace uso de dijit/for/Form, dojox/validate/web y dijit/form/ValidationTextBox para crear un formulario
con validaciones.

Adicionalmente muestra dos formas asíncronas de enviar un formulario:
	1) Con los valores de cada campo en el cuerpo de la petición. En el controller recibido como:
			@ModelAttribute("formulario") Formulario formulario
	2) Convirtiendo los valores del formulario a formato json y colocando este en el cuerpo de la petición. En el controller recibido como:
			@RequestBody Formulario formulario

Cuando el registro tiene éxito se usa nuestro mecanismo de notificación de mensajes:
	dojo.publish("/app/notificacion" ... );
</pre>
<form id="usuarioForm">			
<table class="pageTable">		
		<tr>
			<td><label for="lNombre">Nombre(s)*: </label></td>
			<td><input name="nombre" id="nombre"/></td>					
		</tr>
		<tr>
			<td><label for="lApellido">Apellido Paterno*:</label></td>
			<td><input name="apellido" id="apellido"/></td>			
		</tr>
		<tr>
			<td><label for="lemail">e-mail*:</label></td>
			<td><input name="email" id="email"/></td>					
		</tr>
		<tr>
			<td><label for="lpassword">Contraseña*:</label></td>
			<td><input name="password" id="password" /></td>					

		</tr>
		<tr>
			<td><label for="lTelefono">Teléfono*:</label></td>
			<td><input name="telefono" id="telefono"/></td>
		</tr>
		<tr>
			<td><input id="btnEnviar" /><input id="btnEnviarJson" /></td>
		</tr>
</table>
</form>