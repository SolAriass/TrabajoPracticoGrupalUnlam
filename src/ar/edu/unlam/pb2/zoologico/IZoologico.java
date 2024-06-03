package ar.edu.unlam.pb2.zoologico;

import java.util.List;

import ar.edu.unlam.pb2.excepciones.HabitatVacioException;
import ar.edu.unlam.pb2.excepciones.NoExisteObjetoDondeSeBuscaException;
import ar.edu.unlam.pb2.excepciones.NoSePudoAgregarAnimalInexistenteException;
import ar.edu.unlam.pb2.excepciones.NoSePudoAgregarEstructuraInexistenteExcepcion;
import ar.edu.unlam.pb2.excepciones.NoSePuedenAgregarMenoresDeEdadException;
import ar.edu.unlam.pb2.excepciones.NoTieneEntradaException;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal) throws NoSePudoAgregarAnimalInexistenteException;
	Boolean agregarPersonaAlZoo(Persona persona) throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException;
	Boolean agregarEstructuraAlZoo(Estructura estructura) throws NoSePudoAgregarEstructuraInexistenteExcepcion;
	Boolean agregarVariosVisitantes(List<Persona> visitantesAIngresar);
	RegistroVisitaHabitatAnimal registrarVisitaDeUnVisitanteAUnHabitat(Persona visitante, Estructura habitat)
			throws NoTieneEntradaException;
	Double obtenerRecaudacion();
	Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat)
			throws HabitatVacioException, NoExisteObjetoDondeSeBuscaException;
	Animal obtenerAnimal(Animal animalBuscado) throws NoExisteObjetoDondeSeBuscaException;
	List<RegistroVisitaHabitatAnimal> obtenerRegistrosVisitasHabitatsAnimal();
	Animal obtenerAnimalDeUnHabitat(Animal animal, Estructura habitat) throws NoExisteObjetoDondeSeBuscaException;
	Estructura obtenerEstructura(Estructura estructuraBuscada) throws NoExisteObjetoDondeSeBuscaException;
	List<RegistroVisitaInstalacionComun> obtenerRegistrosVisitasInstalacionesComunes();
	RegistroVisitaInstalacionComun registrarVisitaDeUnVisitanteAUnaInstalacionComun(Persona visitante,
			Estructura instalacionComun) throws NoTieneEntradaException;
}
