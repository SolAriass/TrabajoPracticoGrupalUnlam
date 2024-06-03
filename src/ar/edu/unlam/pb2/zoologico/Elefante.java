package ar.edu.unlam.pb2.zoologico;

public class Elefante extends Animal {

	public Elefante(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		// TODO Auto-generated constructor stub
	}

	@Override
    public Animal crearCria(Integer idCria, String nombreCria, TipoSexo sexo) {
        return new Elefante(idCria, nombreCria, 0, 1.5, this.getTipoAlimentacion(), sexo, this.getCategoriaAnimal());
    }

}
