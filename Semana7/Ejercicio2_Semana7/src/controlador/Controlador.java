package controlador;

import modelo.Modelo;
import vista.Vista;

public class Controlador{
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setControlador(this);
    }

    public void init(){
        this.vista.mostrarMenu();
    }

    //para la vista
    public void guardarVentas(int[][] ventas){
        modelo.setVentas(ventas);
    }

    public void guardarPrecios(float[] precios){
        modelo.setPrecios(precios);
    }

    //se llama en el menu de vista para calcular los ingresos
    public void calcularIngresos(){
        modelo.calcularIngresos();
    }

    //se puede llamar a la vista desde el controlador
    public void mostrarResultados(){
        vista.mostrarResultadosFinales(
                modelo.getIngresosPorAlmacen(),
                modelo.getIngresosTotalesCompania(),
                modelo.getVentas(),
                modelo.getPrecios()
            );
    }
}