package controlador;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;
        //metodo para que la vista interactue con el controlador
        this.vista.setControlador(this);
    }

    public void init(){

        vista.mostrarMensajeBienvenida();
        vista.mostrarMenuPrincipal();
        vista.mostrarMensajeDespedida();

    }

    //la vista las llama para poder contactar con el modelo
    public void pedirNumeros(float num1, float num2){
        modelo.setNumeros(num1, num2);
    }

    public void calcularSuma(){
        modelo.calcularSuma();
    }

    public float mostrarSuma(){
        return modelo.getSuma();
    }







}
