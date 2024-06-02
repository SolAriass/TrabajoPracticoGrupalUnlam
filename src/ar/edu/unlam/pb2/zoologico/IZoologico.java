package ar.edu.unlam.pb2.zoologico;

import java.util.List;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonaAlZoo(Persona persona);
	Boolean agregarEstructuraAlZoo(Estructura estructura);
	Boolean agregarVariosVisitantes(List<Persona> visitantesAIngresar);
}
