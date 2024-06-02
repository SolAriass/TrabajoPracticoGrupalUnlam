package ar.edu.unlam.pb2.zoologico;

import java.util.ArrayList;

public class Habitat extends Estructura {

	private Integer maximoAnimales;
	private Animal animalQueDeterminaEspecie;
	private ArrayList<Animal> animales;

	public Habitat(Integer codigoEstructural, String nombreEstructura, Integer maximoAnimales) {
		super(codigoEstructural, nombreEstructura);
		this.animales = new ArrayList<>();
		this.maximoAnimales = maximoAnimales;
		this.animalQueDeterminaEspecie = null;
	}

	public Boolean agregarAnimal(Animal animal) {
		if (this.animalQueDeterminaEspecie == null) {
			this.animalQueDeterminaEspecie = animal;
		}
		return animales.add(animal);
	}

	public Animal obtenerAnimal(Animal animalBuscado){
		for (Animal animal : animales) {
			if (animal.equals(animalBuscado)) {
				return animal;
			}
		}
		return null;
	}
	public ArrayList<Animal> getAnimales() {
		return animales;
	}
	

}
