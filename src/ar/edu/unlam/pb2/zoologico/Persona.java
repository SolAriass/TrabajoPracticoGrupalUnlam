package ar.edu.unlam.pb2.zoologico;

public class Persona {

	private Integer identificacion;
	private String nombreCompleto;
	private Integer edad;


	public Persona(Integer identificacion, String nombreCompleto, Integer edad) {
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


	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
