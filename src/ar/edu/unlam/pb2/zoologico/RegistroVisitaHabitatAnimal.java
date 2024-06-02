package ar.edu.unlam.pb2.zoologico;

public class RegistroVisitaHabitatAnimal {
	private Persona visitante;
	private Estructura habitat;
	
	public RegistroVisitaHabitatAnimal(Persona visitante, Estructura habitat) {
		this.visitante=visitante;
		this.habitat=habitat;
	}

	public Persona getVisitante() {
		return visitante;
	}

	public void setVisitante(Persona visitante) {
		this.visitante = visitante;
	}

	public Estructura getHabitat() {
		return habitat;
	}

	public void setHabitat(Estructura habitat) {
		this.habitat = habitat;
	}
	
	
}
