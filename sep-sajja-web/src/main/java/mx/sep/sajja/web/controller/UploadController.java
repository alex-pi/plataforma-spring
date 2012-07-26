package mx.sep.sajja.web.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.sep.sajja.modelo.Ejemplo;

import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value= "/cargaArchivos", method = RequestMethod.POST)   
	@ResponseBody
	public Ejemplo create(HttpServletRequest request, HttpServletResponse response) throws Exception {  
		
		MultipartFile multipartFile;
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
		multipartFile = multipartRequest.getFile("uploadedfiles[]");
		FileOutputStream outputStream = null;  
		if(multipartFile != null){		
			byte[] file;
			String filename;   
			String type;  
			
			filename = multipartFile.getOriginalFilename(); 
			type = multipartFile.getContentType();  
			file = multipartFile.getBytes();  
			String filePath = System.getProperty("java.io.tmpdir") + "/" + filename;  
			try {  
				outputStream = new FileOutputStream(new File(filePath));  
				outputStream.write(file);  
				outputStream.close();  
			} catch (Exception e) {  
				System.out.println("Error while saving file");  
			}
		}
		Ejemplo e = new Ejemplo();
		return e;
	} 

}

