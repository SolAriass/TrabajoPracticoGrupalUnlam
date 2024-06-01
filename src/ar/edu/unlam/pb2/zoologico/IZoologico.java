package ar.edu.unlam.pb2.zoologico;

import java.util.List;

import ar.edu.unlam.pb2.zoologico.excepciones.EspecieDiferenteException;
import ar.edu.unlam.pb2.zoologico.excepciones.EstadoDelObjetoEsIncorrectoException;
import ar.edu.unlam.pb2.zoologico.excepciones.HabitatLlenoException;
import ar.edu.unlam.pb2.zoologico.excepciones.InstanciaIncorrectaException;
import ar.edu.unlam.pb2.zoologico.excepciones.NoExisteObjetoDondeSeBuscaException;
import ar.edu.unlam.pb2.zoologico.excepciones.NoSePuedenAgregarMenoresDeEdadException;
import ar.edu.unlam.pb2.zoologico.excepciones.ProgenitoresDelMismoSexoException;
import ar.edu.unlam.pb2.zoologico.excepciones.ProgenitoresEnDistintoHabitatException;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonaAlZoo(Persona persona) throws NoSePuedenAgregarMenoresDeEdadException;
	Boolean agregarEstructuraAlZoo(Estructura estructura);
	Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat) throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException;
	Animal obtenerAnimal(Animal animal) throws NoExisteObjetoDondeSeBuscaException;
	Estructura obtenerEstructura(Estructura estructuraBuscada) throws NoExisteObjetoDondeSeBuscaException;
	Persona obtenerPersona(Persona personaBuscada) throws NoExisteObjetoDondeSeBuscaException;
	Animal obtenerAnimalDeUnHabitat(Animal animal, Estructura habitat) throws NoExisteObjetoDondeSeBuscaException;
	List<Animal> obtenerLosAnimalesDeUnaCategoria(CategoriaAnimal categoria);
	List<Animal> obtenerLosAnimalesDeUnSexo(TipoSexo sexo);
	Boolean reproducirDosAnimalesDeUnHabitat(Animal progenitor1, Animal progenitor2, Estructura habitat, Integer idCria, String nombreCria) throws EspecieDiferenteException, HabitatLlenoException, ProgenitoresDelMismoSexoException, ProgenitoresEnDistintoHabitatException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException;
	Boolean agregarUnVeterinarioAUnHospital(Estructura estructura, Persona personal) throws NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException;
	RegistroTratamiento queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(Estructura hospital,
			Persona veterinario, Animal animal, Estructura habitat) throws EspecieDiferenteException, HabitatLlenoException, InstanciaIncorrectaException, NoExisteObjetoDondeSeBuscaException, EstadoDelObjetoEsIncorrectoException;
	Veterinario obtenerVeterinarioDeUnHospital(Persona veterinario, Estructura hospital) throws InstanciaIncorrectaException, NoExisteObjetoDondeSeBuscaException;
	List<Animal> obtenerLosAnimalesQueAtendioUnVeterinarioEnUnHospital(Persona veterinario,
			Estructura hospital) throws InstanciaIncorrectaException, NoExisteObjetoDondeSeBuscaException;
	List<Persona> obtenerLosVeterinariosQueAtendieronAUnAnimalEnUnHospital(Animal animal, Estructura hospital) throws NoExisteObjetoDondeSeBuscaException;
	
	
}
