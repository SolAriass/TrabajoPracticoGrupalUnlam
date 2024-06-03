package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.unlam.pb2.excepciones.*;

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
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarAnimalesAlMismo()
			throws NoSePudoAgregarAnimalInexistenteException {

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

		Boolean seAgrego = zoo.agregarAnimalAlZoo(mono);

		assertTrue(seAgrego);
		assertEquals(mono, zoo.getAnimales().get(0));

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEstosSePuedenIngresarAHabitats()
			throws NoSePudoAgregarEstructuraInexistenteExcepcion, NoSePudoAgregarAnimalInexistenteException,
			HabitatVacioException, NoExisteObjetoDondeSeBuscaException {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono);

		Boolean seAgrego = zoo.agregarAnimalAlHabitat(mono, habitatMonos);
		Animal animalAgregado = zoo.obtenerAnimalDeUnHabitat(mono, habitatMonos);

		assertTrue(seAgrego);
		assertEquals(mono, animalAgregado);

	}

	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarPersonasAlMismo()
			throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {

		String nombreZoo = "Animalandia";

		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 25;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		Boolean seAgrego = zoo.agregarPersonaAlZoo(personal);

		assertTrue(seAgrego);
		assertEquals(personal, zoo.getPersonas().get(0));

	}

	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarEstructurasAlMismo()
			throws NoSePudoAgregarEstructuraInexistenteExcepcion {

		String nombreZoo = "Animalandia";

		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural = 2234;
		String nombreEstructura = "Hospitalcito";
		// estado es algo que ya tiene dicha estructura

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

		Boolean seAgrego = zoo.agregarEstructuraAlZoo(hospital);

		assertTrue(seAgrego);
		assertEquals(hospital, zoo.getEstructuras().get(0));

	}

	@Test
	public void queUnVisitantePuedaComprarEntradaTeniendoSaldoSuficiente()
			throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 43472194;
		String nombreCompleto = "Sergio Ramirez";
		Integer edad = 23;
		Double dineroQueDispone = 3040.0;

		Persona visitante1 = new Visitante(identificacion, nombreCompleto, edad, dineroQueDispone);

		Boolean pudoEntrar = zoo.agregarPersonaAlZoo(visitante1);

		assertTrue(pudoEntrar);
		assertEquals(visitante1, zoo.getPersonas().get(0));
	}

	@Test(expected = NoSePuedenAgregarMenoresDeEdadException.class)
	public void queUnVisitanteNoPuedaComprarEntradaPorSerMenorDeEdad()
			throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 43472194;
		String nombreCompleto = "Daniel Ramirez";
		Integer edad = 12;
		Double dineroQueDispone = 3040.0;

		Persona visitante1 = new Visitante(identificacion, nombreCompleto, edad, dineroQueDispone);

		Boolean pudoEntrar = zoo.agregarPersonaAlZoo(visitante1);

		assertTrue(pudoEntrar);
		assertEquals(visitante1, zoo.getPersonas().get(0));
	}

	@Test(expected = NoTieneEntradaException.class)
	public void queUnVisitanteNoPuedaComprarEntradaTeniendoSaldoInsuficiente()
			throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 43472194;
		String nombreCompleto = "Sergio Ramirez";
		Integer edad = 23;
		Double dineroQueDispone = 40.0;

		Persona visitante1 = new Visitante(identificacion, nombreCompleto, edad, dineroQueDispone);

		Boolean pudoEntrar = zoo.agregarPersonaAlZoo(visitante1);

		assertTrue(pudoEntrar);
		assertEquals(visitante1, zoo.getPersonas().get(0));
	}

	@Test
	public void queUnGrupoDeVisitantePuedaComprarEntradaTeniendoSaldoSuficiente() {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Persona visitante1 = new Visitante(43472194, "visitante1", 59, 4300.0);
		Persona visitante2 = new Visitante(43205932, "visitante2", 69, 3500.0);
		Persona visitante3 = new Visitante(43205953, "visitante3", 15, 5020.0);
		Persona visitante4 = new Visitante(43205965, "visitante4", 11, 3000.0);

		List<Persona> visitantesAIngresar = new ArrayList<>();

		visitantesAIngresar.add(visitante1);
		visitantesAIngresar.add(visitante2);
		visitantesAIngresar.add(visitante3);
		visitantesAIngresar.add(visitante4);

		Boolean seAgregaron = zoo.agregarVariosVisitantes(visitantesAIngresar);
		assertTrue(seAgregaron);
		assertEquals(visitantesAIngresar.size(), zoo.getPersonas().size());

	}

	@Test
	public void queUnGrupoDePersonasPuedaIngresarConMenoresDeEdad() {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Persona visitante1 = new Visitante(43472194, "visitante1", 59, 4300.0);
		Persona visitante2 = new Visitante(43205932, "visitante2", 69, 3500.0);
		Persona visitante3 = new Visitante(43205953, "visitante3", 15, 5020.0);
		Persona visitante4 = new Visitante(43205965, "visitante4", 11, 3000.0);

		List<Persona> visitantesAIngresar = new ArrayList<>();

		visitantesAIngresar.add(visitante1);
		visitantesAIngresar.add(visitante2);
		visitantesAIngresar.add(visitante3);
		visitantesAIngresar.add(visitante4);

		Boolean seAgregaron = zoo.agregarVariosVisitantes(visitantesAIngresar);
		assertTrue(seAgregaron);
		assertTrue(zoo.getPersonas().contains(visitante3));
		assertTrue(zoo.getPersonas().contains(visitante4));
	}

	@Test
	public void queSePuedaConocerElTotalRecaudadoEnBaseALaCantidadDeEntradasVendidas() {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Persona visitante1 = new Visitante(43472194, "visitante1", 59, 4300.0);
		Persona visitante2 = new Visitante(43205932, "visitante2", 69, 3500.0);
		Persona visitante3 = new Visitante(43205953, "visitante3", 15, 5020.0);
		Persona visitante4 = new Visitante(43205965, "visitante4", 11, 3000.0);

		List<Persona> visitantesAIngresar = new ArrayList<>();

		visitantesAIngresar.add(visitante1);
		visitantesAIngresar.add(visitante2);
		visitantesAIngresar.add(visitante3);
		visitantesAIngresar.add(visitante4);
		zoo.agregarVariosVisitantes(visitantesAIngresar);

		Double totalRecaudado = zoo.obtenerRecaudacion();

		assertEquals(10000.0, totalRecaudado, 0.001);

	}

	@Test
	public void queUnVisitantePuedaUsarUnaInstalacionComunTeniendoEntrada()
			throws NoSePuedenAgregarMenoresDeEdadException, NoTieneEntradaException {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		Estructura banio = new InstalacionComun(432, "Banio");
		Estructura estacionamiento = new InstalacionComun(420, "Estacionamiento");
		Estructura ZonasDeComidas = new InstalacionComun(493, "Zonas de comidas");

		Persona visitante1 = new Visitante(43472194, "visitante1", 39, 4300.0);
		zoo.agregarPersonaAlZoo(visitante1);
		RegistroVisitaInstalacionComun registro = zoo.registrarVisitaDeUnVisitanteAUnaInstalacionComun(visitante1,
				estacionamiento);
		List<RegistroVisitaInstalacionComun> pudoVisitar = zoo.obtenerRegistrosVisitasInstalacionesComunes();

		assertNotNull(pudoVisitar);
		assertEquals(registro, zoo.obtenerRegistrosVisitasInstalacionesComunes().get(0));

	}

	@Test(expected = NoTieneEntradaException.class)
	public void queUnVisitanteNoPuedaUsarUnaInstalacionComunPorNoTenerEntrada()
			throws NoTieneEntradaException, NoSePuedenAgregarMenoresDeEdadException {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		Persona visitante3 = new Visitante(43205953, "visitante3", 25, 20.0); //
		Estructura banio = new InstalacionComun(432, "Banio");

		zoo.agregarPersonaAlZoo(visitante3);
		RegistroVisitaInstalacionComun registro = zoo.registrarVisitaDeUnVisitanteAUnaInstalacionComun(visitante3,
				banio);
		List<RegistroVisitaInstalacionComun> pudoVisitar = zoo.obtenerRegistrosVisitasInstalacionesComunes();

		assertNotNull(pudoVisitar);
		assertEquals(registro, zoo.obtenerRegistrosVisitasInstalacionesComunes().get(0));
	}

	@Test
	public void queUnVisitantePuedaVerUnAnimalTeniendoEntrada() throws NoTieneEntradaException,
			NoSePudoAgregarEstructuraInexistenteExcepcion, NoSePudoAgregarAnimalInexistenteException,
			HabitatVacioException, NoExisteObjetoDondeSeBuscaException, NoSePuedenAgregarMenoresDeEdadException {
		// zoo
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		// persona
		Persona visitante3 = new Visitante(43205953, "visitante3", 45, 5020.0);
		// animal y habitat
		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);
		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarPersonaAlZoo(visitante3);
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlHabitat(mono, habitatMonos);
		RegistroVisitaHabitatAnimal registro = zoo.registrarVisitaDeUnVisitanteAUnHabitat(visitante3, habitatMonos);
		List<RegistroVisitaHabitatAnimal> pudoVer = zoo.obtenerRegistrosVisitasHabitatsAnimal();

		assertNotNull(pudoVer);
		assertEquals(registro, zoo.obtenerRegistrosVisitasHabitatsAnimal().get(0));
	}

	@Test(expected = NoTieneEntradaException.class)
	public void queUnVisitanteNoPuedaVerUnAnimalPorNoTenerEntrada() throws NoTieneEntradaException,
			NoExisteObjetoDondeSeBuscaException, NoSePudoAgregarAnimalInexistenteException,
			NoSePudoAgregarEstructuraInexistenteExcepcion, HabitatVacioException {
		// zoo
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		// persona
		Persona visitante3 = new Visitante(43205953, "visitante3", 45, 120.0); // dinero insuficiente
		// animal y habitat
		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);
		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlHabitat(mono, habitatMonos);
		zoo.registrarVisitaDeUnVisitanteAUnHabitat(visitante3, habitatMonos);

		assertEquals(0, zoo.obtenerRegistrosVisitasHabitatsAnimal().size());
	}

	@Test(expected = HabitatVacioException.class)
	public void queUnVisitanteNoPuedaVerUnHabitatVacio() throws HabitatVacioException,
			NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarEstructuraInexistenteExcepcion,
			NoExisteObjetoDondeSeBuscaException, NoTieneEntradaException {
		// zoo
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		// persona
		Persona visitante3 = new Visitante(43205953, "visitante3", 45, 10020.0);
		// animal y habitat
		Estructura habitatMonos = new Habitat(123, "Isla de los monos", 4);
		Animal mono = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarEstructuraAlZoo(habitatMonos);
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlHabitat(null, habitatMonos);

		RegistroVisitaHabitatAnimal pudoVer = zoo.registrarVisitaDeUnVisitanteAUnHabitat(visitante3, habitatMonos);
		assertNotNull(pudoVer);
		assertEquals(0, zoo.obtenerRegistrosVisitasHabitatsAnimal().size());
	}
}
