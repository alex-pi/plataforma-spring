<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pre>
El siguiente ejemplo muestra la generación de un reporte con jasper. La configuración en el proyecto
consta de varios puntos:

1) Se agrega dependencia al artefacto groovy-all en el pom del proyecto padre.
2) En archivo pom del módulo web se agregan dependencias a los artefactos de jasper: jasperreports y jasperreports-fonts.
3) También en el mismo pom se configura plugin de compilación de archivos jrxml.
4) Se agrega un nuevo modo de resolución de vistas para controllers en archivo web-context.xml.

    &lt;bean class="org.springframework.web.servlet.view.XmlViewResolver"
          p:location="/WEB-INF/spring-config/jasper-sajja-config.xml"
          p:order="0"/&gt;

Para crear nuevos reportes:
1) Colocar archivo jrxml bajo el directorio (en módulo web): src/main/resources/mx/sep/sajja/reportes/jasper/

	p.e. src/main/resources/mx/sep/sajja/reportes/jasper/reporteUsuarios.jrxml

2) Configurar el archivo .jasper que la compilación generará como una nueva vista de spring dentro del archivo jasper-sajja-config.xml
	El archivo .jasper será generado en el directorio: /WEB-INF/classes/mx/sep/sajja/reportes/jasper/reporteUsuarios.jasper 
	
    &lt;bean id="reporteUsuarios"
          class="org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView"&gt;
        &lt;property name="url" value="/WEB-INF/classes/mx/sep/sajja/reportes/jasper/reporteUsuarios.jasper"/&gt;
    &lt;/bean&gt;
    
3) Devolver un objeto ModelAndView desde el controller correspondiente, el nombre de la vista será el id del bean definido arriba: "reporteUsuarios".
   El objeto de modelo debe contener los datos que el reporte consumirá, p.e., en jasper se puede usar alguno de los tipos de DataSource que incluye.
   
		Map model = new HashMap();		
		List&lt;UsuarioSeguridad&gt; usuarios = mttoSeguridadServicio.consultarUsuarios();
		
		model.put("dataSource", new JRBeanCollectionDataSource(usuarios));
		return new ModelAndView("reporteUsuarios", model);   
          
</pre>
<h2>Generación de un reporte con jasper.</h2>

<form id="generaReporteForm">
	<fieldset>
		<legend>Reporte simple</legend>
		<button id="btnGenerarReporte"></button>
	</fieldset>
</form>

