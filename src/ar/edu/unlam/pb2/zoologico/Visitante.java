package ar.edu.unlam.pb2.zoologico;

public class Visitante extends Persona {

	private Double dinero;

	public Visitante(Integer identificacion, String nombreCompleto, Integer edad, Double dinero) {
		super(identificacion, nombreCompleto, edad);
		// TODO Auto-generated constructor stub
		this.dinero = dinero;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}


}
