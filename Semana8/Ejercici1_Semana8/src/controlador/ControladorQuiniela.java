package controlador;

import modelo.ModeloQuiniela;
import modelo.Partido;
import vista.VistaQuiniela;

import java.util.ArrayList;

public class ControladorQuiniela {
    private ModeloQuiniela modelo;
    private VistaQuiniela vista;

    public ControladorQuiniela(ModeloQuiniela modelo, VistaQuiniela vista){
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void init(){
        String mensaje = modelo.cargarPartidoDesdeFichero();
        vista.mostrarMensaje(mensaje);

        vista.mostrarMenu();
    }

    //metodos
    public void listarPartidos(){
        ArrayList<Partido> lista = modelo.getPartidos();
        vista.mostrarListadoArrayList(lista);
    }

    public void actualizarResultado(int indice, String resultado){
        String mensaje = modelo.actualizarResultado(indice, resultado);
        vista.mostrarMensaje(mensaje);
    }

    public void cargarFichero(){
        String mensaje = modelo.cargarPartidoDesdeFichero();
        vista.mostrarMensaje(mensaje);
    }



}
