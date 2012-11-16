package mx.sep.sajja.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.servicios.MttoSeguridadServicio;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * El controller ejemplifica cómo los reportes generados por jasper son
 * tratados como vistas en Spring MVC.
 * 
 * Las vistas(reportes) son beans definidos en el archivo jasper-sajja-config.xml
 * 
 * @author Alejandro Pimentel
 *
 */
@Controller
@RequestMapping("/reportes")
public class ReportesController {

	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;
	
	/**
	 * El método además de devolver una vista espera unos segundos para
	 * mostrar en el navegador el indicador de espera para la carga de la pantalla.
	 * 
	 * @return Un objeto ModelAndView que Spring convertirá en un reporte con Jasper.
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/usuarios")
	public ModelAndView generarReporte() {
		Map model = new HashMap();		
		List<UsuarioSeguridad> usuarios = mttoSeguridadServicio.consultarUsuariosConRoles();
		
		model.put("dataSource", new JRBeanCollectionDataSource(usuarios));
		return new ModelAndView("reporteUsuarios", model);
	}
	
}
