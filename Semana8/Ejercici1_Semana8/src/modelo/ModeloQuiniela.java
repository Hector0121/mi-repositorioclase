package modelo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ModeloQuiniela {
    private ArrayList<Partido> partidos; 

    public ModeloQuiniela(){
        this.partidos = new ArrayList<>();
    }

    public ArrayList<Partido> getPartidos(){
        return partidos;
    }

    //devuelve estring con si se ha podido cargar o no el fichero
    public String cargarPartidoDesdeFichero(){
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos", "equipos.txt");  //ruta del fichero
        //si existe la ruta...
        if (!Files.exists(ruta)) {
            return "Error: No se encuentra el fichero 'equipos.txt' en la carpeta 'datos' del escritorio.";
        }

        try{
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);     
            partidos.clear();
            for (String linea : lineas){                //for each para leer cada linea
                Partido p = Partido.getPartidoFromDelimitedString(linea,"-");
                if (p != null){
                    partidos.add(p);
                }
            }
            return "Partidos cargados con éxito desde el fichero.";
        } catch (IOException e){
            return "Error al leer el fichero: " + e.getMessage();
        }

    }

    //devuelve string con si se ha actualizado el resultado o no
    public String actualizarResultado(int indice, String resultado){
        //miramos que el indice sea valido
        if (indice >= 0 && indice < partidos.size()){
            //miramos que sea un resultado posible
            if (resultado.equals("1") || resultado.equals("X") || resultado.equals("2")){
                partidos.get(indice).setResultado(resultado);
                return "Resultado actualizado correctamente.";
            }
            return "Error: El resultado debe ser '1', '2' o 'X'.";
        }
        return "Error: indice de partido no válido.";
    }


}
