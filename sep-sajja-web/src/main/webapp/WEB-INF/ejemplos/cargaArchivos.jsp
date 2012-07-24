<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table class="pageTable">
		<tr>
			<td id="colForm">
				<form id="cargaForm">
					<fieldset>
						<legend>Seleccion de Archivos</legend>
						Seleccion <input id="uploader" type="file"/>
						<input id="resetForm" value="Clear1" />
						<input id="submitGarga" value="Cargar1" />
						<div id="listaArchivos"></div>
					</fieldset>
				</form>
			</td>
			<td id="colImages">
			</td>
		</tr>
	</table>
