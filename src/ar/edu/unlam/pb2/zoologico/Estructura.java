package ar.edu.unlam.pb2.zoologico;

public class Estructura {
	
	private Integer codigoEstructural;
	private String nombreEstructura;

	public Estructura(Integer codigoEstructural, String nombreEstructura) {
		this.codigoEstructural = codigoEstructural;
		this.nombreEstructura = nombreEstructura;
	}

	public Integer getCodigoEstructural() {
		return codigoEstructural;
	}

	public void setCodigoEstructural(Integer codigoEstructural) {
		this.codigoEstructural = codigoEstructural;
	}

	public String getNombreEstructura() {
		return nombreEstructura;
	}

	public void setNombreEstructura(String nombreEstructura) {
		this.nombreEstructura = nombreEstructura;
	}

}
