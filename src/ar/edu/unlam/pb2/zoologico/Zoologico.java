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
			visitante.setBoleto(new Boleto());
			visitanteAgregado = personas.add(visitante);
		}
		return visitanteAgregado;
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

	public Boolean agregarVariosVisitantes(List<Persona> visitantesAIngresar) {

		if (this.sonTodosInstanciaDeVisitante(visitantesAIngresar)) {
			if (this.verificarQueAlMenosUnoSeaMayorDeEdad(visitantesAIngresar)
					&& this.verificarQueTenganLaPlataSuficiente(visitantesAIngresar)) {
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

//	private boolean verificarQueTodosTenganLaPlataSuficiente(List<Persona> visitantesAIngresar) {
//		Visitante visitante = null;
//		Boolean tienePlataSuficiente=false;
//		Boleto boleto = new Boleto();
//		for (Persona persona : visitantesAIngresar) {
//			if (persona instanceof Visitante) {
//				visitante = (Visitante) persona;
//				if (visitante.getDineroQueDispone()>=boleto.getValor()) {
//					tienePlataSuficiente=true;
//				}
//			}
//			
//		}
//		return false;
//	}

	private boolean verificarQueAlMenosUnoSeaMayorDeEdad(List<Persona> visitantesAIngresar) {
		for (Persona persona : visitantesAIngresar) {
			if (persona.getEdad() >= 18) {
				return true;
			}
		}
		return false;
	}

}
