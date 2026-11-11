package controlador;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import modelo.Factura;
import modelo.ModeloFacturas;
import vista.VistaFacturas;

public class ControladorFacturas {
    private ModeloFacturas modelo;
    private VistaFacturas vista;

    public ControladorFacturas(ModeloFacturas modelo, VistaFacturas vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void init() {
        String mensaje = modelo.cargarFacturasDesdeFichero();
        vista.mostrarMensaje(mensaje);
        
        vista.mostrarMenu();
    }

    //metodos
    public void cargarFichero() {
        String mensaje = modelo.cargarFacturasDesdeFichero();
        vista.mostrarMensaje(mensaje);
    }

    public void listarFacturas() {
        ArrayList<Factura> lista = modelo.getFacturas();
        vista.mostrarListado(lista);
    }

    public void filtrarClientesPorImporte(double valorMinimo) {
        ArrayList<String> clientes = modelo.obtenerClientesConImporteMayorA(valorMinimo);
        vista.mostrarClientesFiltrados(clientes, valorMinimo);
    }

    public void exportarHtml() {
        String resultado = modelo.exportarAHtml("facturas_reporte.html");
        vista.mostrarMensaje(resultado);
    }

    public void exportarCsv() {
        //lo necesito para llamar a exportarACsv
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "facturas_exportadas.csv");
        List<Factura> listaFacturas = modelo.getFacturas();
        
        String resultado = modelo.exportarACsv(ruta, listaFacturas, ",");   //csv está dilimitado por coma
        vista.mostrarMensaje(resultado);
    }
}
