package ar.edu.unlam.pb2.animales;

import ar.edu.unlam.pb2.zoologico.*;
import ar.edu.unlam.pb2.enums.*;

public class Tiburon extends Animal {

	public Tiburon(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String emitirSonido() {
		// TODO Auto-generated method stub
		return "Sonido de tiburon";
	}

	@Override
	public String movimiento() {
		// TODO Auto-generated method stub
		return "nadando rapidamente";
	}

	@Override
	public Animal crearCria(Integer idCria, String nombreCria, TipoSexo sexo) {
		// TODO Auto-generated method stub
		return new Tiburon(idCria, nombreCria, 0, 1.5, this.getTipoAlimentacion(), sexo, this.getCategoriaAnimal());	}

	
	
}
