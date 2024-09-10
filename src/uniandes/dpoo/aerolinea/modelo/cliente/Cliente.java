package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	public Cliente() {}
	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetes.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		return 0;
		//TODO
		
	}
	
	public void usarTiquetes() {
		//TODO
	}
		
}
