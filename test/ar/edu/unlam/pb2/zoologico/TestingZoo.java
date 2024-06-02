package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ar.edu.unlam.pb2.animales.Leon;
import ar.edu.unlam.pb2.animales.Mono;
import ar.edu.unlam.pb2.enums.CategoriaAnimal;
import ar.edu.unlam.pb2.enums.Comida;
import ar.edu.unlam.pb2.enums.TipoAlimentacion;
import ar.edu.unlam.pb2.enums.TipoSexo;

public class TestingZoo {

	
	//TESTS MANTENIMIENTO Y ESTRUCTURA
	
	@Test
	public void dadoQueExisteUnZoologicoQueUnPersonalDeMantenimientoPuedaArreglarUnaEstructuraSiSuEstadoEstaRoto() throws estructuraNoEstaDañadaExcepsion {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 1;
		String nombreCompleto = "Julio Perez";
		Integer edad = 38;
		Persona personalMantenimiento = new Mantenimiento(identificacion, nombreCompleto, edad);
		zoo.agregarPersonalAlZoo(personalMantenimiento);
		
		Integer codigoEstructural = 1;
		String nombreEstructura = "Estrcturita";
		Boolean estaRoto = true;
		Estructura estructura = new Estructura(codigoEstructural, nombreEstructura, estaRoto);
		zoo.agregarEstructuraAlZoo(estructura);
		
		MantenimientoEstructura mantenimientoEstructura = new MantenimientoEstructura(personalMantenimiento, estructura);
		
		zoo.agregarMantenimientoEstructura(mantenimientoEstructura);
		
		Boolean puedeArreglarEstructura = zoo.puedeArreglarEstructura(estructura, personalMantenimiento);
		
		assertTrue(puedeArreglarEstructura);

	}
	
	@Test (expected = estructuraNoEstaDañadaExcepsion.class)
	public void dadoQueExisteUnZoologicoQueUnPersonalDeMantenimientoNoPuedaArreglarUnaEstructuraSiSuEstadoEstaBien() throws estructuraNoEstaDañadaExcepsion {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer identificacion = 1;
		String nombreCompleto = "Julio Perez";
		Integer edad = 38;
		Persona personalMantenimiento = new Mantenimiento(identificacion, nombreCompleto, edad);
		zoo.agregarPersonalAlZoo(personalMantenimiento);
		
		Integer codigoEstructural = 1;
		String nombreEstructura = "Estrcturita";
		Boolean estaRoto = false;
		Estructura estructura = new Estructura(codigoEstructural, nombreEstructura, estaRoto);
		zoo.agregarEstructuraAlZoo(estructura);
		
		MantenimientoEstructura mantenimientoEstructura = new MantenimientoEstructura(personalMantenimiento, estructura);

		zoo.agregarMantenimientoEstructura(mantenimientoEstructura);
		
		Boolean noPuedeArreglarEstructura = zoo.puedeArreglarEstructura(estructura, personalMantenimiento);
		
		assertTrue(noPuedeArreglarEstructura);
	}
	
	@Test(expected = estructuraNoEstaDañadaExcepsion.class)
	public void dadoQueExisteUnZoologicoQueUnPersonalQueNoSeaDeMantenimientoNoPuedaArreglarUnaEstructuraSiSuEstadoEstaRoto() throws estructuraNoEstaDañadaExcepsion {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 1;
		String nombreCompleto = "Julio Perez";
		Integer edad = 38;
		Persona personalVeterinario = new Veterinario(identificacion, nombreCompleto, edad);
		zoo.agregarPersonalAlZoo(personalVeterinario);
		
		Integer codigoEstructural = 1;
		String nombreEstructura = "Estrcturita";
		Boolean estaRoto = true;
		Estructura estructura = new Estructura(codigoEstructural, nombreEstructura, estaRoto);
		zoo.agregarEstructuraAlZoo(estructura);
		
		MantenimientoEstructura mantenimientoEstructura = new MantenimientoEstructura(personalVeterinario, estructura);
		
		zoo.agregarMantenimientoEstructura(mantenimientoEstructura);
		
		Boolean puedeArreglarEstructura = zoo.puedeArreglarEstructura(estructura, personalVeterinario);

	}


	@Test
	public void dadoQueExisteUnZoologicoSiEstaSucioQueSePuedaLimpiarPorUnPersonalDeMantenimiento() throws zoologicoEstaLimpioExcepsion {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer identificacionPersonal = 1;
		String nombrePersonal = "Eduardo Cazca";
		Integer edadPersonal = 32;
		Persona personalMantenimiento = new Mantenimiento(identificacionPersonal, nombrePersonal, edadPersonal);
		
		zoo.agregarPersonalAlZoo(personalMantenimiento);
		Boolean zoologicoEstaLimpio = false;
		zoo.setEstaLimpio(zoologicoEstaLimpio);
		Boolean sePuedeLimpiar = zoo.queUnEmpleadoDeMantenimientoLimpieElZoologico(personalMantenimiento);
		
		assertTrue(sePuedeLimpiar);
	}
	
	@Test (expected = zoologicoEstaLimpioExcepsion.class)
	public void dadoQueExisteUnZoologicoSiEstaLimpioQueNoSePuedaLimpiarPorUnPersonalDeMantenimiento() throws zoologicoEstaLimpioExcepsion {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer identificacionPersonal = 1;
		String nombrePersonal = "Eduardo Cazca";
		Integer edadPersonal = 32;
		Persona personalMantenimiento = new Mantenimiento(identificacionPersonal, nombrePersonal, edadPersonal);
		
		zoo.agregarPersonalAlZoo(personalMantenimiento);
		Boolean zoologicoEstaLimpio = true;
		zoo.setEstaLimpio(zoologicoEstaLimpio);
		Boolean sePuedeLimpiar = zoo.queUnEmpleadoDeMantenimientoLimpieElZoologico(personalMantenimiento);
		
	}
	
	@Test (expected = zoologicoEstaLimpioExcepsion.class)
	public void dadoQueExisteUnZoologicoSiEstaSucioQueNoSePuedaLimpiarPorUnPersonalQueNoSeaDeMantenimiento() throws zoologicoEstaLimpioExcepsion {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer identificacionPersonal = 1;
		String nombrePersonal = "Eduardo Cazca";
		Integer edadPersonal = 32;
		Persona personal = new Veterinario(identificacionPersonal, nombrePersonal, edadPersonal);
		
		zoo.agregarPersonalAlZoo(personal);
		Boolean zoologicoEstaLimpio = false;
		zoo.setEstaLimpio(zoologicoEstaLimpio);
		Boolean sePuedeLimpiar = zoo.queUnEmpleadoDeMantenimientoLimpieElZoologico(personal);
		
	}
	
	

	//TESTS ACCIONES ANIMALES
	
	
	@Test
	public void dadoQueExisteUnZoologicoQueUnAnimalPuedaEmitirUnSonido() {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer codigoAnimal = 514;
		String nombreAnimal = "Mono Mario";
		Integer edadAnimal = 6;
		Double pesoAnimal = 8.9;
		TipoAlimentacion alimentacionAnimal = TipoAlimentacion.OMNIVORO;
		TipoSexo sexoAnimal = TipoSexo.MASCULINO;
		CategoriaAnimal categoriaAnimal = CategoriaAnimal.MAMIFERO;
		Animal mono = new Mono(codigoAnimal, nombreAnimal, edadAnimal, pesoAnimal, alimentacionAnimal, sexoAnimal,
				categoriaAnimal);
		
		Integer codigoEstructural = 1;
		String nombreEstructura = "Estructurita";
		Boolean estaRoto = false;
		Estructura estructura = new Estructura(codigoEstructural, nombreEstructura, estaRoto);
		zoo.agregarEstructuraAlZoo(estructura);
		
		zoo.agregarAnimalAlHabitat(mono, estructura);
		
		String sonidoEsperado = "uh uh ah ah";
		String sonidoObtenido = mono.emitirSonido();

		assertEquals(sonidoEsperado, sonidoObtenido);
	}
	
	@Test 
	public void dadoQueExisteUnZoologicoQueUnAnimalSePuedaMover() {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer codigoAnimal = 514;
		String nombreAnimal = "Leoncito";
		Integer edadAnimal = 6;
		Double pesoAnimal = 16.3;
		TipoAlimentacion alimentacionAnimal = TipoAlimentacion.CARNIVORO;
		TipoSexo sexoAnimal = TipoSexo.MASCULINO;
		CategoriaAnimal categoriaAnimal = CategoriaAnimal.MAMIFERO;
		Animal leon = new Leon(codigoAnimal, nombreAnimal, edadAnimal, pesoAnimal, alimentacionAnimal, sexoAnimal,
				categoriaAnimal);
		
		Integer codigoEstructural = 1;
		String nombreEstructura = "Estructurita";
		Boolean estaRoto = false;
		Estructura estructura = new Estructura(codigoEstructural, nombreEstructura, estaRoto);
		zoo.agregarEstructuraAlZoo(estructura);
		
		zoo.agregarAnimalAlHabitat(leon, estructura);
		
		String sonidoEsperado = "corriendo velozmente";
		String sonidoObtenido = leon.movimiento();

		assertEquals(sonidoEsperado, sonidoObtenido);
	}
	
	
	
	// TESTS LOCAL DE COMIDA
	
	@Test
	public void dadoQueExisteUnZoologicoSiUnVisitanteDeseaComerAlgoYTieneLaPlataSuficientePuedeComprarComidaEnLaSeccionDeComida() {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		String nombre = "Juan";
		Integer edad = 12;
		Integer identificacion = 2;
		Double dineroDisponible = 3000.0;
		Persona visitante = new Visitante(identificacion, nombre, edad, dineroDisponible);
		zoo.agregarPersonalAlZoo(visitante);
		
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		Estructura hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		zoo.agregarEstructuraAlZoo(hamburgueseria);
		
	}
	
	@Test
	public void dadoQueExisteUnZoologicoQueSePuedaAgregarUnaHamburgueseria() {
		//Crea Zoologico
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		//Crea hamburgueseria y la agrega al zoologico
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		
		Boolean sePudoAgregar  = zoo.agregarEstructuraAlZoo(hamburgueseria);
		
		assertTrue(sePudoAgregar);
	}
	
	@Test
	public void dadoQueExisteUnZoologicoConLocalDeComidasQueSePuedaAgregarStockDeComidas() {
		//Crea Zoologico
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		//Crea hamburgueseria y la agrega al zoologico
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		zoo.agregarEstructuraAlZoo(hamburgueseria);
		
		//Agrega stock a la hamburgueseria
		Comida comida = Comida.HAMBURGUESA;
		Integer cantidad = 4;
		hamburgueseria.agregarAlLocalStockDe(comida, cantidad);
	
		//Agregar visitante al zoologico
		String nombre = "Juan";
		Integer edad = 21;
		Integer identificacion = 2;
		Double dineroDisponible = 3000.0;
		Persona visitante = new Visitante(identificacion, nombre, edad, dineroDisponible);
		zoo.agregarPersonalAlZoo(visitante);
		
		
		int cantidadEsperada = 4;
		List<Comida> comidas = hamburgueseria.getComidas();
		
		assertEquals(cantidadEsperada, comidas.size());
	}
	
	@Test
	public void dadoQueExisteUnZoologicoConLocalDeComidasComprobarSiTieneStockDeUnTipoDeComida() {
		//Crea Zoologico
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		//Crea hamburgueseria y la agrega al zoologico
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		zoo.agregarEstructuraAlZoo(hamburgueseria);
		
		//Agrega stock a la hamburgueseria
		Comida pizza = Comida.PIZZA;
		Integer cantidadPizza = 4;
		hamburgueseria.agregarAlLocalStockDe(pizza, cantidadPizza);
		Comida gaseosa = Comida.GASEOSA;
		Integer cantidadGaseosa = 6;
		hamburgueseria.agregarAlLocalStockDe(gaseosa, cantidadGaseosa);
		Comida pizza2 = Comida.PIZZA;
		Integer cantidadPizza2 = 3;
		hamburgueseria.agregarAlLocalStockDe(pizza2, cantidadPizza2);
		
		//Comprobar stock por tipo de comida
		int stockPizzaEsperado = 7;
		int stockPizzaObtenido = hamburgueseria.comprobarStockPorTipoDeComida(Comida.PIZZA);
		
		
		assertEquals(stockPizzaEsperado, stockPizzaObtenido);
	}
	
	@Test
	public void dadoQueExisteUnZoologicoConLocalDeComidasQueUnVisitantePuedaComprarSiTieneSuficienteDineroYSiElLocalTieneStockSuficienteDeLaComida() {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		zoo.agregarEstructuraAlZoo(hamburgueseria);
		
		Comida comida = Comida.HAMBURGUESA;
		Integer cantidad = 4;
		hamburgueseria.agregarAlLocalStockDe(comida, cantidad);
		
		String nombre = "Juan";
		Integer edad = 21;
		Integer identificacion = 2;
		Double dineroDisponible = 3000.0;
		Persona visitante = new Visitante(identificacion, nombre, edad, dineroDisponible);
		zoo.agregarPersonalAlZoo(visitante);
		
		Comida comidaAConsumir = Comida.HAMBURGUESA;
		Integer cantidadAComprar = 2;
		Boolean puedeComprar = hamburgueseria.comprarComida((Visitante) visitante, comidaAConsumir, cantidadAComprar);
		
		assertTrue(puedeComprar);
	}
	
	@Test
	public void dadoQueExisteUnZoologicoConLocalDeComidasSaberLaRecaudacionTotal() {
		//Crea Zoologico
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		//Crea hamburgueseria y la agrega al zoologico
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		zoo.agregarEstructuraAlZoo(hamburgueseria);
		
		//Agrega stock a la hamburgueseria
		Comida hamburguesa = Comida.HAMBURGUESA;
		Integer cantidadHamburguesas = 4;
		hamburgueseria.agregarAlLocalStockDe(hamburguesa, cantidadHamburguesas);
		Comida papas = Comida.PAPAS_FRITAS;
		Integer cantidadPapas = 8;
		hamburgueseria.agregarAlLocalStockDe(papas, cantidadPapas);
		Comida agua = Comida.AGUA;
		Integer cantidadAgua = 10;
		hamburgueseria.agregarAlLocalStockDe(agua, cantidadAgua);
	
		//Agrega visistante al zoo
		Visitante visitante = new Visitante(1, "Juan", 22, 3000.0);
		Visitante visitante2 = new Visitante(2, "Perla", 28, 15000.0);
		Visitante visitante3 = new Visitante(3, "Arion", 54, 55000.0);
		zoo.agregarPersonalAlZoo(visitante);
		zoo.agregarPersonalAlZoo(visitante2);
		zoo.agregarPersonalAlZoo(visitante3);
		
		//Comida a consumir por visitante1 en la hamburgueseria
		Comida comidaAConsumir1 = hamburguesa;
		Integer cantidadAComprar1 = 2;
		hamburgueseria.comprarComida( visitante, comidaAConsumir1, cantidadAComprar1);
		
		//Comida a consumir por visitante2 en la hamburgueseria
		Comida comidaAConsumir2 = papas;
		Integer cantidadAComprar2 = 5;
		hamburgueseria.comprarComida( visitante, comidaAConsumir2, cantidadAComprar2);
		
		//Comida a consumir por visitante3 en la hamburgueseria
		Comida comidaAConsumir3 = agua;
		Integer cantidadAComprar3 = 5;
		hamburgueseria.comprarComida( visitante, comidaAConsumir3, cantidadAComprar3);
		
		Double recaudacionEsperada = 1400.0;
		Double recaudacionObtenida = hamburgueseria.getRecaudacion();
		
		assertEquals(recaudacionEsperada, recaudacionObtenida);
		
		
	}
	
	
}
