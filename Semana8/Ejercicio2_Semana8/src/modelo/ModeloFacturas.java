package modelo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ModeloFacturas {
    private ArrayList<Factura> facturas;

    public ModeloFacturas(){
        this.facturas = new ArrayList<>();
    }

    public ArrayList<Factura> getFacturas(){
        return facturas;
    }

    //cargar las facturas desde el fichero
    public String cargarFacturasDesdeFichero(){
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos", "facturas.tsv");

        if (!Files.exists(ruta)){
            return "Error: no se encuentra el fichero 'facturas.tsv' en la carpeta 'datos' del escritorio."; 
        }

        try{
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            facturas.clear();
            for (String linea : lineas){
                Factura f = Factura.getFacturaFromDelimitedString(linea, "\t");
                if (f != null){
                    facturas.add(f);
                }
            }
            return "Facturas cargadas con exito.";
        }
        catch (IOException e){
            return "Error al leer el fichero: " + e.getMessage();
        }
    }

    //obtener clientes con facturas mayores a un valor minimo
    public ArrayList<String> obtenerClientesConImporteMayorA(double valorMinimo){

        ArrayList<String> clientesFiltrados = new ArrayList<>();     //<String> porque solo nos quedamos con el nombre
        for (Factura f : facturas){
            if (f.calcularImporteTotal() > valorMinimo){
                clientesFiltrados.add(f.getNombreCliente());
            }
        }
        return clientesFiltrados;
    }

    //para html (este lo hice con ia)
    public String exportarAHtml(String nombreArchivo) {
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", nombreArchivo);
        
        // Plantilla HTML básica con marcador %%TABLA%%
        String plantillaHtml = """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <title>Listado de Facturas</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f9; }
                    h2 { color: #333; }
                    table { width: 100%%; border-collapse: collapse; background: #fff; margin-top: 20px; }
                    th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
                    th { background-color: #0056b3; color: white; }
                    tr:nth-child(even) { background-color: #f9f9f9; }
                </style>
            </head>
            <body>
                <h2>Listado General de Facturas</h2>
                <table>
                    <tr>
                        <th>Concepto</th><th>Descuento</th><th>Fecha</th><th>Importe</th>
                        <th>NIF</th><th>Cliente</th><th>Dirección</th><th>IVA</th><th>Total Calc.</th>
                    </tr>
                    %%TABLA%%
                </table>
            </body>
            </html>
            """;

        StringBuilder filasHtml = new StringBuilder();
        for (Factura f : facturas) {
            String[] arr = f.getInstanceAsArrayOfStrings();
            filasHtml.append("<tr>");
            for (String dato : arr) {
                filasHtml.append("<td>").append(dato).append("</td>");
            }
            filasHtml.append("</tr>\n");
        }

        String contenidoFinal = plantillaHtml.replace("%%TABLA%%", filasHtml.toString());

        try {
            Files.writeString(ruta, contenidoFinal, StandardCharsets.UTF_8);
            return "HTML exportado con éxito en: " + ruta.toAbsolutePath();
        } catch (IOException e) {
            return "Error al exportar a HTML: " + e.getMessage();
        }
    }

    //para csv
    public String exportarACsv(Path ruta, List<Factura> facturas, String delimitador){

        ArrayList<String> lineas = new ArrayList<>();

        for (Factura factura : facturas){
            lineas.add(factura.getInstanceAsDelimitedString(delimitador)); 
            /* 
                //tambien se puede hacer obteniendo el array de strings de la factura
            String[] campos = factura.getInstanceAsArrayOfStrings();
            lineas.add(String.join(delimitador, campos));
            */
        }

        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return "Datos exportados exitosamente a: " + ruta.toFile().getAbsolutePath();
        } catch (IOException e) {
            return "Ocurrió un error al intentar exportar las facturas: " + e.getMessage();
        }
    }


}
