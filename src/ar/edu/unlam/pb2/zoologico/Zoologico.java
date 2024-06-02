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
	private Double saldoRecaudado = 0.0;
	private List<RegistroVisitaInstalacionComun> registrosVisitasInstalacionesComunes;
	private List<RegistroVisitaHabitatAnimal> registrosVisitasHabitatsAnimales;

	public Zoologico(String nombreZoo) {
		this.nombreZoo = nombreZoo;
		this.estaLimpio = true;
		this.seEncuentraAbierto = true;
		this.animales = new ArrayList<>();
		this.personas = new ArrayList<>();
		this.estructuras = new ArrayList<>();
		this.registrosVisitasInstalacionesComunes = new ArrayList<>();
		this.registrosVisitasHabitatsAnimales = new ArrayList<>();

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
				personaAgregada = this.agregarVisitante((Visitante) persona);
			} else {
				personaAgregada = personas.add(persona);
			}
		}
		return personaAgregada;
	}

	private Boolean agregarVisitante(Visitante visitante) {
		Boolean visitanteAgregado = false;
		if (visitante.getDineroQueDispone() >= Boleto.getValor()) {
			asignarBoleto(visitante);
			saldoRecaudado += Boleto.getValor();
			visitanteAgregado = personas.add(visitante);
		}
		return visitanteAgregado;
	}

	private void asignarBoleto(Visitante visitante) {
		if (visitante.getBoleto() == null) {
			visitante.setBoleto(new Boleto());
		}

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

	@Override
	public Boolean agregarVariosVisitantes(List<Persona> visitantesAIngresar) {
		Visitante visitante = null;
		if (this.sonTodosInstanciaDeVisitante(visitantesAIngresar)) {
			if (this.verificarQueAlMenosUnoSeaMayorDeEdad(visitantesAIngresar)
					&& this.verificarQueTenganLaPlataSuficiente(visitantesAIngresar)) {
				for (Persona persona : visitantesAIngresar) {
					visitante = (Visitante) persona;
					asignarBoleto(visitante);
				}
				saldoRecaudado += (Boleto.getValor() * visitantesAIngresar.size());
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

	private boolean verificarQueTenganLaPlataSuficiente(List<Persona> visitantesAIngresar) {
		Double dineroTotal = 0.0;
		Visitante visitante = null;
		for (Persona persona : visitantesAIngresar) {
			visitante = (Visitante) persona;
			dineroTotal += visitante.getDineroQueDispone();
		}
		Double dineroNecesario = Boleto.getValor() * visitantesAIngresar.size();
		if (dineroTotal >= dineroNecesario) {
			return true;
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

	public Double obtenerRecaudacion() {
		return this.saldoRecaudado;
	}

	public RegistroVisitaInstalacionComun registrarVisitaDeUnVisitanteAUnaInstalacionComun(Persona visitante,
			Estructura instalacionComun) {
		if (visitante instanceof Visitante) {
			if (((Visitante) visitante).getBoleto() != null) {
				RegistroVisitaInstalacionComun registro = new RegistroVisitaInstalacionComun(visitante,
						instalacionComun);
				registrosVisitasInstalacionesComunes.add(registro);
				return registro;
			}
		}
		return null;
	}

	public List<RegistroVisitaInstalacionComun> obtenerRegistrosVisitasInstalacionesComunes() {
		return registrosVisitasInstalacionesComunes;
	}

	public void setRegistrosVisitas(List<RegistroVisitaInstalacionComun> registrosVisitas) {
		this.registrosVisitasInstalacionesComunes = registrosVisitas;
	}

	public Boolean agregarAnimalAlHabitat(Animal animal, Estructura habitat) {
		this.obtenerAnimal(animal);
		this.obtenerEstructura(habitat);

		Habitat habitatVerificado = (Habitat) habitat;
		return habitatVerificado.agregarAnimal(animal);
	}

	public Estructura obtenerEstructura(Estructura estructuraBuscada) {
		for (Estructura estructura : estructuras) {
			if (estructura.equals(estructuraBuscada)) {
				return estructura;
			}
		}
		return null;
	}

	public Animal obtenerAnimal(Animal animalBuscado) {
		for (Animal animal : animales) {
			if (animal.equals(animalBuscado)) {
				return animal;
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

	public RegistroVisitaHabitatAnimal registrarVisitaDeUnVisitanteAUnHabitat(Persona visitante, Estructura habitat) {
		if (visitante instanceof Visitante) {
			if (((Visitante) visitante).getBoleto() != null && ((Habitat)habitat).getAnimales()!=null) {
				RegistroVisitaHabitatAnimal registro = new RegistroVisitaHabitatAnimal(visitante, habitat);
				registrosVisitasHabitatsAnimales.add(registro);
				return registro;
			}
		}
		return null;
	}

	public List<RegistroVisitaHabitatAnimal> obtenerRegistrosVisitasHabitatsAnimal() {
		return registrosVisitasHabitatsAnimales;
	}

	public void setRegistrosVisitasHabitatsAnimales(List<RegistroVisitaHabitatAnimal> registrosVisitasHabitatsAnimales) {
		this.registrosVisitasHabitatsAnimales = registrosVisitasHabitatsAnimales;
	}
	

}
