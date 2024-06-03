package ar.edu.unlam.pb2.zoologico;

<<<<<<< HEAD
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.pb2.zoologico.excepciones.*;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal) throws NoSePudoAgregarAnimalInexistenteException;
	Boolean agregarPersonalAlZoo(Persona persona) throws NoSePudoAgregarPersonaInexistenteException;
	Boolean agregarEstructuraAlZoo(Estructura estructura) throws NoSePudoAgregarEstructuraInexistenteExcepcion;
	List<Animal> obtenerLosAnimalesConTipoAlimentacionOmnivora();
	List<Animal> obtenerLosAnimalesConTipoAlimentacionCarnivora();
	List<Animal> obtenerLosAnimalesConTipoAlimentacionHerbivora();
	List<Animal> obtenerALosAnimalesConTemperaturaNeutral();
	List<Animal> obtenerALosAnimalesEnfermosPorTemperaturaBaja();
	Boolean agregarUnVeterinarioAUnHospital(Estructura hospital, Persona personal) throws NoSePudoAgregarAlVeterinarioAlHospitalException, NoSePudoAgregarEstructuraInexistenteExcepcion, NoSePudoAgregarPersonaInexistenteException;
	Estructura encontrarSiExisteLaEstructuraEnElZoo(Estructura estructura);
	Persona encontrarSiExisteLaPersonaEnElZoo(Persona personal);
	Boolean estanDormidosLosAnimales();
	Animal encontrarSiExisteElAnimalEnElZoo(Animal animal);
	RegistroAlimentacion cargarAlimentacion(Persona personal, Animal animal, Comida comida, Integer cantidadComida) throws NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonaInexistenteException, NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException;
	List<Animal> conocerLosAnimalesAlimentadosPorUnVeterinario(Persona personal);
	List<Persona> conocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico(Animal animal);
	List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoPlanta();
	List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoCarne();
	List<Animal> obtenerALosAnimalesEnfermosPorAlimentacionIncorrecta();
	List<RegistroAlimentacion> conocerLosRegistrosQueContenganUnAnimalEspecifico(Animal animal);
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
	TreeSet<Animal> obtenerAnimalesDeUnHabitatOrdenadosOrdenEspecifico(Comparator<Animal> OrdenEspecifico,
			Estructura habitat) throws InstanciaIncorrectaException;
	
=======
public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonalAlZoo(Personal persona);
	Boolean agregarEstructuraAlZoo(Estructura estructura);
>>>>>>> 0263159f657eda04ccc7d11ea375316280a94015
}
