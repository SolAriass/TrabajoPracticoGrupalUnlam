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

    public Boolean agregarVeterinarioAlHospital(Persona personal) {
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

    public List<RegistroTratamiento> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroTratamiento> registros) {
        this.registros = registros;
    }

	public void añadirRegistro(RegistroTratamiento registro) {
		registros.add(registro);
	}
  

    
} 