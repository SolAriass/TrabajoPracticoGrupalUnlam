package ar.edu.unlam.pb2.zoologico;



public class Animal {
	
	private Integer codigoDeReconocimiento;
	private String nombreAnimal;
	private Integer edad;
	private Double peso;
	private TipoAlimentacion tipoAlimentacion;
	private TipoSexo tipoSexo;
	private CategoriaAnimal categoriaAnimal;
	private Boolean estaEnfermo;
	private Boolean estaDormido;
	

	public Animal(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		this.codigoDeReconocimiento = codigoDeReconocimiento;
		this.nombreAnimal = nombreAnimal;
		this.edad = edad;
		this.peso = peso;
		this.tipoAlimentacion = alimentacion;
		this.tipoSexo = sexo;
		this.categoriaAnimal = clase;
		this.estaEnfermo = false;
		this.estaDormido = false;
		
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


	public Boolean getEstaEnfermo() {
		return estaEnfermo;
	}


	public void setEstaEnfermo(Boolean estaEnfermo) {
		this.estaEnfermo = estaEnfermo;
	}


	public Boolean getEstaDormido() {
		return estaDormido;
	}


	public void setEstaDormido(Boolean estaDormido) {
		this.estaDormido = estaDormido;
	}

	
	
	
}
