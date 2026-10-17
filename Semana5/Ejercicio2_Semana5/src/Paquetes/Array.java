package Paquetes;

public class Array implements Comparable <Array> {
    //Atibutos
    private String nombre;

    //Constructor 
    public Array (String nombre){
        this.nombre=nombre;
    }
    public Array(){

    }
    

    //Metodos

    //Override
    @Override
    public int compareTo(Array otro) {
        // Sorts the names alphabetically
        return this.nombre.compareTo(otro.nombre);
    }

    //Getter y Setters

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
