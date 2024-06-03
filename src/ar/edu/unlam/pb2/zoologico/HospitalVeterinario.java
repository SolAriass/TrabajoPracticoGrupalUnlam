package ar.edu.unlam.pb2.zoologico;

public class HospitalVeterinario extends Estructura {

	public HospitalVeterinario(Integer codigoEstructural, String nombreEstructura) {
		super(codigoEstructural, nombreEstructura);
	}


<<<<<<< HEAD
	public List<Veterinario> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(List<Veterinario> veterinarios) {
		this.veterinarios = veterinarios;
	}

	public List<RegistroTratamiento> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroTratamiento> registros) {
		this.registros = registros;
	}

	public void añadirRegistro(RegistroTratamiento registro) {
		registros.add(registro);
	}

	public List<Animal> obtenerAnimalesAtendidosPorUnVeterinario(Persona veterinario) {
=======
>>>>>>> 0263159f657eda04ccc7d11ea375316280a94015

		List<Animal> auxiliar = new ArrayList<>();
		
		for (RegistroTratamiento registroTratamiento : registros) {
			if (registroTratamiento.getVeterinario().equals(veterinario)) {
				auxiliar.add(registroTratamiento.getAnimal());
			}
		}
		
		return auxiliar;
		
	}

	public List<Persona> obtenerVeterinariosQueAtendieronUnAnimal(Animal animal) {
		
		List<Persona> auxiliar = new ArrayList<>();
		
		for (RegistroTratamiento registroTratamiento : registros) {
			if (registroTratamiento.getAnimal().equals(animal)) {
				auxiliar.add(registroTratamiento.getVeterinario());
			}
		}
		
		return auxiliar;
	}

	public Veterinario obtenerVeterinario(Persona veterinario) {
		
		for (Veterinario veterinarioDelMomento : veterinarios) {
			if (veterinarioDelMomento.equals(veterinario)) {
				return veterinarioDelMomento;
			}
		}
		
		return null;

	}
  

    
} 