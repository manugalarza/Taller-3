package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
    protected static final int COSTO_POR_KM_NATURAL = 600;
    protected static final int COSTO_POR_KM_CORPORATIVO = 900;

    protected static final double DESCUENTO_PEQ = 0.02;
    protected static final double DESCUENTO_MEDIANAS = 0.1;
    protected static final double DESCUENTO_GRANDES = 0.2;

    
    @Override
    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        Ruta ruta = vuelo.getRuta(); 
        int distancia = calcularDistanciaVuelo(ruta);

        if (cliente instanceof ClienteCorporativo) {
            return distancia * COSTO_POR_KM_CORPORATIVO;
        } else {
            return distancia * COSTO_POR_KM_NATURAL;
        }
    }

    @Override
    public double calcularPorcentajeDescuento(Cliente cliente) {
        if (cliente instanceof ClienteCorporativo) {
            ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
            switch (corporativo.getTamanoEmpresa()) {
                case ClienteCorporativo.GRANDE:
                    return DESCUENTO_GRANDES;
                case ClienteCorporativo.MEDIANA:
                    return DESCUENTO_MEDIANAS;
                case ClienteCorporativo.PEQUENA:
                    return DESCUENTO_PEQ;
                default:
                    return 0;
            }
        }
        return 0; // Clientes naturales no tienen descuento
    }
}
