package ar.edu.unlam.pb2.zoologico;

public class Visitante extends Persona {

	private Double dineroQueDispone;
	private Boleto boleto;

	public Visitante(Integer identificacion, String nombreCompleto, Integer edad, Double dineroQueDispone) {
		super(identificacion, nombreCompleto, edad);
		this.dineroQueDispone = dineroQueDispone;
		this.boleto = null;
	}

	public Double getDineroQueDispone() {
		return dineroQueDispone;
	}

	public void setDineroQueDispone(Double dineroQueDispone) {
		this.dineroQueDispone = dineroQueDispone;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	@Override
	public String toString() {
		return "Visitante [boleto=" + boleto + "]";
	}

}
