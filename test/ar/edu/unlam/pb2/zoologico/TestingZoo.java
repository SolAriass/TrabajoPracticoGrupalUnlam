package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
		// estar enfermo es algo que ya tiene el mono, por defecto esta sano
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

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		Boolean seAgrego = zoo.agregarPersonaAlZoo(personal);

		assertTrue(seAgrego);
		assertEquals(personal, zoo.getPersonas().get(0));

	}

	@Test
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarEstructurasAlMismo() {

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
	public void queUnVisitantePuedaComprarEntradaTeniendoSaldoSuficiente() {
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
	
	@Test //(expected= Exception.class)
	public void queUnVisitanteNoPuedaComprarEntradaPorSerMenorDeEdad() {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 43472194;
		String nombreCompleto = "Daniel Ramirez";
		Integer edad = 12;
		Double dineroQueDispone = 3040.0;

		Persona visitante1 = new Visitante(identificacion, nombreCompleto, edad, dineroQueDispone);

		Boolean pudoEntrar = zoo.agregarPersonaAlZoo(visitante1);

		assertFalse(pudoEntrar);
	}

	@Test
	public void queUnVisitanteNoPuedaComprarEntradaTeniendoSaldoInsuficiente() {
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 43472194;
		String nombreCompleto = "Sergio Ramirez";
		Integer edad = 23;
		Double dineroQueDispone = 40.0;

		Persona visitante1 = new Visitante(identificacion, nombreCompleto, edad, dineroQueDispone);

		Boolean pudoEntrar = zoo.agregarPersonaAlZoo(visitante1);

		assertFalse(pudoEntrar);
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
}
