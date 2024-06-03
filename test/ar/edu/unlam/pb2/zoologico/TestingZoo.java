package ar.edu.unlam.pb2.zoologico;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

import ar.edu.unlam.pb2.zoologico.excepciones.EspecieDiferenteException;
import ar.edu.unlam.pb2.zoologico.excepciones.EstadoDelObjetoEsIncorrectoException;
import ar.edu.unlam.pb2.zoologico.excepciones.HabitatLlenoException;
import ar.edu.unlam.pb2.zoologico.excepciones.InstanciaIncorrectaException;
import ar.edu.unlam.pb2.zoologico.excepciones.NoExisteObjetoDondeSeBuscaException;
import ar.edu.unlam.pb2.zoologico.excepciones.NoSePuedenAgregarMenoresDeEdadException;
import ar.edu.unlam.pb2.zoologico.excepciones.ProgenitoresDelMismoSexoException;
import ar.edu.unlam.pb2.zoologico.excepciones.ProgenitoresEnDistintoHabitatException;

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
	public void dadoQueExisteUnZoologicoQueNoSePuedaAgregarElMismoAnimalDosVeces() {

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
	public void dadoQueExisteUnZoologicoQueSePuedanAgregarPersonasAlMismo() throws Exception {

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
	
	@Test (expected = NoSePuedenAgregarMenoresDeEdadException.class)
	public void dadoQueExisteUnZoologicoNoSePuedenAgregarPersonasSiEstasSonMenores() throws NoSePuedenAgregarMenoresDeEdadException {

		String nombreZoo = "Animalandia";

		Zoologico zoo = new Zoologico(nombreZoo);

		Integer identificacion = 23;
		String nombreCompleto = "Jime Gomez";
		Integer edad = 15;

		Persona personal = new Veterinario(identificacion, nombreCompleto, edad);

		Boolean seAgrego = zoo.agregarPersonaAlZoo(personal);

		assertFalse(seAgrego);
		
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
	public void dadoQueExisteUnZoologicoConAnimalesEstosSePuedenIngresarAHabitats() throws Exception {

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
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsPodemosObtenerUnAnimalDeUnHabitatParticular() throws Exception {

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
		
		assertEquals(mono1, primerAnimalObtenido);
		
	}
	
	@Test (expected = NoExisteObjetoDondeSeBuscaException.class)
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsNoPodemosAgregarAnimalesSiElHabitatNoEstaEnElZoologico() throws NoExisteObjetoDondeSeBuscaException, Exception {

		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono1);
		
		Animal mono2 = new Mono(514, "Mono Mario", 6, 8.9, TipoAlimentacion.OMNIVORO, TipoSexo.MASCULINO,
				CategoriaAnimal.MAMIFERO);
		zoo.agregarAnimalAlZoo(mono2);
	
		zoo.agregarAnimalAlHabitat (mono1, habitatMonos); // Solo el mono 1 fue agregado

	}
	
	@Test (expected = NoExisteObjetoDondeSeBuscaException.class)
	public void dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsNoPodemosAgregarAnimalesSiNoEstanEnElZoologico() throws NoExisteObjetoDondeSeBuscaException, Exception {

		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);

		Integer codigoEstructural = 123;
		String nombreEstructura = "Isla de los monos";
		Integer maximoAnimales = 4;
		Estructura habitatMonos = new Habitat(codigoEstructural, nombreEstructura, maximoAnimales);
		zoo.agregarEstructuraAlZoo(habitatMonos);

		Animal mono1 = new Mono(513, "Mona Lisa", 4, 7.2, TipoAlimentacion.OMNIVORO, TipoSexo.FEMENINO,
				CategoriaAnimal.MAMIFERO);

		zoo.agregarAnimalAlHabitat (mono1, habitatMonos); 

	}
	
	@Test (expected = EspecieDiferenteException.class)
	public void dadoQueExisteUnZoologicoConHabitatsEstosNoDebenAlbergarDistintasEspecies() throws EspecieDiferenteException, Exception {

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
	
	@Test (expected = HabitatLlenoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsNoSePuedenIngresarMasAnimalesSiEsteEstaLleno() throws HabitatLlenoException, Exception {

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
		
		zoo.agregarAnimalAlHabitat (mono1, habitatMonos);
		zoo.agregarAnimalAlHabitat (mono2, habitatMonos);
		zoo.agregarAnimalAlHabitat (mono3, habitatMonos);
		zoo.agregarAnimalAlHabitat (mono4, habitatMonos);
		zoo.agregarAnimalAlHabitat (mono5, habitatMonos);
		
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
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesePuedenReproducir () throws Exception {
		
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
	
	@Test (expected = ProgenitoresDelMismoSexoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiSonDelMismoSexo () throws ProgenitoresDelMismoSexoException, Exception {
		
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
		zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);
		zoo.obtenerAnimalDeUnHabitatPorCodigo(idCria, habitatMonos);
		
	}

	@Test (expected = HabitatLlenoException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiElHabitatYaEstaLleno () throws HabitatLlenoException, Exception {
		
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
		zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos, idCria, nombreCria);

	}
	
	@Test (expected = ProgenitoresEnDistintoHabitatException.class)
	public void dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiEstanEnDistintoHabitat () throws ProgenitoresEnDistintoHabitatException, Exception {
		
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
		zoo.reproducirDosAnimalesDeUnHabitat(mona, mono, habitatMonos1, idCria, nombreCria);
		
	}
	
	@Test 
	public void dadoQueExisteUnZoologicoConVeterinariosQueEstanEnHospitalesPodemosObtenerUnVeterinarioDeUnHospital() throws Exception {

		String nombreZoo = "Animalandia";
		Zoologico zoo = new Zoologico(nombreZoo);
		
        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
        zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		zoo.agregarEstructuraAlZoo(hospital);
        zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);
	
		Veterinario veterinarioObtenido = zoo.obtenerVeterinarioDeUnHospital(veterinario, hospital);		
		assertEquals(veterinario, veterinarioObtenido);

	}
	
	@Test 
    public void dadoQueExisteUnZoologicoConUnHospitalQueSePuedaCrearUnRegistroDeTratamientoAlCurarUnVeterinarioAUnAnimal() throws Exception {

        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		zoo.agregarEstructuraAlZoo(bosqueOsos);    
        zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
        zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		zoo.agregarEstructuraAlZoo(hospital);
        zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);

        oso.setEstaEnfermo(true);
        
		RegistroTratamiento registro = zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso,  bosqueOsos);
		assertNotNull(registro);
		assertFalse(oso.getEstaEnfermo());
		assertEquals(veterinario, registro.getVeterinario());

    }
	
	@Test (expected = EstadoDelObjetoEsIncorrectoException.class)
    public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiYaEstaSano() throws EstadoDelObjetoEsIncorrectoException, Exception {

        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		zoo.agregarEstructuraAlZoo(bosqueOsos);    
        zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
        zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		zoo.agregarEstructuraAlZoo(hospital);
        zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);
        
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso,  bosqueOsos);

    }
	
	@Test (expected = InstanciaIncorrectaException.class)
    public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiLaPersonaQueAtiendeNoEsUnVeterinario() throws InstanciaIncorrectaException, Exception {

        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		zoo.agregarEstructuraAlZoo(bosqueOsos);    
        zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona empleadoMantenimiento = new EmpleadoMantenimiento(23, "Luis Alvarez", 34);
        zoo.agregarPersonaAlZoo(empleadoMantenimiento);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		zoo.agregarEstructuraAlZoo(hospital);
        zoo.agregarUnVeterinarioAUnHospital(hospital, empleadoMantenimiento);
        
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, empleadoMantenimiento, oso,  bosqueOsos);

    }
	
	@Test (expected = NoExisteObjetoDondeSeBuscaException.class)
    public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiElVeterinarioNoEstaEnElZoologico() throws NoExisteObjetoDondeSeBuscaException, Exception {

        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		zoo.agregarEstructuraAlZoo(bosqueOsos);    
        zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		zoo.agregarEstructuraAlZoo(hospital);
        
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso,  bosqueOsos);

    }
	
	@Test (expected = NoExisteObjetoDondeSeBuscaException.class)
    public void dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiElVeterinarioNoEstaEnElHospital() throws NoExisteObjetoDondeSeBuscaException, Exception {

        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		zoo.agregarEstructuraAlZoo(bosqueOsos);    
        zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		zoo.agregarEstructuraAlZoo(hospital);
        
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso,  bosqueOsos);

    }
	
	
	@Test 
    public void dadoQueExisteUnZoologicoConUnHospitalSePuedenObtenerTodosLosAnimalesQueTratoUnVeterinarioParticular() throws Exception {
			
        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);

        Animal oso1 = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso1);
        oso1.setEstaEnfermo(true);
        
        Animal oso2 = new Oso(3334, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso2);
        oso2.setEstaEnfermo(true);
        
        Animal oso3 = new Oso(3335, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso3);
        oso3.setEstaEnfermo(true);
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		zoo.agregarEstructuraAlZoo(bosqueOsos);    
        zoo.agregarAnimalAlHabitat(oso1, bosqueOsos);
        zoo.agregarAnimalAlHabitat(oso2, bosqueOsos);
        zoo.agregarAnimalAlHabitat(oso3, bosqueOsos);

        Persona veterinario = new Veterinario(23, "Luis Alvarez", 34);
        zoo.agregarPersonaAlZoo(veterinario);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		zoo.agregarEstructuraAlZoo(hospital);
        zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario);
        
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso2,  bosqueOsos);
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso3,  bosqueOsos);
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario, oso1,  bosqueOsos);
		
		List<Animal> animalesObtenidos = zoo.obtenerLosAnimalesQueAtendioUnVeterinarioEnUnHospital(veterinario, hospital);
		
		List<Animal> animalesEsperados = new ArrayList<>();
		animalesEsperados.add(oso2);
		animalesEsperados.add(oso3);
		animalesEsperados.add(oso1);
		
		assertNotNull(animalesObtenidos);
		assertEquals(animalesEsperados, animalesObtenidos);
		
    }
	
	@Test 
    public void dadoQueExisteUnZoologicoConUnHospitalSePuedenObtenerTodosLosVeterinariosQueAtendieronAUnAnimalParticular() throws Exception {

        String nombreZoo = "Animalandia";
        Zoologico zoo = new Zoologico(nombreZoo);

        Animal oso = new Oso(3333, "gordito", 2, 20.0, TipoAlimentacion.HERBIVORO, TipoSexo.FEMENINO,
                CategoriaAnimal.MAMIFERO);
        zoo.agregarAnimalAlZoo(oso);      
        
		Integer codigoHabitat = 123;
		String nombreHabitat ="Bosque de los osos";
		Integer maximoAnimales = 4;
		Estructura bosqueOsos = new Habitat(codigoHabitat, nombreHabitat, maximoAnimales);
		zoo.agregarEstructuraAlZoo(bosqueOsos);    
        zoo.agregarAnimalAlHabitat(oso, bosqueOsos);

        Persona veterinario1 = new Veterinario(23, "Luis Alvarez", 34);
        zoo.agregarPersonaAlZoo(veterinario1);
        
        Persona veterinario2 = new Veterinario(23, "Luis Alvarez", 34);
        zoo.agregarPersonaAlZoo(veterinario2);
        
        Persona veterinario3 = new Veterinario(23, "Luis Alvarez", 34);
        zoo.agregarPersonaAlZoo(veterinario3);
 
		Integer codigoHospital = 2234;
		String nombreHospital= "Hospitalcito";
		Estructura hospital = new HospitalVeterinario(codigoHospital, nombreHospital);
		zoo.agregarEstructuraAlZoo(hospital);
        zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario1);
        zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario2);
        zoo.agregarUnVeterinarioAUnHospital(hospital, veterinario3);
        
        oso.setEstaEnfermo(true);
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario2, oso,  bosqueOsos);
		
        oso.setEstaEnfermo(true);
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario1, oso,  bosqueOsos);
		
        oso.setEstaEnfermo(true);
		zoo.queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(hospital, veterinario3, oso,  bosqueOsos);
		
		List<Persona> veterinariosObtenidos = zoo.obtenerLosVeterinariosQueAtendieronAUnAnimalEnUnHospital(oso, hospital);
		
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
