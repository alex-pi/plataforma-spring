<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<pre>
</pre>
<form id="usuarioSeguridadForm">			
<table class="pageTable">		
		<tr>
			<td><label for="username">Username*: </label></td>
			<td><input name="username" id="usernameUsuSeg"/></td>					
		</tr>
		<tr>
			<td><label for="nombre">Nombre del Usuario*:</label></td>
			<td><input name="nombre" id="nombreUsuSeg"/></td>			
		</tr>
		<tr>
			<td><label for="activo">Activo:</label></td>
			<td><input type="checkbox" name="activo" id="activoUsuSeg"/></td>					
		</tr>
		<tr>
			<td><label for="password">Contraseña*:</label></td>
			<td><input name="password" id="passwordUsuSeg" /></td>					

		</tr>
		<tr>
			<td><input id="btnRegistrarUsuSeg" /></td>
		</tr>
</table>
</form>