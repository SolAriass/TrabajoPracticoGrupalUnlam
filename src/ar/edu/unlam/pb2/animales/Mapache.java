package ar.edu.unlam.pb2.animales;

import ar.edu.unlam.pb2.enums.CategoriaAnimal;
import ar.edu.unlam.pb2.enums.TipoAlimentacion;
import ar.edu.unlam.pb2.enums.TipoSexo;
import ar.edu.unlam.pb2.zoologico.Animal;

public class Mapache extends Animal {

	public Mapache(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		// TODO Auto-generated constructor stub
	}

	@Override
    public Animal crearCria(Integer idCria, String nombreCria, TipoSexo sexo) {
        return new Mapache(idCria, nombreCria, 0, 1.5, this.getTipoAlimentacion(), sexo, this.getCategoriaAnimal());
    }

	@Override
	public String emitirSonido() {
		// TODO Auto-generated method stub
		return "chi chi chi";
	}

	@Override
	public String movimiento() {
		// TODO Auto-generated method stub
		return "deslizandose furtivamente";
	}


}
