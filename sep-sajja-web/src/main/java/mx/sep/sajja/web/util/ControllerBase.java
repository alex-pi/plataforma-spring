package mx.sep.sajja.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import mx.sep.sajja.datos.vo.FiltroBusquedaVO;

/**
 * Los controllers pueden heredar de esta clase para hacer uso de utilerías y helpers.
 * 
 * @author Alejandro Pimentel
 *
 */
public abstract class ControllerBase {
	
	/**
	 * Método de utilería para simplificar el uso de operaciones REST como paginación y ordenamiento.
	 * 
	 * @param rango cadena con información de la paginación en la forma items=x-y
	 * @param total
	 * @param request
	 * @param response
	 * @return
	 */
	protected FiltroBusquedaVO manejarRestPaging(String rango, Integer total, HttpServletRequest request, HttpServletResponse response){
		String[] rangos = rango.substring("items=".length()).split("-");
		int desde = Integer.valueOf(rangos[0]);
		int hasta = Integer.valueOf(rangos[1]);	
		String nombreCampo = null;
		String ascDesc = null;
		
		String queryString = request.getQueryString();
		if(StringUtils.hasText(queryString) && queryString.indexOf("sort(") != -1){
			Integer idx = "sort(".length();
			nombreCampo = queryString.substring(idx+1, queryString.indexOf(")"));
			ascDesc = queryString.substring(idx, idx+1);	
			ascDesc = ascDesc.equals("+")? "asc":"desc";
		}
		
		response.addHeader("Content-Range", "items " + desde + "-" + hasta + "/" + total);
		
		return new FiltroBusquedaVO(desde, hasta, nombreCampo, ascDesc);
	}
}
