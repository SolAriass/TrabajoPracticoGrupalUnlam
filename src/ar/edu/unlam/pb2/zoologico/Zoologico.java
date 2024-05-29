package ar.edu.unlam.pb2.zoologico;

import java.util.List;

import java.util.ArrayList;

public class Zoologico implements IZoologico{
	
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




	@Override
	public List<Animal> obtenerLosAnimalesConTipoAlimentacionOmnivora() {
		
		List<Animal> listaAuxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getTipoAlimentacion().equals(TipoAlimentacion.OMNIVORO)) {
				listaAuxiliar.add(animal);
			}
		}

		
		return listaAuxiliar;
	}




	@Override
	public List<Animal> obtenerLosAnimalesConTipoAlimentacionCarnivora() {
		
		List<Animal> listaAuxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getTipoAlimentacion().equals(TipoAlimentacion.CARNIVORO)) {
				listaAuxiliar.add(animal);
			}
		}
		
		
		return listaAuxiliar;
	}




	@Override
	public List<Animal> obtenerLosAnimalesConTipoAlimentacionHerbivora() {

		List<Animal> listaAuxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getTipoAlimentacion().equals(TipoAlimentacion.HERBIVORO)) {
				listaAuxiliar.add(animal);
			}
		}
		
		
		
		return listaAuxiliar;
	}




	@Override
	public List<Animal> obtenerALosAnimalesSanos() {
		
		List<Animal> auxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getEstaEnfermo() == false) {
				auxiliar.add(animal);
			}
		}
		return auxiliar;
	}




	@Override
	public List<Animal> obtenerALosAnimalesEnfermos() {
		
		List<Animal> auxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getEstaEnfermo() == true) {
				auxiliar.add(animal);
			}
		}
		
		return auxiliar;
	}










	
	
	
	
	
	
	
	
	
}
