package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	private List<Tiquete> tiquetes;
	
	private String identificador;
	
	public Cliente(String identificador) {
		this.tiquetes = new ArrayList<>();
		this.identificador = identificador;
	}
	
	public String getTipoCliente() {
		return "General";
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetes.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int valorTotal = 0;
        for (Tiquete tiquete : tiquetes) {
            valorTotal += tiquete.getTarifa();  
        }
        return valorTotal;
	}
	
	public void usarTiquetes() {
		for (Tiquete tiquete : tiquetes) {
            tiquete.marcarComoUsado();  
            }
    }

    public List<Tiquete> getTiquetes() {
        return this.tiquetes;
	}
		
}
