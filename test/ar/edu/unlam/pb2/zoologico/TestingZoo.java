package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestingZoo {
	
	
	@Test
	public void queSePuedaCrearUnZoologico() {
		
		String nombreZoo = "Animalandia";
		
		Zoologico zoo = new Zoologico(nombreZoo);
		
		String nombreEsperado = "Animalandia";
		
		assertNotNull(zoo);
		assertEquals(nombreEsperado, zoo.getNombreZoo());
		
	}
	
	
	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarAnimalesAlMismo() {
		
		String nombreZoo = "Animalandia";
		
		Zoologico zoo = new Zoologico(nombreZoo);
		
		
		
		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
		//estar enfermo es algo que ya tiene el mono, por defecto esta sano
		TipoSexo sexo = TipoSexo.FEMENINO;
		CategoriaAnimal clase = CategoriaAnimal.MAMIFERO;
		
		Animal mono = new Mono(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		
		
		Boolean seAgrego = zoo.agregarAnimalAlZoo(mono);
		
		
		assertTrue(seAgrego);
		assertEquals(mono, zoo.getAnimales().get(0));
		
		
		
	}
	
	
	
	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarPersonasAlMismo() {
		
		String nombreZoo = "Animalandia";
		
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;
		
		Personal personal = new Veterinario(identificacion, nombreCompleto, edad);
		
		
		Boolean seAgrego = zoo.agregarPersonalAlZoo(personal);
		
		
		assertTrue(seAgrego);
		assertEquals(personal, zoo.getPersonas().get(0));
		

		
	}
	
	
	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarEstructurasAlMismo() {
		
		String nombreZoo = "Animalandia";
		
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";
		//estado es algo que ya tiene dicha estructura
		
		
		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);
		
		
		
		
		Boolean seAgrego = zoo.agregarEstructuraAlZoo(hospital);
		
		
		assertTrue(seAgrego);
		assertEquals(hospital, zoo.getEstructuras().get(0));
		

		
	}
	
	
	@Test
	public void dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionOmnivora () {

		String nombreZoo = "Animalandia";

		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
		// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		TipoSexo sexo = TipoSexo.FEMENINO;
		CategoriaAnimal clase = CategoriaAnimal.MAMIFERO;

		Animal mono = new Mono(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal oso = new Oso(78, "winnie pooh", 7, 10.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		Animal tiburon = new Tiburon(90, "tiburoncin", 12, 20.0, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.PEZ);
		Animal serpiente = new Serpiente(1002, "thiago", 4, 2.5, TipoAlimentacion.CARNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.REPTIL);
		Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);

		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlZoo(mapache);
		zoo.agregarAnimalAlZoo(oso);
		zoo.agregarAnimalAlZoo(tiburon);
		zoo.agregarAnimalAlZoo(serpiente);
		zoo.agregarAnimalAlZoo(elefante);

		List<Animal> animalesOmnivoros = zoo.obtenerLosAnimalesConTipoAlimentacionOmnivora();

		Integer tamañoEsperado = 2;

		assertEquals((int) tamañoEsperado, animalesOmnivoros.size());
		assertEquals(mono, animalesOmnivoros.get(0));
		assertEquals(oso, animalesOmnivoros.get(1));

	}
	
	
	
	
	
	
	

}
