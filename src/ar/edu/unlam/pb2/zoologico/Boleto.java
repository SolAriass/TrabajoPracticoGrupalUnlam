package ar.edu.unlam.pb2.zoologico;

public class Boleto {
	private static Integer contadorID=0;
	private Integer ID;
	private final static Double VALOR=2500.0;

	public Boleto() {
		contadorID++;
		ID=contadorID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		this.ID = iD;
	}

	public static Double getValor() {
		return VALOR;
	}

	@Override
	public String toString() {
		return "Boleto [ID()=" + getID() + "]";
	}


}
