package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.ArrayList;

public class HospitalVeterinario extends Estructura {
	
	private List <Veterinario> veterinarios;
	private List <RegistroTratamiento> registros;

	public HospitalVeterinario(Integer codigoEstructural, String nombreEstructura) {
		super(codigoEstructural, nombreEstructura);
		this.veterinarios = new ArrayList<>();
		this.registros = new ArrayList<>();
	}

	public Boolean agregarVeterinarioAlHospital(Persona personal) throws VeterinarioNuloExcepcion {
		
		if(personal != null && personal instanceof Veterinario) {
			veterinarios.add((Veterinario) personal);
		}
		
		throw new VeterinarioNuloExcepcion("El veterinario es invalido");
		
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

	
	

	
	

}
