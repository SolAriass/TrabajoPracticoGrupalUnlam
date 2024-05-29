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
		// estado es algo que ya tiene dicha estructura

		Estructura hospital = new HospitalVeterinario(codigoEstructural, nombreEstructura);

		Boolean seAgrego = zoo.agregarEstructuraAlZoo(hospital);

		assertTrue(seAgrego);
		assertEquals(hospital, zoo.getEstructuras().get(0));

	}

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesEstosSePuedenIngresarAHabitats() {

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
		
		Boolean seAgrego = zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		Animal animalAgregado = zoo.obtenerAnimalDeUnHabitat(mono, habitatMonos);
		
		assertTrue(seAgrego);
		assertEquals(mono, animalAgregado);

	}
	
	@Test
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsPodemosObtenerUnAnimalDeUnHabitatParticular() {

		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

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
	
		zoo.agregarAnimalAlHabitat (mono1, habitatMonos); // Solo el mono 1 fue agregado
		Animal primerAnimalObtenido = zoo.obtenerAnimalDeUnHabitat(mono1, habitatMonos);
		Animal segundoAnimalObtenido = zoo.obtenerAnimalDeUnHabitat(mono2, habitatMonos);
		
		assertEquals(mono1, primerAnimalObtenido);
		assertNull(segundoAnimalObtenido);

	}
	
	@Test
	public void dadoQueExisteUnZoologicoConHabitatsEstosNoDebenAlbergarDistintasEspecies() {

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
		
		Animal oso = new Oso(216, "Oso Maloso", 8, 120.6, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(oso);
	
		Boolean seAgregoElPrimero = zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		Boolean seAgregoElSegundo = zoo.agregarAnimalAlHabitat (oso, habitatMonos);

		assertTrue(seAgregoElPrimero);
		assertFalse(seAgregoElSegundo);
		
	}
	
	@Test
	public void dadoQueExisteUnZoologicoConHabitatsNoSePuedenIngresarMasAnimalesSiEsteEstaLleno() {

		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono1);
		
		Animal mono2 = new Mono(514, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono2);
		
		Animal mono3 = new Mono(515, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono3);
		
		Animal mono4 = new Mono(516, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono4);
		
		Animal mono5 = new Mono(517, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono5);
		
		Boolean seAgregoElPrimero = zoo.agregarAnimalAlHabitat (mono1, habitatMonos);
		Boolean seAgregoElSegundo = zoo.agregarAnimalAlHabitat (mono2, habitatMonos);
		Boolean seAgregoElTercero = zoo.agregarAnimalAlHabitat (mono3, habitatMonos);
		Boolean seAgregoElCuarto = zoo.agregarAnimalAlHabitat (mono4, habitatMonos);
		Boolean seAgregoElQuinto = zoo.agregarAnimalAlHabitat (mono5, habitatMonos);
		
		assertTrue(seAgregoElPrimero);
		assertTrue(seAgregoElSegundo);
		assertTrue(seAgregoElTercero);
		assertTrue(seAgregoElCuarto);
		assertFalse(seAgregoElQuinto);
		
	}
	

	@Test
	public void dadoQueExisteUnZoologicoConAnimalesPodemosObtenerTodosLosDeUnaMismaCategoria() {
			
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Animal mono = new Mono(513, "mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
		Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO, CategoriaAnimal.MAMIFERO);
		Animal oso = new Oso(78, "winnie pooh", 7, 10.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
		Animal tiburon = new Tiburon(90, "tiburoncin", 12, 20.0, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO, CategoriaAnimal.PEZ);
		Animal serpiente = new Serpiente(1002, "thiago", 4, 2.5, TipoAlimentacion.CARNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.REPTIL);
		Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO, CategoriaAnimal.MAMIFERO);
		
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlZoo(mapache);
		zoo.agregarAnimalAlZoo(oso);
		zoo.agregarAnimalAlZoo(tiburon);
		zoo.agregarAnimalAlZoo(serpiente);
		zoo.agregarAnimalAlZoo(elefante);
		
		List <Animal> animalesMamiferos = zoo.obtenerLosAnimalesDeUnaCategoria(CategoriaAnimal.MAMIFERO);
		
		Integer tamañoEsperado = 4;
		
		assertEquals((int) tamañoEsperado, animalesMamiferos.size());
		assertEquals(mono, animalesMamiferos.get(0));
		assertEquals(mapache, animalesMamiferos.get(1));
		assertEquals(oso, animalesMamiferos.get(2));
		assertEquals(elefante, animalesMamiferos.get(3));

	}
	
	@Test
	public void dadoQueExisteUnZoologicoConAnimalesPodemosObtenerTodosLosDeUnMismoSexo() {

		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
		Animal mono = new Mono(513, "mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
		Animal mapache = new Mapache(113, "pedro", 3, 1.3, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO, CategoriaAnimal.MAMIFERO);
		Animal oso = new Oso(78, "winnie pooh", 7, 10.5, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.MAMIFERO);
		Animal tiburon = new Tiburon(90, "tiburoncin", 12, 20.0, TipoAlimentacion.CARNIVORO, TipoSexo.MASCULINO, CategoriaAnimal.PEZ);
		Animal serpiente = new Serpiente(1002, "thiago", 4, 2.5, TipoAlimentacion.CARNIVORO, TipoSexo.FEMENINO, CategoriaAnimal.REPTIL);
		Animal elefante = new Elefante(125, "dumbo", 9, 12.5, TipoAlimentacion.HERBIVORO, TipoSexo.MASCULINO, CategoriaAnimal.MAMIFERO);
		
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlZoo(mapache);
		zoo.agregarAnimalAlZoo(oso);
		zoo.agregarAnimalAlZoo(tiburon);
		zoo.agregarAnimalAlZoo(serpiente);
		zoo.agregarAnimalAlZoo(elefante);

		List <Animal> animalesHembras = zoo.obtenerLosAnimalesDeUnSexo(TipoSexo.FEMENINO);
		
		Integer tamañoEsperado = 3;
		
		assertEquals((int) tamañoEsperado, animalesHembras.size());
		assertEquals(mono, animalesHembras.get(0));
		assertEquals(oso, animalesHembras.get(1));
		assertEquals(serpiente, animalesHembras.get(2));
		
	}
	
	@Test
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesePuedenReproducir () {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mona);
		zoo.agregarAnimalAlHabitat (mona, habitatMonos);
		
		Animal mono = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		
		Integer idCria = 515;
		String nombreCria = "monito bebé";
		Boolean seReproducieron = zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);
		Animal cria = zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos);
		String nombreObtenido = cria.getNombreAnimal();
		
		assertTrue(seReproducieron);
		assertNotNull(cria);
		assertEquals(nombreCria, nombreObtenido);

	}
	
	@Test
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiSonDelMismoSexo () {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mona);
		zoo.agregarAnimalAlHabitat (mona, habitatMonos);
		
		Animal mono = new Mono(514, "Mona Rosa", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		
		Integer idCria = 515;
		String nombreCria = "monito bebé";
		Boolean seReproducieron = zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);
		Animal cria = zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos);
		
		assertFalse(seReproducieron);
		assertNull(cria);
		
	}

	@Test
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiElHabitatYaEstaLleno () {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 2;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mona);
		zoo.agregarAnimalAlHabitat (mona, habitatMonos);
		
		Animal mono = new Mono(514, "Mona Rosa", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlHabitat (mono, habitatMonos);
		
		Integer idCria = 515;
		String nombreCria = "monito bebé";
		Boolean seReproducieron = zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);
		Animal cria = zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos);
		
		assertFalse(seReproducieron);
		assertNull(cria);

	}
	
	@Test
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiEstanEnDistintoHabitat () {
		
		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural1 = 123;
		String nombreEstructura1 = "Isla de los monos";
		Integer maximoAnimales1 = 4;
		Estructura habitatMonos1 = new Habitat(codigoEstructural1, nombreEstructura1, maximoAnimales1);
		zoo.agregarEstructuraAlZoo(habitatMonos1);

		Animal mona = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mona);
		zoo.agregarAnimalAlHabitat (mona, habitatMonos1);
		
		Integer codigoEstructural2 = 321;
		String nombreEstructura2 = "Otra isla de los monos";
		Integer maximoAnimales2 = 4;
		Estructura habitatMonos2 = new Habitat(codigoEstructural2, nombreEstructura2, maximoAnimales2);
		zoo.agregarEstructuraAlZoo(habitatMonos2);
		
		Animal mono = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono);
		zoo.agregarAnimalAlHabitat (mono, habitatMonos2);
		
		Integer idCria = 515;
		String nombreCria = "monito bebé";
		Boolean seReproducieron = zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos1, idCria, nombreCria);
		Animal cria = zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos1);
		
		assertFalse(seReproducieron);
		assertNull(cria);
		
	}
	
}
