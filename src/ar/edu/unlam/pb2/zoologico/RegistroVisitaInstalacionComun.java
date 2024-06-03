package ar.edu.unlam.pb2.zoologico;

public class RegistroVisitaInstalacionComun {

	private Persona visitante;
	private Estructura instalacionComun;
	
	public RegistroVisitaInstalacionComun(Persona visitante, Estructura instalacionComun) {
		this.visitante=visitante;
		this.instalacionComun=instalacionComun;
	}

	
	public Persona getVisitante() {
		return visitante;
	}

	public void setVisitante(Persona visitante) {
		this.visitante = visitante;
	}

	public Estructura getInstalacionComun() {
		return instalacionComun;
	}

	public void setInstalacionComun(Estructura instalacionComun) {
		this.instalacionComun = instalacionComun;
	}


	@Override
	public String toString() {
		return "RegistroVisita [visitante=" + visitante + ", instalacionComun=" + instalacionComun + "]";
	}
	
	
}
