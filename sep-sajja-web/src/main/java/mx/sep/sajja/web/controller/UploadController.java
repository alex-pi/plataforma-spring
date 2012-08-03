package mx.sep.sajja.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.sep.sajja.modelo.Archivo;
import mx.sep.sajja.modelo.Ejemplo;
import mx.sep.sajja.servicios.ArchivoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



@Controller
@RequestMapping(value = "/upload") 
public class UploadController {   
	
	
/*	@RequestMapping("/cargaArchivos")
	public String cargaArchivos() throws InterruptedException{		
		return new String("ejemplos/cargaArchivos");
	}*/
	
	@Autowired
	ArchivoServicio archivoServicio;
	
	@RequestMapping(value= "/cargaArchivos", method = RequestMethod.POST)   
	@ResponseBody
	public Ejemplo create(HttpServletRequest request, HttpServletResponse response) throws Exception {  
		
		MultiValueMap<String,MultipartFile> mapaArchivos ;
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
		mapaArchivos =  multipartRequest.getMultiFileMap();
		FileOutputStream outputStream = null;
		byte[] file;
		String filename;   
		String type;    

		if(mapaArchivos != null && mapaArchivos.size() > 0){
			
			for(Entry<String, List<MultipartFile>> listaElementos : mapaArchivos.entrySet())
			{
				
				List<MultipartFile> listaArchivos = listaElementos.getValue();
				for (Iterator iterator = listaArchivos.iterator(); iterator
						.hasNext();) {
					MultipartFile multipartFile = (MultipartFile) iterator
							.next();

					Archivo archivo = new Archivo();
					filename = multipartFile.getOriginalFilename(); 
					type = multipartFile.getContentType();  
					file = multipartFile.getBytes();  
					String filePath = ("c:\\temp\\" + StringUtils.trimAllWhitespace(filename));
					File localFile = new File(filePath);
					OutputStream out = new FileOutputStream(localFile);
					out.write(file);
					out.close();
					archivo.setNombre(filename);
					archivo.setRuta(filePath);
					archivo.setDatos(file);
					archivoServicio.insertarArchivo(archivo);
					
				}
				
			}
		}
		Ejemplo e = new Ejemplo();
		return e;
	} 
	
}

