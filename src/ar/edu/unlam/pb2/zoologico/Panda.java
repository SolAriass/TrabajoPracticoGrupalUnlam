package ar.edu.unlam.pb2.zoologico;

public class Panda extends Animal {

	public Panda(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		
	}


    @Override
    public Animal crearCria(Integer idCria, String nombreCria, TipoSexo sexo) {
        return new Panda(idCria, nombreCria, 0, 1.5, this.getTipoAlimentacion(), sexo, this.getCategoriaAnimal());
    }

    
    
}


