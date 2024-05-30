package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.ArrayList;

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
	public Boolean agregarPersonaAlZoo(Persona persona) {

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

	public Boolean agregarVariosVisitantes(List<Persona> visitantesAIngresar) {
		
		if (this.sonTodosInstanciaDeVisitante(visitantesAIngresar)) {
			if (this.verificarQueAlMenosUnoSeaMayorDeEdad(visitantesAIngresar)
					&& this.verificarQueTodosTenganLaPlataSuficiente(visitantesAIngresar)) {
				return personas.addAll(visitantesAIngresar);
			}	
		}		
		
		return false;
	}

	private Boolean sonTodosInstanciaDeVisitante(List<Persona> visitantesAIngresar) {
		
	    for (Persona persona : visitantesAIngresar) {
	        if (!(persona instanceof Visitante)) {
	            return false;
	        }
	    }
	    return true;
	}

	private boolean verificarQueTodosTenganLaPlataSuficiente(List<Persona> visitantesAIngresar) {
        Double dineroTotal = 0.0;
        for (Persona persona : visitantesAIngresar) {

        }
        return false;
    }
	
	private boolean verificarQueAlMenosUnoSeaMayorDeEdad(List<Persona> visitantesAIngresar) {
        for (Persona persona : visitantesAIngresar) {
            if (persona.getEdad() >= 18) {
                return true;
            }
        }
        return false;
    }
	
	@Override
    public Boolean agregarUnVeterinarioAUnHospital(Estructura estructura, Persona personal) {

        Boolean agregado = false;
        if (this.obtenerEstructura(estructura) != null
                && this.encontrarSiExisteLaPersonaEnElZoo(personal) != null) {
            if (estructura instanceof HospitalVeterinario && personal instanceof Veterinario) {
                ((HospitalVeterinario) estructura).agregarVeterinarioAlHospital(personal);
                agregado = true;
            }
        }

        return agregado;
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

	public RegistroTratamiento queUnVeterinarioTrateAUnAnimalEnfermoEnUnHospital(Estructura hospital,
			Persona veterinario, Animal animal, Estructura habitat) {
		
		if (obtenerVeterinarioDeUnHospital(veterinario, hospital) != null && this.animales.contains(animal) && this.estructuras.contains(habitat)) {
			if (animal.getEstaEnfermo()) {
				
				this.retirarAnimalDeSuHabitat(animal, habitat);
				
				animal.setEstaEnfermo(false);
				RegistroTratamiento registro = new RegistroTratamiento(veterinario, animal);
				
				HospitalVeterinario hospitalNuevo = (HospitalVeterinario) hospital;
				hospitalNuevo.añadirRegistro(registro);
				
				this.agregarAnimalAlHabitat(animal, habitat);
				
				return registro;
			}
		}
		
		return null;
	}

	private void retirarAnimalDeSuHabitat(Animal animal, Estructura habitat) {
		Habitat habitatNuevo = (Habitat) this.obtenerEstructura(habitat);
		habitatNuevo.getAnimales().remove(animal);
	}

	public Veterinario obtenerVeterinarioDeUnHospital(Persona veterinario, Estructura hospital) {
		if (this.estructuras.contains(hospital) && hospital instanceof HospitalVeterinario && veterinario instanceof Veterinario) {
			HospitalVeterinario hospitalVerificado = (HospitalVeterinario) hospital;
			for (Veterinario veterinarioDelMomento : hospitalVerificado.getVeterinarios()) {
				if (veterinarioDelMomento.equals(veterinario)) {
					return veterinarioDelMomento;
				}
			}
		}

		return null;
	}

}
