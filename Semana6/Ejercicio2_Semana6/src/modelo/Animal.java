package modelo;

import java.util.Objects;


public class Animal {
    private Cuidador cuidador;
    private String nombre;
    private String especie;
    private float pesoKg;
    private float consumoDiario;

    public Animal(Cuidador cuidador, String nombre, String especie, float pesoKg, float consumoDiario) {
        this.cuidador = cuidador;
        this.nombre = nombre;
        this.especie = especie;
        this.pesoKg = pesoKg;
        this.consumoDiario = consumoDiario;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(float pesoKg) {
        this.pesoKg = pesoKg;
    }

    public float getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(float consumoDiario) {
        this.consumoDiario = consumoDiario;
    }
    
    //métodos
    public float calcularCosteDiario(float precioKg){
        return this.consumoDiario * precioKg;
    }



    //para el hashset
    @Override 
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o instanceof Animal && o != null){
            Animal objeto = (Animal) o;
            if (this.nombre.equals(objeto.getNombre()))
                return true;
            else
                return false;
        }
        else
            return false;
    }

    @Override 
    public int hashCode(){
        return Objects.hash(this.nombre);
    }

}
