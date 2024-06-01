package ar.edu.unlam.pb2.zoologico;

public class RegistroTratamiento {

	private Persona personal;
	private Animal animal;
	
	
	public RegistroTratamiento(Persona personal, Animal animal) {
		this.personal = personal;
		this.animal = animal;
	}


	public Persona getPersonal() {
		return personal;
	}


	public void setPersonal(Persona personal) {
		this.personal = personal;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
	
	
	
	
}
