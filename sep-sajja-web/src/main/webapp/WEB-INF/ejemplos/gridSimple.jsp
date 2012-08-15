<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<pre>
Este ejemplo muestra un uso sencillo del DataGrid con dojo.

- La información es cargada por una petición ajax. La información obtenida está en formato JSON. Es una lista de objetos tipo Usuario.
- Al seleccionar alguna fila del grid se muestra en consola el objeto correspondiente.

Se debe recordar llamar al método startup() del grid para inicializar el componente. El panel no lo llamará pues el grid es un 
componente de dojox no de dijit.

</pre>
<div id="gridSimple"></div>