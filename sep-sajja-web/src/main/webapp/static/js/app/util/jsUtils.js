define([
	"dojo/_base/xhr",
	"dojo/store/Memory",
	"dojo/DeferredList",
	"dojo/_base/Deferred",
	"dojo/_base/lang",
	"dijit/registry",
	"app/util/constants"
],function(
	xhr,
	Memory,
	DeferredList,
	Deferred,
	lang,
	registry,
	constants
){
	var isEmpty = function(obj){
		for(var i in obj){
			if(obj.hasOwnProperty(i)){
				return false;
			}
		}

		return true;
	};
	/**
	 * Obtiene de una URL un arreglo de objetos para devolverlo como Memory
	 * Params: object
	 *		properties: 
	 *			urlBase url base para de los contraladores
	 *			requestMapping RequestMapping a obtener List<? extends Object>
	 *			load function que recibe el resultado
	 * Return: dojo/store/Memory
	 */
	var getMemory= function( object ){
		xhr.get({
			url: object.urlBase + object.requestMapping,
			headers : {
			     "Content-Type" : "application/json; charset=UTF-8"
			},					
			handleAs: 'json',
			load: function(response){
				var objStore = new Memory({
					data: response
				});
				object.load( objStore );
			}
		});	
	};
	/**
	 *envia una petición Json de un objeto Json
	 *Params: object
	 *		properties:
	 *			urlBase url base para de los contraladores
	 *			requestMapping RequestMapping a enviar la peticion
	 *			data objeto en js tipo JSON
	 *			load function que recibe el resultado
	 *			configModule configuracion de objetos del contendedor
	 */
	var submitObject = function( object ){
		console.log( object );
		if ( object.configModule ){
			object.configModule.standby.show();
		}
		xhr.post({
			url: object.urlBase + object.requestMapping,
			postData: dojo.toJson( object.data ),
			headers : {
			     "Content-Type" : "application/json; charset=UTF-8"
			},					
			handleAs: 'json',
			load: function( response ){
				if ( object.configModule ){
					object.configModule.standby.hide();
				}
				object.load( response );
			}
		});		
	};
	/**
	 *envia una petición Json de un objeto Json
	 *Params: object
	 *		properties:
	 *			urlBase url base para de los contraladores
	 *			requestMapping RequestMapping a enviar la peticion
	 *			data objeto en js tipo JSON
	 *			load function que recibe el resultado
	 *			configModule configuracion de objetos del contendedor
	 */
	var submitUrl = function( object ){
		if ( object.configModule ){
			object.configModule.standby.show();
		}
		xhr.get({
			url: object.urlBase + object.requestMapping,
			headers : {
			     "Content-Type" : "application/json; charset=UTF-8"
			},					
			handleAs: 'json',
			load: function( response ){
				if ( object.configModule ){
					object.configModule.standby.hide();
				}
				object.load( response );
			}
		});		
	};
	/**
	 *De un objeto Json realiza set('value') a las variables declaradas con los
	 *nombres de las propiedades
	 **/
	var setVarWidgetFromObject = function( object , objectWidget, aleatorio ){
		var widget = null;
		for (var property in object) {
			//widget = objectWidget[ property ];
			widget = registry.byId( property + ((aleatorio)?aleatorio:"") );
			if ( widget == null || widget == undefined || property == '__parent' ){
				console.log(property + '-->Fue omitido', widget);
				continue;
			}
			if ( object[ property ] == null ){
				continue;
			}
			//widget = module.get( property );//eval( property );
			console.log( "Variable que debe existir: " + property + " de tipo: " + widget.declaredClass );
			if ( widget.declaredClass == 'dijit.form.CheckBox' ){
				var value = object[ property ];
				if ( value == '1' ){
					widget.set('checked', true );
				}else{
					widget.set('checked', false );
				}
			}else if ( widget.declaredClass == 'dijit.form.FilteringSelect' ){	
				var store = widget.get('store');
				var options = {
					deep: true
				};
				var funtionQuery = function( data ){
					return eval( "data."+property+" == '"+ object[ property ] +"'" );
				};
				var def = store.query( funtionQuery , options );
				Deferred.when( def, function( item ){
					if ( item == null || item.length == 0 ) return;
					console.log("ITEM DEL SELECT OBTENIDO POR BUSQUEDA");
					console.log(item);
					var searchAttrOrig = widget.get('searchAttr');
					var unItem = item[0];
					widget.set('displayedValue', unItem[ searchAttrOrig ] );
				}, function(err){
					console.error('dijit.form.FilteringSelect: ' + err.toString());
				});
			}else if( widget.declaredClass == 'dijit.form.DateTextBox' ){
				console.log("Fecha a pasar al control: " + object[ property ]);
				widget.set('value', new Date(object[ property ]) );
			}else{
				widget.set('value', object[ property ] );
			}
		}
	};
	
	var validFileFilter = function( type ){
		var filtros = constants.TYPE_FILES_FILTER;
		var existe = false;
		var concat = "";
		for( var property in filtros ){
			if ( filtros[ property ].type ==  type ){
				existe = true;
			}
			concat += filtros[ property ].descripcion + " ";
		}
		if ( existe ){
			return existe;
		}else{
			return concat;
		}
	};
	
	return {
		isEmpty: isEmpty,
		getMemory: getMemory,
		setVarWidgetFromObject: setVarWidgetFromObject,
		submitObject: submitObject,
		submitUrl: submitUrl,
		validFileFilter: validFileFilter
	};
});