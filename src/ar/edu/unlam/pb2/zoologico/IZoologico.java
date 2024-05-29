package ar.edu.unlam.pb2.zoologico;

import java.util.List;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonalAlZoo(Personal persona);
	Boolean agregarEstructuraAlZoo(Estructura estructura);
	List<Animal> obtenerLosAnimalesConTipoAlimentacionOmnivora();
}
