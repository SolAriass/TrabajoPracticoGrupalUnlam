package ar.edu.unlam.pb2.zoologico;

import java.util.Objects;

public class Animal {

	private Integer codigoDeReconocimiento;
	private Integer edad;
	private Habitat habitat;

	public Animal(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {

		this.codigoDeReconocimiento = codigoDeReconocimiento;
		this.edad = edad;
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

	public Integer getCodigoDeReconocimiento() {
		return codigoDeReconocimiento;
	}

	public void setCodigoDeReconocimiento(Integer codigoDeReconocimiento) {
		this.codigoDeReconocimiento = codigoDeReconocimiento;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public Habitat getHabitat() {
		return this.habitat;
	}

	public void setHabitat(Estructura habitat) {
		this.habitat = (Habitat) habitat;
	}

}
