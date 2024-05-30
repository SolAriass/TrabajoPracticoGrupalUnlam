package ar.edu.unlam.pb2.zoologico;
import java.util.ArrayList;
import java.util.Random;

public class Habitat extends Estructura {
	private ArrayList<Animal> animales;
	private Animal animalQueDeterminaEspecie;
	private Integer maximoAnimales;

	public Habitat(Integer codigoEstructural, String nombreEstructura, Integer maximoAnimales) {
		super(codigoEstructural, nombreEstructura);
		this.animales = new ArrayList<>();
		this.animalQueDeterminaEspecie = null; // Se va a seleccionar cuando agreguemos al primer animal
		this.maximoAnimales = maximoAnimales;
	}

	public Boolean agregarAnimal(Animal animal) {
		if (this.animalQueDeterminaEspecie == null) {
			this.animalQueDeterminaEspecie = animal;
		}

		if (animales.size() < maximoAnimales &&
				animal.getClass().equals(this.animalQueDeterminaEspecie.getClass())) {
			return animales.add(animal);
		}

		return false; // Si la especie del animal no coincide, no se agrega
	}

	public Animal obtenerAnimal(Animal animalBuscado) {

		for (Animal animal : animales) {
			if (animal.equals(animalBuscado)) {
				return animal;
			}
		}

		return null;
	}
	
		public Animal obtenerAnimalPorCodigo(Integer codigo) {
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
