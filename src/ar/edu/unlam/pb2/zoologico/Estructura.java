package ar.edu.unlam.pb2.zoologico;

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEstructural == null) ? 0 : codigoEstructural.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estructura other = (Estructura) obj;
		if (codigoEstructural == null) {
			if (other.codigoEstructural != null)
				return false;
		} else if (!codigoEstructural.equals(other.codigoEstructural))
			return false;
		return true;
	}

	

}
