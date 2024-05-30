package ar.edu.unlam.pb2.zoologico;

public class Visitante extends Persona {

	private Double dineroQueDispone;

	public Visitante(Integer identificacion, String nombreCompleto, Integer edad, Double dineroQueDispone) {
		super(identificacion, nombreCompleto, edad);
		this.dineroQueDispone = dineroQueDispone;
	}

	public Double getDineroQueDispone() {
		return dineroQueDispone;
	}

	public void setDineroQueDispone(Double dineroQueDispone) {
		this.dineroQueDispone = dineroQueDispone;
	}

}
