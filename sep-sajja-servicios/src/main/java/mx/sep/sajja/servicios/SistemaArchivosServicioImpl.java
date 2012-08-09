package mx.sep.sajja.servicios;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import mx.sep.sajja.servicios.util.ErrorInfraestructura;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class SistemaArchivosServicioImpl implements SistemaArchivosServicio, ApplicationContextAware{

	private String dirBase;
	private Map<String,String> paths;
	private ApplicationContext ctx;
	
	public void escribirArchivo(String pathId, String nombreArchivo, byte[] archivo) throws ErrorInfraestructura {
		String pathDirectorio = dirBase+paths.get(pathId);
		try {
			Resource r = ctx.getResource(pathDirectorio);
			if(!r.exists()){
				throw new ErrorInfraestructura("servicios.archivos.error.directorio.noExiste", new Object[]{pathDirectorio});
			}
			File archivoLocal = new File(r.getFile(),nombreArchivo);
			if(!r.getFile().canWrite()){
				throw new ErrorInfraestructura("servicios.archivos.error.directorio.noPermisos", new Object[]{pathDirectorio});
			}
			if(!archivoLocal.exists()){
				archivoLocal.createNewFile();
			}
			
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivoLocal));
			bos.write(archivo);
			bos.close();
		} catch (IOException e) {
			throw new ErrorInfraestructura(e, "servicios.archivos.error.escritura", new Object[]{nombreArchivo, pathDirectorio});
		}
	}
	
	public Map<String, String> obtenerPaths() {
		return paths;
	}
	
	public String obtenerPathAbsoluto(String pathId){
		return dirBase+paths.get(pathId);
	}
	
	public void setDirBase(String dirBase) {
		this.dirBase = dirBase;
	}

	public void setPaths(Map<String, String> paths) {
		this.paths = paths;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
	}
}
