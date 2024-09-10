package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
    protected static final int COSTO_POR_KM = 1000;

    @Override
    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        Ruta ruta = vuelo.getRuta(); 
        int distancia = calcularDistanciaVuelo(ruta);

        return distancia * COSTO_POR_KM;
    }

    @Override
    public double calcularPorcentajeDescuento(Cliente cliente) {
        if (cliente instanceof ClienteCorporativo) {
            ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
            switch (corporativo.getTamanoEmpresa()) {
                case ClienteCorporativo.GRANDE:
                    return 0.1;
                case ClienteCorporativo.MEDIANA:
                    return 0.05;
                case ClienteCorporativo.PEQUENA:
                    return 0.02;
                default:
                    return 0;
            }
        }
        return 0; // Clientes naturales no tienen descuento
    }
}
