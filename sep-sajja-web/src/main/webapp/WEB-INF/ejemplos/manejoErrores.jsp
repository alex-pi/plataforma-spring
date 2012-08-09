<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pre>
Este ejemplo muestra las posibilidades que se tienen en cuanto a manejo de errores en la aplicación:

1) El primer botón hace una petición ajax a 'ejemplos/error/simple/1'. La app simplemente lanzará una excepción:

	throw new ErrorNegocio("Aqui se explica lo que salió mal con la lógica de negocio.");
	
  	Ya que nuestra petición no declara un 'handler' para cuando hay error, la app muestra un diálogo con la información del error.

2) El segundo botón por el contrario provocará que el servidor lance la excepción del siguiente modo:

	Ejemplo e = new Ejemplo();
	e.setId(1l);
	e.setCampo1("Información adicional del error.");
	throw new ErrorNegocio(new Object[]{}, "codigo.mensaje.ejemplo", e);
	
	El objeto llamado 'e' contiene información adicional y específica para el error que ha sucedido. De este modo desearíamos
	procesar el error nosotros mismos, de ahi que para esta petición sí declaremos un 'handler' para error.
	
		error: function(resp){
			var infoError = json.fromJson(resp.responseText);
			var nodoInfo = domConstruct.create("div", {id:'divInfo', style: {display: 'block'}});
			....						
		}
----

El ejemplo muestra además cómo crear nodos dinámicamente usando 'dojo/dom-construct'.
</pre>