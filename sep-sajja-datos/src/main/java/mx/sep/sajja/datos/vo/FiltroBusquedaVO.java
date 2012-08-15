package mx.sep.sajja.datos.vo;

/**
 * Este bean contiene información básica para contruir una consulta paginada y ordenada
 * por algún campo campo.
 * 
 * @author Alejandro Pimentel
 *
 */
public class FiltroBusquedaVO {

	private Integer desde;
	private Integer hasta;
	private Integer limite;
	private String nombreCampo;
	private String ascDesc;	
	
	public FiltroBusquedaVO(Integer desde, Integer hasta, String nombreCampo,
			String ascDesc) {
		this.desde = desde;
		this.hasta = hasta;
		this.nombreCampo = nombreCampo;
		this.ascDesc = ascDesc;
		this.limite = hasta-desde;
	}

	/**
	 *  
	 * @return El nombre del campo con el que se ordenará.
	 */
	public String getNombreCampo() {
		return nombreCampo;
	}

	/**
	 * 
	 * @return Una cadena que indica el tipo de ordenamiento ascendente/descendente.
	 */
	public String getAscDesc() {
		return ascDesc;
	}

	/**
	 * 
	 * @return Número de registro desde el cual se buscará.
	 */
	public Integer getDesde() {
		return desde;
	}

	/**
	 * 
	 * @return Número de regitro hasta el cual se obtendrán datos.
	 */
	public Integer getHasta() {
		return hasta;
	}

	/**
	 * 
	 * @return Cantidad de registros que se obtendrán.
	 */
	public Integer getLimite() {
		return limite;
	}
	
}
