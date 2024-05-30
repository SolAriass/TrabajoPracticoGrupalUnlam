package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;

public class Zoologico implements IZoologico {

	private String nombreZoo;
	private Boolean seEncuentraAbierto;
	private Boolean estaLimpio;
	private List<Animal> animales;
	private List<Persona> personas;
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

		for (Animal a : this.animales) {
			if (a.equals(animal)) {
				return false;
			}
		}

		return animales.add(animal);
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	@Override
	public Boolean agregarPersonalAlZoo(Persona persona) {

		for (Persona p : this.personas) {
			if (p.equals(persona)) {
				return false;
			}
		}
		return personas.add(persona);
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public Boolean agregarEstructuraAlZoo(Estructura estructura) {
		for (Estructura e : this.estructuras) {
			if (e.equals(estructura)) {
				return false;
			}
		}
		return estructuras.add(estructura);
	}

	public List<Estructura> getEstructuras() {
		return estructuras;
	}

	public void setEstructuras(List<Estructura> estructuras) {
		this.estructuras = estructuras;
	}

	@Override
	public Persona buscarPersonaPorId(Integer id) throws PersonaNoEncontradaException {
		for (Persona persona : this.personas) {
			if (persona.getIdentificacion().equals(id)) {
				return persona;
			}
		}

		throw new PersonaNoEncontradaException();
	}

	@Override
	public Animal buscarAnimalPorId(Integer codigoDeReconocimiento) throws AnimalNoEncontradoException {
		for (Animal animal : this.animales) {
			if (animal.getCodigoDeReconocimiento().equals(codigoDeReconocimiento)) {
				return animal;
			}
		}

		throw new AnimalNoEncontradoException();
	}

	@Override
	public Estructura buscarEstructuraPorId(Integer codigoEstructural) throws EstructuraNoEncontradaException {
		for (Estructura estructura : this.estructuras) {
			if (estructura.getCodigoEstructural().equals(codigoEstructural)) {
				return estructura;
			}
		}

		throw new EstructuraNoEncontradaException();
	}

	@Override
	public Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat) {

		if (habitat instanceof Habitat && animales.contains(animal) && estructuras.contains(habitat)) {
			Habitat habitatVerificado = (Habitat) habitat;
			 if(habitatVerificado.agregarAnimal(animal)) {
				 animal.setHabitat(habitat);
				 return true;
			 }
		}

		return false;
	}

	@Override
	public Animal obtenerAnimalDeUnHabitatPorCodigo(Integer codigo, Estructura habitat) {
		if (habitat instanceof Habitat) {
			Habitat habitatVerificado = (Habitat) habitat;
			return habitatVerificado.obtenerAnimalPorCodigo(codigo);
		}

		return null;
	}

	@Override
	public List<Animal> obtenerAnimalesDeUnHabitat(Estructura habitat) {
		List<Animal> animales = new ArrayList<>();

		for (Animal animal : this.animales) {
			if (animal.getHabitat().equals(habitat)) {
				animales.add(animal);
			}
		}

		return animales;
	}

	public TreeSet<Animal> obtenerAnimalesDeUnHabitatOrdenadosOrdenEspecifico(Comparator<Animal> OrdenEspecifico,
			Estructura habitatMonos) {
		TreeSet<Animal> animalesNoRepetidos = new TreeSet<Animal>(OrdenEspecifico);
		List<Animal> animales = this.obtenerAnimalesDeUnHabitat(habitatMonos);

		animalesNoRepetidos.addAll(animales);

		return animalesNoRepetidos;
	}

}
