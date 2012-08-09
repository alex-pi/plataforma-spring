package mx.sep.sajja.servicios;

import java.util.Map;

import mx.sep.sajja.servicios.util.ErrorInfraestructura;

/**
 * Servicios para leer y escribir archivos a un grupo de directorios
 * previamente configurado.
 * 
 * @author Alejandro Pimentel
 *
 */
public interface SistemaArchivosServicio {

	/**
	 * Intenta escribir un archivo al directorio relacionado al parámetro pathId. Si este directorio no
	 * se encuentra o no se tienen permisos de escritura el método lanza una excepción.
	 * 
	 * Si el archivo existe será sustituido.
	 * 
	 * @param pathId llave relacionada al directorio en que se guardará el archivo.
	 * @param nombreArchivo Nombre con que será guardado el archivo.
	 * @param archivo Contenido en bytes del archivo.
	 * @throws ErrorInfraestructura
	 */
	void escribirArchivo(String pathId, String nombreArchivo, byte[] archivo) throws ErrorInfraestructura;
	
	/**
	 * Obtiene todos los pares de identificador y directorio que se tienen configurados.
	 * 
	 * @return Un mapa de identificador de path como llave y el path como valor.
	 */
	Map<String, String> obtenerPaths();
	
	/**
	 * Obtiene el directorio absoluto relacionado al identificador que se pasa como
	 * parámetro.
	 * 
	 * @param pathId identificador del path
	 * @return path en formato absoluto
	 */
	String obtenerPathAbsoluto(String pathId);
}
