package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.pb2.zoologico.excepciones.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Zoologico implements IZoologico {

	private String nombreZoo;
	private Boolean seEncuentraAbierto;
	private Boolean estaLimpio;
	private List<Animal> animales;
	private List<Persona> personas;
	private List<Estructura> estructuras;

	public Zoologico(String nombreZoo) {
		this.nombreZoo = nombreZoo;
		this.estaLimpio = true;
		this.seEncuentraAbierto = true;
		this.animales = new ArrayList<>();
		this.personas = new ArrayList<>();
		this.estructuras = new ArrayList<>();
	}

	public String getNombreZoo() {
		return nombreZoo;
	}

	public void setNombreZoo(String nombreZoo) {
		this.nombreZoo = nombreZoo;
	}

	public Boolean getSeEncuentraAbierto() {
		return seEncuentraAbierto;
	}

	public void setSeEncuentraAbierto(Boolean seEncuentraAbierto) {
		this.seEncuentraAbierto = seEncuentraAbierto;
	}

	public Boolean getEstaLimpio() {
		return estaLimpio;
	}

	public void setEstaLimpio(Boolean estaLimpio) {
		this.estaLimpio = estaLimpio;
	}

	@Override
	public Boolean agregarAnimalAlZoo(Animal animal) {
		return animales.add(animal);
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	@Override
	public Boolean agregarPersonaAlZoo(Persona persona) throws NoSePuedenAgregarMenoresDeEdadException {
		
	    if (persona.getEdad() < 18) {
	        throw new NoSePuedenAgregarMenoresDeEdadException("No se pueden agregar personas menores de edad al zoológico");
	    }

		Boolean personaAgregada = false;

		if (persona.getEdad() >= 18) {

			if (persona instanceof Visitante) {
				personaAgregada = this.agregarVisitante(persona);
			} else {
				personaAgregada = personas.add(persona);
			}
		}

		return personaAgregada;

	}

	private Boolean agregarVisitante(Persona persona) {
		return true; // PROVISORIO, METODO DE JAVI
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public Boolean agregarEstructuraAlZoo(Estructura estructura) {
		return estructuras.add(estructura);
	}

	public List<Estructura> getEstructuras() {
		return estructuras;
	}

	public void setEstructuras(List<Estructura> estructuras) {
		this.estructuras = estructuras;
	}

	public Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat) throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {
		
		this.obtenerAnimal(animal);
		this.obtenerEstructura(habitat);
		
		if (!(habitat instanceof Habitat)) {
			throw new InstanciaIncorrectaException("La estructura ingresada no es un habitat");
		}


		Habitat habitatVerificado = (Habitat) habitat;
		return habitatVerificado.agregarAnimal(animal);

	}

	public Animal obtenerAnimal(Animal animalBuscado) throws NoExisteObjetoDondeSeBuscaException {

		for (Animal animal : animales) {
			if (animal.equals(animalBuscado)) {
				return animal;
			}
		}

		throw new NoExisteObjetoDondeSeBuscaException("El animal ingresado no existe en el zoologico");

	}

	public Estructura obtenerEstructura(Estructura estructuraBuscada) throws NoExisteObjetoDondeSeBuscaException {

		for (Estructura estructura : estructuras) {
			if (estructura.equals(estructuraBuscada)) {
				return estructura;
			}
		}

		throw new NoExisteObjetoDondeSeBuscaException("La estructura ingresada no existe en el zoologico");
	}
	
	public Persona obtenerPersona(Persona personaBuscada) throws NoExisteObjetoDondeSeBuscaException {

		for (Persona persona : personas) {
			if (persona.equals(personaBuscada)) {
				return persona;
			}
		}

		throw new NoExisteObjetoDondeSeBuscaException("La persona ingresada no existe en el zoologico");
	}

	public Animal obtenerAnimalDeUnHabitat(Animal animal, Estructura habitat) throws NoExisteObjetoDondeSeBuscaException {

		if (habitat instanceof Habitat) {
			Habitat habitatVerificado = (Habitat) habitat;
			return habitatVerificado.obtenerAnimal(animal);
		}

		return null;
	}

	public Animal obtenerAnimalDeUnHabitatPorCodigo(Integer codigo, Estructura habitat) throws NoExisteObjetoDondeSeBuscaException {
		if (habitat instanceof Habitat) {
			Habitat habitatVerificado = (Habitat) habitat;
			return habitatVerificado.obtenerAnimalPorCodigo(codigo);
		}

		return null;

	}

	public List<Animal> obtenerLosAnimalesDeUnaCategoria(CategoriaAnimal categoria) {

		List<Animal> listaAuxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getCategoriaAnimal().equals(categoria)) {
				listaAuxiliar.add(animal);
			}
		}

		return listaAuxiliar;
	}

	public List<Animal> obtenerLosAnimalesDeUnSexo(TipoSexo sexo) {

		List<Animal> listaAuxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getTipoSexo().equals(sexo)) {
				listaAuxiliar.add(animal);
			}
		}

		return listaAuxiliar;

	}

	public Boolean reproducirDosAnimalesDeUnHabitat(Animal progenitor1, Animal progenitor2, Estructura habitat,
			Integer idCria, String nombreCria) throws EspecieDiferenteException, HabitatLlenoException, ProgenitoresDelMismoSexoException, ProgenitoresEnDistintoHabitatException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {
		
		if (progenitor1.getTipoSexo().equals(progenitor2.getTipoSexo())) {
			throw new ProgenitoresDelMismoSexoException("Dos animales del mismo sexo no pueden reproducirse");
		}
		
		if (obtenerAnimalDeUnHabitat(progenitor1, habitat) == null
				|| obtenerAnimalDeUnHabitat(progenitor2, habitat) == null) {
			throw new ProgenitoresEnDistintoHabitatException("Los progenitores no se encuentran en el mismo habitat");
		}

		if (habitat instanceof Habitat) {
			Habitat habitatVerificado = (Habitat) habitat;
			Animal cria = habitatVerificado.reproducirAnimales(progenitor1, progenitor2, idCria, nombreCria);
			this.agregarAnimalAlZoo(cria);
			return this.agregarAnimalAlHabitat(cria, habitatVerificado);
		}

		return false;

	}
	


	@Override
	public Boolean agregarUnVeterinarioAUnHospital(Estructura hospital, Persona veterinario) throws NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {
			
		this.obtenerEstructura(hospital);
		this.obtenerPersona(veterinario);
		
		if (!(veterinario instanceof Veterinario) || !(hospital instanceof HospitalVeterinario)) {
			throw new InstanciaIncorrectaException("Al menos uno de los objetos ingresados por parámetro es de una instancia incorrecta");

		}
		
		Boolean agregado = false;
		if (this.obtenerEstructura(hospital) != null && this.obtenerPersona(veterinario) != null) {
			if (hospital instanceof HospitalVeterinario && veterinario instanceof Veterinario) {
				((HospitalVeterinario) hospital).agregarVeterinarioAlHospital(veterinario);
				agregado = true;
			}
		}

		return agregado;
	}

	public RegistroTratamiento queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(Estructura hospital,
			Persona veterinario, Animal animal, Estructura habitat) throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException, EstadoDelObjetoEsIncorrectoException {

		this.obtenerEstructura(hospital);
		this.obtenerPersona(veterinario);
		this.obtenerAnimal(animal);
		this.obtenerEstructura(habitat);
		
		if (!(veterinario instanceof Veterinario) || !(hospital instanceof HospitalVeterinario) || !(habitat instanceof Habitat)) {
			throw new InstanciaIncorrectaException("Al menos uno de los objetos ingresados por parámetro es de una instancia incorrecta");

		}
		
		if (obtenerVeterinarioDeUnHospital(veterinario, hospital) == null) {
			throw new NoExisteObjetoDondeSeBuscaException("El veterinario no existe en ese hospital");
		}

		if (!animal.getEstaEnfermo()) {
			throw new EstadoDelObjetoEsIncorrectoException ("El animal no puede ser tratado porque ya está sano");
		}

		this.retirarAnimalDeSuHabitat(animal, habitat);

		animal.setEstaEnfermo(false);
		RegistroTratamiento registro = new RegistroTratamiento(veterinario, animal);

		HospitalVeterinario hospitalNuevo = (HospitalVeterinario) hospital;
		hospitalNuevo.añadirRegistro(registro);

		this.agregarAnimalAlHabitat(animal, habitat);

		return registro;

	}

	private void retirarAnimalDeSuHabitat(Animal animal, Estructura habitat) throws NoExisteObjetoDondeSeBuscaException {
		Habitat habitatNuevo = (Habitat) this.obtenerEstructura(habitat);
		habitatNuevo.getAnimales().remove(animal);
	}

	public Veterinario obtenerVeterinarioDeUnHospital(Persona veterinario, Estructura hospital) throws NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {
		
		this.obtenerPersona(veterinario);
		this.obtenerEstructura(hospital);
		
		if (!(hospital instanceof HospitalVeterinario)) {
			throw new InstanciaIncorrectaException("La estructura ingresada no es un hospital veterinario");
		}

		HospitalVeterinario hospitalVerificado = (HospitalVeterinario) hospital;
		return hospitalVerificado.obtenerVeterinario(veterinario);
	
	}

	public List<Animal> obtenerLosAnimalesQueAtendioUnVeterinarioEnUnHospital(Persona veterinario,
			Estructura hospital) throws NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {

		List<Animal> auxiliar = new ArrayList<>();
		
		this.obtenerPersona(veterinario);
		this.obtenerEstructura(hospital);
		
		if (!(hospital instanceof HospitalVeterinario)) {
			throw new InstanciaIncorrectaException("La estructura ingresada no es un hospital veterinario");
		}

		if (this.obtenerVeterinarioDeUnHospital(veterinario, hospital) != null) {
			HospitalVeterinario hospitalVerificado = (HospitalVeterinario) hospital;
			auxiliar = hospitalVerificado.obtenerAnimalesAtendidosPorUnVeterinario(veterinario);
		}

		return auxiliar;
	}

	public List<Persona> obtenerLosVeterinariosQueAtendieronAUnAnimalEnUnHospital(Animal animal, Estructura hospital) throws NoExisteObjetoDondeSeBuscaException {
		
		List<Persona> auxiliar = new ArrayList<>();

		if (hospital instanceof HospitalVeterinario && this.obtenerEstructura(hospital) != null) {
			HospitalVeterinario hospitalVerificado = (HospitalVeterinario) hospital;
			auxiliar = hospitalVerificado.obtenerVeterinariosQueAtendieronUnAnimal(animal);
		}

		return auxiliar;
	}
	
	public TreeSet<Animal> obtenerAnimalesDeUnHabitatOrdenadosOrdenEspecifico(Comparator<Animal> OrdenEspecifico,
			Estructura habitat) throws InstanciaIncorrectaException {
		
		TreeSet<Animal> animalesNoRepetidos = new TreeSet<Animal>(OrdenEspecifico);
		
		if (!(habitat instanceof Habitat)) {
			throw new InstanciaIncorrectaException("La estructura ingresada no es un habitat");
		}
		
		Habitat habitatVerificado = (Habitat) habitat;
		List<Animal> animales = habitatVerificado.getAnimales();

		animalesNoRepetidos.addAll(animales);

		return animalesNoRepetidos;
	}

}
