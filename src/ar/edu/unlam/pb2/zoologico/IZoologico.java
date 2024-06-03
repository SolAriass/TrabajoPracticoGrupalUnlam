package ar.edu.unlam.pb2.zoologico;

import java.util.List;

<<<<<<< HEAD
import ar.edu.unlam.pb2.zoologico.excepciones.NoFueCreadoElRegistroExcepcion;
import ar.edu.unlam.pb2.zoologico.excepciones.NoSePudoAgregarAlVeterinarioAlHospitalException;
import ar.edu.unlam.pb2.zoologico.excepciones.NoSePudoAgregarAnimalInexistenteException;
import ar.edu.unlam.pb2.zoologico.excepciones.NoSePudoAgregarEstructuraInexistenteExcepcion;
import ar.edu.unlam.pb2.zoologico.excepciones.NoSePudoAgregarPersonaInexistenteException;
import ar.edu.unlam.pb2.zoologico.excepciones.NoSePudoAgregarPersonalInvalidoExcepcion;
import ar.edu.unlam.pb2.zoologico.excepciones.NoSePudoAlimentarException;

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
=======
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
>>>>>>> rama-nico-bon
}
