package ar.edu.unlam.pb2.zoologico;

import java.util.List;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonaAlZoo(Persona persona);
	Boolean agregarEstructuraAlZoo(Estructura estructura);
	Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat);
	Animal obtenerAnimal(Animal animal);
	Estructura obtenerEstructura(Estructura estructuraBuscada);
	Animal obtenerAnimalDeUnHabitat(Animal animal, Estructura habitat);
	List<Animal> obtenerLosAnimalesDeUnaCategoria(CategoriaAnimal categoria);
	List<Animal> obtenerLosAnimalesDeUnSexo(TipoSexo sexo);
	Boolean reproducirDosAnimalesDeUnHabitat(Animal progenitor1, Animal progenitor2, Estructura habitat, Integer idCria, String nombreCria);
	Boolean agregarUnVeterinarioAUnHospital(Estructura estructura, Persona personal);
	Persona encontrarSiExisteLaPersonaEnElZoo(Persona personal);
	
}
