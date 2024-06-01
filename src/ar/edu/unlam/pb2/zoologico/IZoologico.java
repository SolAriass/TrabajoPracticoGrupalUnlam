package ar.edu.unlam.pb2.zoologico;

import java.util.List;

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
}
