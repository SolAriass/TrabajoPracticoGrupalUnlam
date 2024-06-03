package ar.edu.unlam.pb2.zoologico;

import java.util.Objects;

public class Estructura {

	private Integer codigoEstructural;
	private String nombreEstructura;

	// holaaaa, sisi diablo :(

	public Estructura(Integer codigoEstructural, String nombreEstructura) {
		this.codigoEstructural = codigoEstructural;
		this.nombreEstructura = nombreEstructura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoEstructural);
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
		return Objects.equals(codigoEstructural, other.codigoEstructural);
	}

	public Integer getCodigoEstructural() {
		return codigoEstructural;
	}

	public void setCodigoEstructural(Integer codigoEstructural) {
		this.codigoEstructural = codigoEstructural;
	}

}
