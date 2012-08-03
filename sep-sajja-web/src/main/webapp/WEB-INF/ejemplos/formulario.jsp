<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			
<table class="pageTable">
		<tr>
			<td id="colForm">
				<form id="formularioForm" >
				<div>
					<label for="lNombre">Nombre(s)*: </label>
					<input name="nombre" id="nombre"/>					
				</div>
				<div>
					<label for="lApellido">Apellido Paterno*:</label>
					<input name="apellido" id="apellido"/>			
				<div>
				</div>
					<label for="lemail">E-mail*:</label>
					<input name="email" id="email" 
								validator="dojox.validate.isEmailAddress"/>					
				</div>
				<div>
					<label for="lpassword">Contraseña*:</label>
					<input name="password" id="password" />					

				</div>
				<div>
					<label for="lTelefono">Telefono:</label>
					<input name="telefono" id="telefono"/>
				</div>
				<div>
				<input id="submitEnviar"/>
				</div>
			</form>
			</td>
			<td id="colImages">
			</td>
		</tr>
	</table>