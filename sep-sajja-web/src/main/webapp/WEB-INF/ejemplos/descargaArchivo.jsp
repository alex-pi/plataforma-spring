<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pre>
El ejemplo muestra una lista de directorios y una de archivos según se seleccione la primera. Los archivos se leen de los
directorios configurados para la clase SistemaArchivosServicioImpl.

La descarga se lleva a cabo por medio de un simple formulario que al tener el archivo listo abre otra ventana para evitar perder
nuestra pantalla principal.

Se mostrará un error si ninguno de los directorios configurados para SistemaArchivosServicioImpl existe.

El controller encargado de la descarga es ArchivosController. 

</pre>

<form id="descargaForm">
	<fieldset>
		<legend>Selección de Archivo</legend>
		Directorio: <select id="sltDirectorio"></select> <br/>
		Archivo: <select id="sltArchivo"></select> <br/>
		<input id="btnDescarga" />
	</fieldset>
</form>

