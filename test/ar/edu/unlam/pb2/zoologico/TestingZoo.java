package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import java.util.List;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.exepciones.AnimalNoEncontradoException;
import ar.edu.unlam.pb2.exepciones.EstructuraNoEncontradaException;
import ar.edu.unlam.pb2.exepciones.PersonaNoEncontradaException;

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

		assertNotNull(zoo);
		assertEquals(nombreEsperado, this.zoo.getNombreZoo());
	}

	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarAnimalesAlMismo() {
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

	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarEstructurasAlMismo() {

		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";
		// estado es algo que ya tiene dicha estructura

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

		Boolean seAgrego = this.zoo.agregarEstructuraAlZoo(hospital);

		assertTrue(seAgrego);
		assertEquals(hospital, this.zoo.getEstructuras().get(0));
	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesQueSePuedaObtenerUnAnimalPorId() throws AnimalNoEncontradoException {
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
			throws AnimalNoEncontradoException {
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

		Animal animalObtenido = this.zoo.buscarAnimalPorId(1);
	}

	@Test
	public void dadoQueExisteUnZoologicoConPersonalQueSePuedaObtenerLaPersonaPorId()
			throws PersonaNoEncontradaException {
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;
		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personalDos = new Veterinario(24, "Martin Perez", 20);
		this.zoo.agregarPersonalAlZoo(personal);
		this.zoo.agregarPersonalAlZoo(personalDos);

		Persona personalObtenido = this.zoo.buscarPersonaPorId(24);

		assertEquals(personalDos, personalObtenido);
	}

	@Test(expected = PersonaNoEncontradaException.class)
	public void dadoQueExisteUnZoologicoConPersonalQueAlBuscarUnaPersonaPorIdInexistenteSeaNull()
			throws PersonaNoEncontradaException {
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;
		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personalDos = new Veterinario(24, "Martin Perez", 20);
		this.zoo.agregarPersonalAlZoo(personal);
		this.zoo.agregarPersonalAlZoo(personalDos);

		Persona personalObtenido = this.zoo.buscarPersonaPorId(10);
	}

	@Test
	public void dadoQueExisteUnZoologicoConEstructurasQueSePuedaObtenerLaEstructuraPorId()
			throws EstructuraNoEncontradaException {
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);
		Estructura hospitalDos = new HospitalVeterinario(2500, "Hospitalinho");

		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarEstructuraAlZoo(hospitalDos);

		Estructura estructuraObtenida = this.zoo.buscarEstructuraPorId(2500);

		assertEquals(hospitalDos, estructuraObtenida);
	}

	@Test(expected = EstructuraNoEncontradaException.class)
	public void dadoQueExisteUnZoologicoConEstructurasQueAlBuscarUnaEstructuraPorIdInexistenteSeaNull()
			throws EstructuraNoEncontradaException {
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);
		Estructura hospitalDos = new HospitalVeterinario(2500, "Hospitalinho");

		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarEstructuraAlZoo(hospitalDos);

		Estructura estructuraObtenida = this.zoo.buscarEstructuraPorId(2000);
	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesQueNoSePuedaAgregarDosAnimalesConMismoCodigo() {
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
	public void dadoQueExisteUnZoologicoConPersonalQueNoSePuedaAgregarDosPersonasConMismoCodigo() {
		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);
		Persona personalDos = new Veterinario(identificacion, "Pepe Gomez", 30);

		this.zoo.agregarPersonalAlZoo(personal);
		this.zoo.agregarPersonalAlZoo(personalDos);

		List<Persona> personas = this.zoo.getPersonas();
		assertEquals(1, personas.size());
	}

	@Test
	public void dadoQueExisteUnZoologicoConEstructurasQueNoSePuedaAgregarDosEstructurasConMismoCodigo() {
		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);
		Estructura hospitalDos = new HospitalVeterinario(codigoEstructural, "Hospitalinho");

		this.zoo.agregarEstructuraAlZoo(hospital);
		this.zoo.agregarEstructuraAlZoo(hospitalDos);

		List<Estructura> estructuras = this.zoo.getEstructuras();
		assertEquals(1, estructuras.size());
	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEstosSePuedenIngresarAHabitats() {

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono);

		Boolean seAgrego = zoo.agregarAnimalAlHabitat(mono, habitatMonos);
		Animal animalAgregado = zoo.obtenerAnimalDeUnHabitatPorCodigo(513, habitatMonos);

		assertTrue(seAgrego);
		assertEquals(mono, animalAgregado);

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsPodemosObtenerUnAnimalDeUnHabitatParticular() {
		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono1);

		Animal mono2 = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono2);

		zoo.agregarAnimalAlHabitat(mono1, habitatMonos); // Solo el mono 1 fue agregado
		Animal primerAnimalObtenido = zoo.obtenerAnimalDeUnHabitatPorCodigo(513, habitatMonos);
		Animal segundoAnimalObtenido = zoo.obtenerAnimalDeUnHabitatPorCodigo(514, habitatMonos);

		assertEquals(mono1, primerAnimalObtenido);
		assertNull(segundoAnimalObtenido);

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEnUnHabitatQueSePuedanObtenerLosAnimalesDeUnHabitatOrdenadosPorEdadDecreciente() {
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
	public void dadoQueExisteUnZoologicoConAnimalesEnUnHabitatQueSePuedanObtenerLosAnimalesDeUnHabitatOrdenadosPorEdadAscendente() {
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
}
