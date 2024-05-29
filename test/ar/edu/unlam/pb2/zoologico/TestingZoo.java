package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import java.time.LocalTime;
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
	
	

	 @Test
	public void dadoQueExisteUnZoologicoConAnimalesEnSusHabitatsConocerALosAnimalesSanosDeSalud() {

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

		List<Animal> animalesSanos = zoo.obtenerALosAnimalesSanos();

		Integer tamañoEsperado = 7;

		assertEquals((int) tamañoEsperado, animalesSanos.size());
		assertEquals(mono, animalesSanos.get(0));
		assertEquals(mapache, animalesSanos.get(1));
		assertEquals(oso, animalesSanos.get(2));
		assertEquals(tiburon, animalesSanos.get(3));
		assertEquals(serpiente, animalesSanos.get(4));
		assertEquals(elefante, animalesSanos.get(5));
		assertEquals(panda, animalesSanos.get(6));
	}
	 
	 
	 @Test
		public void dadoQueExisteUnZoologicoConAnimalesEnSusHabitatsConocerALosAnimalesEnfermosDeSalud() {

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

			// ver si hay q modificar por alimentacion
			mono.enfermar(true);
			tiburon.enfermar(true);
			elefante.enfermar(true);

			zoo.agregarAnimalAlZoo(mono);
			zoo.agregarAnimalAlZoo(mapache);
			zoo.agregarAnimalAlZoo(oso);
			zoo.agregarAnimalAlZoo(tiburon);
			zoo.agregarAnimalAlZoo(serpiente);
			zoo.agregarAnimalAlZoo(elefante);
			zoo.agregarAnimalAlZoo(panda);

			List<Animal> animalesEnfermos = zoo.obtenerALosAnimalesEnfermos();

			Integer tamañoEsperado = 3;

			assertEquals((int) tamañoEsperado, animalesEnfermos.size());
			assertEquals(mono, animalesEnfermos.get(0));
			assertEquals(tiburon, animalesEnfermos.get(1));
			assertEquals(elefante, animalesEnfermos.get(2));

		}
	
	
	 @Test
		public void dadoQueExisteUnZoologicoConVeterinarioQueSePuedaAgregarAUnHospital() {

			String nombreZoo = "Animalandia";

			Zoologico zoo = new Zoologico(nombreZoo);

			// DATOS DE PERSONAL
			Integer identificacion = 23;
			String nombreCompleto = "Jime Gomez";
			Integer edad = 25;

			Personal personal = new Veterinario(identificacion, nombreCompleto, edad);
			Personal personal2 = new Veterinario(identificacion, nombreCompleto, edad);
			Personal personal3 = new Veterinario(identificacion, nombreCompleto, edad);

			// DATOS DE ESTRUCTURA
			Integer codigoEstructural = 2234;
			String nombreEstructura = "Hospitalcito";
			// estado es algo que ya tiene dicha estructura

			Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

			zoo.agregarEstructuraAlZoo(hospital);

			zoo.agregarPersonalAlZoo(personal);
			zoo.agregarPersonalAlZoo(personal2);
			zoo.agregarPersonalAlZoo(personal3);

			Boolean seAgrego = zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

			assertTrue(seAgrego);
			assertEquals(personal, ((HospitalVeterinario) hospital).getVeterinarios().get(0));

		}
	 
	
	 @Test
		public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarOtroPersonalQueNoSeaVeterinario() {

			String nombreZoo = "Animalandia";

			Zoologico zoo = new Zoologico(nombreZoo);

			// DATOS DE PERSONAL
			Integer identificacion = 23;
			String nombreCompleto = "Jime Gomez";
			Integer edad = 25;

			Personal personal = new Mantenimiento(identificacion, nombreCompleto, edad);
			Personal personal2 = new Veterinario(identificacion, nombreCompleto, edad);
			Personal personal3 = new Veterinario(identificacion, nombreCompleto, edad);

			// DATOS DE ESTRUCTURA
			Integer codigoEstructural = 2234;
			String nombreEstructura = "Hospitalcito";
			// estado es algo que ya tiene dicha estructura

			Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

			zoo.agregarEstructuraAlZoo(hospital);

			zoo.agregarPersonalAlZoo(personal);
			zoo.agregarPersonalAlZoo(personal2);
			zoo.agregarPersonalAlZoo(personal3);

			Boolean seAgrego = zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

			assertFalse(seAgrego);

		}
	 
	 @Test
		public void dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarEnOtraEstructuraQueNoSeaUnHospital() {

			String nombreZoo = "Animalandia";

			Zoologico zoo = new Zoologico(nombreZoo);

			// DATOS DE PERSONAL
			Integer identificacion = 23;
			String nombreCompleto = "Jime Gomez";
			Integer edad = 25;

			Personal personal = new Mantenimiento(identificacion, nombreCompleto, edad);
			Personal personal2 = new Veterinario(identificacion, nombreCompleto, edad);
			Personal personal3 = new Veterinario(identificacion, nombreCompleto, edad);

			// DATOS DE ESTRUCTURA
			Integer codigoEstructural = 2234;
			String nombreEstructura = "Hospitalcito";
			// estado es algo que ya tiene dicha estructura

			Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);
			Estructura hospital2 = new Habitat(codigoEstructural, nombreEstructura);

			zoo.agregarEstructuraAlZoo(hospital);
			zoo.agregarEstructuraAlZoo(hospital2);

			zoo.agregarPersonalAlZoo(personal);
			zoo.agregarPersonalAlZoo(personal2);
			zoo.agregarPersonalAlZoo(personal3);

			Boolean seAgrego = zoo.agregarUnVeterinarioAUnHospital(hospital2, personal);

			assertFalse(seAgrego);

		}
	 
	 
	 @Test
		public void dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarAUnHospitalInexistente() {

			String nombreZoo = "Animalandia";

			Zoologico zoo = new Zoologico(nombreZoo);

			// DATOS DE PERSONAL
			Integer identificacion = 23;
			String nombreCompleto = "Jime Gomez";
			Integer edad = 25;

			Personal personal = new Veterinario(identificacion, nombreCompleto, edad);
			Personal personal2 = new Veterinario(identificacion, nombreCompleto, edad);
			Personal personal3 = new Veterinario(identificacion, nombreCompleto, edad);

			// DATOS DE ESTRUCTURA
			Integer codigoEstructural = 2234;
			String nombreEstructura = "Hospitalcito";
			// estado es algo que ya tiene dicha estructura

			Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

			zoo.agregarPersonalAlZoo(personal);
			zoo.agregarPersonalAlZoo(personal2);
			zoo.agregarPersonalAlZoo(personal3);

			Boolean seAgrego = zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

			assertFalse(seAgrego);
			assertEquals(null, zoo.encontrarSiExisteLaEstructuraEnElZoo(hospital));

		}

		@Test
		public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarUnVeterinarioInexistente() {

			String nombreZoo = "Animalandia";

			Zoologico zoo = new Zoologico(nombreZoo);

			// DATOS DE PERSONAL
			Integer identificacion = 23;
			String nombreCompleto = "Jime Gomez";
			Integer edad = 25;

			Personal personal = new Veterinario(identificacion, nombreCompleto, edad);
			Personal personal2 = new Veterinario(identificacion, nombreCompleto, edad);
			Personal personal3 = new Veterinario(identificacion, nombreCompleto, edad);

			// DATOS DE ESTRUCTURA
			Integer codigoEstructural = 2234;
			String nombreEstructura = "Hospitalcito";
			// estado es algo que ya tiene dicha estructura

			Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

			zoo.agregarEstructuraAlZoo(hospital);

			zoo.agregarPersonalAlZoo(personal2);
			zoo.agregarPersonalAlZoo(personal3);

			Boolean seAgrego = zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

			assertFalse(seAgrego);
			assertEquals(null, zoo.encontrarSiExisteLaPersonaEnElZoo(personal));

		}
	 
		@Test
		public void dadoQueExisteUnZoologicoQueAlHacerseDeNocheLosAnimalesSeDuerman() {

			String nombreZoo = "Animalandia";
			LocalTime horario = LocalTime.of(20, 00);

			Zoologico zoo = new Zoologico(nombreZoo);

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

			zoo.agregarAnimalAlZoo(mapache);
			zoo.agregarAnimalAlZoo(oso);
			zoo.agregarAnimalAlZoo(tiburon);
			zoo.agregarAnimalAlZoo(serpiente);
			zoo.agregarAnimalAlZoo(elefante);
			zoo.agregarAnimalAlZoo(panda);

			zoo.setHorarioZoo(horario);
			Boolean estanDormidos = zoo.estanDormidosLosAnimales();

			assertTrue(estanDormidos);

		}

		@Test
		public void dadoQueExisteUnZoologicoQueAlHacerDeDiaParaQueDespiertenLosAnimales() {

			String nombreZoo = "Animalandia";
			LocalTime horario = LocalTime.of(8, 00);

			Zoologico zoo = new Zoologico(nombreZoo);

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

			zoo.agregarAnimalAlZoo(mapache);
			zoo.agregarAnimalAlZoo(oso);
			zoo.agregarAnimalAlZoo(tiburon);
			zoo.agregarAnimalAlZoo(serpiente);
			zoo.agregarAnimalAlZoo(elefante);
			zoo.agregarAnimalAlZoo(panda);

			zoo.setHorarioZoo(horario);
			Boolean estanDormidos = zoo.estanDormidosLosAnimales();

			assertFalse(estanDormidos);

		}
		
		
		
		
		
	 
		
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueSeCreeUnRegistroCuandoUnVeterinarioAlimenteDeFormaCorrectaAlAnimal() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal mono = new Mono( 230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
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

				Personal personal = new Veterinario(23, "Luis Alvarez", 34);
				Personal personal2 = new Veterinario(56, "Alejo Diaz", 19);
				Personal personal3 = new Veterinario(77, "Lourdes Juarez", 55);

				zoo.agregarPersonalAlZoo(personal);
				zoo.agregarPersonalAlZoo(personal2);
				zoo.agregarPersonalAlZoo(personal3);
				
				Integer cantidadComida = 3;
				Comida comida = Comida.PLANTA;
				
				RegistroAlimentacion registroNuevo = zoo.cargarAlimentacion(personal, mono, comida, cantidadComida);
				
				assertNotNull(registroNuevo);
				
			}
		 
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroCuandoUnVeterinarioAlimenteDeFormaIncorrectaAlAnimal() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal mono = new Mono( 230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
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

				Personal personal = new Veterinario(23, "Luis Alvarez", 34);
				Personal personal2 = new Veterinario(56, "Alejo Diaz", 19);
				Personal personal3 = new Veterinario(77, "Lourdes Juarez", 55);

				zoo.agregarPersonalAlZoo(personal);
				zoo.agregarPersonalAlZoo(personal2);
				zoo.agregarPersonalAlZoo(personal3);
				
				Integer cantidadComida = 3;
				Comida comida = Comida.CARNE;
				
				RegistroAlimentacion registroNuevo = zoo.cargarAlimentacion(personal, panda, comida, cantidadComida);
				
				assertNull(registroNuevo);
				
			}
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElVeterinarioEsInexistente() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal mono = new Mono( 230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
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

				Personal personal = new Veterinario(23, "Luis Alvarez", 34);
				Personal personal2 = new Veterinario(56, "Alejo Diaz", 19);
				Personal personal3 = new Veterinario(77, "Lourdes Juarez", 55);

				zoo.agregarPersonalAlZoo(personal);
				zoo.agregarPersonalAlZoo(personal2);

				
				Integer cantidadComida = 3;
				Comida comida = Comida.PLANTA;
				
				RegistroAlimentacion registroNuevo = zoo.cargarAlimentacion(personal3, mono, comida, cantidadComida);
				
				assertNull(registroNuevo);
				
			}
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElAnimalEsInexistente() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal mono = new Mono( 230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
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

				zoo.agregarAnimalAlZoo(mapache);
				zoo.agregarAnimalAlZoo(oso);
				zoo.agregarAnimalAlZoo(tiburon);
				zoo.agregarAnimalAlZoo(serpiente);
				zoo.agregarAnimalAlZoo(elefante);
				zoo.agregarAnimalAlZoo(panda);

				Personal personal = new Veterinario(23, "Luis Alvarez", 34);
				Personal personal2 = new Veterinario(56, "Alejo Diaz", 19);
				Personal personal3 = new Veterinario(77, "Lourdes Juarez", 55);

				zoo.agregarPersonalAlZoo(personal);
				zoo.agregarPersonalAlZoo(personal2);
				zoo.agregarPersonalAlZoo(personal3);

				
				Integer cantidadComida = 3;
				Comida comida = Comida.PLANTA;
				
				RegistroAlimentacion registroNuevo = zoo.cargarAlimentacion(personal3, mono, comida, cantidadComida);
				
				assertNull(registroNuevo);
				
			}
		 
		 
		 
		 
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearElRegistroSiUnPersonalNoAutorizadoQuiereAlimentarAlAnimal() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
						CategoriaAnimal.MAMIFERO);

				zoo.agregarAnimalAlZoo(panda);

				Personal personal = new Mantenimiento(23, "Luis Alvarez", 34);
	
				zoo.agregarPersonalAlZoo(personal);

				
				Integer cantidadComida = 3;
				Comida comida = Comida.PLANTA;
				
				RegistroAlimentacion registroNuevo = zoo.cargarAlimentacion(personal, panda, comida, cantidadComida);
				
				assertNull(registroNuevo);
				
			}
		 
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConAnimalesConocerALosQueSeEnfermaronPorHaberSidoAlimentadosConComidaNoApta() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
						CategoriaAnimal.MAMIFERO);
				Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
						CategoriaAnimal.MAMIFERO);
				Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO,
						CategoriaAnimal.MAMIFERO);
				Animal mono = new Mono( 230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);

				zoo.agregarAnimalAlZoo(panda);
				zoo.agregarAnimalAlZoo(mapache);
				zoo.agregarAnimalAlZoo(elefante);
				zoo.agregarAnimalAlZoo(mono);

				Personal personal = new Veterinario(23, "Luis Alvarez", 34);
	
				zoo.agregarPersonalAlZoo(personal);

				zoo.cargarAlimentacion(personal, panda, Comida.CARNE, 3);
				zoo.cargarAlimentacion(personal, mapache, Comida.PLANTA, 1);
				zoo.cargarAlimentacion(personal, elefante, Comida.CARNE, 5);
				zoo.cargarAlimentacion(personal, mono, Comida.PLANTA, 2);
				
				List<Animal> animalesEnfermosPorComida = zoo.obtenerALosAnimalesEnfermos();
				
				assertEquals(3, animalesEnfermosPorComida.size());
				assertEquals(panda, animalesEnfermosPorComida.get(0));
				assertEquals(mapache, animalesEnfermosPorComida.get(1));
				assertEquals(elefante, animalesEnfermosPorComida.get(2));
			
			}
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosAnimalesQueAlimentoUnVeterinarioEspecifico() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
						CategoriaAnimal.MAMIFERO);
				Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
						CategoriaAnimal.MAMIFERO);
				Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO,
						CategoriaAnimal.MAMIFERO);
				Animal mono = new Mono( 230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);

				zoo.agregarAnimalAlZoo(panda);
				zoo.agregarAnimalAlZoo(mapache);
				zoo.agregarAnimalAlZoo(elefante);
				zoo.agregarAnimalAlZoo(mono);

				Personal personal = new Veterinario(23, "Luis Alvarez", 34);
	
				zoo.agregarPersonalAlZoo(personal);

				zoo.cargarAlimentacion(personal, panda, Comida.PLANTA, 3);
				zoo.cargarAlimentacion(personal, mapache, Comida.CARNE, 1);
				zoo.cargarAlimentacion(personal, elefante, Comida.PLANTA, 5);
				zoo.cargarAlimentacion(personal, mono, Comida.PLANTA, 2);
		
				
				List<Animal> animalesAlimentadosPorUnVeterinario = zoo.conocerLosAnimalesAlimentadosPorUnVeterinario(personal);
				
				assertEquals(4, animalesAlimentadosPorUnVeterinario.size());
				assertEquals(panda, animalesAlimentadosPorUnVeterinario.get(0));
				assertEquals(mapache, animalesAlimentadosPorUnVeterinario.get(1));
				assertEquals(elefante, animalesAlimentadosPorUnVeterinario.get(2));
				assertEquals(mono, animalesAlimentadosPorUnVeterinario.get(3));
			}
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
						CategoriaAnimal.MAMIFERO);

				zoo.agregarAnimalAlZoo(panda);


				Personal personal = new Veterinario(23, "Luis Alvarez", 34);
				Personal personal1 = new Veterinario(55, "Lorenzo Grande", 64);
				Personal personal2 = new Veterinario(3, "Guido Perez", 24);
				Personal personal3 = new Veterinario(99, "Leonardo Alvarez", 44);
	
				zoo.agregarPersonalAlZoo(personal);
				zoo.agregarPersonalAlZoo(personal1);
				zoo.agregarPersonalAlZoo(personal2);
				zoo.agregarPersonalAlZoo(personal3);

				zoo.cargarAlimentacion(personal, panda, Comida.PLANTA, 3);
				zoo.cargarAlimentacion(personal1, panda, Comida.PLANTA, 1);
				zoo.cargarAlimentacion(personal2, panda, Comida.PLANTA, 5);
				zoo.cargarAlimentacion(personal3, panda, Comida.PLANTA, 2);
		
				
				List<Personal> veterinariosQueAlimentaronAUnAnimal = zoo.conocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico(panda);
				
				assertEquals(4, veterinariosQueAlimentaronAUnAnimal.size());
				assertEquals(personal, veterinariosQueAlimentaronAUnAnimal.get(0));
				assertEquals(personal1, veterinariosQueAlimentaronAUnAnimal.get(1));
				assertEquals(personal2, veterinariosQueAlimentaronAUnAnimal.get(2));
				assertEquals(personal3, veterinariosQueAlimentaronAUnAnimal.get(3));
			}
		 
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiLaCantidadDeComidaEsMenorOIgualACero() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
						CategoriaAnimal.MAMIFERO);

				zoo.agregarAnimalAlZoo(panda);


				Personal personal = new Veterinario(23, "Luis Alvarez", 34);

	
				zoo.agregarPersonalAlZoo(personal);
		
		
				RegistroAlimentacion registroNuevo = zoo.cargarAlimentacion(personal, panda, Comida.PLANTA, 0);
				
				assertNull(registroNuevo);
				
				
				
			
			}
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConPlantas() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
						CategoriaAnimal.MAMIFERO);
				
				Animal mono = new Mono( 230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, 
						CategoriaAnimal.MAMIFERO);
				
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
				
				Personal veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
				Personal veterinario2 = new Veterinario(77, "Thiago Funes", 54);
				Personal veterinario3 = new Veterinario(231, "Camila Alvarez", 44);
				

				zoo.agregarAnimalAlZoo(panda);
				zoo.agregarAnimalAlZoo(mono);
				zoo.agregarAnimalAlZoo(mapache);
				zoo.agregarAnimalAlZoo(oso);
				zoo.agregarAnimalAlZoo(tiburon);
				zoo.agregarAnimalAlZoo(serpiente);
				zoo.agregarAnimalAlZoo(elefante);
				
				
				
				zoo.agregarPersonalAlZoo(veterinario1);
				zoo.agregarPersonalAlZoo(veterinario2);
				zoo.agregarPersonalAlZoo(veterinario3);
		
		
				zoo.cargarAlimentacion(veterinario1, panda, Comida.PLANTA, 4);
				zoo.cargarAlimentacion(veterinario1, elefante, Comida.PLANTA, 2);
				zoo.cargarAlimentacion(veterinario2, panda, Comida.PLANTA, 1);
				zoo.cargarAlimentacion(veterinario3, mono, Comida.PLANTA, 5);
				zoo.cargarAlimentacion(veterinario3, serpiente, Comida.CARNE, 4);
				zoo.cargarAlimentacion(veterinario2, oso, Comida.PLANTA, 1);
				
				
				List <Animal> animalesQueComenPlantas = zoo.conocerALosAnimalesQueConsumieronComidaDeTipoPlanta();
				
				Integer tamañoEsperado = 5;
				Integer tamañoObtenido = animalesQueComenPlantas.size();
				
				assertEquals(tamañoEsperado, tamañoObtenido);
				
				
				
				
			
			}
		 
		 
		 
		 @Test
			public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConCarne() {

				String nombreZoo = "Animalandia";

				Zoologico zoo = new Zoologico(nombreZoo);

				// estar enfermo es algo que ya tiene el mono, por defecto esta sano
		

				Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
						CategoriaAnimal.MAMIFERO);
				
				Animal mono = new Mono( 230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, 
						CategoriaAnimal.MAMIFERO);
				
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
				
				Personal veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
				Personal veterinario2 = new Veterinario(77, "Thiago Funes", 54);
				Personal veterinario3 = new Veterinario(231, "Camila Alvarez", 44);
				

				zoo.agregarAnimalAlZoo(panda);
				zoo.agregarAnimalAlZoo(mono);
				zoo.agregarAnimalAlZoo(mapache);
				zoo.agregarAnimalAlZoo(oso);
				zoo.agregarAnimalAlZoo(tiburon);
				zoo.agregarAnimalAlZoo(serpiente);
				zoo.agregarAnimalAlZoo(elefante);
				
				
				
				zoo.agregarPersonalAlZoo(veterinario1);
				zoo.agregarPersonalAlZoo(veterinario2);
				zoo.agregarPersonalAlZoo(veterinario3);
		
		
				zoo.cargarAlimentacion(veterinario1, panda, Comida.PLANTA, 4);
				zoo.cargarAlimentacion(veterinario1, elefante, Comida.PLANTA, 2);
				zoo.cargarAlimentacion(veterinario2, panda, Comida.PLANTA, 1);
				zoo.cargarAlimentacion(veterinario3, mono, Comida.PLANTA, 5);
				zoo.cargarAlimentacion(veterinario3, serpiente, Comida.CARNE, 4);
				zoo.cargarAlimentacion(veterinario2, oso, Comida.PLANTA, 1);
				
				
				List <Animal> animalesQueComenCarne = zoo.conocerALosAnimalesQueConsumieronComidaDeTipoCarne();
				
				Integer tamañoEsperado = 1;
				Integer tamañoObtenido = animalesQueComenCarne.size();
				
				assertEquals(tamañoEsperado, tamañoObtenido);
				
				
				
				
			
			}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		
		
		
	 

}
