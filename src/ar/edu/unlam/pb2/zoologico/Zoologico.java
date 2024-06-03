package ar.edu.unlam.pb2.zoologico;

import java.util.List;

import java.time.LocalTime;
import ar.edu.unlam.pb2.zoologico.excepciones.*;

import java.util.ArrayList;

public class Zoologico implements IZoologico {

	private String nombreZoo;
	private Boolean seEncuentraAbierto;
	private Boolean estaLimpio;
	private List<Animal> animales;
	private List<Persona> personas;
	private List<Estructura> estructuras;
	private LocalTime horarioZoo;
	private List<RegistroAlimentacion> registrosDeAlimentacion;

	public Zoologico(String nombreZoo) {
		this.nombreZoo = nombreZoo;
		this.estaLimpio = true;
		this.seEncuentraAbierto = true;
		this.animales = new ArrayList<>();
		this.personas = new ArrayList<>();
		this.estructuras = new ArrayList<>();
		this.horarioZoo = LocalTime.of(18, 00);
		this.registrosDeAlimentacion = new ArrayList<>();

	}

	public LocalTime getHorarioZoo() {
		return horarioZoo;
	}

	public void setHorarioZoo(LocalTime horarioZoo) {
		this.horarioZoo = horarioZoo;
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

	
	/*
	 * aplico directamente en este metodo agregar el lanzamiento de la excepcion
	 * para tratarla luego en el test dado asi, el metodo encontrar nos podria
	 * devolver un null ya que en la vida cotidiana podemos buscar algo y no
	 * encontrarlo si lo pensamos de esa manera
	 */

	@Override
	public Boolean agregarAnimalAlZoo(Animal animal) throws NoSePudoAgregarAnimalInexistenteException {

		if (animal != null) {
			return animales.add(animal);
		}

		throw new NoSePudoAgregarAnimalInexistenteException("el animal ingresado no existe");
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	@Override
	public Boolean agregarPersonaAlZoo(Persona persona) throws NoSePuedenAgregarMenoresDeEdadException {

		if (persona == null) {
			throw new NoSePudoAgregarPersonaInexistenteException("la persona ingresado no existe");
		}

		if (persona.getEdad() < 18) {
			throw new NoSePuedenAgregarMenoresDeEdadException(
					"No se pueden agregar personas menores de edad al zoológico");
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
	public Boolean agregarEstructuraAlZoo(Estructura estructura) throws NoSePudoAgregarEstructuraInexistenteExcepcion {

		if (estructura != null) {
			return estructuras.add(estructura);
		}
		throw new NoSePudoAgregarEstructuraInexistenteExcepcion("la estructura ingresada no existe");
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

	@Override
	public List<Animal> obtenerLosAnimalesConTipoAlimentacionOmnivora() {

		List<Animal> listaAuxiliar = new ArrayList<>();
		for (Animal animal : animales) {
			if (animal.getTipoAlimentacion().equals(TipoAlimentacion.OMNIVORO)) {
				listaAuxiliar.add(animal);
			}
		}


		return listaAuxiliar;
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

	public Animal obtenerAnimalDeUnHabitat(Animal animal, Estructura habitat)
			throws NoExisteObjetoDondeSeBuscaException {

		if (habitat instanceof Habitat) {
			Habitat habitatVerificado = (Habitat) habitat;
			return habitatVerificado.obtenerAnimal(animal);
		}

		return null;
	}

	public Animal obtenerAnimalDeUnHabitatPorCodigo(Integer codigo, Estructura habitat)
			throws NoExisteObjetoDondeSeBuscaException {
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
			Integer idCria, String nombreCria)
			throws EspecieDiferenteException, HabitatLlenoException, ProgenitoresDelMismoSexoException,
			ProgenitoresEnDistintoHabitatException, NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {

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
	public List<Animal> obtenerLosAnimalesConTipoAlimentacionCarnivora() {

		List<Animal> listaAuxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getTipoAlimentacion().equals(TipoAlimentacion.CARNIVORO)) {
				listaAuxiliar.add(animal);
			}
		}

		return listaAuxiliar;
	}

	@Override
	public List<Animal> obtenerLosAnimalesConTipoAlimentacionHerbivora() {

		List<Animal> listaAuxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getTipoAlimentacion().equals(TipoAlimentacion.HERBIVORO)) {
				listaAuxiliar.add(animal);
			}
		}

		return listaAuxiliar;
	}

	@Override
	public List<Animal> obtenerALosAnimalesConTemperaturaNeutral() {

		List<Animal> auxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getTemperaturaAnimal() == 36.1) {
				auxiliar.add(animal);
			}
		}
		return auxiliar;
	}

	@Override
	public List<Animal> obtenerALosAnimalesEnfermosPorTemperaturaBaja() {

		List<Animal> auxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getTemperaturaAnimal() >= 38.0) {
				animal.setEstaEnfermo(true);
				auxiliar.add(animal);
			}
		}

		return auxiliar;
	}

	@Override
	public Persona encontrarSiExisteLaPersonaEnElZoo(Persona personal) {

		Persona existente = null;
		if (personal != null) {
			for (Persona p : personas) {
				if (p.equals(personal)) {
					existente = personal;
				}

			}
		}

		return existente;
	}

	@Override
	public Estructura encontrarSiExisteLaEstructuraEnElZoo(Estructura estructura) throws NullPointerException {

		Estructura existente = null;
		if (estructura != null) {
			for (Estructura e : estructuras) {
				if (e.equals(estructura)) {
					existente = estructura;
				}

			}
		}

		return existente;
	}


//		if (this.encontrarSiExisteLaEstructuraEnElZoo(estructura) != null
//				&& this.encontrarSiExisteLaPersonaEnElZoo(personal) != null) {
//			if (estructura instanceof HospitalVeterinario && personal instanceof Veterinario) {
//				((HospitalVeterinario) estructura).agregarVeterinarioAlHospital(personal);
//				return true;
//			}
//			
//		} es del metodo de abajo

	@Override
	public Boolean agregarUnVeterinarioAUnHospital(Estructura estructura, Persona personal)
			throws NoSePudoAgregarAlVeterinarioAlHospitalException, NoSePudoAgregarEstructuraInexistenteExcepcion,
			NoSePudoAgregarPersonaInexistenteException {

		if (this.encontrarSiExisteLaEstructuraEnElZoo(estructura) == null) {
			throw new NoSePudoAgregarEstructuraInexistenteExcepcion("El hospital no existe en el zoológico");
		}

		if (this.encontrarSiExisteLaPersonaEnElZoo(personal) == null) {
			throw new NoSePudoAgregarPersonaInexistenteException("El veterinario no existe en el zoológico");
		}

		if (!(estructura instanceof HospitalVeterinario)) {
			throw new NoSePudoAgregarAlVeterinarioAlHospitalException("La estructura no es un hospital veterinario");
		}

		if (!(personal instanceof Veterinario)) {
			throw new NoSePudoAgregarAlVeterinarioAlHospitalException("La persona no es un veterinario");
		}

		try {
			((HospitalVeterinario) estructura).agregarVeterinarioAlHospital(personal);
		} catch (VeterinarioNuloExcepcion e) {
			e.getMessage();
		}
		return true;
	}

	@Override
	public Boolean estanDormidosLosAnimales() {

		Boolean dormidos = false;
		LocalTime horarioDeDormir = LocalTime.of(20, 00);
		LocalTime horarioDeDespertar = LocalTime.of(8, 00);
		if (this.getHorarioZoo().isAfter(horarioDeDormir) || this.getHorarioZoo().equals(horarioDeDormir)
				|| this.getHorarioZoo().isBefore(horarioDeDespertar)) {
			for (Animal animal : animales) {
				animal.dormir(true);
				dormidos = true;
			}

		} else {
			for (Animal animal : animales) {
				animal.dormir(false);
				dormidos = false;
			}
		}
		return dormidos;

	}

	@Override
	public RegistroAlimentacion cargarAlimentacion(Persona personal, Animal animal, Comida comida,
			Integer cantidadComida) throws NoFueCreadoElRegistroExcepcion, NoSePudoAgregarPersonalInvalidoExcepcion,
			NoSePudoAgregarAnimalInexistenteException, NoSePudoAgregarPersonaInexistenteException,
			NoSePudoAlimentarException {
		RegistroAlimentacion registro = null;

		if (this.encontrarSiExisteLaPersonaEnElZoo(personal) == null) {
			throw new NoSePudoAgregarPersonaInexistenteException("El veterinario no existe en el zoológico");
		}

		if (this.encontrarSiExisteElAnimalEnElZoo(animal) == null) {
			throw new NoSePudoAgregarAnimalInexistenteException("El animal no existe en el zoológico");
		}

		if (!(personal instanceof Veterinario)) {
			throw new NoSePudoAgregarPersonalInvalidoExcepcion("No es el personal requerido");
		}

		if (((Veterinario) personal).alimentar(animal, comida, cantidadComida)) {
			registro = new RegistroAlimentacion(personal, animal, comida, cantidadComida);
			registrosDeAlimentacion.add(registro);
			return registro;
		}

		throw new NoFueCreadoElRegistroExcepcion("Cancelacion de registro por nula o mala alimentacion");

	}

	public List<RegistroAlimentacion> getRegistrosDeAlimentacion() {
		return registrosDeAlimentacion;
	}

	public void setRegistrosDeAlimentacion(List<RegistroAlimentacion> registrosDeAlimentacion) {
		this.registrosDeAlimentacion = registrosDeAlimentacion;
	}

	@Override
	public Animal encontrarSiExisteElAnimalEnElZoo(Animal animal) {

		Animal existente = null;
		if (animal != null) {
			for (Animal a : animales) {
				if (a.equals(animal)) {
					existente = animal;
				}

			}
		}

		return existente;
	}

	@Override
	public List<Animal> conocerLosAnimalesAlimentadosPorUnVeterinario(Persona personal) {

		List<Animal> auxiliar = new ArrayList<>();

		for (RegistroAlimentacion registro : registrosDeAlimentacion) {
			if (registro.getPersonal().equals(personal)) {
				auxiliar.add(registro.getAnimal());
			}
		}

		return auxiliar;
	}

	@Override
	public List<Persona> conocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico(Animal animal) {

		List<Persona> auxiliarPersona = new ArrayList<>();

		for (RegistroAlimentacion registro : registrosDeAlimentacion) {
			if (registro.getAnimal().equals(animal)) {
				auxiliarPersona.add(registro.getPersonal());
			}
		}

		return auxiliarPersona;
	}

	@Override
	public List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoPlanta() {

		List<Animal> auxiliarAnimal = new ArrayList<>();

		for (RegistroAlimentacion registro : registrosDeAlimentacion) {
			if (registro.getComida().equals(Comida.PLANTA)) {
				auxiliarAnimal.add(registro.getAnimal());
			}
		}

		return auxiliarAnimal;
	}

	@Override
	public List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoCarne() {

		List<Animal> auxiliarAnimal = new ArrayList<>();

		for (RegistroAlimentacion registro : registrosDeAlimentacion) {
			if (registro.getComida().equals(Comida.CARNE)) {
				auxiliarAnimal.add(registro.getAnimal());
			}
		}

		return auxiliarAnimal;
	}

	@Override
	public List<Animal> obtenerALosAnimalesEnfermosPorAlimentacionIncorrecta() {

		List<Animal> auxiliarAnimalEnfermo = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getEstaEnfermo() == true && animal.getAlimentacionInapropiada() == true) {
				auxiliarAnimalEnfermo.add(animal);
			}
		}

		return auxiliarAnimalEnfermo;
	}

	@Override
	public List<RegistroAlimentacion> conocerLosRegistrosQueContenganUnAnimalEspecifico(Animal animal) {

		List<RegistroAlimentacion> auxiliarRegistro = new ArrayList<>();

		for (RegistroAlimentacion registro : registrosDeAlimentacion) {
			if (registro.getAnimal().equals(animal)) {
				auxiliarRegistro.add(registro);
			}
		}

		return auxiliarRegistro;
	}

	@Override
	public Boolean agregarUnVeterinarioAUnHospital(Estructura hospital, Persona veterinario)
			throws NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {

		this.obtenerEstructura(hospital);
		this.obtenerPersona(veterinario);

		if (!(veterinario instanceof Veterinario) || !(hospital instanceof HospitalVeterinario)) {
			throw new InstanciaIncorrectaException(
					"Al menos uno de los objetos ingresados por parámetro es de una instancia incorrecta");

		}

		
		agregado = ((HospitalVeterinario) hospital).agregarVeterinarioAlHospital(veterinario);	
		

		return agregado;
	}

	public RegistroTratamiento queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(Estructura hospital,
			Persona veterinario, Animal animal, Estructura habitat)
			throws EspecieDiferenteException, HabitatLlenoException, NoExisteObjetoDondeSeBuscaException,
			InstanciaIncorrectaException, EstadoDelObjetoEsIncorrectoException {

		this.obtenerEstructura(hospital);
		this.obtenerPersona(veterinario);
		this.obtenerAnimal(animal);
		this.obtenerEstructura(habitat);

		if (!(veterinario instanceof Veterinario) || !(hospital instanceof HospitalVeterinario)
				|| !(habitat instanceof Habitat)) {
			throw new InstanciaIncorrectaException(
					"Al menos uno de los objetos ingresados por parámetro es de una instancia incorrecta");

		}

		if (obtenerVeterinarioDeUnHospital(veterinario, hospital) == null) {
			throw new NoExisteObjetoDondeSeBuscaException("El veterinario no existe en ese hospital");
		}

		if (!animal.getEstaEnfermo()) {
			throw new EstadoDelObjetoEsIncorrectoException("El animal no puede ser tratado porque ya está sano");
		}

		this.retirarAnimalDeSuHabitat(animal, habitat);

		animal.setEstaEnfermo(false);
		RegistroTratamiento registro = new RegistroTratamiento(veterinario, animal);

		HospitalVeterinario hospitalNuevo = (HospitalVeterinario) hospital;
		hospitalNuevo.añadirRegistro(registro);

		this.agregarAnimalAlHabitat(animal, habitat);

		return registro;

	}

	private void retirarAnimalDeSuHabitat(Animal animal, Estructura habitat)
			throws NoExisteObjetoDondeSeBuscaException {
		Habitat habitatNuevo = (Habitat) this.obtenerEstructura(habitat);
		habitatNuevo.getAnimales().remove(animal);
	}

	public Veterinario obtenerVeterinarioDeUnHospital(Persona veterinario, Estructura hospital)
			throws NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {

		this.obtenerPersona(veterinario);
		this.obtenerEstructura(hospital);

		if (!(hospital instanceof HospitalVeterinario)) {
			throw new InstanciaIncorrectaException("La estructura ingresada no es un hospital veterinario");
		}

		HospitalVeterinario hospitalVerificado = (HospitalVeterinario) hospital;
		return hospitalVerificado.obtenerVeterinario(veterinario);

	}

	public List<Animal> obtenerLosAnimalesQueAtendioUnVeterinarioEnUnHospital(Persona veterinario, Estructura hospital)
			throws NoExisteObjetoDondeSeBuscaException, InstanciaIncorrectaException {

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

}
