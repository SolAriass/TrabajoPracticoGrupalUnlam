package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.ArrayList;

public class Zoologico implements IZoologico {

	private String nombreZoo;
	private Boolean seEncuentraAbierto;
	private Boolean estaLimpio;
	private List<Animal> animales;
	private List<Personal> personas;
	private List<Estructura> estructuras;

	public Zoologico(String nombreZoo) {
		this.nombreZoo = nombreZoo;
		this.estaLimpio = true;
		this.seEncuentraAbierto = true;
		this.animales = new ArrayList<>();
		this.personas = new ArrayList<>();
		this.estructuras = new ArrayList<>();
	}

	public String getNombreZoo() {
		return nombreZoo;
	}

	public void setNombreZoo(String nombreZoo) {
		this.nombreZoo = nombreZoo;
	}

	public Boolean getSeEncuentraAbierto() {
		return seEncuentraAbierto;
	}

	public void setSeEncuentraAbierto(Boolean seEncuentraAbierto) {
		this.seEncuentraAbierto = seEncuentraAbierto;
	}

	public Boolean getEstaLimpio() {
		return estaLimpio;
	}

	public void setEstaLimpio(Boolean estaLimpio) {
		this.estaLimpio = estaLimpio;
	}

	@Override
	public Boolean agregarAnimalAlZoo(Animal animal) {
		return animales.add(animal);
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	@Override
	public Boolean agregarPersonalAlZoo(Personal persona) {
		return personas.add(persona);
	}

	public List<Personal> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Personal> personas) {
		this.personas = personas;
	}

	@Override
	public Boolean agregarEstructuraAlZoo(Estructura estructura) {
		return estructuras.add(estructura);
	}

	public List<Estructura> getEstructuras() {
		return estructuras;
	}

	public void setEstructuras(List<Estructura> estructuras) {
		this.estructuras = estructuras;
	}

	public Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat) {

		if (habitat instanceof Habitat && this.obtenerAnimal(animal) != null
				&& this.obtenerEstructura(habitat) != null) {
			Habitat habitatVerificado = (Habitat) habitat;
			return habitatVerificado.agregarAnimal(animal);
		}
		
		return false;
	}

	private Animal obtenerAnimal(Animal animalBuscado) {

		for (Animal animal : animales) {
			if (animal.equals(animalBuscado)) {
				return animal;
			}
		}

		return null;
	}

	private Estructura obtenerEstructura(Estructura estructuraBuscada) {

		for (Estructura estructura : estructuras) {
			if (estructura.equals(estructuraBuscada)) {
				return estructura;
			}
		}

		return null;
	}
	
	public Animal obtenerAnimalDeUnHabitat(Animal animal, Estructura habitat) {
		
		if (habitat instanceof Habitat) {
			Habitat habitatVerificado = (Habitat) habitat;
			return habitatVerificado.obtenerAnimal(animal);
		}
		
		return null;
	}

}
