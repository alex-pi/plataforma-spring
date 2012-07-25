<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table class="pageTable">
		<tr>
			<td id="colForm">
				<form id="cargaForm">
					<fieldset>
						<legend>Selección de Archivos</legend>
						Selección <div id="uploader"></div>
						<input id="resetForm" />
						<input id="submitCarga" />
						<div id="listaArchivos"></div>
					</fieldset>
				</form>
			</td>
			<td id="colImages">
			</td>
		</tr>
	</table>
