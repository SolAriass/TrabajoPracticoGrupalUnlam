package ar.edu.unlam.pb2.zoologico;

import java.util.Objects;

public class MantenimientoEstructura {

	private Persona mantenimiento;
	private Estructura estructura;
	
	public MantenimientoEstructura(Persona mantenimiento, Estructura estructura) {
		super();
		this.mantenimiento = mantenimiento;
		this.estructura = estructura;
	}

	public Persona getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(Persona mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public Estructura getEstructura() {
		return estructura;
	}

	public void setEstructura(Estructura estructura) {
		this.estructura = estructura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estructura, mantenimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MantenimientoEstructura other = (MantenimientoEstructura) obj;
		return Objects.equals(estructura, other.estructura) && Objects.equals(mantenimiento, other.mantenimiento);
	}
	
	
	
}
