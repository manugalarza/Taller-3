package uniandes.dpoo.aerolinea.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {
    @Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) 
    		throws IOException, InformacionInconsistenteException {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONObject json = new JSONObject(contenido);
            aerolinea.setNombre(json.getString("nombre"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) 
    		throws IOException, InformacionInconsistenteException {
        try {
            JSONObject json = new JSONObject();
            json.put("nombre", aerolinea.getNombre());
            Files.write(Paths.get(archivo), json.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	}
