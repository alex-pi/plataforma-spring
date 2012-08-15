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
  	<link rel="stylesheet" href="static/js/libs/dojox/widget/Toaster/Toaster.css" />
  	<link rel="stylesheet" href="static/js//libs/dojox/grid/resources/soriaGrid.css">
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
  	        },{
  	        	name: 'static',
  	        	location: '<c:url value="/static"/>'
  	        }],
  	      	parseOnLoad: false,
  	        async: true,
  	      	debugAtAllCosts: true,
  	      	ioPublish: true,
  	      	cacheBust: true
  	    };  		
  	</script>
  	<script src="static/js/libs/dojo/dojo.js"></script>
	<script>
	require(["dojox/grid/DataGrid", "dojo/store/Memory","dojo/data/ObjectStore", 
	         "dojo/store/JsonRest", "dojox/data/QueryReadStore", "dojox/data/JsonRestStore", "dojo/_base/xhr", "dojo/domReady!"], 
			function(DataGrid, Memory, ObjectStore, JsonRest, QueryReadStore, JsonRestStore, xhr){
		
		var gridSimple,
			store,
			dataStore,
			qrs;
		
		function crearGrid(){

			gridSimple = new DataGrid({
				store: store,
				structure: [
					{ name: "Nombre", field: "nombre", width: "84px" },
					{ name: "Apellido", field: "apellido", width: "84px" },
					{ name: "e-mail", field: "email", width: "120px" },
					{ name: "Password", field: "password", width: "70px" },
					{ name: "Teléfono", field: "telefono", width: "90px" }
				],
				style: 'height: 200px;'
			}, dojo.byId("gridPaginado"));
			
			gridSimple.startup();
		}
		
		function init(){
// 			store = new JsonRest({target: dojo.config.app.urlBase + "usuarios"});
// 			dataStore = ObjectStore({objectStore: store});	
// 			qrs = new QueryReadStore({url: dojo.config.app.urlBase + "usuarios"});
			store = new JsonRestStore({target: dojo.config.app.urlBase + "usuarios"});
			crearGrid();
		}
		
		init();
	});
	</script>               
</head>
	<body class="soria">
        <div id="gridPaginado">

        </div>
    </body>
</html>
