package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import org.junit.Test;

<<<<<<< HEAD
import ar.edu.unlam.pb2.zoologico.excepciones.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;



public class TestingZoo {

	private Zoologico zoo;

	@Before
	public void init(){
		String nombreZoo = "Animalandia";

		this.zoo = new Zoologico(nombreZoo);


	}

	@Test
	public void queSePuedaCrearUnZoologico() {
		
		String nombreZoo = "Animalandia";
		
		Zoologico zoo = new Zoologico(nombreZoo);

		String nombreEsperado = "Animalandia";
		
		assertNotNull(zoo);
		assertEquals(nombreEsperado, this.zoo.getNombreZoo());

	}
	
	
	@Test

	public void dadoQueExisteUnZoologicoQueSePuedanAgregarAnimalesAlMismo()
			throws NoSePudoAgregarAnimalInexistenteException {

		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
		//estar enfermo es algo que ya tiene el mono, por defecto esta sano
		TipoSexo sexo = TipoSexo.FEMENINO;
		CategoriaAnimal clase = CategoriaAnimal.MAMIFERO;
		
		Animal mono = new Mono(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);


		Boolean seAgrego = this.zoo.agregarAnimalAlZoo(mono);

		assertTrue(seAgrego);
		assertEquals(mono, this.zoo.getAnimales().get(0));

	}


	@Test(expected = NoSePudoAgregarAnimalInexistenteException.class)
	public void dadoQueExisteUnZoologicoQueNoSePuedanAgregarAnimalInexistente()
			throws NoSePudoAgregarAnimalInexistenteException {

		Animal mono = null;

		Boolean seAgrego = this.zoo.agregarAnimalAlZoo(mono);
	}



	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarPersonasAlMismo() {
		

		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		Boolean seAgrego = this.zoo.agregarPersonalAlZoo(personal);

		assertTrue(seAgrego);
		assertEquals(personal, this.zoo.getPersonas().get(0));
	
	}


	@Test(expected = NoSePudoAgregarPersonaInexistenteException.class)
	public void dadoQueExisteUnZoologicoQueNoSePuedanAgregarPersonasAlMismoSiEstaNoExiste()
			throws NoSePudoAgregarPersonaInexistenteException {

		Persona persona = null;

		Boolean seAgrego = this.zoo.agregarPersonalAlZoo(persona);
	}

	@Test (expected = NoSePuedenAgregarMenoresDeEdadException.class)
	public void dadoQueExisteUnZoologicoNoSePuedenAgregarPersonasSiEstasSonMenores() throws NoSePuedenAgregarMenoresDeEdadException {

		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 15;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		Boolean seAgrego = this.zoo.agregarPersonaAlZoo(personal);
		
	}

	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarEstructurasAlMismo()
			throws NoSePudoAgregarEstructuraInexistenteExcepcion {

		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

		Boolean seAgrego = this.zoo.agregarEstructuraAlZoo(hospital);

		assertTrue(seAgrego);
		assertEquals(hospital, this.zoo.getEstructuras().get(0));

	}

	@Test(expected = NoSePudoAgregarEstructuraInexistenteExcepcion.class)
	public void dadoQueExisteUnZoologicoQueNoSePuedanAgregarEstructurasAlMismoSiEstaNoExiste()
			throws NoSePudoAgregarEstructuraInexistenteExcepcion {

		Estructura hospital = null;

		Boolean seAgrego = this.zoo.agregarEstructuraAlZoo(hospital);

	}

	@Test
	public void dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionOmnivora()
			throws NoSePudoAgregarAnimalInexistenteException {

		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
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

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);

		List<Animal> animalesOmnivoros = this.zoo.obtenerLosAnimalesConTipoAlimentacionOmnivora();

		Integer tamañoEsperado = 2;

		assertEquals((int) tamañoEsperado, animalesOmnivoros.size());
		assertEquals(mono.getCodigoDeReconocimiento(), animalesOmnivoros.get(0).getCodigoDeReconocimiento());
		assertEquals(oso.getCodigoDeReconocimiento(), animalesOmnivoros.get(1).getCodigoDeReconocimiento());

	}

	@Test
	public void dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionCarnivora() {

		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
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

		try {
			this.zoo.agregarAnimalAlZoo(mono);
			this.zoo.agregarAnimalAlZoo(mapache);
			this.zoo.agregarAnimalAlZoo(oso);
			this.zoo.agregarAnimalAlZoo(tiburon);
			this.zoo.agregarAnimalAlZoo(serpiente);
			this.zoo.agregarAnimalAlZoo(elefante);

		} catch (NoSePudoAgregarAnimalInexistenteException e) {
			e.getMessage();
		}

		List<Animal> animalesCarnivoros = this.zoo.obtenerLosAnimalesConTipoAlimentacionCarnivora();

		Integer tamañoEsperado = 3;

		assertEquals((int) tamañoEsperado, animalesCarnivoros.size());
		assertEquals(mapache, animalesCarnivoros.get(0));
		assertEquals(tiburon, animalesCarnivoros.get(1));
		assertEquals(serpiente, animalesCarnivoros.get(2));

	}

	@Test
	public void dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionHerbivora()
			throws NoSePudoAgregarAnimalInexistenteException {

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

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		List<Animal> animalesHerbivoros = this.zoo.obtenerLosAnimalesConTipoAlimentacionHerbivora();

		Integer tamañoEsperado = 2;

		assertEquals((int) tamañoEsperado, animalesHerbivoros.size());
		assertEquals(elefante, animalesHerbivoros.get(0));
		assertEquals(panda, animalesHerbivoros.get(1));

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesConocerALosAnimalesConTemperaturaCorporalNeutral()
			throws NoSePudoAgregarAnimalInexistenteException {

		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
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

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		List<Animal> animalesSanos = this.zoo.obtenerALosAnimalesConTemperaturaNeutral();

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
	public void dadoQueExisteUnZoologicoConAnimalesConocerALosAnimalesEnfermosDeSaludPorBajaTemperaturaCorporal()
			throws NoSePudoAgregarAnimalInexistenteException {

		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
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

		mono.setTemperaturaAnimal(38.2);
		tiburon.setTemperaturaAnimal(38.2);
		elefante.setTemperaturaAnimal(38.2);

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		List<Animal> animalesEnfermos = this.zoo.obtenerALosAnimalesEnfermosPorTemperaturaBaja();

		Integer tamañoEsperado = 3;

		assertEquals((int) tamañoEsperado, animalesEnfermos.size());
		assertEquals(mono, animalesEnfermos.get(0));
		assertEquals(tiburon, animalesEnfermos.get(1));
		assertEquals(elefante, animalesEnfermos.get(2));

	}

	@Test
	public void dadoQueExisteUnZoologicoConVeterinarioQueSePuedaAgregarAUnHospital()
			throws NoSePudoAgregarEstructuraInexistenteExcepcion, NoSePudoAgregarPersonaInexistenteException,
			NoSePudoAgregarAlVeterinarioAlHospitalException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);


		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarEstructuraAlZoo(hospital);

		Boolean seAgrego = this.zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

		assertTrue(seAgrego);
		assertEquals(personal, ((HospitalVeterinario) hospital).getVeterinarios().get(0));

	}

	@Test(expected = NoSePudoAgregarAlVeterinarioAlHospitalException.class)
	public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarOtroPersonalQueNoSeaVeterinario()
			throws NoSePudoAgregarEstructuraInexistenteExcepcion, NoSePudoAgregarPersonaInexistenteException,
			NoSePudoAgregarAlVeterinarioAlHospitalException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Mantenimiento(identificacion, nombreCompleto, edad);

		// DATOS DE ESTRUCTURA
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

		this.zoo.agregarEstructuraAlZoo(hospital);

		this.zoo.agregarPersonalAlZoo(personal);

		Boolean seAgrego = this.zoo.agregarUnVeterinarioAUnHospital(hospital, personal);
	}

	@Test(expected = NoSePudoAgregarAlVeterinarioAlHospitalException.class)
	public void dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarEnOtraEstructuraQueNoSeaUnHospital()
			throws NoSePudoAgregarEstructuraInexistenteExcepcion, NoSePudoAgregarPersonaInexistenteException,
			NoSePudoAgregarAlVeterinarioAlHospitalException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		// DATOS DE ESTRUCTURA
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito falso";

		Estructura habitatSergio = new Habitat(codigoEstructural, nombreEstructura);

		this.zoo.agregarEstructuraAlZoo(hospital);

		this.zoo.agregarPersonalAlZoo(personal);

		Boolean seAgrego = this.zoo.agregarUnVeterinarioAUnHospital(habitatSergio, personal);

	}

	@Test(expected = NoSePudoAgregarEstructuraInexistenteExcepcion.class)
	public void dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarAUnHospitalInexistente()
			throws NoSePudoAgregarPersonaInexistenteException, NoSePudoAgregarAlVeterinarioAlHospitalException,
			NoSePudoAgregarEstructuraInexistenteExcepcion {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		// DATOS DE ESTRUCTURA
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";
		// estado es algo que ya tiene dicha estructura

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

		this.zoo.agregarPersonalAlZoo(personal);

		Boolean seAgrego = this.zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

	}

	@Test(expected = NoSePudoAgregarPersonaInexistenteException.class)
	public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarUnVeterinarioInexistente()
			throws NoSePudoAgregarEstructuraInexistenteExcepcion, NoSePudoAgregarPersonaInexistenteException,
			NoSePudoAgregarAlVeterinarioAlHospitalException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personal2 = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personal3 = new Veterinario(identificacion, nombreCompleto, edad);

		// DATOS DE ESTRUCTURA
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";
		// estado es algo que ya tiene dicha estructura

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

		this.zoo.agregarEstructuraAlZoo(hospital);

		this.zoo.agregarPersonalAlZoo(personal2);
		this.zoo.agregarPersonalAlZoo(personal3);

		Boolean seAgrego = this.zoo.agregarUnVeterinarioAUnHospital(hospital, personal);
	}

	@Test
	public void dadoQueExisteUnZoologicoQueAlHacerseDeNocheLosAnimalesSeDuerman()
			throws NoSePudoAgregarAnimalInexistenteException {

		LocalTime horario = LocalTime.of(20, 00);

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

		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		this.zoo.setHorarioZoo(horario);
		Boolean estanDormidos = this.zoo.estanDormidosLosAnimales();

		assertTrue(estanDormidos);

	}

	@Test
	public void dadoQueExisteUnZoologicoQueAlHacerseDeDiaSeDespiertenLosAnimales()
			throws NoSePudoAgregarAnimalInexistenteException {

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

		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		zoo.setHorarioZoo(horario);
		Boolean estanDormidos = this.zoo.estanDormidosLosAnimales();

		assertFalse(estanDormidos);

	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueSeCreeUnRegistroCuandoUnVeterinarioAlimenteDeFormaCorrectaAlAnimal()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
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
		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);
		Persona personal2 = new Veterinario(56, "Alejo Diaz", 19);
		Persona personal3 = new Veterinario(77, "Lourdes Juarez", 55);

		this.zoo.agregarPersonalAlZoo(personal);
		this.zoo.agregarPersonalAlZoo(personal2);
		this.zoo.agregarPersonalAlZoo(personal3);

		Integer cantidadComida = 3;
		Comida comida = Comida.PLANTA;

		RegistroAlimentacion registroNuevo = this.zoo.cargarAlimentacion(personal, mono, comida, cantidadComida);

		assertNotNull(registroNuevo);
		assertEquals(mono, registroNuevo.getAnimal());

	}

	@Test(expected = NoSePudoAgregarPersonaInexistenteException.class)
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElVeterinarioEsInexistente()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
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
		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);
		Persona personal2 = new Veterinario(56, "Alejo Diaz", 19);
		Persona personal3 = new Veterinario(77, "Lourdes Juarez", 55);

		this.zoo.agregarPersonalAlZoo(personal);
		this.zoo.agregarPersonalAlZoo(personal2);

		Integer cantidadComida = 3;
		Comida comida = Comida.PLANTA;

		RegistroAlimentacion registroNuevo = this.zoo.cargarAlimentacion(personal3, mono, comida, cantidadComida);

	}

	@Test(expected = NoSePudoAgregarAnimalInexistenteException.class)
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElAnimalEsInexistente()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
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
		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);
		Persona personal2 = new Veterinario(56, "Alejo Diaz", 19);
		Persona personal3 = new Veterinario(77, "Lourdes Juarez", 55);

		this.zoo.agregarPersonalAlZoo(personal);
		this.zoo.agregarPersonalAlZoo(personal2);
		this.zoo.agregarPersonalAlZoo(personal3);

		Integer cantidadComida = 3;
		Comida comida = Comida.PLANTA;

		RegistroAlimentacion registroNuevo = this.zoo.cargarAlimentacion(personal3, mono, comida, cantidadComida);
	}

	@Test(expected = NoSePudoAgregarPersonalInvalidoExcepcion.class)
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearElRegistroSiUnPersonalNoAutorizadoQuiereAlimentarAlAnimal()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Mantenimiento(23, "Luis Alvarez", 34);

		this.zoo.agregarPersonalAlZoo(personal);

		Integer cantidadComida = 3;
		Comida comida = Comida.PLANTA;

		RegistroAlimentacion registroNuevo = this.zoo.cargarAlimentacion(personal, panda, comida, cantidadComida);

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesConocerALosQueSeEnfermaronPorHaberSidoAlimentadosConComidaNoApta()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(panda);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(mono);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);

		this.zoo.agregarPersonalAlZoo(personal);

		this.zoo.cargarAlimentacion(personal, panda, Comida.CARNE, 3);
		this.zoo.cargarAlimentacion(personal, mapache, Comida.PLANTA, 1);
		this.zoo.cargarAlimentacion(personal, elefante, Comida.CARNE, 5);
		this.zoo.cargarAlimentacion(personal, mono, Comida.PLANTA, 2);

		// el mono se enfermo por otro motivo y no fue agregado ya que su causa no fue
		// por mala alimentacion
		mono.setEstaEnfermo(true);

		List<Animal> animalesEnfermosPorComida = this.zoo.obtenerALosAnimalesEnfermosPorAlimentacionIncorrecta();

		assertEquals(3, animalesEnfermosPorComida.size());
		assertEquals(panda, animalesEnfermosPorComida.get(0));
		assertEquals(mapache, animalesEnfermosPorComida.get(1));
		assertEquals(elefante, animalesEnfermosPorComida.get(2));

	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosAnimalesQueAlimentoUnVeterinarioEspecifico()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(panda);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(mono);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);

		this.zoo.agregarPersonalAlZoo(personal);

		this.zoo.cargarAlimentacion(personal, panda, Comida.PLANTA, 3);
		this.zoo.cargarAlimentacion(personal, mapache, Comida.CARNE, 1);
		this.zoo.cargarAlimentacion(personal, elefante, Comida.PLANTA, 5);
		this.zoo.cargarAlimentacion(personal, mono, Comida.PLANTA, 2);

		List<Animal> animalesAlimentadosPorUnVeterinario = this.zoo.conocerLosAnimalesAlimentadosPorUnVeterinario(personal);

		assertEquals(4, animalesAlimentadosPorUnVeterinario.size());
		assertEquals(panda, animalesAlimentadosPorUnVeterinario.get(0));
		assertEquals(mapache, animalesAlimentadosPorUnVeterinario.get(1));
		assertEquals(elefante, animalesAlimentadosPorUnVeterinario.get(2));
		assertEquals(mono, animalesAlimentadosPorUnVeterinario.get(3));
	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);
		Persona personal1 = new Veterinario(55, "Lorenzo Grande", 64);
		Persona personal2 = new Veterinario(3, "Guido Perez", 24);
		Persona personal3 = new Veterinario(99, "Leonardo Alvarez", 44);

		this.zoo.agregarPersonalAlZoo(personal);
		this.zoo.agregarPersonalAlZoo(personal1);
		this.zoo.agregarPersonalAlZoo(personal2);
		this.zoo.agregarPersonalAlZoo(personal3);

		this.zoo.cargarAlimentacion(personal, panda, Comida.PLANTA, 3);
		this.zoo.cargarAlimentacion(personal1, panda, Comida.PLANTA, 1);
		this.zoo.cargarAlimentacion(personal2, panda, Comida.PLANTA, 5);
		this.zoo.cargarAlimentacion(personal3, panda, Comida.PLANTA, 2);

		List<Persona> veterinariosQueAlimentaronAUnAnimal = this.zoo
				.conocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico(panda);

		assertEquals(4, veterinariosQueAlimentaronAUnAnimal.size());
		assertEquals(personal, veterinariosQueAlimentaronAUnAnimal.get(0));
		assertEquals(personal1, veterinariosQueAlimentaronAUnAnimal.get(1));
		assertEquals(personal2, veterinariosQueAlimentaronAUnAnimal.get(2));
		assertEquals(personal3, veterinariosQueAlimentaronAUnAnimal.get(3));
	}

	@Test(expected = NoSePudoAlimentarException.class)
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiLaCantidadDeComidaEsMenorOIgualACero()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);

		this.zoo.agregarPersonalAlZoo(personal);

		RegistroAlimentacion registroNuevo = this.zoo.cargarAlimentacion(personal, panda, Comida.PLANTA, 0);
	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConPlantas()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
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

		Persona veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
		Persona veterinario2 = new Veterinario(77, "Thiago Funes", 54);
		Persona veterinario3 = new Veterinario(231, "Camila Alvarez", 44);

		this.zoo.agregarAnimalAlZoo(panda);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);

		this.zoo.agregarPersonalAlZoo(veterinario1);
		this.zoo.agregarPersonalAlZoo(veterinario2);
		this.zoo.agregarPersonalAlZoo(veterinario3);

		this.zoo.cargarAlimentacion(veterinario1, panda, Comida.PLANTA, 4);
		this.zoo.cargarAlimentacion(veterinario1, elefante, Comida.PLANTA, 2);
		this.zoo.cargarAlimentacion(veterinario2, panda, Comida.PLANTA, 1);
		this.zoo.cargarAlimentacion(veterinario3, mono, Comida.PLANTA, 5);
		this.zoo.cargarAlimentacion(veterinario3, serpiente, Comida.CARNE, 4);
		this.zoo.cargarAlimentacion(veterinario2, oso, Comida.PLANTA, 1);

		List<Animal> animalesQueComenPlantas = this.zoo.conocerALosAnimalesQueConsumieronComidaDeTipoPlanta();

		Integer tamañoEsperado = 5;
		Integer tamañoObtenido = animalesQueComenPlantas.size();

		assertEquals(tamañoEsperado, tamañoObtenido);

	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConCarne()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
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

		Persona veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
		Persona veterinario2 = new Veterinario(77, "Thiago Funes", 54);
		Persona veterinario3 = new Veterinario(231, "Camila Alvarez", 44);

		this.zoo.agregarAnimalAlZoo(panda);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);

		this.zoo.agregarPersonalAlZoo(veterinario1);
		this.zoo.agregarPersonalAlZoo(veterinario2);
		this.zoo.agregarPersonalAlZoo(veterinario3);

		this.zoo.cargarAlimentacion(veterinario1, panda, Comida.PLANTA, 4);
		this.zoo.cargarAlimentacion(veterinario1, elefante, Comida.PLANTA, 2);
		this.zoo.cargarAlimentacion(veterinario2, panda, Comida.PLANTA, 1);
		this.zoo.cargarAlimentacion(veterinario3, mono, Comida.PLANTA, 5);
		this.zoo.cargarAlimentacion(veterinario3, serpiente, Comida.CARNE, 4);
		this.zoo.cargarAlimentacion(veterinario2, oso, Comida.PLANTA, 1);

		List<Animal> animalesQueComenCarne = this.zoo.conocerALosAnimalesQueConsumieronComidaDeTipoCarne();

		Integer tamañoEsperado = 1;
		Integer tamañoObtenido = animalesQueComenCarne.size();

		assertEquals(tamañoEsperado, tamañoObtenido);
	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosRegistrosQueContenganUnAnimalEspecifico()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
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

		Persona veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
		Persona veterinario2 = new Veterinario(77, "Thiago Funes", 54);
		Persona veterinario3 = new Veterinario(231, "Camila Alvarez", 44);

		this.zoo.agregarAnimalAlZoo(panda);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);

		this.zoo.agregarPersonalAlZoo(veterinario1);
		this.zoo.agregarPersonalAlZoo(veterinario2);
		this.zoo.agregarPersonalAlZoo(veterinario3);

		RegistroAlimentacion registro1 = this.zoo.cargarAlimentacion(veterinario1, panda, Comida.PLANTA, 3);
		RegistroAlimentacion registro2 = this.zoo.cargarAlimentacion(veterinario1, panda, Comida.PLANTA, 1);
		RegistroAlimentacion registro3 = this.zoo.cargarAlimentacion(veterinario2, panda, Comida.PLANTA, 5);
		RegistroAlimentacion registro4 = this.zoo.cargarAlimentacion(veterinario3, panda, Comida.PLANTA, 2);
		RegistroAlimentacion registro5 = this.zoo.cargarAlimentacion(veterinario3, elefante, Comida.PLANTA, 2);

		List<RegistroAlimentacion> registrosQueContengan = this.zoo.conocerLosRegistrosQueContenganUnAnimalEspecifico(panda);

		Integer tamañoEsperado = 4;
		Integer tamañoObtenido = registrosQueContengan.size();

		assertEquals(tamañoEsperado, tamañoObtenido);
		assertEquals(registro1, registrosQueContengan.get(0));
		assertEquals(registro2, registrosQueContengan.get(1));
		assertEquals(registro3, registrosQueContengan.get(2));
		assertEquals(registro4, registrosQueContengan.get(3));

	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerSiElPesoDelAnimalAumentoAlSerAlimentadoConSuComidaCorrespondiente()
			throws NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		Animal mono = new Mono(230, "Sergio Ramirez", 3, 5.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);

		Animal oso = new Oso(78, "winnie pooh", 7, 10.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		Animal tiburon = new Tiburon(90, "tiburoncin", 12, 20.0, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.PEZ);

		Animal serpiente = new Serpiente(1002, "thiago", 4, 2.5, TipoAlimentacion.CARNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.REPTIL);

		Animal elefante = new Elefante(125, "dumbo", 9, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);

		Persona veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
		Persona veterinario2 = new Veterinario(77, "Thiago Funes", 54);
		Persona veterinario3 = new Veterinario(231, "Camila Alvarez", 44);

		this.zoo.agregarAnimalAlZoo(panda);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		
		this.zoo.agregarPersonalAlZoo(veterinario1);
		this.zoo.agregarPersonalAlZoo(veterinario2);
		this.zoo.agregarPersonalAlZoo(veterinario3);

		this.zoo.cargarAlimentacion(veterinario1, panda, Comida.PLANTA, 3);
		this.zoo.cargarAlimentacion(veterinario1, panda, Comida.PLANTA, 1);
		this.zoo.cargarAlimentacion(veterinario2, panda, Comida.PLANTA, 5);
		this.zoo.cargarAlimentacion(veterinario3, panda, Comida.PLANTA, 2);
		this.zoo.cargarAlimentacion(veterinario3, elefante, Comida.PLANTA, 2);
		
		Double pesoObtenidoAnimalAlAlimentarse = this.zoo.getRegistrosDeAlimentacion().get(4).getAnimal().getPeso();
		Double pesoEsperado = 40.0;
		
		assertEquals(pesoEsperado, pesoObtenidoAnimalAlAlimentarse);
=======
	
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
		

		
>>>>>>> 0263159f657eda04ccc7d11ea375316280a94015
	}
	
	
	
	
	
	
	

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEstosSePuedenIngresarAHabitats() throws Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		
		Boolean seAgrego = this.zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		Animal animalAgregado = this.zoo.obtenerAnimalDeUnHabitat(mono, habitatMonos);
		
		assertTrue(seAgrego);
		assertEquals(mono, animalAgregado);

	}
	
	@Test
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsPodemosObtenerUnAnimalDeUnHabitatParticular() throws Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono1);
		
		this.zoo.agregarAnimalAlHabitat (mono1, habitatMonos);
		Animal primerAnimalObtenido = this.zoo.obtenerAnimalDeUnHabitat(mono1, habitatMonos);
		
		assertEquals(mono1, primerAnimalObtenido);
		
	}
	
	@Test (expected = NoExisteObjetoDondeSeBuscaException.class)
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsNoPodemosAgregarAnimalesSiElHabitatNoEstaEnElZoologico() throws NoExisteObjetoDondeSeBuscaException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono1);
	
		this.zoo.agregarAnimalAlHabitat (mono1, habitatMonos); 

	}
	
	@Test (expected = NoExisteObjetoDondeSeBuscaException.class)
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsNoPodemosAgregarAnimalesSiNoEstanEnElZoologico() throws NoExisteObjetoDondeSeBuscaException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlHabitat (mono1, habitatMonos); 

	}
	
	@Test (expected = EspecieDiferenteException.class)
	public void dadoQueExisteUnZoologicoConHabitatsEstosNoDebenAlbergarDistintasEspecies() throws EspecieDiferenteException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		
		Animal oso = new Oso(216, "Oso Maloso", 8, 120.6, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(oso);
	
		this.zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		this.zoo.agregarAnimalAlHabitat (oso, habitatMonos);
	}
	
	@Test (expected = HabitatLlenoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsNoSePuedenIngresarMasAnimalesSiEsteEstaLleno() throws HabitatLlenoException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono1);
		
		Animal mono2 = new Mono(514, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono2);
		
		Animal mono3 = new Mono(515, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono3);
		
		Animal mono4 = new Mono(516, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono4);
		
		Animal mono5 = new Mono(517, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono5);
		
		this.zoo.agregarAnimalAlHabitat (mono1, habitatMonos);
		this.zoo.agregarAnimalAlHabitat (mono2, habitatMonos);
		this.zoo.agregarAnimalAlHabitat (mono3, habitatMonos);
		this.zoo.agregarAnimalAlHabitat (mono4, habitatMonos);
		this.zoo.agregarAnimalAlHabitat (mono5, habitatMonos);
		
	}
	

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesPodemosObtenerTodosLosDeUnaMismaCategoria() {
		
		Animal mono = new Mono(513, "mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
		Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO, CategoriaAnimal.MAMIFERO);
		Animal oso = new Oso(78, "winnie pooh", 7, 10.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
		Animal tiburon = new Tiburon(90, "tiburoncin", 12, 20.0, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO, CategoriaAnimal.PEZ);
		Animal serpiente = new Serpiente(1002, "thiago", 4, 2.5, TipoAlimentacion.CARNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.REPTIL);
		Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO, CategoriaAnimal.MAMIFERO);
		
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		
		List <Animal> animalesMamiferos = this.zoo.obtenerLosAnimalesDeUnaCategoria(CategoriaAnimal.MAMIFERO);
		
		Integer tamañoEsperado = 4;
		
		assertEquals((int) tamañoEsperado, animalesMamiferos.size());
		assertEquals(mono, animalesMamiferos.get(0));
		assertEquals(mapache, animalesMamiferos.get(1));
		assertEquals(oso, animalesMamiferos.get(2));
		assertEquals(elefante, animalesMamiferos.get(3));

	}
	
	@Test
	public void dadoQueExisteUnZoologicoConAnimalesPodemosObtenerTodosLosDeUnMismoSexo() {
		
		Animal mono = new Mono(513, "mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
		Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO, CategoriaAnimal.MAMIFERO);
		Animal oso = new Oso(78, "winnie pooh", 7, 10.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
		Animal tiburon = new Tiburon(90, "tiburoncin", 12, 20.0, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO, CategoriaAnimal.PEZ);
		Animal serpiente = new Serpiente(1002, "thiago", 4, 2.5, TipoAlimentacion.CARNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.REPTIL);
		Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO, CategoriaAnimal.MAMIFERO);
		
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);

		List <Animal> animalesHembras = this.zoo.obtenerLosAnimalesDeUnSexo(TipoSexo.FEMENINO);
		
		Integer tamañoEsperado = 3;
		
		assertEquals((int) tamañoEsperado, animalesHembras.size());
		assertEquals(mono, animalesHembras.get(0));
		assertEquals(oso, animalesHembras.get(1));
		assertEquals(serpiente, animalesHembras.get(2));
		
	}
	
	@Test 
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesePuedenReproducir () throws Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mona);
		this.zoo.agregarAnimalAlHabitat (mona, habitatMonos);
		
		Animal mono = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		
		Integer idCria = 515;
		String nombreCria = "monito bebé";
		Boolean seReproducieron = this.zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);
		Animal cria = this.zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos);
		String nombreObtenido = cria.getNombreAnimal();
		
		assertTrue(seReproducieron);
		assertNotNull(cria);
		assertEquals(nombreCria, nombreObtenido);

	}
	
	@Test (expected = ProgenitoresDelMismoSexoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiSonDelMismoSexo () throws ProgenitoresDelMismoSexoException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mona);
		this.zoo.agregarAnimalAlHabitat (mona, habitatMonos);
		
		Animal mono = new Mono(514, "Mona Rosa", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		
		Integer idCria = 515;
		String nombreCria = "monito bebé";
		this.zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);
		this.zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos);
		
	}

	@Test (expected = HabitatLlenoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiElHabitatYaEstaLleno () throws HabitatLlenoException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 2;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mona);
		this.zoo.agregarAnimalAlHabitat (mona, habitatMonos);
		
		Animal mono = new Mono(514, "Mona Rosa", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		
		Integer idCria = 515;
		String nombreCria = "monito bebé";
		this.zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);

	}
	
	@Test (expected = ProgenitoresEnDistintoHabitatException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiEstanEnDistintoHabitat () throws ProgenitoresEnDistintoHabitatException, Exception {

		Integer codigoEstructural1 = 123;
		String nombreEstructura1 = "Isla de los monos";
		Integer maximoAnimales1 = 4;
		Estructura habitatMonos1 = new Habitat(codigoEstructural1, nombreEstructura1, maximoAnimales1);
		this.zoo.agregarEstructuraAlZoo(habitatMonos1);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mona);
		this.zoo.agregarAnimalAlHabitat (mona, habitatMonos1);
		
		Integer codigoEstructural2 = 321;
		String nombreEstructura2 = "Otra isla de los monos";
		Integer maximoAnimales2 = 4;
		Estructura habitatMonos2 = new Habitat(codigoEstructural2, nombreEstructura2, maximoAnimales2);
		this.zoo.agregarEstructuraAlZoo(habitatMonos2);
		
		Animal mono = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat (mono, habitatMonos2);
		
		Integer idCria = 515;
		String nombreCria = "monito bebé";
		this.zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos1, idCria, nombreCria);
		
	}
	
	@Test 
	public void dadoQueExisteUnZoologicoConVeterinariosQueEstanEnHospitalesPodemosObtenerUnVeterinarioDeUnHospital() throws Exception {
		
        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
        this.zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		this.zoo.agregarEstructuraAlZoo(hospital);
        this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);
	
		Veterinario veterinarioObtenido = this.zoo.obtenerVeterinarioDeUnHospital(veterinario, hospital);		
		assertEquals(veterinario, veterinarioObtenido);

	}
	
	@Test 
    public void dadoQueExisteUnZoologicoConUnHospitalQueSePuedaCrearUnRegistroDeTratamientoAlCurarUnVeterinarioAUnAnimal() throws Exception {

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        this.zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);    
        this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
        this.zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		this.zoo.agregarEstructuraAlZoo(hospital);
        this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);

        oso.setEstaEnfermo(true);
        
		RegistroTratamiento registro = this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso,  bosqueOsos);
		assertNotNull(registro);
		assertFalse(oso.getEstaEnfermo());
		assertEquals(veterinario, registro.getVeterinario());

    }
	
	@Test (expected = EstadoDelObjetoEsIncorrectoException.class)
    public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiYaEstaSano() throws EstadoDelObjetoEsIncorrectoException, Exception {

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
      	this.zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);    
        this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
        this.zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		this.zoo.agregarEstructuraAlZoo(hospital);
        this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);
        
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso,  bosqueOsos);

    }
	
	@Test (expected = InstanciaIncorrectaException.class)
    public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiLaPersonaQueAtiendeNoEsUnVeterinario() throws InstanciaIncorrectaException, Exception {

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        this.zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);    
        this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona mantenimiento = new Mantenimiento(23, "Luis Alvarez", 34);
        this.zoo.agregarPersonaAlZoo(mantenimiento);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		this.zoo.agregarEstructuraAlZoo(hospital);
        this.zoo.agregarUnVeterinarioAUnHospital(hospital, mantenimiento);
        
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, mantenimiento, oso,  bosqueOsos);

    }
	
	@Test (expected = NoExisteObjetoDondeSeBuscaException.class)
    public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiElVeterinarioNoEstaEnElZoologico() throws NoExisteObjetoDondeSeBuscaException, Exception {

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        this.zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);    
        this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		this.zoo.agregarEstructuraAlZoo(hospital);
        
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso,  bosqueOsos);

    }
	
	@Test (expected = NoExisteObjetoDondeSeBuscaException.class)
    public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiElVeterinarioNoEstaEnElHospital() throws NoExisteObjetoDondeSeBuscaException, Exception {

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        this.zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);    
        this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		this.zoo.agregarEstructuraAlZoo(hospital);
        
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso,  bosqueOsos);

    }
	
	
	@Test 
    public void dadoQueExisteUnZoologicoConUnHospitalSePuedenObtenerTodosLosAnimalesQueTratoUnVeterinarioParticular() throws Exception {
			
        Animal oso1 = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        this.zoo.agregarAnimalAlZoo(oso1);
        oso1.setEstaEnfermo(true);
        
        Animal oso2 = new Oso(3334, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        this.zoo.agregarAnimalAlZoo(oso2);
        oso2.setEstaEnfermo(true);
        
        Animal oso3 = new Oso(3335, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        this.zoo.agregarAnimalAlZoo(oso3);
        oso3.setEstaEnfermo(true);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);    
        this.zoo.agregarAnimalAlHabitat(oso1, bosqueOsos);
        this.zoo.agregarAnimalAlHabitat(oso2, bosqueOsos);
        this.zoo.agregarAnimalAlHabitat(oso3, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
        this.zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		this.zoo.agregarEstructuraAlZoo(hospital);
        this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);
        
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso2,  bosqueOsos);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso3,  bosqueOsos);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso1,  bosqueOsos);
		
		List<Animal> animalesObtenidos = this.zoo.obtenerLosAnimalesQueAtendioUnVeterinarioEnUnHospital(veterinario, hospital);
		
		List<Animal> animalesEsperados = new ArrayList<>();
		animalesEsperados.add(oso2);
		animalesEsperados.add(oso3);
		animalesEsperados.add(oso1);
		
		assertNotNull(animalesObtenidos);
		assertEquals(animalesEsperados, animalesObtenidos);
		
    }
	
	@Test 
    public void dadoQueExisteUnZoologicoConUnHospitalSePuedenObtenerTodosLosVeterinariosQueAtendieronAUnAnimalParticular() throws Exception {

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        this.zoo.agregarAnimalAlZoo(oso);      
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);    
        this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
        this.zoo.agregarPersonaAlZoo(veterinario1);
        
        Persona veterinario2 = new Veterinario(23, "Luis Alvarez", 34);
        this.zoo.agregarPersonaAlZoo(veterinario2);
        
        Persona veterinario3 = new Veterinario(23, "Luis Alvarez", 34);
        this.zoo.agregarPersonaAlZoo(veterinario3);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		this.zoo.agregarEstructuraAlZoo(hospital);
        this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario1);
        this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario2);
        this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario3);
        
        oso.setEstaEnfermo(true);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario2, oso,  bosqueOsos);
		
        oso.setEstaEnfermo(true);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario1, oso,  bosqueOsos);
		
        oso.setEstaEnfermo(true);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario3, oso,  bosqueOsos);
		
		List<Persona> veterinariosObtenidos = this.zoo.obtenerLosVeterinariosQueAtendieronAUnAnimalEnUnHospital(oso, hospital);
		
		List<Persona> veterinariosEsperados = new ArrayList<>();
		veterinariosEsperados.add(veterinario2);
		veterinariosEsperados.add(veterinario1);
		veterinariosEsperados.add(veterinario3);
		
		assertNotNull(veterinariosObtenidos);
		assertEquals(veterinariosEsperados, veterinariosObtenidos);
    }
	
	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEnUnHabitatQueSePuedanObtenerLosAnimalesDeUnHabitatOrdenadosPorEdadDecreciente() throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {
		
        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono2 = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono3 = new Mono(515, "Mono Juan", 2, 6.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);

		zoo.agregarAnimalAlZoo(mono1);
		zoo.agregarAnimalAlZoo(mono2);
		zoo.agregarAnimalAlZoo(mono3);
		zoo.agregarAnimalAlHabitat(mono1, habitatMonos);
		zoo.agregarAnimalAlHabitat(mono2, habitatMonos);
		zoo.agregarAnimalAlHabitat(mono3, habitatMonos);

		TreeSet<Animal> animalesOrdenados = zoo
				.obtenerAnimalesDeUnHabitatOrdenadosOrdenEspecifico(new OrdenDescendiente(), habitatMonos);

		assertEquals(3, animalesOrdenados.size());

		// ORDEN:
		// MONO2 6 años (first)
		// MONO1 4 años
		// MONO3 2 años (last)
		assertEquals(6, (int) animalesOrdenados.first().getEdad());
		assertEquals(2, (int) animalesOrdenados.last().getEdad());
	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEnUnHabitatQueSePuedanObtenerLosAnimalesDeUnHabitatOrdenadosPorEdadAscendente() throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {

        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);
		
		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono2 = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono3 = new Mono(515, "Mono Juan", 2, 6.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);

		zoo.agregarAnimalAlZoo(mono1);
		zoo.agregarAnimalAlZoo(mono2);
		zoo.agregarAnimalAlZoo(mono3);
		zoo.agregarAnimalAlHabitat(mono1, habitatMonos);
		zoo.agregarAnimalAlHabitat(mono2, habitatMonos);
		zoo.agregarAnimalAlHabitat(mono3, habitatMonos);

		TreeSet<Animal> animalesOrdenados = zoo
				.obtenerAnimalesDeUnHabitatOrdenadosOrdenEspecifico(new OrdenAscendente(), habitatMonos);

		assertEquals(3, animalesOrdenados.size());

		// ORDEN:
		// MONO3 2 años (first)
		// MONO1 4 años
		// MONO2 6 años (last)
		assertEquals(2, (int) animalesOrdenados.first().getEdad());
		assertEquals(6, (int) animalesOrdenados.last().getEdad());
	}
	
}
