package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import ar.edu.unlam.pb2.animales.*;
import ar.edu.unlam.pb2.excepciones.*;
import ar.edu.unlam.pb2.enums.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class TestingZoo {

	private Zoologico zoo;

	@Before
	public void init() {
		String nombreZoo = "Animalandia";

		this.zoo = new Zoologico(nombreZoo);

	}

	@Test
	public void queSePuedaCrearUnZoologico() {
		String nombreEsperado = "Animalandia";

		assertNotNull(this.zoo);
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
		// estar enfermo es algo que ya tiene el mono, por defecto esta sano
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

		this.zoo.agregarAnimalAlZoo(mono);
	}

	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarPersonasAlMismo()
			throws NoSePuedenAgregarMenoresDeEdadException, NoFueEncontradaPersonaInexistenteException,
			NoTieneEntradaException {

		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		Boolean seAgrego = this.zoo.agregarPersonaAlZoo(personal);

		assertTrue(seAgrego);
		assertEquals(personal, this.zoo.getPersonas().get(0));

	}

	@Test(expected = NoFueEncontradaPersonaInexistenteException.class)
	public void dadoQueExisteUnZoologicoQueNoSePuedanAgregarPersonasAlMismoSiEstaNoExiste()
			throws NoFueEncontradaPersonaInexistenteException, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException {

		Persona persona = null;

		this.zoo.agregarPersonaAlZoo(persona);
	}

	@Test(expected = NoSePuedenAgregarMenoresDeEdadException.class)
	public void dadoQueExisteUnZoologicoNoSePuedenAgregarPersonasSiEstasSonMenores()
			throws NoSePuedenAgregarMenoresDeEdadException, NoFueEncontradaPersonaInexistenteException,
			NoTieneEntradaException {

		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 15;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		this.zoo.agregarPersonaAlZoo(personal);

	}

	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarEstructurasAlMismo()
			throws NoFueEncontradaEstructuraInexistenteExcepcion {

		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura, true);

		Boolean seAgrego = this.zoo.agregarEstructuraAlZoo(hospital);

		assertTrue(seAgrego);
		assertEquals(hospital, this.zoo.getEstructuras().get(0));

	}

	@Test(expected = NoFueEncontradaEstructuraInexistenteExcepcion.class)
	public void dadoQueExisteUnZoologicoQueNoSePuedanAgregarEstructurasAlMismoSiEstaNoExiste()
			throws NoFueEncontradaEstructuraInexistenteExcepcion {

		Estructura hospital = null;

		this.zoo.agregarEstructuraAlZoo(hospital);

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesQueSePuedaObtenerUnAnimalPorId()
			throws AnimalNoEncontradoException, NoSePudoAgregarAnimalInexistenteException {
		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
		TipoSexo sexo = TipoSexo.FEMENINO;
		CategoriaAnimal clase = CategoriaAnimal.MAMIFERO;

		Animal mono = new Mono(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		Animal monoDos = new Mono(530, "Cuco", 5, 9.5, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(monoDos);

		Animal animalObtenido = this.zoo.buscarAnimalPorId(codigoDeReconocimiento);

		assertEquals(mono, animalObtenido);
	}

	@Test(expected = AnimalNoEncontradoException.class)
	public void dadoQueExisteUnZoologicoConAnimalesQueAlBuscarUnAnimalPorIdInexistenteArrojeUnaException()
			throws AnimalNoEncontradoException, NoSePudoAgregarAnimalInexistenteException {
		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
		TipoSexo sexo = TipoSexo.FEMENINO;
		CategoriaAnimal clase = CategoriaAnimal.MAMIFERO;

		Animal mono = new Mono(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		Animal monoDos = new Mono(530, "Cuco", 5, 9.5, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(monoDos);

		this.zoo.buscarAnimalPorId(1);
	}

	@Test
	public void dadoQueExisteUnZoologicoConPersonalQueSePuedaObtenerLaPersonaPorId()
			throws NoFueEncontradaPersonaInexistenteException, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException, PersonaNoEncontradaException {
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;
		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personalDos = new Veterinario(24, "Martin Perez", 20);
		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarPersonaAlZoo(personalDos);

		Persona personalObtenido = this.zoo.buscarPersonaPorId(24);

		assertEquals(personalDos, personalObtenido);
	}

	@Test(expected = PersonaNoEncontradaException.class)
	public void dadoQueExisteUnZoologicoConPersonalQueAlBuscarUnaPersonaPorIdInexistenteSeaNull()
			throws NoFueEncontradaPersonaInexistenteException, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException, PersonaNoEncontradaException {
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;
		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personalDos = new Veterinario(24, "Martin Perez", 20);
		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarPersonaAlZoo(personalDos);

		this.zoo.buscarPersonaPorId(10);
	}

	@Test
	public void dadoQueExisteUnZoologicoConEstructurasQueSePuedaObtenerLaEstructuraPorId()
			throws EstructuraNoEncontradaException, NoFueEncontradaEstructuraInexistenteExcepcion {
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura, true);
		Estructura hospitalDos = new HospitalVeterinario(2500, "Hospitalinho", true);

		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarEstructuraAlZoo(hospitalDos);

		Estructura estructuraObtenida = this.zoo.buscarEstructuraPorId(2500);

		assertEquals(hospitalDos, estructuraObtenida);
	}

	@Test(expected = EstructuraNoEncontradaException.class)
	public void dadoQueExisteUnZoologicoConEstructurasQueAlBuscarUnaEstructuraPorIdInexistenteSeaNull()
			throws NoFueEncontradaEstructuraInexistenteExcepcion, EstructuraNoEncontradaException {
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura, true);
		Estructura hospitalDos = new HospitalVeterinario(2500, "Hospitalinho", true);

		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarEstructuraAlZoo(hospitalDos);

		this.zoo.buscarEstructuraPorId(2000);
	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesQueNoSePuedaAgregarDosAnimalesConMismoCodigo()
			throws NoSePudoAgregarAnimalInexistenteException {
		Integer codigoDeReconocimiento = 230;
		String nombreAnimal = "Sergio Ramirez";
		Integer edad = 3;
		Double peso = 5.5;
		TipoAlimentacion alimentacion = TipoAlimentacion.OMNIVORO;
		TipoSexo sexo = TipoSexo.FEMENINO;
		CategoriaAnimal clase = CategoriaAnimal.MAMIFERO;

		Animal mono = new Mono(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		Animal monoDos = new Mono(codigoDeReconocimiento, "Cuca", 5, 9.5, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(monoDos);

		List<Animal> animales = this.zoo.getAnimales();
		assertEquals(1, animales.size());
	}

	@Test
	public void dadoQueExisteUnZoologicoConPersonalQueNoSePuedaAgregarDosPersonasConMismoCodigo()
			throws NoFueEncontradaPersonaInexistenteException, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException {
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personalDos = new Veterinario(identificacion, "Pepe Gomez", 30);

		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarPersonaAlZoo(personalDos);

		List<Persona> personas = this.zoo.getPersonas();
		assertEquals(1, personas.size());
	}

	@Test
	public void dadoQueExisteUnZoologicoConEstructurasQueNoSePuedaAgregarDosEstructurasConMismoCodigo()
			throws NoFueEncontradaEstructuraInexistenteExcepcion {
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura, true);
		Estructura hospitalDos = new HospitalVeterinario(codigoEstructural, "Hospitalinho", true);

		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarEstructuraAlZoo(hospitalDos);

		List<Estructura> estructuras = this.zoo.getEstructuras();
		assertEquals(1, estructuras.size());
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
	public void dadoQueExisteUnZoologicoConAnimalesPodemosObtenerTodosLosDeUnaMismaCategoria()
			throws NoSePudoAgregarAnimalInexistenteException {

		Animal mono = new Mono(513, "mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
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

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);

		List<Animal> animalesMamiferos = this.zoo.obtenerLosAnimalesDeUnaCategoria(CategoriaAnimal.MAMIFERO);

		Integer tamañoEsperado = 4;

		assertEquals((int) tamañoEsperado, animalesMamiferos.size());
		assertEquals(mono, animalesMamiferos.get(0));
		assertEquals(mapache, animalesMamiferos.get(1));
		assertEquals(oso, animalesMamiferos.get(2));
		assertEquals(elefante, animalesMamiferos.get(3));

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesPodemosObtenerTodosLosDeUnMismoSexo()
			throws NoSePudoAgregarAnimalInexistenteException {

		Animal mono = new Mono(513, "mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
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

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);

		List<Animal> animalesHembras = this.zoo.obtenerLosAnimalesDeUnSexo(TipoSexo.FEMENINO);

		Integer tamañoEsperado = 3;

		assertEquals((int) tamañoEsperado, animalesHembras.size());
		assertEquals(mono, animalesHembras.get(0));
		assertEquals(oso, animalesHembras.get(1));
		assertEquals(serpiente, animalesHembras.get(2));

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

		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlZoo(mapache);
		this.zoo.agregarAnimalAlZoo(oso);
		this.zoo.agregarAnimalAlZoo(tiburon);
		this.zoo.agregarAnimalAlZoo(serpiente);
		this.zoo.agregarAnimalAlZoo(elefante);
		this.zoo.agregarAnimalAlZoo(panda);

		mono.setTemperaturaAnimal(38.2);
		tiburon.setTemperaturaAnimal(38.2);
		elefante.setTemperaturaAnimal(38.2);

		List<Animal> animalesEnfermos = this.zoo.obtenerALosAnimalesEnfermosPorTemperaturaBaja();

		Integer tamañoEsperado = 3;

		assertEquals((int) tamañoEsperado, animalesEnfermos.size());
		assertEquals(mono, animalesEnfermos.get(0));
		assertEquals(tiburon, animalesEnfermos.get(1));
		assertEquals(elefante, animalesEnfermos.get(2));

	}

	@Test
	public void dadoQueExisteUnZoologicoConVeterinarioQueSePuedaAgregarAUnHospital()
			throws NoFueEncontradaEstructuraInexistenteExcepcion, NoFueEncontradaPersonaInexistenteException,
			NoSePudoAgregarAlVeterinarioAlHospitalException, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura, true);

		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarEstructuraAlZoo(hospital);

		Boolean seAgrego = this.zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

		assertTrue(seAgrego);
		assertEquals(personal, ((HospitalVeterinario) hospital).getVeterinarios().get(0));

	}

	@Test(expected = NoSePudoAgregarAlVeterinarioAlHospitalException.class)
	public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarOtroPersonalQueNoSeaVeterinario()
			throws NoFueEncontradaEstructuraInexistenteExcepcion, NoFueEncontradaPersonaInexistenteException,
			NoSePudoAgregarAlVeterinarioAlHospitalException, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Mantenimiento(identificacion, nombreCompleto, edad);

		// DATOS DE ESTRUCTURA
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura, true);

		this.zoo.agregarEstructuraAlZoo(hospital);

		this.zoo.agregarPersonaAlZoo(personal);

		this.zoo.agregarUnVeterinarioAUnHospital(hospital, personal);
	}

	@Test(expected = NoSePudoAgregarAlVeterinarioAlHospitalException.class)
	public void dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarEnOtraEstructuraQueNoSeaUnHospital()
			throws NoFueEncontradaEstructuraInexistenteExcepcion, NoFueEncontradaPersonaInexistenteException,
			NoSePudoAgregarAlVeterinarioAlHospitalException, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		// DATOS DE ESTRUCTURA
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito falso";

		Estructura habitatSergio = new Habitat(codigoEstructural, nombreEstructura, 10, true);

		this.zoo.agregarEstructuraAlZoo(habitatSergio);

		this.zoo.agregarPersonaAlZoo(personal);

		this.zoo.agregarUnVeterinarioAUnHospital(habitatSergio, personal);

	}

	@Test(expected = NoFueEncontradaEstructuraInexistenteExcepcion.class)
	public void dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarAUnHospitalInexistente()
			throws NoFueEncontradaPersonaInexistenteException, NoSePudoAgregarAlVeterinarioAlHospitalException,
			NoFueEncontradaEstructuraInexistenteExcepcion, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		// DATOS DE ESTRUCTURA
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";
		// estado es algo que ya tiene dicha estructura

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura, true);

		this.zoo.agregarPersonaAlZoo(personal);

		this.zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

	}

	@Test(expected = NoFueEncontradaPersonaInexistenteException.class)
	public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarUnVeterinarioInexistente()
			throws NoFueEncontradaEstructuraInexistenteExcepcion, NoFueEncontradaPersonaInexistenteException,
			NoSePudoAgregarAlVeterinarioAlHospitalException, NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException {

		// DATOS DE PERSONAL
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personal2 = new Veterinario(21, "Mario Ruiz", 87);
		Persona personal3 = new Veterinario(33, "Olga Rosas", 21);

		// DATOS DE ESTRUCTURA
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";
		// estado es algo que ya tiene dicha estructura

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura, true);

		this.zoo.agregarEstructuraAlZoo(hospital);

		this.zoo.agregarPersonaAlZoo(personal2);
		this.zoo.agregarPersonaAlZoo(personal3);

		this.zoo.agregarUnVeterinarioAUnHospital(hospital, personal);

	}
	
	@Test
	public void dadoQueExisteUnZoologicoConVeterinariosQueEstanEnHospitalesPodemosObtenerUnVeterinarioDeUnHospital()
			throws Exception {

		Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario);

		Integer codigoHospital = 2234;
		String nombreHospital = "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital, true);
		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);

		Veterinario veterinarioObtenido = this.zoo.obtenerVeterinarioDeUnHospital(veterinario, hospital);
		assertEquals(veterinario, veterinarioObtenido);

	}

	@Test
	public void dadoQueExisteUnZoologicoConUnHospitalQueSePuedaCrearUnRegistroDeTratamientoAlCurarUnVeterinarioAUnAnimal()
			throws Exception {

		Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(oso);

		Integer codigoHabitat = 123;
		String nombreHabitat = "Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

		Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario);

		Integer codigoHospital = 2234;
		String nombreHospital = "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital, true);
		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);

		oso.setEstaEnfermo(true);

		RegistroTratamiento registro = this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario,
				oso, bosqueOsos);
		assertNotNull(registro);
		assertFalse(oso.getEstaEnfermo());
		assertEquals(veterinario, registro.getVeterinario());

	}

	@Test(expected = EstadoDelObjetoEsIncorrectoException.class)
	public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiYaEstaSano()
			throws EstadoDelObjetoEsIncorrectoException, Exception {

		Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(oso);

		Integer codigoHabitat = 123;
		String nombreHabitat = "Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

		Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario);

		Integer codigoHospital = 2234;
		String nombreHospital = "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital, true);
		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);

		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso, bosqueOsos);

	}

	@Test(expected = NoSePudoAgregarAlVeterinarioAlHospitalException.class)
	public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiLaPersonaQueAtiendeNoEsUnVeterinario()
			throws NoSePudoAgregarAlVeterinarioAlHospitalException, Exception {

		Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(oso);

		Integer codigoHabitat = 123;
		String nombreHabitat = "Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

		Persona mantenimiento = new Mantenimiento(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(mantenimiento);

		Integer codigoHospital = 2234;
		String nombreHospital = "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital, true);
		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarUnVeterinarioAUnHospital(hospital, mantenimiento);

		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, mantenimiento, oso, bosqueOsos);

	}

	@Test(expected = NoExisteObjetoDondeSeBuscaException.class)
	public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiElVeterinarioNoEstaEnElZoologico()
			throws NoExisteObjetoDondeSeBuscaException, Exception {

		Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(oso);

		Integer codigoHabitat = 123;
		String nombreHabitat = "Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

		Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);

		Integer codigoHospital = 2234;
		String nombreHospital = "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital, true);
		this.zoo.agregarEstructuraAlZoo(hospital);

		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso, bosqueOsos);

	}

	@Test(expected = NoExisteObjetoDondeSeBuscaException.class)
	public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiElVeterinarioNoEstaEnElHospital()
			throws NoExisteObjetoDondeSeBuscaException, Exception {

		Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(oso);

		Integer codigoHabitat = 123;
		String nombreHabitat = "Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

		Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario);

		Integer codigoHospital = 2234;
		String nombreHospital = "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital, true);
		this.zoo.agregarEstructuraAlZoo(hospital);

		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso, bosqueOsos);

	}

	@Test
	public void dadoQueExisteUnZoologicoConUnHospitalSePuedenObtenerTodosLosAnimalesQueTratoUnVeterinarioParticular()
			throws Exception {

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
		String nombreHabitat = "Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso1, bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso2, bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso3, bosqueOsos);

		Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario);

		Integer codigoHospital = 2234;
		String nombreHospital = "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital, true);
		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);

		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso2, bosqueOsos);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso3, bosqueOsos);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso1, bosqueOsos);

		List<Animal> animalesObtenidos = this.zoo.obtenerLosAnimalesQueAtendioUnVeterinarioEnUnHospital(veterinario,
				hospital);

		List<Animal> animalesEsperados = new ArrayList<>();
		animalesEsperados.add(oso2);
		animalesEsperados.add(oso3);
		animalesEsperados.add(oso1);

		assertNotNull(animalesObtenidos);
		assertEquals(animalesEsperados, animalesObtenidos);

	}

	@Test
	public void dadoQueExisteUnZoologicoConUnHospitalSePuedenObtenerTodosLosVeterinariosQueAtendieronAUnAnimalParticular()
			throws Exception {

		Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(oso);

		Integer codigoHabitat = 123;
		String nombreHabitat = "Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(bosqueOsos);
		this.zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

		Persona veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario1);

		Persona veterinario2 = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario2);

		Persona veterinario3 = new Veterinario(23, "Luis Alvarez", 34);
		this.zoo.agregarPersonaAlZoo(veterinario3);

		Integer codigoHospital = 2234;
		String nombreHospital = "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital, true);
		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario1);
		this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario2);
		this.zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario3);

		oso.setEstaEnfermo(true);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario2, oso, bosqueOsos);

		oso.setEstaEnfermo(true);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario1, oso, bosqueOsos);

		oso.setEstaEnfermo(true);
		this.zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario3, oso, bosqueOsos);

		List<Persona> veterinariosObtenidos = this.zoo.obtenerLosVeterinariosQueAtendieronAUnAnimalEnUnHospital(oso,
				hospital);

		List<Persona> veterinariosEsperados = new ArrayList<>();
		veterinariosEsperados.add(veterinario2);
		veterinariosEsperados.add(veterinario1);
		veterinariosEsperados.add(veterinario3);

		assertNotNull(veterinariosObtenidos);
		assertEquals(veterinariosEsperados, veterinariosObtenidos);
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
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarPersonaAlZoo(personal2);
		this.zoo.agregarPersonaAlZoo(personal3);

		Integer cantidadComida = 3;
		ComidaAnimales comida = ComidaAnimales.PLANTA;

		RegistroAlimentacion registroNuevo = this.zoo.cargarAlimentacion(personal, mono, comida, cantidadComida);

		assertNotNull(registroNuevo);
		assertEquals(mono, registroNuevo.getAnimal());

	}

	@Test(expected = NoFueEncontradaPersonaInexistenteException.class)
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElVeterinarioEsInexistente()
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarPersonaAlZoo(personal2);

		Integer cantidadComida = 3;
		ComidaAnimales comida = ComidaAnimales.PLANTA;

		this.zoo.cargarAlimentacion(personal3, mono, comida, cantidadComida);

	}

	@Test(expected = NoSePudoAgregarAnimalInexistenteException.class)
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElAnimalEsInexistente()
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarPersonaAlZoo(personal2);
		this.zoo.agregarPersonaAlZoo(personal3);

		Integer cantidadComida = 3;
		ComidaAnimales comida = ComidaAnimales.PLANTA;

		this.zoo.cargarAlimentacion(personal3, mono, comida, cantidadComida);
	}

	@Test(expected = NoSePudoAgregarPersonalInvalidoExcepcion.class)
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearElRegistroSiUnPersonalNoAutorizadoQuiereAlimentarAlAnimal()
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Mantenimiento(23, "Luis Alvarez", 34);

		this.zoo.agregarPersonaAlZoo(personal);

		Integer cantidadComida = 3;
		ComidaAnimales comida = ComidaAnimales.PLANTA;

		this.zoo.cargarAlimentacion(personal, panda, comida, cantidadComida);

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesConocerALosQueSeEnfermaronPorHaberSidoAlimentadosConComidaNoApta()
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(personal);

		this.zoo.cargarAlimentacion(personal, panda, ComidaAnimales.CARNE, 3);
		this.zoo.cargarAlimentacion(personal, mapache, ComidaAnimales.PLANTA, 1);
		this.zoo.cargarAlimentacion(personal, elefante, ComidaAnimales.CARNE, 5);
		this.zoo.cargarAlimentacion(personal, mono, ComidaAnimales.PLANTA, 2);

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
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(personal);

		this.zoo.cargarAlimentacion(personal, panda, ComidaAnimales.PLANTA, 3);
		this.zoo.cargarAlimentacion(personal, mapache, ComidaAnimales.CARNE, 1);
		this.zoo.cargarAlimentacion(personal, elefante, ComidaAnimales.PLANTA, 5);
		this.zoo.cargarAlimentacion(personal, mono, ComidaAnimales.PLANTA, 2);

		List<Animal> animalesAlimentadosPorUnVeterinario = this.zoo
				.conocerLosAnimalesAlimentadosPorUnVeterinario(personal);

		assertEquals(4, animalesAlimentadosPorUnVeterinario.size());
		assertEquals(panda, animalesAlimentadosPorUnVeterinario.get(0));
		assertEquals(mapache, animalesAlimentadosPorUnVeterinario.get(1));
		assertEquals(elefante, animalesAlimentadosPorUnVeterinario.get(2));
		assertEquals(mono, animalesAlimentadosPorUnVeterinario.get(3));
	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico()
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);
		Persona personal1 = new Veterinario(55, "Lorenzo Grande", 64);
		Persona personal2 = new Veterinario(3, "Guido Perez", 24);
		Persona personal3 = new Veterinario(99, "Leonardo Alvarez", 44);

		this.zoo.agregarPersonaAlZoo(personal);
		this.zoo.agregarPersonaAlZoo(personal1);
		this.zoo.agregarPersonaAlZoo(personal2);
		this.zoo.agregarPersonaAlZoo(personal3);

		this.zoo.cargarAlimentacion(personal, panda, ComidaAnimales.PLANTA, 3);
		this.zoo.cargarAlimentacion(personal1, panda, ComidaAnimales.PLANTA, 1);
		this.zoo.cargarAlimentacion(personal2, panda, ComidaAnimales.PLANTA, 5);
		this.zoo.cargarAlimentacion(personal3, panda, ComidaAnimales.PLANTA, 2);

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
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

		Animal panda = new Panda(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(panda);

		Persona personal = new Veterinario(23, "Luis Alvarez", 34);

		this.zoo.agregarPersonaAlZoo(personal);

		this.zoo.cargarAlimentacion(personal, panda, ComidaAnimales.PLANTA, 0);
	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConPlantas()
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(veterinario1);
		this.zoo.agregarPersonaAlZoo(veterinario2);
		this.zoo.agregarPersonaAlZoo(veterinario3);

		this.zoo.cargarAlimentacion(veterinario1, panda, ComidaAnimales.PLANTA, 4);
		this.zoo.cargarAlimentacion(veterinario1, elefante, ComidaAnimales.PLANTA, 2);
		this.zoo.cargarAlimentacion(veterinario2, panda, ComidaAnimales.PLANTA, 1);
		this.zoo.cargarAlimentacion(veterinario3, mono, ComidaAnimales.PLANTA, 5);
		this.zoo.cargarAlimentacion(veterinario3, serpiente, ComidaAnimales.CARNE, 4);
		this.zoo.cargarAlimentacion(veterinario2, oso, ComidaAnimales.PLANTA, 1);

		List<Animal> animalesQueComenPlantas = this.zoo.conocerALosAnimalesQueConsumieronComidaDeTipoPlanta();

		Integer tamañoEsperado = 5;
		Integer tamañoObtenido = animalesQueComenPlantas.size();

		assertEquals(tamañoEsperado, tamañoObtenido);

	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConCarne()
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(veterinario1);
		this.zoo.agregarPersonaAlZoo(veterinario2);
		this.zoo.agregarPersonaAlZoo(veterinario3);

		this.zoo.cargarAlimentacion(veterinario1, panda, ComidaAnimales.PLANTA, 4);
		this.zoo.cargarAlimentacion(veterinario1, elefante, ComidaAnimales.PLANTA, 2);
		this.zoo.cargarAlimentacion(veterinario2, panda, ComidaAnimales.PLANTA, 1);
		this.zoo.cargarAlimentacion(veterinario3, mono, ComidaAnimales.PLANTA, 5);
		this.zoo.cargarAlimentacion(veterinario3, serpiente, ComidaAnimales.CARNE, 4);
		this.zoo.cargarAlimentacion(veterinario2, oso, ComidaAnimales.PLANTA, 1);

		List<Animal> animalesQueComenCarne = this.zoo.conocerALosAnimalesQueConsumieronComidaDeTipoCarne();

		Integer tamañoEsperado = 1;
		Integer tamañoObtenido = animalesQueComenCarne.size();

		assertEquals(tamañoEsperado, tamañoObtenido);
	}

	@Test
	public void dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosRegistrosQueContenganUnAnimalEspecifico()
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(veterinario1);
		this.zoo.agregarPersonaAlZoo(veterinario2);
		this.zoo.agregarPersonaAlZoo(veterinario3);

		RegistroAlimentacion registro1 = this.zoo.cargarAlimentacion(veterinario1, panda, ComidaAnimales.PLANTA, 3);
		RegistroAlimentacion registro2 = this.zoo.cargarAlimentacion(veterinario1, panda, ComidaAnimales.PLANTA, 1);
		RegistroAlimentacion registro3 = this.zoo.cargarAlimentacion(veterinario2, panda, ComidaAnimales.PLANTA, 5);
		RegistroAlimentacion registro4 = this.zoo.cargarAlimentacion(veterinario3, panda, ComidaAnimales.PLANTA, 2);
		this.zoo.cargarAlimentacion(veterinario3, elefante, ComidaAnimales.PLANTA, 2);

		List<RegistroAlimentacion> registrosQueContengan = this.zoo
				.conocerLosRegistrosQueContenganUnAnimalEspecifico(panda);

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
			throws NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaPersonaInexistenteException,
			NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion, NoSePudoAlimentarException,
			NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

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

		this.zoo.agregarPersonaAlZoo(veterinario1);
		this.zoo.agregarPersonaAlZoo(veterinario2);
		this.zoo.agregarPersonaAlZoo(veterinario3);

		this.zoo.cargarAlimentacion(veterinario1, panda, ComidaAnimales.PLANTA, 3);
		this.zoo.cargarAlimentacion(veterinario1, panda, ComidaAnimales.PLANTA, 1);
		this.zoo.cargarAlimentacion(veterinario2, panda, ComidaAnimales.PLANTA, 5);
		this.zoo.cargarAlimentacion(veterinario3, panda, ComidaAnimales.PLANTA, 2);
		this.zoo.cargarAlimentacion(veterinario3, elefante, ComidaAnimales.PLANTA, 2);

		Double pesoObtenidoAnimalAlAlimentarse = this.zoo.getRegistrosDeAlimentacion().get(4).getAnimal().getPeso();
		Double pesoEsperado = 40.0;

		assertEquals(pesoEsperado, pesoObtenidoAnimalAlAlimentarse);

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEstosSePuedenIngresarAHabitats() throws Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);

		Boolean seAgrego = this.zoo.agregarAnimalAlHabitat(mono, habitatMonos);
		Animal animalAgregado = this.zoo.obtenerAnimalDeUnHabitat(mono, habitatMonos);

		assertTrue(seAgrego);
		assertEquals(mono, animalAgregado);

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsPodemosObtenerUnAnimalDeUnHabitatParticular()
			throws Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono1);

		this.zoo.agregarAnimalAlHabitat(mono1, habitatMonos);
		Animal primerAnimalObtenido = this.zoo.obtenerAnimalDeUnHabitat(mono1, habitatMonos);

		assertEquals(mono1, primerAnimalObtenido);

	}

	@Test(expected = NoExisteObjetoDondeSeBuscaException.class)
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsNoPodemosAgregarAnimalesSiElHabitatNoEstaEnElZoologico()
			throws NoExisteObjetoDondeSeBuscaException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono1);

		this.zoo.agregarAnimalAlHabitat(mono1, habitatMonos);

	}

	@Test(expected = NoExisteObjetoDondeSeBuscaException.class)
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsNoPodemosAgregarAnimalesSiNoEstanEnElZoologico()
			throws NoExisteObjetoDondeSeBuscaException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlHabitat(mono1, habitatMonos);

	}

	@Test(expected = EspecieDiferenteException.class)
	public void dadoQueExisteUnZoologicoConHabitatsEstosNoDebenAlbergarDistintasEspecies()
			throws EspecieDiferenteException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);

		Animal oso = new Oso(216, "Oso Maloso", 8, 120.6, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(oso);

		this.zoo.agregarAnimalAlHabitat(mono, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(oso, habitatMonos);
	}

	@Test(expected = HabitatLlenoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsNoSePuedenIngresarMasAnimalesSiEsteEstaLleno()
			throws HabitatLlenoException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
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

		this.zoo.agregarAnimalAlHabitat(mono1, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(mono2, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(mono3, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(mono4, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(mono5, habitatMonos);

	}

	@Test
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesePuedenReproducir() throws Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mona);
		this.zoo.agregarAnimalAlHabitat(mona, habitatMonos);

		Animal mono = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat(mono, habitatMonos);

		Integer idCria = 515;
		String nombreCria = "monito bebé";
		Boolean seReproducieron = this.zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria,
				nombreCria);
		Animal cria = this.zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos);
		String nombreObtenido = cria.getNombreAnimal();

		assertTrue(seReproducieron);
		assertNotNull(cria);
		assertEquals(nombreCria, nombreObtenido);

	}

	@Test(expected = ProgenitoresDelMismoSexoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiSonDelMismoSexo()
			throws ProgenitoresDelMismoSexoException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mona);
		this.zoo.agregarAnimalAlHabitat(mona, habitatMonos);

		Animal mono = new Mono(514, "Mona Rosa", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat(mono, habitatMonos);

		Integer idCria = 515;
		String nombreCria = "monito bebé";
		this.zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);
		this.zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos);

	}

	@Test(expected = HabitatLlenoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiElHabitatYaEstaLleno()
			throws HabitatLlenoException, Exception {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 2;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mona);
		this.zoo.agregarAnimalAlHabitat(mona, habitatMonos);

		Animal mono = new Mono(514, "Mona Rosa", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat(mono, habitatMonos);

		Integer idCria = 515;
		String nombreCria = "monito bebé";
		this.zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);

	}

	@Test(expected = ProgenitoresEnDistintoHabitatException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiEstanEnDistintoHabitat()
			throws ProgenitoresEnDistintoHabitatException, Exception {

		Integer codigoEstructural1 = 123;
		String nombreEstructura1 = "Isla de los monos";
		Integer maximoAnimales1 = 4;
		Estructura habitatMonos1 = new Habitat(codigoEstructural1, nombreEstructura1, maximoAnimales1, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos1);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mona);
		this.zoo.agregarAnimalAlHabitat(mona, habitatMonos1);

		Integer codigoEstructural2 = 321;
		String nombreEstructura2 = "Otra isla de los monos";
		Integer maximoAnimales2 = 4;
		Estructura habitatMonos2 = new Habitat(codigoEstructural2, nombreEstructura2, maximoAnimales2, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos2);

		Animal mono = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat(mono, habitatMonos2);

		Integer idCria = 515;
		String nombreCria = "monito bebé";
		this.zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos1, idCria, nombreCria);

	}

	

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEnUnHabitatQueSePuedanObtenerLosAnimalesDeUnHabitatOrdenadosPorEdadDecreciente()
			throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException,
			InstanciaIncorrectaException, NoSePudoAgregarAnimalInexistenteException,
			NoFueEncontradaEstructuraInexistenteExcepcion, HabitatVacioException {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono2 = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono3 = new Mono(515, "Mono Juan", 2, 6.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(mono1);
		this.zoo.agregarAnimalAlZoo(mono2);
		this.zoo.agregarAnimalAlZoo(mono3);
		this.zoo.agregarAnimalAlHabitat(mono1, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(mono2, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(mono3, habitatMonos);

		TreeSet<Animal> animalesOrdenados = this.zoo
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
	public void dadoQueExisteUnZoologicoConAnimalesEnUnHabitatQueSePuedanObtenerLosAnimalesDeUnHabitatOrdenadosPorEdadAscendente()
			throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException,
			InstanciaIncorrectaException, NoSePudoAgregarAnimalInexistenteException,
			NoFueEncontradaEstructuraInexistenteExcepcion, HabitatVacioException {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono2 = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		Animal mono3 = new Mono(515, "Mono Juan", 2, 6.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);

		this.zoo.agregarAnimalAlZoo(mono1);
		this.zoo.agregarAnimalAlZoo(mono2);
		this.zoo.agregarAnimalAlZoo(mono3);
		this.zoo.agregarAnimalAlHabitat(mono1, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(mono2, habitatMonos);
		this.zoo.agregarAnimalAlHabitat(mono3, habitatMonos);

		TreeSet<Animal> animalesOrdenados = this.zoo
				.obtenerAnimalesDeUnHabitatOrdenadosOrdenEspecifico(new OrdenAscendente(), habitatMonos);

		assertEquals(3, animalesOrdenados.size());

		// ORDEN:
		// MONO3 2 años (first)
		// MONO1 4 años
		// MONO2 6 años (last)
		assertEquals(2, (int) animalesOrdenados.first().getEdad());
		assertEquals(6, (int) animalesOrdenados.last().getEdad());
	}

	// TESTS MANTENIMIENTO Y ESTRUCTURA

	@Test
	public void dadoQueExisteUnZoologicoQueUnPersonalDeMantenimientoPuedaArreglarUnaEstructuraSiSuEstadoEstaRoto()
			throws estructuraNoEstaDañadaExcepsion, NoSePuedenAgregarMenoresDeEdadException,
			NoFueEncontradaPersonaInexistenteException, NoFueEncontradaEstructuraInexistenteExcepcion,
			NoTieneEntradaException {

		Integer identificacion = 1;
		String nombreCompleto = "Julio Perez";
		Integer edad = 38;
		Persona personalMantenimiento = new Mantenimiento(identificacion, nombreCompleto, edad);
		this.zoo.agregarPersonaAlZoo(personalMantenimiento);

		Integer codigoEstructural = 1;
		String nombreEstructura = "Estrcturita";
		Boolean estaRoto = true;
		Estructura estructura = new Estructura(codigoEstructural, nombreEstructura, estaRoto);
		this.zoo.agregarEstructuraAlZoo(estructura);

		MantenimientoEstructura mantenimientoEstructura = new MantenimientoEstructura(personalMantenimiento,
				estructura);

		this.zoo.agregarMantenimientoEstructura(mantenimientoEstructura);

		Boolean puedeArreglarEstructura = this.zoo.puedeArreglarEstructura(estructura, personalMantenimiento);

		assertTrue(puedeArreglarEstructura);

	}

	@Test(expected = estructuraNoEstaDañadaExcepsion.class)
	public void dadoQueExisteUnZoologicoQueUnPersonalDeMantenimientoNoPuedaArreglarUnaEstructuraSiSuEstadoEstaBien()
			throws estructuraNoEstaDañadaExcepsion, NoSePuedenAgregarMenoresDeEdadException,
			NoFueEncontradaPersonaInexistenteException, NoFueEncontradaEstructuraInexistenteExcepcion,
			NoTieneEntradaException {

		Integer identificacion = 1;
		String nombreCompleto = "Julio Perez";
		Integer edad = 38;
		Persona personalMantenimiento = new Mantenimiento(identificacion, nombreCompleto, edad);
		this.zoo.agregarPersonaAlZoo(personalMantenimiento);

		Integer codigoEstructural = 1;
		String nombreEstructura = "Estrcturita";
		Boolean estaRoto = false;
		Estructura estructura = new Estructura(codigoEstructural, nombreEstructura, estaRoto);
		this.zoo.agregarEstructuraAlZoo(estructura);

		MantenimientoEstructura mantenimientoEstructura = new MantenimientoEstructura(personalMantenimiento,
				estructura);

		this.zoo.agregarMantenimientoEstructura(mantenimientoEstructura);

		Boolean noPuedeArreglarEstructura = this.zoo.puedeArreglarEstructura(estructura, personalMantenimiento);

		assertTrue(noPuedeArreglarEstructura);
	}

	@Test(expected = estructuraNoEstaDañadaExcepsion.class)
	public void dadoQueExisteUnZoologicoQueUnPersonalQueNoSeaDeMantenimientoNoPuedaArreglarUnaEstructuraSiSuEstadoEstaRoto()
			throws estructuraNoEstaDañadaExcepsion, NoSePuedenAgregarMenoresDeEdadException,
			NoFueEncontradaPersonaInexistenteException, NoFueEncontradaEstructuraInexistenteExcepcion,
			NoTieneEntradaException {

		Integer identificacion = 1;
		String nombreCompleto = "Julio Perez";
		Integer edad = 38;
		Persona personalVeterinario = new Veterinario(identificacion, nombreCompleto, edad);
		this.zoo.agregarPersonaAlZoo(personalVeterinario);

		Integer codigoEstructural = 1;
		String nombreEstructura = "Estrcturita";
		Boolean estaRoto = true;
		Estructura estructura = new Estructura(codigoEstructural, nombreEstructura, estaRoto);
		this.zoo.agregarEstructuraAlZoo(estructura);

		MantenimientoEstructura mantenimientoEstructura = new MantenimientoEstructura(personalVeterinario, estructura);

		this.zoo.agregarMantenimientoEstructura(mantenimientoEstructura);

		this.zoo.puedeArreglarEstructura(estructura, personalVeterinario);

	}

	@Test
	public void dadoQueExisteUnZoologicoSiEstaSucioQueSePuedaLimpiarPorUnPersonalDeMantenimiento()
			throws zoologicoEstaLimpioExcepsion, NoSePuedenAgregarMenoresDeEdadException,
			NoFueEncontradaPersonaInexistenteException, NoTieneEntradaException {

		Integer identificacionPersonal = 1;
		String nombrePersonal = "Eduardo Cazca";
		Integer edadPersonal = 32;
		Persona personalMantenimiento = new Mantenimiento(identificacionPersonal, nombrePersonal, edadPersonal);

		this.zoo.agregarPersonaAlZoo(personalMantenimiento);
		Boolean zoologicoEstaLimpio = false;
		this.zoo.setEstaLimpio(zoologicoEstaLimpio);
		Boolean sePuedeLimpiar = this.zoo.queUnEmpleadoDeMantenimientoLimpieElZoologico(personalMantenimiento);

		assertTrue(sePuedeLimpiar);
	}

	@Test(expected = zoologicoEstaLimpioExcepsion.class)
	public void dadoQueExisteUnZoologicoSiEstaLimpioQueNoSePuedaLimpiarPorUnPersonalDeMantenimiento()
			throws zoologicoEstaLimpioExcepsion, NoSePuedenAgregarMenoresDeEdadException,
			NoFueEncontradaPersonaInexistenteException, NoTieneEntradaException {

		Integer identificacionPersonal = 1;
		String nombrePersonal = "Eduardo Cazca";
		Integer edadPersonal = 32;
		Persona personalMantenimiento = new Mantenimiento(identificacionPersonal, nombrePersonal, edadPersonal);

		this.zoo.agregarPersonaAlZoo(personalMantenimiento);
		Boolean zoologicoEstaLimpio = true;
		this.zoo.setEstaLimpio(zoologicoEstaLimpio);
		this.zoo.queUnEmpleadoDeMantenimientoLimpieElZoologico(personalMantenimiento);

	}

	@Test(expected = zoologicoEstaLimpioExcepsion.class)
	public void dadoQueExisteUnZoologicoSiEstaSucioQueNoSePuedaLimpiarPorUnPersonalQueNoSeaDeMantenimiento()
			throws zoologicoEstaLimpioExcepsion, NoSePuedenAgregarMenoresDeEdadException,
			NoFueEncontradaPersonaInexistenteException, NoTieneEntradaException {

		Integer identificacionPersonal = 1;
		String nombrePersonal = "Eduardo Cazca";
		Integer edadPersonal = 32;
		Persona personal = new Veterinario(identificacionPersonal, nombrePersonal, edadPersonal);

		this.zoo.agregarPersonaAlZoo(personal);
		Boolean zoologicoEstaLimpio = false;
		this.zoo.setEstaLimpio(zoologicoEstaLimpio);
		this.zoo.queUnEmpleadoDeMantenimientoLimpieElZoologico(personal);

	}

	// TESTS ACCIONES ANIMALES

	@Test
	public void dadoQueExisteUnZoologicoQueUnAnimalPuedaEmitirUnSonido()
			throws NoFueEncontradaEstructuraInexistenteExcepcion, EspecieDiferenteException, HabitatLlenoException,
			NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException, HabitatVacioException,
			NoSePudoAgregarAnimalInexistenteException {

		Integer codigoAnimal = 514;
		String nombreAnimal = "Mono Mario";
		Integer edadAnimal = 6;
		Double pesoAnimal = 8.9;
		TipoAlimentacion alimentacionAnimal = TipoAlimentacion.OMNIVORO;
		TipoSexo sexoAnimal = TipoSexo.MASCULINO;
		CategoriaAnimal categoriaAnimal = CategoriaAnimal.MAMIFERO;
		Animal mono = new Mono(codigoAnimal, nombreAnimal, edadAnimal, pesoAnimal, alimentacionAnimal, sexoAnimal,
				categoriaAnimal);
		this.zoo.agregarAnimalAlZoo(mono);

		Integer codigoEstructural = 1;
		String nombreEstructura = "Estructurita";
		Boolean estaRoto = false;
		Estructura habitatMono = new Habitat(codigoEstructural, nombreEstructura, 5, estaRoto);
		this.zoo.agregarEstructuraAlZoo(habitatMono);

		this.zoo.agregarAnimalAlHabitat(mono, habitatMono);

		String sonidoEsperado = "uh uh ah ah";
		String sonidoObtenido = mono.emitirSonido();

		assertEquals(sonidoEsperado, sonidoObtenido);
	}

	@Test
	public void dadoQueExisteUnZoologicoQueUnAnimalSePuedaMover() throws NoFueEncontradaEstructuraInexistenteExcepcion,
			EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException,
			InstanciaIncorrectaException, HabitatVacioException, NoSePudoAgregarAnimalInexistenteException {

		Integer codigoAnimal = 514;
		String nombreAnimal = "Leoncito";
		Integer edadAnimal = 6;
		Double pesoAnimal = 16.3;
		TipoAlimentacion alimentacionAnimal = TipoAlimentacion.CARNIVORO;
		TipoSexo sexoAnimal = TipoSexo.MASCULINO;
		CategoriaAnimal categoriaAnimal = CategoriaAnimal.MAMIFERO;
		Animal leon = new Leon(codigoAnimal, nombreAnimal, edadAnimal, pesoAnimal, alimentacionAnimal, sexoAnimal,
				categoriaAnimal);
		this.zoo.agregarAnimalAlZoo(leon);

		Integer codigoEstructural = 1;
		String nombreEstructura = "Estructurita";
		Boolean estaRoto = false;
		Estructura habitatLeon = new Habitat(codigoEstructural, nombreEstructura, 5, estaRoto);
		this.zoo.agregarEstructuraAlZoo(habitatLeon);

		this.zoo.agregarAnimalAlHabitat(leon, habitatLeon);

		String sonidoEsperado = "corriendo velozmente";
		String sonidoObtenido = leon.movimiento();

		assertEquals(sonidoEsperado, sonidoObtenido);
	}

	// TESTS LOCAL DE COMIDA
	
	
	
	@Test
	public void dadoQueExisteUnZoologicoQueSePuedaAgregarUnaHamburgueseria()
			throws NoFueEncontradaEstructuraInexistenteExcepcion {
		// Crea Zoologico
		// Crea hamburgueseria y la agrega al zoologico
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);

		Boolean sePudoAgregar = this.zoo.agregarEstructuraAlZoo(hamburgueseria);

		assertTrue(sePudoAgregar);
	}
	
	@Test
	public void dadoQueExisteUnZoologicoConLocalDeComidasQueSePuedaAgregarStockDeComidas()
			throws NoSePuedenAgregarMenoresDeEdadException, NoFueEncontradaPersonaInexistenteException,
			NoFueEncontradaEstructuraInexistenteExcepcion, NoTieneEntradaException, NoSePudoAgregarStockAlLocalException {

		// Crea hamburgueseria y la agrega al zoologico
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		this.zoo.agregarEstructuraAlZoo(hamburgueseria);

		// Agrega stock a la hamburgueseria
		ComidaHumanos comida = ComidaHumanos.HAMBURGUESA;
		Integer cantidad = 4;
		
		this.zoo.agregarStockAlLocalDeComida(hamburgueseria, comida, cantidad);
		
		Integer cantidadObtenida = hamburgueseria.getComidas().size();
		
		assertEquals(cantidad, cantidadObtenida);
	}
	

	@Test
	public void dadoQueExisteUnZoologicoSiUnVisitanteDeseaComerAlgoYTieneLaPlataSuficientePuedeComprarComidaEnLaSeccionDeComida()
			throws NoSePuedenAgregarMenoresDeEdadException, NoFueEncontradaPersonaInexistenteException,
			NoFueEncontradaEstructuraInexistenteExcepcion, NoTieneEntradaException, SaldoInsuficienteParaComprarComidaException, NoSePudoAgregarStockAlLocalException {

		String nombre = "Juan";
		Integer edad = 20;
		Integer identificacion = 2;
		Double dineroDisponible = 3000.0;
		Persona visitante = new Visitante(identificacion, nombre, edad, dineroDisponible);
		this.zoo.agregarPersonaAlZoo(visitante);

		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		Estructura hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		this.zoo.agregarEstructuraAlZoo(hamburgueseria);
		ComidaHumanos comida = ComidaHumanos.HAMBURGUESA;
		Integer cantidad = 5;
		
		this.zoo.agregarStockAlLocalDeComida((LocalDeComida) hamburgueseria, comida, cantidad);
		
		Boolean pudoComprar = this.zoo.comprarComidaEnLaTiendaConDineroYStockSuficiente(hamburgueseria, visitante, comida, 3);
		
		assertTrue(pudoComprar);
	}


	@Test
	public void dadoQueExisteUnZoologicoConLocalDeComidasComprobarSiTieneStockDeUnTipoDeComida()
			throws NoFueEncontradaEstructuraInexistenteExcepcion, NoSePudoAgregarStockAlLocalException {
		// Crea Zoologico

		// Crea hamburgueseria y la agrega al zoologico
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		this.zoo.agregarEstructuraAlZoo(hamburgueseria);

		// Agrega stock a la hamburgueseria
		ComidaHumanos pizza = ComidaHumanos.PIZZA;
		Integer cantidadPizza = 4;
		ComidaHumanos gaseosa = ComidaHumanos.GASEOSA;
		Integer cantidadGaseosa = 6;
		ComidaHumanos pizza2 = ComidaHumanos.PIZZA;
		Integer cantidadPizza2 = 3;

		this.zoo.agregarStockAlLocalDeComida(hamburgueseria, pizza, cantidadPizza);
		this.zoo.agregarStockAlLocalDeComida(hamburgueseria, gaseosa, cantidadGaseosa);
		this.zoo.agregarStockAlLocalDeComida(hamburgueseria, pizza2, cantidadPizza2);
		
		// Comprobar stock por tipo de comida
		Integer stockPizzaEsperado = 7;

		Integer stockPizzaObtenido = this.zoo.comprarStockPorTipoDeComida(hamburgueseria, ComidaHumanos.PIZZA);
		
		
		assertEquals(stockPizzaEsperado, stockPizzaObtenido);
	}

	@Test
	public void dadoQueExisteUnZoologicoConLocalDeComidasQueUnVisitantePuedaComprarSiTieneSuficienteDineroYSiElLocalTieneStockSuficienteDeLaComida()
			throws NoSePuedenAgregarMenoresDeEdadException, NoFueEncontradaPersonaInexistenteException,
			NoFueEncontradaEstructuraInexistenteExcepcion, NoTieneEntradaException,
			NoSePudoAgregarStockAlLocalException,
			SaldoInsuficienteParaComprarComidaException, StockInsuficienteDeComidaException {

		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		zoo.agregarEstructuraAlZoo(hamburgueseria);

		ComidaHumanos comida = ComidaHumanos.HAMBURGUESA;
		Integer cantidad = 4;
		
		this.zoo.agregarStockAlLocalDeComida(hamburgueseria, comida, cantidad);

		String nombre = "Juan";
		Integer edad = 21;
		Integer identificacion = 2;
		Double dineroDisponible = 3000.0;
		Persona visitante = new Visitante(identificacion, nombre, edad, dineroDisponible);
		zoo.agregarPersonaAlZoo(visitante);

		ComidaHumanos comidaAConsumir = ComidaHumanos.HAMBURGUESA;
		Integer cantidadAComprar = 2;
		
		Boolean puedeComprar = this.zoo.comprarComidaEnLaTiendaConDineroYStockSuficiente(hamburgueseria, visitante, comidaAConsumir, cantidadAComprar);

		assertTrue(puedeComprar);
	}

	@Test
	public void dadoQueExisteUnZoologicoConLocalDeComidasSaberLaRecaudacionTotal()
			throws NoSePuedenAgregarMenoresDeEdadException, NoFueEncontradaPersonaInexistenteException,
			NoFueEncontradaEstructuraInexistenteExcepcion, NoTieneEntradaException, NoSePudoAgregarStockAlLocalException {

		// Crea hamburgueseria y la agrega al zoologico
		Integer codigoEstructural = 1;
		Boolean estaRoto = false;
		String nombreLocal = "ZooFood";
		LocalDeComida hamburgueseria = new LocalDeComida(codigoEstructural, nombreLocal, estaRoto);
		this.zoo.agregarEstructuraAlZoo(hamburgueseria);

		// Agrega stock a la hamburgueseria
		ComidaHumanos hamburguesa = ComidaHumanos.HAMBURGUESA;
		Integer cantidadHamburguesas = 4;
		ComidaHumanos papas = ComidaHumanos.PAPAS_FRITAS;
		Integer cantidadPapas = 8;
		ComidaHumanos agua = ComidaHumanos.AGUA;
		Integer cantidadAgua = 10;
		
		this.zoo.agregarStockAlLocalDeComida(hamburgueseria, hamburguesa, cantidadHamburguesas);
		this.zoo.agregarStockAlLocalDeComida(hamburgueseria, papas, cantidadPapas);
		this.zoo.agregarStockAlLocalDeComida(hamburgueseria, agua, cantidadAgua);
		

		// Agrega visistante al zoo
		Visitante visitante = new Visitante(1, "Juan", 22, 3000.0);
		Visitante visitante2 = new Visitante(2, "Perla", 28, 15000.0);
		Visitante visitante3 = new Visitante(3, "Arion", 54, 55000.0);
		this.zoo.agregarPersonaAlZoo(visitante);
		this.zoo.agregarPersonaAlZoo(visitante2);
		this.zoo.agregarPersonaAlZoo(visitante3);

		// Comida a consumir por visitante1 en la hamburgueseria
		ComidaHumanos comidaAConsumir1 = hamburguesa;
		Integer cantidadAComprar1 = 2;
		this.zoo.comprarComidaEnLaTiendaConDineroYStockSuficiente(hamburgueseria, visitante, comidaAConsumir1, cantidadAComprar1);

		// ComidaHumanos a consumir por visitante2 en la hamburgueseria
		ComidaHumanos comidaAConsumir2 = papas;
		Integer cantidadAComprar2 = 5;
		this.zoo.comprarComidaEnLaTiendaConDineroYStockSuficiente(hamburgueseria, visitante, comidaAConsumir2, cantidadAComprar2);

		// ComidaHumanos a consumir por visitante3 en la hamburgueseria
		ComidaHumanos comidaAConsumir3 = agua;
		Integer cantidadAComprar3 = 5;
		this.zoo.comprarComidaEnLaTiendaConDineroYStockSuficiente(hamburgueseria, visitante, comidaAConsumir3, cantidadAComprar3);

		Double recaudacionEsperada = 1400.0;
		Double recaudacionObtenida = hamburgueseria.getRecaudacion();

		assertEquals(recaudacionEsperada, recaudacionObtenida);

	}
	
	
	

	@Test
	public void queUnVisitantePuedaComprarEntradaTeniendoSaldoSuficiente()
			throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException,
			NoFueEncontradaPersonaInexistenteException {

		Integer identificacion = 43472194;
		String nombreCompleto = "Sergio Ramirez";
		Integer edad = 23;
		Double dineroQueDispone = 3040.0;

		Persona visitante1 = new Visitante(identificacion, nombreCompleto, edad, dineroQueDispone);

		Boolean pudoEntrar = this.zoo.agregarPersonaAlZoo(visitante1);

		assertTrue(pudoEntrar);
		assertEquals(visitante1, this.zoo.getPersonas().get(0));
	}

	@Test(expected = NoSePuedenAgregarMenoresDeEdadException.class)
	public void queUnVisitanteNoPuedaComprarEntradaPorSerMenorDeEdad() throws NoSePuedenAgregarMenoresDeEdadException,
			NoTieneEntradaException, NoFueEncontradaPersonaInexistenteException {

		Integer identificacion = 43472194;
		String nombreCompleto = "Daniel Ramirez";
		Integer edad = 12;
		Double dineroQueDispone = 3040.0;

		Persona visitante1 = new Visitante(identificacion, nombreCompleto, edad, dineroQueDispone);

		Boolean pudoEntrar = this.zoo.agregarPersonaAlZoo(visitante1);

		assertTrue(pudoEntrar);
		assertEquals(visitante1, this.zoo.getPersonas().get(0));
	}

	@Test(expected = NoTieneEntradaException.class)
	public void queUnVisitanteNoPuedaComprarEntradaTeniendoSaldoInsuficiente()
			throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException,
			NoFueEncontradaPersonaInexistenteException {
		Integer identificacion = 43472194;
		String nombreCompleto = "Sergio Ramirez";
		Integer edad = 23;
		Double dineroQueDispone = 40.0;

		Persona visitante1 = new Visitante(identificacion, nombreCompleto, edad, dineroQueDispone);

		Boolean pudoEntrar = this.zoo.agregarPersonaAlZoo(visitante1);

		assertTrue(pudoEntrar);
		assertEquals(visitante1, this.zoo.getPersonas().get(0));
	}

	@Test
	public void queUnGrupoDeVisitantePuedaComprarEntradaTeniendoSaldoSuficiente() {
		Persona visitante1 = new Visitante(43472194, "visitante1", 59, 4300.0);
		Persona visitante2 = new Visitante(43205932, "visitante2", 69, 3500.0);
		Persona visitante3 = new Visitante(43205953, "visitante3", 15, 5020.0);
		Persona visitante4 = new Visitante(43205965, "visitante4", 11, 3000.0);

		List<Persona> visitantesAIngresar = new ArrayList<>();

		visitantesAIngresar.add(visitante1);
		visitantesAIngresar.add(visitante2);
		visitantesAIngresar.add(visitante3);
		visitantesAIngresar.add(visitante4);

		Boolean seAgregaron = this.zoo.agregarVariosVisitantes(visitantesAIngresar);
		assertTrue(seAgregaron);
		assertEquals(visitantesAIngresar.size(), this.zoo.getPersonas().size());

	}

	@Test
	public void queUnGrupoDePersonasPuedaIngresarConMenoresDeEdad() {
		Persona visitante1 = new Visitante(43472194, "visitante1", 59, 4300.0);
		Persona visitante2 = new Visitante(43205932, "visitante2", 69, 3500.0);
		Persona visitante3 = new Visitante(43205953, "visitante3", 15, 5020.0);
		Persona visitante4 = new Visitante(43205965, "visitante4", 11, 3000.0);

		List<Persona> visitantesAIngresar = new ArrayList<>();

		visitantesAIngresar.add(visitante1);
		visitantesAIngresar.add(visitante2);
		visitantesAIngresar.add(visitante3);
		visitantesAIngresar.add(visitante4);

		Boolean seAgregaron = this.zoo.agregarVariosVisitantes(visitantesAIngresar);
		assertTrue(seAgregaron);
		assertTrue(this.zoo.getPersonas().contains(visitante3));
		assertTrue(this.zoo.getPersonas().contains(visitante4));
	}

	@Test
	public void queSePuedaConocerElTotalRecaudadoEnBaseALaCantidadDeEntradasVendidas() {
		Persona visitante1 = new Visitante(43472194, "visitante1", 59, 4300.0);
		Persona visitante2 = new Visitante(43205932, "visitante2", 69, 3500.0);
		Persona visitante3 = new Visitante(43205953, "visitante3", 15, 5020.0);
		Persona visitante4 = new Visitante(43205965, "visitante4", 11, 3000.0);

		List<Persona> visitantesAIngresar = new ArrayList<>();

		visitantesAIngresar.add(visitante1);
		visitantesAIngresar.add(visitante2);
		visitantesAIngresar.add(visitante3);
		visitantesAIngresar.add(visitante4);
		this.zoo.agregarVariosVisitantes(visitantesAIngresar);

		Double totalRecaudado = this.zoo.obtenerRecaudacion();

		assertEquals(10000.0, totalRecaudado, 0.001);

	}

	@Test
	public void queUnVisitantePuedaUsarUnaInstalacionComunTeniendoEntrada()
			throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException,
			NoFueEncontradaPersonaInexistenteException {

		Estructura estacionamiento = new InstalacionComun(420, "Estacionamiento", true);

		Persona visitante1 = new Visitante(43472194, "visitante1", 39, 4300.0);
		this.zoo.agregarPersonaAlZoo(visitante1);
		RegistroVisitaInstalacionComun registro = this.zoo.registrarVisitaDeUnVisitanteAUnaInstalacionComun(visitante1,
				estacionamiento);
		List<RegistroVisitaInstalacionComun> pudoVisitar = this.zoo.obtenerRegistrosVisitasInstalacionesComunes();

		assertNotNull(pudoVisitar);
		assertEquals(registro, this.zoo.obtenerRegistrosVisitasInstalacionesComunes().get(0));

	}

	@Test(expected = NoTieneEntradaException.class)
	public void queUnVisitanteNoPuedaUsarUnaInstalacionComunPorNoTenerEntrada() throws NoTieneEntradaException,
			NoSePuedenAgregarMenoresDeEdadException, NoFueEncontradaPersonaInexistenteException {
		Persona visitante3 = new Visitante(43205953, "visitante3", 25, 20.0); //
		Estructura banio = new InstalacionComun(432, "Banio", true);

		this.zoo.agregarPersonaAlZoo(visitante3);
		RegistroVisitaInstalacionComun registro = this.zoo.registrarVisitaDeUnVisitanteAUnaInstalacionComun(visitante3,
				banio);
		List<RegistroVisitaInstalacionComun> pudoVisitar = this.zoo.obtenerRegistrosVisitasInstalacionesComunes();

		assertNotNull(pudoVisitar);
		assertEquals(registro, this.zoo.obtenerRegistrosVisitasInstalacionesComunes().get(0));
	}

	@Test
	public void queUnVisitantePuedaVerUnAnimalTeniendoEntrada()
			throws NoTieneEntradaException, NoFueEncontradaEstructuraInexistenteExcepcion,
			NoSePudoAgregarAnimalInexistenteException, HabitatVacioException, NoExisteObjetoDondeSeBuscaException,
			NoSePuedenAgregarMenoresDeEdadException, NoFueEncontradaPersonaInexistenteException,
			InstanciaIncorrectaException, EspecieDiferenteException, HabitatLlenoException {
		// persona
		Persona visitante3 = new Visitante(43205953, "visitante3", 45, 5020.0);
		// animal y habitat
		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);
		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarPersonaAlZoo(visitante3);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat(mono, habitatMonos);
		RegistroVisitaHabitatAnimal registro = this.zoo.registrarVisitaDeUnVisitanteAUnHabitat(visitante3,
				habitatMonos);
		List<RegistroVisitaHabitatAnimal> pudoVer = this.zoo.obtenerRegistrosVisitasHabitatsAnimal();

		assertNotNull(pudoVer);
		assertEquals(registro, this.zoo.obtenerRegistrosVisitasHabitatsAnimal().get(0));
	}

	@Test(expected = NoTieneEntradaException.class)
	public void queUnVisitanteNoPuedaVerUnAnimalPorNoTenerEntrada()
			throws NoTieneEntradaException, NoExisteObjetoDondeSeBuscaException,
			NoSePudoAgregarAnimalInexistenteException, NoFueEncontradaEstructuraInexistenteExcepcion,
			HabitatVacioException, InstanciaIncorrectaException, EspecieDiferenteException, HabitatLlenoException {
		// persona
		Persona visitante3 = new Visitante(43205953, "visitante3", 45, 120.0); // dinero insuficiente
		// animal y habitat
		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales, true);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);
		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarAnimalAlZoo(mono);
		this.zoo.agregarAnimalAlHabitat(mono, habitatMonos);
		this.zoo.registrarVisitaDeUnVisitanteAUnHabitat(visitante3, habitatMonos);

		assertEquals(0, this.zoo.obtenerRegistrosVisitasHabitatsAnimal().size());
	}

	@Test(expected = HabitatVacioException.class)
	public void queUnVisitanteNoPuedaVerUnHabitatVacio()
			throws HabitatVacioException, NoSePudoAgregarAnimalInexistenteException,
			NoFueEncontradaEstructuraInexistenteExcepcion, NoExisteObjetoDondeSeBuscaException, NoTieneEntradaException,
			InstanciaIncorrectaException, EspecieDiferenteException, HabitatLlenoException {
		// persona
		Persona visitante3 = new Visitante(43205953, "visitante3", 45, 10020.0);
		// animal y habitat
		Estructura habitatMonos = new Habitat(123, "Isla de los monos", 4, true);
		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		this.zoo.agregarEstructuraAlZoo(habitatMonos);
		this.zoo.agregarAnimalAlZoo(mono);

		RegistroVisitaHabitatAnimal pudoVer = this.zoo.registrarVisitaDeUnVisitanteAUnHabitat(visitante3, habitatMonos);
		assertNotNull(pudoVer);
		assertEquals(0, this.zoo.obtenerRegistrosVisitasHabitatsAnimal().size());
	}
}
