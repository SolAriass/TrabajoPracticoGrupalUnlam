package ar.edu.unlam.pb2.zoologico;

<<<<<<< HEAD
=======
import java.util.Objects;

>>>>>>> rama-nico-bon
public class Persona {

	private Integer identificacion;
	private String nombreCompleto;
	private Integer edad;

<<<<<<< HEAD

=======
>>>>>>> rama-nico-bon
	public Persona(Integer identificacion, String nombreCompleto, Integer edad) {
		this.identificacion = identificacion;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
	}
<<<<<<< HEAD
	
=======

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
		Persona other = (Persona) obj;
		return Objects.equals(identificacion, other.identificacion);
	}

>>>>>>> rama-nico-bon
}
