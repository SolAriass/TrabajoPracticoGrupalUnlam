package ar.edu.unlam.pb2.zoologico;

public interface IZoologico {
	
	Boolean agregarAnimalAlZoo(Animal animal);
	Boolean agregarPersonalAlZoo(Personal persona);
	Boolean agregarEstructuraAlZoo(Estructura estructura);
	Personal buscarPersonaPorId(Integer id) throws PersonaNoEncontradaException;
	Animal buscarAnimalPorId(Integer codigoDeReconocimiento) throws AnimalNoEncontradoException;
	Estructura buscarEstructuraPorId(Integer codigoEstructural) throws EstructuraNoEncontradaException;
}
