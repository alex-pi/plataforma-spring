<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			
<table class="pageTable">
		<tr>
			<td id="colForm">
				<form dojoType="dijit.form.Form" method="post" id="formularioForm" >
		<script type="dojo/method" event="onSubmit">
			if(this.validate()){
				return confirm('El formulario es válido, favor de presionar ok para continuar');
			}else{
				alert('El formulario contiene datos incorrectos, favor de corregirlos');
				return false;
			}
			return true;
		</script>
				<div>
					<label for="lfirstName">Nombre(s)*</label>
					<input type="text" required="true" name="firstName" id="firstName" placeholder="Nombre" 
							dojoType="dijit.form.ValidationTextBox" missingMessage="Ingresa tú nombre" />					
				</div>
				<div>
					<label for="lastName">Apellidos*</label>
					<input type="text" required="true" name="lastName" id="lastName" placeholder="Apellidos" 
							dojoType="dijit.form.ValidationTextBox" missingMessage="Ingresa tus Apellidos" />			
				<div>
				</div>
					<label for="lemail">E-mail*:</label>
					<input type="text" required="true" name="email" id="email" dojoType="dijit.form.ValidationTextBox" 
								validator="dojox.validate.isEmailAddress"/>					
				</div>
				<div>
					<label for="lpassword">Contraseña*:</label>
					<input type="password" required="true" name="password" id="password" dojoType="dijit.form.ValidationTextBox" 
								missingMessage="Ingresa tú password" />					

				</div>
				<div>
					<label for="lphone">Telefono:</label>
					<input type="text name="phone" id="phone"
							dojoType="dijit.form.ValidationTextBox" missingMessage="Ingresa tú teléfono" />
				</div>

				<input type="submit" value="Enviar" label="Enviar" id="submitButton" dojoType="dijit.form.Button" />
				
			</form>
			</td>
			<td id="colImages">
			</td>
		</tr>
	</table>