<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">	
  	<title>Sistema de Administración de Juicios Jurídico Administrativos.</title>
	<link rel="stylesheet" href="static/css/style.css" media="screen">
  	<link rel="stylesheet" href="static/js/libs/dijit/themes/soria/soria.css" media="screen">  
  	<script>
  		dojoConfig= {
			has: {
	            "dojo-firebug": true,
	            "dojo-debug-messages": true
	        },  				
  	        app: {
  	        	urlBase: '<c:url value="/mvc/"/>',
  	        	urlStatic: '<c:url value="/static/"/>'
  	        	},
  	        packages:[{
  	        	name: 'app',
  	        	location: '<c:url value="/static/"/>js/app'
  	        },{
  	        	name: 'content',
  	        	location: '<c:url value="/mvc"/>'
  	        }],
  	      	parseOnLoad: false,
  	        async: 1,
  	      	cacheBust: true,
  	      	publishRequireResult: true,
  	      	uploaderPath: '<c:url value="/static/"/>js/libs/dojox/form/resources/uploader.swf'
  	    };  		
  	</script>
  	<script src="static/js/libs/dojo/dojo.js"></script>
	<script>
		require(["dojo/_base/xhr", "dojo/_base/array", "dojox/form/uploader/plugins/IFrame", "dojo/domReady!"],
		        function(xhr, arrayUtil){					

		        });
	</script>               
</head>
	<body class="soria">
        <div id="layoutPrincipal">

        </div>
    </body>
</html>
