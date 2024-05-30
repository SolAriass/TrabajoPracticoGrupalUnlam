package ar.edu.unlam.pb2.zoologico;

public class RegistroTratamiento {

	private Persona veterinario;
	private Animal animal;

	public RegistroTratamiento(Persona veterinario, Animal animal) {
		this.veterinario = veterinario;
		this.animal = animal;
	}

	public Persona getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Persona veterinario) {
		this.veterinario = veterinario;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	

}
