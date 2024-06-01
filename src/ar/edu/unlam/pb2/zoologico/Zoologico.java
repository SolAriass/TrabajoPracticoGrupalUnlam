package ar.edu.unlam.pb2.zoologico;

import java.util.List;

import java.time.LocalTime;
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
	public Boolean agregarPersonalAlZoo(Persona persona) throws NoSePudoAgregarPersonaInexistenteException {

		if (persona != null) {
			return personas.add(persona);
		}
		throw new NoSePudoAgregarPersonaInexistenteException("la persona ingresado no existe");
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

	@Override
	public Boolean agregarUnVeterinarioAUnHospital(Estructura estructura, Persona personal)
			throws NoSePudoAgregarAlVeterinarioAlHospitalException, NoSePudoAgregarEstructuraInexistenteExcepcion,
			NoSePudoAgregarPersonaInexistenteException {

//		if (this.encontrarSiExisteLaEstructuraEnElZoo(estructura) != null
//				&& this.encontrarSiExisteLaPersonaEnElZoo(personal) != null) {
//			if (estructura instanceof HospitalVeterinario && personal instanceof Veterinario) {
//				((HospitalVeterinario) estructura).agregarVeterinarioAlHospital(personal);
//				return true;
//			}
//			
//		}

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

		List<Persona> auxiliar = new ArrayList<>();

		for (RegistroAlimentacion registro : registrosDeAlimentacion) {
			if (registro.getAnimal().equals(animal)) {
				auxiliar.add(registro.getPersonal());
			}
		}

		return auxiliar;
	}

	@Override
	public List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoPlanta() {

		List<Animal> auxiliar = new ArrayList<>();

		for (RegistroAlimentacion registro : registrosDeAlimentacion) {
			if (registro.getComida().equals(Comida.PLANTA)) {
				auxiliar.add(registro.getAnimal());
			}
		}

		return auxiliar;
	}

	@Override
	public List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoCarne() {

		List<Animal> auxiliar = new ArrayList<>();

		for (RegistroAlimentacion registro : registrosDeAlimentacion) {
			if (registro.getComida().equals(Comida.CARNE)) {
				auxiliar.add(registro.getAnimal());
			}
		}

		return auxiliar;
	}

	@Override
	public List<Animal> obtenerALosAnimalesEnfermosPorAlimentacionIncorrecta() {

		List<Animal> auxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getEstaEnfermo() == true && animal.getAlimentacionInapropiada() == true) {
				auxiliar.add(animal);
			}
		}

		return auxiliar;
	}

}
