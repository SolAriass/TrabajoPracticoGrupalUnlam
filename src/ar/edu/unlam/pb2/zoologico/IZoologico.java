package ar.edu.unlam.pb2.zoologico;

import java.util.List;

import ar.edu.unlam.pb2.excepciones.AnimalNoEncontradoException;
import ar.edu.unlam.pb2.excepciones.EstructuraNoEncontradaException;
import ar.edu.unlam.pb2.excepciones.PersonaNoEncontradaException;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonalAlZoo(Persona persona);
	Boolean agregarEstructuraAlZoo(Estructura estructura);
	Persona buscarPersonaPorId(Integer id) throws PersonaNoEncontradaException;
	Animal buscarAnimalPorId(Integer codigoDeReconocimiento) throws AnimalNoEncontradoException;
	Estructura buscarEstructuraPorId(Integer codigoEstructural) throws EstructuraNoEncontradaException;
	Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat);
	Animal obtenerAnimalDeUnHabitatPorCodigo(Integer codigo, Estructura habitat);
	List<Animal> obtenerAnimalesDeUnHabitat(Estructura habitat);
}
