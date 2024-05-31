package ar.edu.unlam.pb2.zoologico;

public class Boleto {
	private static Integer ID=1;
	private final static Double VALOR=2500.0;

	public Boleto() {
		ID++;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public static Double getValor() {
		return VALOR;
	}


}
