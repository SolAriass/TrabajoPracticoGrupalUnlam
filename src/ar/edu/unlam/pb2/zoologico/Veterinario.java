package ar.edu.unlam.pb2.zoologico;

public class Veterinario extends Personal {

	public Veterinario(Integer identificacion, String nombreCompleto, Integer edad) {
		super(identificacion, nombreCompleto, edad);
	}

	public Boolean alimentar(Animal animal, Comida comida, Integer cantidadComida) {
		Boolean alimentado = false;

		if (cantidadComida > 0) {

			if (animal.getTipoAlimentacion().equals(TipoAlimentacion.OMNIVORO)
					&& (comida.equals(Comida.CARNE) || comida.equals(Comida.PLANTA))) {
				animal.setPeso(animal.getPeso() * cantidadComida);
				alimentado = true;
				
			} else if (animal.getTipoAlimentacion().equals(TipoAlimentacion.CARNIVORO) && comida.equals(Comida.CARNE)) {
				animal.setPeso(animal.getPeso() * cantidadComida);
				alimentado = true;
				
			} else if (animal.getTipoAlimentacion().equals(TipoAlimentacion.HERBIVORO)
					&& comida.equals(Comida.PLANTA)) {
				animal.setPeso(animal.getPeso() * cantidadComida);
				alimentado = true;
				
			} else {
				animal.setEstaEnfermo(true);
				alimentado = false;
			}

		}

		return alimentado;
	}

}
