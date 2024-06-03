package ar.edu.unlam.pb2.animales;

import ar.edu.unlam.pb2.enums.TipoAlimentacion;
import ar.edu.unlam.pb2.enums.TipoSexo;
import ar.edu.unlam.pb2.enums.CategoriaAnimal;
import ar.edu.unlam.pb2.zoologico.Animal;

public class Mono extends Animal {

	public Mono(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
			TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
		super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
	}

	
	
	
}
