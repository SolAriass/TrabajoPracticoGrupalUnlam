package ar.edu.unlam.pb2.zoologico;

import java.util.Objects;

public class Animal {
	
	private Integer codigoDeReconocimiento;

	public Animal(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		
		this.codigoDeReconocimiento = codigoDeReconocimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoDeReconocimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(codigoDeReconocimiento, other.codigoDeReconocimiento);
	}

	public Integer getCodigo() {
		return codigoDeReconocimiento;
	}

	
	
}
