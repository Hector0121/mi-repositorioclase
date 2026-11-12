package modelo;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Modelo {
    ArrayList<Persona> personas;

    public Modelo(){
        this.personas = new ArrayList<>();
    }

    //getter del array de personas
    public ArrayList<Persona> getPersonas(){
        return personas;
    }

    //cargar los datos desde un fichero
    public String cargarDesdeFichero(){
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos", "datos.txt");

        if (!Files.exists(ruta)){
            return "Error: no se encuentra el fichero 'datos.txt' en la carpeta 'datos' del escritorio.";
        }

        try{
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            personas.clear();
            for (String linea : lineas){
                Persona p = Persona.getPersonaFromDelimitedString(linea, "\t");
                if (p != null){
                    personas.add(p);
                }
            }
            return "Personas cargadas con éxito.";
        }
        catch (IOException e){
            return "Error al leer el fichero." + e.getMessage();
        }
    }

    public String importarDesdeFichero(String nombreFichero){
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos", nombreFichero);

        if (!Files.exists(ruta)) {
            return "Error: El archivo '" + nombreFichero + "' no existe en el escritorio.";
        }

        try {
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            int contadorNuevas = 0;
            for (String linea : lineas) {
                Persona p = Persona.getPersonaFromDelimitedString(linea, "\t");
                if (p != null) {
                    personas.add(p);
                    contadorNuevas++;
                }
            }
            return "Importación completada. Se añadieron " + contadorNuevas + " registros.";
        } catch (IOException e) {
            return "Error al importar el fichero: " + e.getMessage();
        }

    }
}
