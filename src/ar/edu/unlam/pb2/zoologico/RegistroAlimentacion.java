package ar.edu.unlam.pb2.zoologico;

import ar.edu.unlam.pb2.enums.ComidaAnimales;

public class RegistroAlimentacion {

private Persona personal;
private Animal animal;
private ComidaAnimales comida;
private Integer cantidadComida;

public RegistroAlimentacion(Persona personal, Animal animal, ComidaAnimales comida, Integer cantidadComida) {
this.personal = personal;
this.animal = animal;
this.comida = comida;
this.cantidadComida = cantidadComida;
}

public Persona getPersonal() {
return personal;
}

public void setPersonal(Persona personal) {
this.personal = personal;
}

public Animal getAnimal() {
return animal;
}

public void setAnimal(Animal animal) {
this.animal = animal;
}

public ComidaAnimales getComida() {
return comida;
}

public void setComida(ComidaAnimales comida) {
this.comida = comida;
}

public Integer getCantidadComida() {
return cantidadComida;
}

public void setCantidadComida(Integer cantidadComida) {
this.cantidadComida = cantidadComida;
}






}