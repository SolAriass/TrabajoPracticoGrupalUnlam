package ar.edu.unlam.pb2.zoologico;

import java.util.Comparator;

public class OrdenDescendiente implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return o2.getEdad().compareTo(o1.getEdad());
	}

}
