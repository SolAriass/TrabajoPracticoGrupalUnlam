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
	
	
	@Test
	public void dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionCarnivora () {

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

		List<Animal> animalesCarnivoros = zoo.obtenerLosAnimalesConTipoAlimentacionCarnivora();

		Integer tamañoEsperado = 3;

		assertEquals((int) tamañoEsperado, animalesCarnivoros.size());
		assertEquals(mapache, animalesCarnivoros.get(0));
		assertEquals(tiburon, animalesCarnivoros.get(1));
		assertEquals(serpiente, animalesCarnivoros.get(2));

	}
	
	
	@Test
	public void dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionHerbivora () {

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
		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlZoo(mapache);
		zoo.agregarAnimalAlZoo(oso);
		zoo.agregarAnimalAlZoo(tiburon);
		zoo.agregarAnimalAlZoo(serpiente);
		zoo.agregarAnimalAlZoo(elefante);
		zoo.agregarAnimalAlZoo(panda);

		
		List<Animal> animalesHerbivoros = zoo.obtenerLosAnimalesConTipoAlimentacionHerbivora();
		
		
		Integer tamañoEsperado = 2;

		assertEquals((int) tamañoEsperado, animalesHerbivoros.size());
		assertEquals(elefante, animalesHerbivoros.get(0));
		assertEquals(panda, animalesHerbivoros.get(1));

	}
	
	
	
	
	
	
	

}
