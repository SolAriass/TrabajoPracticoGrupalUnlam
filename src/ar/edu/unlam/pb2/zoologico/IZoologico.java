package ar.edu.unlam.pb2.zoologico;

import java.util.List;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonalAlZoo(Personal persona);
	Boolean agregarEstructuraAlZoo(Estructura estructura);
	List<Animal> obtenerLosAnimalesConTipoAlimentacionOmnivora();
	List<Animal> obtenerLosAnimalesConTipoAlimentacionCarnivora();
	List<Animal> obtenerLosAnimalesConTipoAlimentacionHerbivora();
	List<Animal> obtenerALosAnimalesConTemperaturaNeutral();
	List<Animal> obtenerALosAnimalesEnfermosPorTemperaturaBaja();
	Boolean agregarUnVeterinarioAUnHospital(Estructura hospital, Personal personal);
	Estructura encontrarSiExisteLaEstructuraEnElZoo(Estructura estructura);
	Personal encontrarSiExisteLaPersonaEnElZoo(Personal personal);
	Boolean estanDormidosLosAnimales();
	Animal encontrarSiExisteElAnimalEnElZoo(Animal animal);
	RegistroAlimentacion cargarAlimentacion(Personal personal, Animal animal, Comida comida, Integer cantidadComida);
	List<Animal> conocerLosAnimalesAlimentadosPorUnVeterinario(Personal personal);
	List<Personal> conocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico(Animal animal);
	List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoPlanta();
	List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoCarne();
	List<Animal> obtenerALosAnimalesEnfermosPorAlimentacionIncorrecta();
}
