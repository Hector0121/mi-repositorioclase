package controlador;

import modelo.Persona;
import modelo.Modelo;
import vista.Vista;

import java.util.ArrayList;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void init(){
        String mensajeCarga = modelo.cargarDesdeFichero();
        vista.mostrarMensaje(mensajeCarga);

        vista.mostrarMenu();
    }

    //metodos
    public void importarFichero(String nombreFichero){
        String resultado = modelo.importarDesdeFichero(nombreFichero);
        vista.mostrarMensaje(resultado);
    }

    public void mostrarTablaPersonas(){
        ArrayList<Persona> lista = modelo.getPersonas();
        vista.mostrarTabla(lista);
    }

}
