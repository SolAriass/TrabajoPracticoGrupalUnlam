package ar.edu.unlam.pb2.zoologico;
import java.util.ArrayList;
import java.util.Random;
import ar.edu.unlam.pb2.excepciones.*;
import ar.edu.unlam.pb2.enums.*;

public class Habitat extends Estructura {
	private ArrayList<Animal> animales;
	private Animal animalQueDeterminaEspecie;
	private Integer maximoAnimales;

	public Habitat(Integer codigoEstructural, String nombreEstructura, Integer maximoAnimales, Boolean estadoEstructura) {
		super(codigoEstructural, nombreEstructura, estadoEstructura);
		this.animales = new ArrayList<>();
		this.animalQueDeterminaEspecie = null; // Se va a seleccionar cuando agreguemos al primer animal
		this.maximoAnimales = maximoAnimales;
	}

	public Boolean agregarAnimal(Animal animal) throws EspecieDiferenteException, HabitatLlenoException {
		if (this.animalQueDeterminaEspecie == null) {
			this.animalQueDeterminaEspecie = animal;
		}

	    if (animales.size() >= maximoAnimales) {
	        throw new HabitatLlenoException("El hábitat está lleno y no puede albergar más animales.");
	    }
		
		if (!animal.getClass().equals(this.animalQueDeterminaEspecie.getClass())) {
			throw new EspecieDiferenteException("El hábitat no puede albergar distintas especies.");
		}

		return animales.add(animal); // Si la especie del animal no coincide, no se agrega
	}

	public Animal obtenerAnimal(Animal animalBuscado) throws NoExisteObjetoDondeSeBuscaException {

		for (Animal animal : animales) {
			if (animal.equals(animalBuscado)) {
				return animal;
			}
		}
		
		return null;	
	}
	
		public Animal obtenerAnimalPorCodigo(Integer codigo) throws NoExisteObjetoDondeSeBuscaException {
			for (Animal animal : animales) {
				if (animal.getCodigoDeReconocimiento().equals(codigo)) {
					return animal;
				}
			}

		return null;	
	}

	public Animal reproducirAnimales(Animal progenitor1, Animal progenitor2, Integer idCria, String nombreCria) {
		
		Random sexoAleatorio = new Random();
		TipoSexo sexo = sexoAleatorio.nextBoolean() ? TipoSexo.MASCULINO : TipoSexo.FEMENINO;

		return progenitor1.crearCria(idCria, nombreCria, sexo);

	}

	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}
	
	


}
