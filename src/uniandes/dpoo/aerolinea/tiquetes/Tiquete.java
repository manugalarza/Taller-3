package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
    private String codigo;
    
    private int tarifa;
    
    private boolean usado;
    
    private Vuelo vuelo;
    
    private Cliente clienteComprador;

    public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.clienteComprador = clienteComprador;
        this.tarifa = tarifa;
        this.usado = false; // Por defecto el tiquete no está usado
    }

    public Cliente getCliente() {
        return clienteComprador;
    }

    public Vuelo getVuelo() {
        return this.vuelo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getTarifa() {
        return this.tarifa;
    }

    public void marcarComoUsado() {
        this.usado = true;
    }

    public boolean esUsado() {
        return usado;
    }
}
