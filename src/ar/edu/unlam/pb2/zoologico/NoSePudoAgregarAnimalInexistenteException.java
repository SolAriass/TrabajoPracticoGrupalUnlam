package ar.edu.unlam.pb2.zoologico;

public class NoSePudoAgregarAnimalInexistenteException extends Exception {

	public NoSePudoAgregarAnimalInexistenteException(String mensaje) {
		super(mensaje);
	}

}
