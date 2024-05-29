package ar.edu.unlam.pb2.zoologico;

import java.util.List;

import java.time.LocalTime;
import java.util.ArrayList;

public class Zoologico implements IZoologico{
	
	private String nombreZoo; 
	private Boolean seEncuentraAbierto;
	private Boolean estaLimpio;
	private List<Animal> animales;
	private List<Personal> personas;
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
	public Boolean agregarPersonalAlZoo(Personal persona) {
		return personas.add(persona);
	}




	public List<Personal> getPersonas() {
		return personas;
	}




	public void setPersonas(List<Personal> personas) {
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
	public List<Animal> obtenerALosAnimalesSanos() {
		
		List<Animal> auxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getEstaEnfermo() == false) {
				auxiliar.add(animal);
			}
		}
		return auxiliar;
	}




	@Override
	public List<Animal> obtenerALosAnimalesEnfermos() {
		
		List<Animal> auxiliar = new ArrayList<>();

		for (Animal animal : animales) {
			if (animal.getEstaEnfermo() == true) {
				auxiliar.add(animal);
			}
		}
		
		return auxiliar;
	}

	@Override
	public Personal encontrarSiExisteLaPersonaEnElZoo(Personal personal) {

		Personal existente = null;
		if (personal != null) {
			for (Personal p : personas) {
				if (p.equals(personal)) {
					existente = personal;
				}

			}
		}

		return existente;
	}
	
	
	@Override
	public Estructura encontrarSiExisteLaEstructuraEnElZoo(Estructura estructura) {

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
	public Boolean agregarUnVeterinarioAUnHospital(Estructura estructura, Personal personal) {
	
		Boolean agregado = false;
		if (this.encontrarSiExisteLaEstructuraEnElZoo(estructura) != null
				&& this.encontrarSiExisteLaPersonaEnElZoo(personal) != null) {
			if (estructura instanceof HospitalVeterinario && personal instanceof Veterinario) {
				((HospitalVeterinario) estructura).agregarVeterinarioAlHospital(personal);
				agregado = true;
			}
		}
		
		
		return agregado;
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
	public RegistroAlimentacion cargarAlimentacion(Personal personal, Animal animal, Comida comida, Integer cantidadComida) {
		RegistroAlimentacion registro = null;
		
		if(this.encontrarSiExisteLaPersonaEnElZoo(personal) != null && this.encontrarSiExisteElAnimalEnElZoo(animal) != null 
				&& personal instanceof Veterinario) {
			if(((Veterinario) personal).alimentar(animal, comida, cantidadComida) == true) {
				registro = new RegistroAlimentacion(personal, animal, comida, cantidadComida);
				registrosDeAlimentacion.add(registro);	
			}	
		}
		
		return registro;
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
	public List<Animal> conocerLosAnimalesAlimentadosPorUnVeterinario(Personal personal) {

		List <Animal> auxiliar = new ArrayList<>();
		
		for(RegistroAlimentacion registro : registrosDeAlimentacion) {
			if(registro.getPersonal().equals(personal)) {
				auxiliar.add(registro.getAnimal());
			}
		}
		
		
		
		return auxiliar;
	}





	@Override
	public List<Personal> conocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico(Animal animal) {
		
		List <Personal> auxiliar = new ArrayList<>();
		
		for(RegistroAlimentacion registro : registrosDeAlimentacion) {
			if(registro.getAnimal().equals(animal)) {
				auxiliar.add(registro.getPersonal());
			}
		}
		
		
		return auxiliar;
	}





	@Override
	public List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoPlanta() {
		
		List <Animal> auxiliar = new ArrayList<>();
		
		for(RegistroAlimentacion registro : registrosDeAlimentacion) {
			if(registro.getComida().equals(Comida.PLANTA)) {
				auxiliar.add(registro.getAnimal());
			}
		}
		
		
		
		return auxiliar;
	}





	@Override
	public List<Animal> conocerALosAnimalesQueConsumieronComidaDeTipoCarne() {
		
		List <Animal> auxiliar = new ArrayList<>();
		
		for(RegistroAlimentacion registro : registrosDeAlimentacion) {
			if(registro.getComida().equals(Comida.CARNE)) {
				auxiliar.add(registro.getAnimal());
			}
		}
		
		
		return auxiliar;
	}





	










	
	
	
	
	
	
	
	
	
}
