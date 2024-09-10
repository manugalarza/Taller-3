package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Collection<Tiquete> tiquete;
	private boolean usado;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		this.tiquete = new ArrayList<>();
	}
	
	public Ruta getRuta() {
		return this.ruta;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public Avion getAvion() {
		return this.avion;
	}
	
	public Collection<Tiquete> getTiquetes() {
		return this.tiquete;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
        if (this.tiquete.size() + cantidad > avion.getCapacidad()) {
            throw new IllegalArgumentException("La cantidad de tiquetes excede la capacidad del avión.");
        }

        for (int i = 0; i < cantidad; i++) {
            Tiquete tiquete = new Tiquete(cliente.getTipoCliente(), this, cliente, calculadora.calcularTarifa(this, cliente));
            tiquete.esUsado();
        }

        return cantidad;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vuelo otroVuelo = (Vuelo) obj;
        return this.fecha.equals(otroVuelo.fecha) && 
               this.avion.equals(otroVuelo.avion) && 
               this.ruta.equals(otroVuelo.ruta);
	}

	public void marcarComoRealizado() {
		this.usado = true;
	}
}
