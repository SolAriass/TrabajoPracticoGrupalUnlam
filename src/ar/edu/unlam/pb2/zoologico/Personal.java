package ar.edu.unlam.pb2.zoologico;

import java.util.Objects;

public class Personal {

	private Integer identificacion;
	private String nombreCompleto;
	private Integer edad;

	public Personal(Integer identificacion, String nombreCompleto, Integer edad) {
		this.identificacion = identificacion;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
	}

	public Integer getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return Objects.equals(identificacion, other.identificacion);
	}

}
