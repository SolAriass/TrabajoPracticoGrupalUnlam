package ar.edu.unlam.pb2.zoologico;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.pb2.excepciones.*;
import ar.edu.unlam.pb2.enums.*;

public interface IZoologico {

	Boolean agregarAnimalAlZoo(Animal animal) throws NoSePudoAgregarAnimalInexistenteException;

	Boolean agregarPersonaAlZoo(Persona persona) throws NoSePudoAgregarPersonaInexistenteException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException;

	Boolean agregarEstructuraAlZoo(Estructura estructura) throws NoSePudoAgregarEstructuraInexistenteExcepcion;

	List<Animal> obtenerLosAnimalesConTipoAlimentacionOmnivora();

	List<Animal> obtenerLosAnimalesConTipoAlimentacionCarnivora();

	List<Animal> obtenerLosAnimalesConTipoAlimentacionHerbivora();

	List<Animal> obtenerALosAnimalesConTemperaturaNeutral();

	List<Animal> obtenerALosAnimalesEnfermosPorTemperaturaBaja();

	Boolean agregarUnVeterinarioAUnHospital(Estructura hospital, Persona personal)
			throws NoSePudoAgregarAlVeterinarioAlHospitalException, NoSePudoAgregarEstructuraInexistenteExcepcion,
			NoSePudoAgregarPersonaInexistenteException;

	Estructura encontrarSiExisteLaEstructuraEnElZoo(Estructura estructura);

	Persona encontrarSiExisteLaPersonaEnElZoo(Persona personal);

	Boolean estanDormidosLosAnimales();

	Animal encontrarSiExisteElAnimalEnElZoo(Animal animal);

	RegistroAlimentacion cargarAlimentacion(Persona personal, Animal animal, ComidaAnimales comida,
			Integer cantidadComida) throws NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonaInexistenteException,
			NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonalInvalidoExcepcion,
			NoSePudoAlimentarException;

	List<Animal> conocerLosAnimalesAlimentadosPorUnVeterinario(Persona personal);

	List<Persona> conocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico(Animal animal);

	List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoPlanta();

	List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoCarne();

	List<Animal> obtenerALosAnimalesEnfermosPorAlimentacionIncorrecta();

	List<RegistroAlimentacion> conocerLosRegistrosQueContenganUnAnimalEspecifico(Animal animal);

	Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat)
			throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException,
			InstanciaIncorrectaException, HabitatVacioException;

	Animal obtenerAnimal(Animal animal) throws NoExisteObjetoDondeSeBuscaException;

	Estructura obtenerEstructura(Estructura estructuraBuscada) throws NoExisteObjetoDondeSeBuscaException;

	Persona obtenerPersona(Persona personaBuscada) throws NoExisteObjetoDondeSeBuscaException;

	Animal obtenerAnimalDeUnHabitat(Animal animal, Estructura habitat) throws NoExisteObjetoDondeSeBuscaException;

	List<Animal> obtenerLosAnimalesDeUnaCategoria(CategoriaAnimal categoria);

	List<Animal> obtenerLosAnimalesDeUnSexo(TipoSexo sexo);

	Boolean reproducirDosAnimalesDeUnHabitat(Animal progenitor1, Animal progenitor2, Estructura habitat, Integer idCria,
			String nombreCria) throws EspecieDiferenteException, HabitatLlenoException, ProgenitoresDelMismoSexoException,
			ProgenitoresEnDistintoHabitatException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException,
			NoSePudoAgregarAnimalInexistenteException, HabitatVacioException;

	RegistroTratamiento queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(Estructura hospital,
			Persona veterinario, Animal animal, Estructura habitat)
			throws EspecieDiferenteException, HabitatLlenoException, InstanciaIncorrectaException,
			NoExisteObjetoDondeSeBuscaException, EstadoDelObjetoEsIncorrectoException, HabitatVacioException;

	Veterinario obtenerVeterinarioDeUnHospital(Persona veterinario, Estructura hospital)
			throws InstanciaIncorrectaException, NoExisteObjetoDondeSeBuscaException;

	List<Animal> obtenerLosAnimalesQueAtendioUnVeterinarioEnUnHospital(Persona veterinario,
			Estructura hospital) throws InstanciaIncorrectaException, NoExisteObjetoDondeSeBuscaException;

	List<Persona> obtenerLosVeterinariosQueAtendieronAUnAnimalEnUnHospital(Animal animal, Estructura hospital)
			throws NoExisteObjetoDondeSeBuscaException;

	TreeSet<Animal> obtenerAnimalesDeUnHabitatOrdenadosOrdenEspecifico(Comparator<Animal> OrdenEspecifico,
			Estructura habitat) throws InstanciaIncorrectaException;

	Boolean agregarMantenimientoEstructura(MantenimientoEstructura mantenimietoEstructura);

	Animal obtenerAnimalDeUnHabitatPorCodigo(Integer codigo, Estructura habitat)
			throws NoExisteObjetoDondeSeBuscaException;

	Boolean queUnEmpleadoQueNoSeaDeMantenimientoLimpieElZoologico(Persona personalMantenimiento,
			Boolean zoologicoEstaLimpio);

	Boolean queUnEmpleadoDeMantenimientoLimpieElZoologico(Persona personalMantenimiento)
			throws zoologicoEstaLimpioExcepsion;

	Boolean puedeArreglarEstructura(Estructura estructura, Persona personalMantenimiento)
			throws estructuraNoEstaDañadaExcepsion;

	Boolean agregarVariosVisitantes(List<Persona> visitantesAIngresar);

	RegistroVisitaHabitatAnimal registrarVisitaDeUnVisitanteAUnHabitat(Persona visitante, Estructura habitat)
			throws NoTieneEntradaException;

	Double obtenerRecaudacion();

	List<RegistroVisitaHabitatAnimal> obtenerRegistrosVisitasHabitatsAnimal();

	List<RegistroVisitaInstalacionComun> obtenerRegistrosVisitasInstalacionesComunes();

	RegistroVisitaInstalacionComun registrarVisitaDeUnVisitanteAUnaInstalacionComun(Persona visitante,
			Estructura instalacionComun) throws NoTieneEntradaException;

	Persona buscarPersonaPorId(Integer id) throws PersonaNoEncontradaException;

	Animal buscarAnimalPorId(Integer codigoDeReconocimiento) throws AnimalNoEncontradoException;

	Estructura buscarEstructuraPorId(Integer codigoEstructural) throws EstructuraNoEncontradaException;
}
