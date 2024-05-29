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
	}

	public CategoriaAnimal getCategoriaAnimal() {
		return categoriaAnimal;
	}

	public void setCategoriaAnimal(CategoriaAnimal categoriaAnimal) {
		this.categoriaAnimal = categoriaAnimal;
	}

	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}
	
	

}
