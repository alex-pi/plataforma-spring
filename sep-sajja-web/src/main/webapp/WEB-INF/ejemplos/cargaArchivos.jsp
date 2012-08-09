<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pre>
Este ejemplo muestra como subir varios archivos de manera asíncrona al servidor por medio del
Uploader de dojo.

- La pantalla obtiene la lista de directorios que se tienen configurados (ver SistemaArchivosServicioImpl)
  y los muestra en un Select.
- Se puede indicar si los archivos deben o no ser guardados en la base de datos.
- El controller encargado del lado del servidor es UploadController.
</pre>
<table>
	<tr>
		<td id="colForm">
			<form id="cargaForm">
				<fieldset>
					<legend>Selección de Archivos</legend>
					<input id="chkGuardarEnBase" type="checkbox"> <label for="chkGuardarEnBase">Guardar también en Base de datos</label> <br/>
					Directorio: <select id="sltDirectorio"></select> <br/>
					Selección <div id="uploader"></div>
					<input id="resetForm" />
					<input id="submitCarga" />
					<div id="listaArchivos"></div>
				</fieldset>
			</form>
		</td>
	</tr>
</table>
