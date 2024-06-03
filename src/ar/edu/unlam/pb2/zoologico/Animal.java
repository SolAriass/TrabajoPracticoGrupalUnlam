package ar.edu.unlam.pb2.zoologico;

<<<<<<< HEAD
public abstract class Animal {
	private Integer codigoDeReconocimiento;
	private String nombreAnimal;
	private Integer edad; 
	private Double peso;
	private TipoAlimentacion tipoAlimentacion;
	private TipoSexo tipoSexo;
	private CategoriaAnimal categoriaAnimal;
	private Boolean estaEnfermo;
	private Boolean estaDormido;
	private Double temperaturaAnimal;
	private Boolean alimentacionInapropiada;
=======
public class Animal {
	
	
	
>>>>>>> 0263159f657eda04ccc7d11ea375316280a94015

	public Animal(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		
		
	}

	
<<<<<<< HEAD
	public Boolean getAlimentacionInapropiada() {
		return alimentacionInapropiada;
	}

	public void setAlimentacionInapropiada(Boolean alimentacionInapropiada) {
		this.alimentacionInapropiada = alimentacionInapropiada;
	}

	public Double getTemperaturaAnimal() {
		return temperaturaAnimal;
	}

	public void setTemperaturaAnimal(Double temperaturaAnimal) {
		this.temperaturaAnimal = temperaturaAnimal;
	}

	public void setEstaEnfermo(Boolean estaEnfermo) {
		this.estaEnfermo = estaEnfermo;
	}
	
	public Boolean getEstaEnfermo() {
		return estaEnfermo;
	}

	
	public TipoAlimentacion getTipoAlimentacion() {
		return tipoAlimentacion;
	}

	public void setTipoAlimentacion(TipoAlimentacion tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}

	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	public CategoriaAnimal getCategoriaAnimal() {
		return categoriaAnimal;
	}

	public void setCategoriaAnimal(CategoriaAnimal categoriaAnimal) {
		this.categoriaAnimal = categoriaAnimal;
	}
	
	public Boolean getEstaDormido() {
		return estaDormido;
	}

	public void dormir(Boolean estaDormido) {
		this.estaDormido = estaDormido;
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

	public String getNombreAnimal() {
		return nombreAnimal;
	}

	public void setNombreAnimal(String nombreAnimal) {
		this.nombreAnimal = nombreAnimal;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public abstract Animal crearCria (Integer idCria, String nombreCria, TipoSexo sexo);
	
	

=======
	
	
>>>>>>> 0263159f657eda04ccc7d11ea375316280a94015
}
