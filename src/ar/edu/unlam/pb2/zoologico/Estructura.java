package ar.edu.unlam.pb2.zoologico;
import java.util.ArrayList;

import ar.edu.unlam.pb2.enums.ComidaHumanos;

public class Estructura {
	
	private Integer codigoEstructural;
	private String nombreEstructura;
	private Boolean estaRoto;


	public Estructura(Integer codigoEstructural, String nombreEstructura, Boolean estadoEstructura) {
		this.codigoEstructural = codigoEstructural;
		this.nombreEstructura = nombreEstructura;
		this.estaRoto = estadoEstructura;
	}


	public Boolean getEstaRoto() {
		return estaRoto;
	}


	public void setEstaRoto(Boolean estadoEstructura) {
		this.estaRoto = estadoEstructura;
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
