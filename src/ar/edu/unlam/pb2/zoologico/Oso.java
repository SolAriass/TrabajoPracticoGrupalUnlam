package ar.edu.unlam.pb2.zoologico;

public class Oso extends Animal {

	public Oso(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);

	}

	@Override
    public Animal crearCria(Integer idCria, String nombreCria, TipoSexo sexo) {
        return new Oso(idCria, nombreCria, 0, 1.5, this.getTipoAlimentacion(), sexo, this.getCategoriaAnimal());
    }

}
