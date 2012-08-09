package mx.sep.sajja.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import mx.sep.sajja.modelo.Archivo;
import mx.sep.sajja.modelo.Ejemplo;
import mx.sep.sajja.servicios.ArchivoServicio;
import mx.sep.sajja.servicios.SistemaArchivosServicio;
import mx.sep.sajja.servicios.util.ErrorInfraestructura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Controller para administrar la subida de archivos.
 * 
 * @author Brian Hernández y Alejandro Pimentel
 *
 */
@Controller
@RequestMapping(value = "/archivos") 
public class UploadController {   
	
	@Autowired
	private ArchivoServicio archivoServicio;
	@Autowired
	private SistemaArchivosServicio sistemaArchivosServicio;
	
	/**
	 * Este método admite la subida de varios archivos a la vez.
	 * 
	 * @param idPath El identificador del path en el cual se guardará el archivo.
	 * @param guardarEnBD Bandera que indica si adicionalmente se debe guardar el archivo de Base de Datos.
	 * @param request
	 * 
	 * @return Una entidad ejemplo vacía. Podría sustituirse por un informe resultado de la carga de los archivos.
	 */
	@RequestMapping(value= "/upload", method = RequestMethod.POST)   
	@ResponseBody
	public Ejemplo uploadArchivos(@RequestParam("path") String idPath, @RequestParam(value="guardaBD", required=false) String guardarEnBD, HttpServletRequest request) {  
		
		MultiValueMap<String,MultipartFile> mapaArchivos ;
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
		mapaArchivos =  multipartRequest.getMultiFileMap();
		byte[] archivo;
		String nombreArchivo = "";   
		String type;    
		
		try {
			if(mapaArchivos != null && mapaArchivos.size() > 0){
				
				for(Entry<String, List<MultipartFile>> listaElementos : mapaArchivos.entrySet()) {
					
					List<MultipartFile> listaArchivos = listaElementos.getValue();
					for (MultipartFile multipartFile : listaArchivos) {
	
						nombreArchivo = multipartFile.getOriginalFilename(); 
						type = multipartFile.getContentType();  
						archivo = multipartFile.getBytes();
						
						sistemaArchivosServicio.escribirArchivo(idPath, nombreArchivo, archivo);
						
						if(guardarEnBD != null) {
							Archivo entidadArchivo = new Archivo();	
							entidadArchivo.setNombre(nombreArchivo);
							entidadArchivo.setRuta(sistemaArchivosServicio.obtenerPathAbsoluto(idPath));
							entidadArchivo.setDatos(archivo);
							archivoServicio.insertarArchivo(entidadArchivo);
						}
					}
					
				}
			}
		} catch(IOException ioe){
			throw new ErrorInfraestructura(ioe, "servicios.archivos.error.upload", new Object[]{nombreArchivo});
		}
		Ejemplo e = new Ejemplo();
		return e;
	}
	
	/**
	 * Una colección de los paths configurados para guardar archivos.
	 * 
	 * Es importante hacer notar que usando ACL's se podrían filtrar los paths que
	 * un usuario no deba ver.
	 * 
	 * @return Un mapa de identificador de path como llave y el path como valor.
	 */
	@RequestMapping(value= "/paths", method = RequestMethod.GET)   
	@ResponseBody	
	public Map<String,String> obtenerPaths(){
		return sistemaArchivosServicio.obtenerPaths();
	}
	
}

