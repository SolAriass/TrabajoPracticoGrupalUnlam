package ar.edu.unlam.pb2.zoologico;

public class Persona {

	private Object identificacion;
	private String nombreCompleto;
	private Integer edad;


	public Persona(Integer identificacion, String nombreCompleto, Integer edad) {
		this.identificacion = identificacion;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	
}
