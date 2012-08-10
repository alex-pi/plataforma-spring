package mx.sep.sajja.servicios;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mx.sep.sajja.servicios.util.ErrorInfraestructura;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class SistemaArchivosServicioImpl implements SistemaArchivosServicio, ApplicationContextAware{

	private final Map<String,String> PATHS;
	private ApplicationContext ctx;
	private final String DIR_BASE;
		
	public SistemaArchivosServicioImpl(Map<String, String> paths, String dirBase) {
		this.PATHS = paths;
		DIR_BASE = dirBase;
	}

	/**
	 * {@inheritDoc}
	 */
	public void escribirArchivo(String pathId, String nombreArchivo, byte[] archivo) throws ErrorInfraestructura {
		String pathDirectorio = DIR_BASE+PATHS.get(pathId);
		try {
			Resource r = this.obtenerRecurso(pathDirectorio);

			File archivoLocal = new File(r.getFile(),nombreArchivo);
			this.verificarPermisosEscritura(r.getFile());
			
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
	
	/**
	 * {@inheritDoc}
	 */	
	public List<String> obtenerNombresArchivos(String pathId){
		String pathDirectorio = DIR_BASE+PATHS.get(pathId);
		Resource r = this.obtenerRecurso(pathDirectorio);
		File dir = obtenerFile(r);

		List<String> archivos = Arrays.asList(dir.list());
		
		return archivos;
	}
	
	/**
	 * {@inheritDoc}
	 */	
	public byte[] leerArchivo(String pathId, String nombreArchivo){
		String pathDirectorio = DIR_BASE+PATHS.get(pathId);
		Resource r = this.obtenerRecurso(pathDirectorio+nombreArchivo);
		byte[] archivo = null;
		
		try {
			archivo = IOUtils.toByteArray(r.getInputStream());
		} catch (IOException e) {
			throw new ErrorInfraestructura(e, "servicios.archivos.error.lectura", new Object[]{nombreArchivo, pathDirectorio});
		}
		
		return archivo;
	}
	
	private Resource obtenerRecurso(String pathAbsoluto){
		Resource r = ctx.getResource(pathAbsoluto);
		if(!r.exists()){
			throw new ErrorInfraestructura(new Object[]{pathAbsoluto}, "servicios.archivos.error.directorio.noExiste");
		}		
		
		return r;
	}
	
	private File obtenerFile(Resource r){
		File f = null;
		try {
			f = r.getFile();
			return f;
		} catch (IOException e) {
			throw new ErrorInfraestructura(new Object[]{r.getFilename()}, "servicios.archivos.error.directorio.noExiste");
		}
	}
	
	private void verificarPermisosEscritura(File f){
		if(!f.canWrite()){
			throw new ErrorInfraestructura(new Object[]{f.getAbsolutePath()}, "servicios.archivos.error.directorio.noPermisos.escritura");
		}		
	}
	
	private void verificarPermisosLectura(File f){
		if(!f.canRead()){
			throw new ErrorInfraestructura(new Object[]{f.getAbsolutePath()}, "servicios.archivos.error.directorio.noPermisos.lectura");
		}		
	}
	
	/**
	 * {@inheritDoc}
	 */	
	public Map<String, String> obtenerPaths() {
		Map<String, String> soloExistentes = new HashMap<String, String>();
		for (Entry<String,String> p : PATHS.entrySet()) {
			Resource r = ctx.getResource(DIR_BASE+p.getValue());
			if(r.exists()){
				soloExistentes.put(p.getKey(), p.getValue());
			}
		}

		return soloExistentes;
	}
	
	/**
	 * {@inheritDoc}
	 */	
	public String obtenerPathAbsoluto(String pathId){
		return DIR_BASE+PATHS.get(pathId);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
	}
}
