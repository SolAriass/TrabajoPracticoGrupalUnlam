package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.ArrayList;

public class Zoologico implements IZoologico {

	private String nombreZoo;
	private Boolean seEncuentraAbierto;
	private Boolean estaLimpio;
	private static Double precioEntrada;
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
		precioEntrada = 2500.0;
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
		
		if(persona.getEdad()>= 18) {
			if (persona instanceof Visitante) {
				personaAgregada = this.agregarVisitante((Visitante) persona);
			}else {
				personaAgregada = personas.add(persona);
			}
		}
		return personaAgregada;
	}

	private Boolean agregarVisitante(Visitante visitante) {
		Boolean visitanteAgregado =false;
		Boleto boleto = new Boleto();
		if (visitante.getDineroQueDispone()>=boleto.getValor()) {
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

//	public Boolean comprarEntrada(Persona visitante) {
//		Boolean visitanteCompro=false;
//		if (visitante.getEdad()>= 18 && visitante.getDineroQueDispone()>= getPrecioEntrada()) {
//			
//		}
//		return visitanteCompro;
//	}


	public static Double getPrecioEntrada() {
		return precioEntrada;
	}

	public static void setPrecioEntrada(Double precioEntrada) {
		Zoologico.precioEntrada = precioEntrada;
	}

}
