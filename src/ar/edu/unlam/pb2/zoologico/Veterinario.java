package ar.edu.unlam.pb2.zoologico;

import ar.edu.unlam.pb2.zoologico.excepciones.NoSePudoAlimentarException;

public class Veterinario extends Persona {

	public Veterinario(Integer identificacion, String nombreCompleto, Integer edad) {
		super(identificacion, nombreCompleto, edad);
	}

	public Boolean alimentar(Animal animal, Comida comida, Integer cantidadComida) throws NoSePudoAlimentarException {
		

		if (cantidadComida > 0) {

			if (animal.getTipoAlimentacion().equals(TipoAlimentacion.OMNIVORO)
					&& (comida.equals(Comida.CARNE) || comida.equals(Comida.PLANTA))) {
				animal.setPeso(animal.getPeso() * cantidadComida);
				return  true;

			} else if (animal.getTipoAlimentacion().equals(TipoAlimentacion.CARNIVORO) && comida.equals(Comida.CARNE)) {
				animal.setPeso(animal.getPeso() * cantidadComida);
				return true;

			} else if (animal.getTipoAlimentacion().equals(TipoAlimentacion.HERBIVORO)
					&& comida.equals(Comida.PLANTA)) {
				animal.setPeso(animal.getPeso() * cantidadComida);
				return true;

			} else {
				animal.setEstaEnfermo(true);
				animal.setAlimentacionInapropiada(true);
				return true;
			}

		}

		throw new NoSePudoAlimentarException("algo fallo al intentar alimentar al animal");
	}

}
