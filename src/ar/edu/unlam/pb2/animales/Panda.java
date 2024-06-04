package ar.edu.unlam.pb2.animales;

import ar.edu.unlam.pb2.zoologico.Animal;
import ar.edu.unlam.pb2.enums.*;

public class Panda extends Animal {

	public Panda(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		
	}

    @Override
    public Animal crearCria(Integer idCria, String nombreCria, TipoSexo sexo) {
        return new Panda(idCria, nombreCria, 0, 1.5, this.getTipoAlimentacion(), sexo, this.getCategoriaAnimal());
    }


    @Override
    public String emitirSonido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emitirSonido'");
    }


    @Override
    public String movimiento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'movimiento'");
    }

    
    
}


