package ar.edu.unlam.pb2.zoologico;

import java.util.List;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonalAlZoo(Personal persona);
	Boolean agregarEstructuraAlZoo(Estructura estructura);
	List<Animal> obtenerLosAnimalesConTipoAlimentacionOmnivora();
	List<Animal> obtenerLosAnimalesConTipoAlimentacionCarnivora();
	List<Animal> obtenerLosAnimalesConTipoAlimentacionHerbivora();
	List<Animal> obtenerALosAnimalesSanos();
	List<Animal> obtenerALosAnimalesEnfermos();
	Boolean agregarUnVeterinarioAUnHospital(Estructura hospital, Personal personal);
	 Estructura encontrarSiExisteLaEstructuraEnElZoo(Estructura estructura);
	 Personal encontrarSiExisteLaPersonaEnElZoo(Personal personal);
}
