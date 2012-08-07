<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pre>
El url para cargar el template de cada tab es de la forma mvc/**/nombreTemplate. Por ejemplo este template se encuentra en:
	mvc/ejemplos/controllerJsp

Gracias a la configuración de spring mvc (ver web-context.xml) el path/url mencionado puede ser de un JSP o de un Controller.

- Spring intentará resolverlo como un path de un Controller y este probablemente nos regrese un JSP.
- Si no encuentra un controller que atienda ese url buscará un JSP directamente.
- Si no encuentra ninguno de los dos devolverá un error 404.

Pero... ¿Por qué sería útil en primer lugar pasar por un Controller para obtener mi JSP? 
	Respuesta corta: Para colocar información en el JSP que pueda ser usada con JSTL o algún otro mecanismo.

------
Hablemos de este ejemplo en concreto. Al momento este ejemplo va directamente al JSP pues no hay un controller que corresponda con el url :
	mvc/ejemplos/controllerJsp
	
Podemos cambiar esto en nuestro EjemplosController.java :

//	@RequestMapping("/controllerJsp") <strong>Debemos descomentar esta línea para pasar primero por el Controller.</strong>
	public ModelAndView vistaDesdeController() {
		return new ModelAndView("ejemplos/controllerJsp","datoModelo", "Despachado por controller");
	}
</pre>
<h1>${datoModelo}</h1>
<h2 id="miDiv">Generado por un JSP !!!</h2>
