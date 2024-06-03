package ar.edu.unlam.pb2.zoologico;

public class Tiburon extends Animal {

    public Tiburon(Integer codigoDeReconocimiento, String nombreAnimal, Integer edad, Double peso,
            TipoAlimentacion alimentacion, TipoSexo sexo, CategoriaAnimal clase) {
        super(codigoDeReconocimiento, nombreAnimal, edad, peso, alimentacion, sexo, clase);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Animal crearCria(Integer idCria, String nombreCria, TipoSexo sexo) {
        return new Tiburon(idCria, nombreCria, 0, 1.5, this.getTipoAlimentacion(), sexo, this.getCategoriaAnimal());
    }

    
    
}