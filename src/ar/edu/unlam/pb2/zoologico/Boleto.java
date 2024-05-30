package ar.edu.unlam.pb2.zoologico;

public class Boleto {
	Integer ID=1;
	Double valor;

	public Boleto() {
		this.ID++;
		this.valor=Zoologico.getPrecioEntrada();
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
