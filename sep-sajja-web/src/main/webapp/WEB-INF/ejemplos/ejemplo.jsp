<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pre>
Para cada tab que se muestra al dar click en el menú, se intenta cargar un módulo JS y un template (Html). Ver WEB-INF/index.jsp

Hablemos de los módulos primero:
- El módulo que se carga para este tab está dentro del archivo:
	static/js/app/ejemplos/modulo.js
- Cada módulo se define del siguiente modo:
	define(['dep1','dep2'], function(dep1, dep2){
		// Hacer algo aqui con mis dos módulos...
	});
- Al mismo tiempo dep1 y dep2 pueden depender de otros módulos para hacer su trabajo. Dojo se encarga de que cada módulo sea cargado sólo una vez.

Por ejemplo, nuestro modulo.js requiere de util_ejemplo:
	define(["app/ejemplos/util_ejemplo"], function(util){...}
Y a su vex util_ejemplo tiene sus propias dependencias:
	define(["dojo/dom"], function(dom){...}
	
¿Y qué pasa con nuestro template?
- Es justo el jsp en el que nos encontramos. O más exactamente el Html que este generará.
- El url que devuelve nuestro template es: mvc/ejemplos/modulo . Este url es atendido por un controller (EjemplosController) que eventualmente devolverá este JSP.
	Veamos el código del controller que se encarga de esto:
	
	@RequestMapping("/modulo")
	public String moduloSimple() throws InterruptedException{
		// Con esto simulamos una petición tardada para mostrar más tiempo la imágen de carga de nuestro Tab.
		Thread.sleep(7000);
		return new String("ejemplos/ejemplo");
	}	
</pre>
<h2 id="saludo">Mi primer script con AMD </h2>
