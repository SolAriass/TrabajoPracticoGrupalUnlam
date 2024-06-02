package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.ArrayList;

import ar.edu.unlam.pb2.enums.Comida;

public class LocalDeComida extends Estructura {
	
	private List<Comida> comidas;
	private Double papasFritas = 150.0;
	private Double precioHamburguesa = 200.0;
	private Double precioGaseosa = 100.0;
	private Double precioAgua = 50.0;
	private Double precioPizza = 300.0;
	private Double recaudacion = 0.0;

	public LocalDeComida(Integer codigoEstructural, String nombreEstructura, Boolean estadoEstructura) {
		super(codigoEstructural, nombreEstructura, estadoEstructura);
		// TODO Auto-generated constructor stub
		this.comidas = new ArrayList<>();
	}
	
	public void agregarAlLocalStockDe(Comida comida, Integer cantidadAAgregar) {	
		for (int i = 0; i < cantidadAAgregar; i++) {
			
			this.comidas.add(comida);
		}
	}

	public Boolean comprarComida(Visitante visitante, Comida comida, Integer cantidad) {
		// TODO Auto-generated method stub
		Double precioTotal = calcularCantidadAPagar(comida, cantidad);
		
		if( comprobarStock(cantidad, comida) ) {
			if(visitante.getDinero() > precioTotal) {
				recaudacion+=precioTotal;
				return true;
			}
		}
		
		return false;
	}

	public Double calcularCantidadAPagar(Comida comida, Integer cantidad) {
		Double precioTotal = 0.0;
		
		switch(comida) {
		case PAPAS_FRITAS:
			precioTotal = cantidad * papasFritas;
			break;
		case HAMBURGUESA:
			precioTotal = cantidad * precioHamburguesa;
			break;
		case GASEOSA:
			precioTotal = cantidad * precioGaseosa;
			break;
		case AGUA:
			precioTotal = cantidad * precioAgua;
			break;
		case PIZZA:
			precioTotal = cantidad * precioPizza;
			break;
		}
		return precioTotal;
	}
	

	public  Boolean comprobarStock(Integer cantidad, Comida comidaAbuscar) {
		// TODO Auto-generated method stub
		Integer contadorDeTipoDeComida = comprobarStockPorTipoDeComida(comidaAbuscar);
		
		if(contadorDeTipoDeComida > cantidad) {
			return true;
		}
		
		return false;
	}

	public Integer comprobarStockPorTipoDeComida(Comida comidaAbuscar) {
		Integer contadorDeTipoDeComida = 0;
		
		for (Comida comida : comidas) {
			if(comida.equals(comidaAbuscar)) {
				contadorDeTipoDeComida++;
			}
			
		}
		return contadorDeTipoDeComida;
	}


	public List<Comida> getComidas() {
		return comidas;
	}

	public void setComidas(List<Comida> comidas) {
		this.comidas = comidas;
	}

	public Double getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(Double recaudacion) {
		this.recaudacion = recaudacion;
	}
}
