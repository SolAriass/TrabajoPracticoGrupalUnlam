package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.ArrayList;

public class HospitalVeterinario extends Estructura {
	
	private List <Veterinario> veterinarios;

	public HospitalVeterinario(Integer codigoEstructural, String nombreEstructura) {
		super(codigoEstructural, nombreEstructura);
		this.veterinarios = new ArrayList<>();
	}

	public Boolean agregarVeterinarioAlHospital(Personal personal) {
		Boolean agregado = false;
		
		if(personal != null) {
			veterinarios.add((Veterinario) personal);
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


	
	

}
