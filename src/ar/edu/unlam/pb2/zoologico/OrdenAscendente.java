package ar.edu.unlam.pb2.zoologico;

import java.util.Comparator;

public class OrdenAscendente implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getEdad().compareTo(o2.getEdad());
	}

}