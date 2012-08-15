<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pre>

Este ejemplo muestra un grid que carga la información bajo demanda. Igualmente se puede ordenar la información
dando click en alguna de las columnas.

Los urls indican al servidor cómo se debe ordenar la información, por ejemplo:
	
	mvc/usuarios/?sort(+nombre)
	mvc/usuarios/?sort(-nombre)
	
Dentro de los encabezados de la petición viaja el rango de registros solicitado:

	Range	items=0-19

El servidor debe devolver un encabezado parecido pero agregando el total de registros en la fuente de datos.

	Content-Range	items 0-19/981
	
Estos encabezados son parte del estándar descrito en: <a href="http://www.ietf.org/rfc/rfc2616.txt" target="_blank">http://www.ietf.org/rfc/rfc2616.txt</a>

JsonRest y JsonRestStore tratan de apegarse a este estándar. 

</pre>
<div id="gridPaginado"></div>