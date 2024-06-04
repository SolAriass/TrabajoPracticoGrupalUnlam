package ar.edu.unlam.pb2.animales;

import ar.edu.unlam.pb2.enums.CategoriaAnimal;
import ar.edu.unlam.pb2.enums.TipoAlimentacion;
import ar.edu.unlam.pb2.enums.TipoSexo;
import ar.edu.unlam.pb2.zoologico.Animal;

public class Leon extends Animal {

	public Leon(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Animal crearCria(Integer idCria, String nombreCria, TipoSexo sexo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String emitirSonido() {
		// TODO Auto-generated method stub
		return "RAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAWR";
	}

	@Override
	public String movimiento() {
		// TODO Auto-generated method stub
		return "corriendo velozmente";
	}

}
