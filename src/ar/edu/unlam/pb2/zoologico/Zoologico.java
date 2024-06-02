package ar.edu.unlam.pb2.zoologico;

import java.util.List;

import ar.edu.unlam.pb2.enums.CategoriaAnimal;
import ar.edu.unlam.pb2.enums.TipoSexo;

import java.util.ArrayList;

public class Zoologico implements IZoologico {

	private String nombreZoo;
	private Boolean seEncuentraAbierto;
	private Boolean estaLimpio;
	private List<Animal> animales;
	private List<Persona> personas;
	private List<Estructura> estructuras;
	private List<MantenimientoEstructura> mantenimientoEstructura;

	public Zoologico(String nombreZoo) {
		this.nombreZoo = nombreZoo;
		this.estaLimpio = true;
		this.seEncuentraAbierto = true;
		this.animales = new ArrayList<>();
		this.personas = new ArrayList<>();
		this.estructuras = new ArrayList<>();
		this.mantenimientoEstructura = new ArrayList<>();
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
	public Boolean agregarPersonalAlZoo(Persona persona) {
		return personas.add(persona);
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

	public List<MantenimientoEstructura> getMantenimientoEstructura() {
		return mantenimientoEstructura;
	}

	public void setMantenimientoEstructura(List<MantenimientoEstructura> mantenimientoEstructura) {
		this.mantenimientoEstructura = mantenimientoEstructura;
	}

	public Boolean agregarMantenimientoEstructura(MantenimientoEstructura mantenimietoEstructura) {
		return this.mantenimientoEstructura.add(mantenimietoEstructura);
	}

	public Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat) {

		if (habitat instanceof Habitat && animales.contains(animal) && estructuras.contains(habitat)) {
			Habitat habitatVerificado = (Habitat) habitat;
			return habitatVerificado.agregarAnimal(animal);
		}

		return false;
	}

	public Animal obtenerAnimal(Animal animalBuscado) {

		for (Animal animal : animales) {
			if (animal.equals(animalBuscado)) {
				return animal;
			}
		}

		return null;
	}

	public Estructura obtenerEstructura(Estructura estructuraBuscada) {

		for (Estructura estructura : estructuras) {
			if (estructura.equals(estructuraBuscada)) {
				return estructura;
			}
		}

		return null;
	}

	public Animal obtenerAnimalDeUnHabitat(Animal animal, Estructura habitat) {

		if (habitat instanceof Habitat) {
			Habitat habitatVerificado = (Habitat) habitat;
			return habitatVerificado.obtenerAnimal(animal);
		}

		return null;
	}

	public Animal obtenerAnimalDeUnHabitatPorCodigo(Integer codigo, Estructura habitat) {
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
			Integer idCria, String nombreCria) {

		if (habitat instanceof Habitat && !progenitor1.getTipoSexo().equals(progenitor2.getTipoSexo())
				&& obtenerAnimalDeUnHabitat(progenitor1, habitat) != null
				&& obtenerAnimalDeUnHabitat(progenitor2, habitat) != null) {
			Habitat habitatVerificado = (Habitat) habitat;
			Animal cria = habitatVerificado.reproducirAnimales(progenitor1, progenitor2, idCria, nombreCria);
			this.agregarAnimalAlZoo(cria);
			return this.agregarAnimalAlHabitat(cria, habitatVerificado);
		}

		return false;

	}

	public Boolean puedeArreglarEstructura(Estructura estructura, Persona personalMantenimiento) throws estructuraNoEstaDañadaExcepsion{
		// TODO Auto-generated method stub


		if (personalMantenimiento instanceof Mantenimiento && estructura.getEstaRoto()) {

			for (MantenimientoEstructura mantenimientoEstructura : this.mantenimientoEstructura) {

				if (mantenimientoEstructura.getMantenimiento().equals(personalMantenimiento)) {
					if (mantenimientoEstructura.getEstructura().equals(estructura)) {
						estructura.setEstaRoto(false);
						return true;

					}
				}

			}

		}

//		return false;
		throw new estructuraNoEstaDañadaExcepsion();
	}

	public Boolean queUnEmpleadoDeMantenimientoLimpieElZoologico(Persona personalMantenimiento) throws zoologicoEstaLimpioExcepsion {
		// TODO Auto-generated method stub

		if (personalMantenimiento instanceof Mantenimiento && !this.getEstaLimpio()) {
			this.setEstaLimpio(true);
			return true;
		}

		throw new zoologicoEstaLimpioExcepsion();
	}

	public Boolean queUnEmpleadoQueNoSeaDeMantenimientoLimpieElZoologico(Persona personalMantenimiento,
			Boolean zoologicoEstaLimpio) {
		// TODO Auto-generated method stub

		if (!(personalMantenimiento instanceof Mantenimiento) && !(zoologicoEstaLimpio)) {
			this.setEstaLimpio(true);
			return true;
		}

		return false;
	}

}
