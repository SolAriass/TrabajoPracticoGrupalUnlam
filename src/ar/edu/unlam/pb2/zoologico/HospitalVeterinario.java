package ar.edu.unlam.pb2.zoologico;

import java.util.ArrayList;
import java.util.List;

public class HospitalVeterinario extends Estructura {

    private List <Veterinario> veterinarios;
    private List <RegistroTratamiento> registros;

    public HospitalVeterinario(Integer codigoEstructural, String nombreEstructura) {
        super(codigoEstructural, nombreEstructura);
        this.veterinarios = new ArrayList<>();
        this.registros = new ArrayList<>();
    }

    public Boolean agregarVeterinarioAlHospital(Persona veterinario) {
        Boolean agregado = false;

        if(veterinario != null) {
            veterinarios.add((Veterinario) veterinario);
            agregado = true;
        }

        return agregado;

    }

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