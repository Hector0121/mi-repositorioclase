package modelo;

import java.util.HashMap;

public class RefugioHashMap {
    private HashMap<String, Animal> animales;
    private float precio;

    public RefugioHashMap() {
        this.animales = new HashMap<>();
        this.precio = 3.0f;
    }

    public float getPrecio() { 
        return precio; 
    }
    public void setPrecio(float precio) { 
        if (precio > 0) 
            this.precio = precio; 
    }
    public HashMap<String, Animal> getAnimalesMap() { 
        return animales; 
    }

    //metodos
    public void agregarAnimal(Animal animal){
        animales.put(animal.getNombre(), animal);
        System.out.println("Animal agregado con éxito.");
    }

    public Animal buscarAnimal(String nombre){
        return animales.get(nombre);
    }

    public boolean actualizarAnimal(String nombre, String nuevaEspecie, float nuevoPeso, float nuevoConsumo) {
        Animal a = buscarAnimal(nombre);
        if (a != null) {
            a.setEspecie(nuevaEspecie);
            a.setPesoKg(nuevoPeso);
            a.setConsumoDiario(nuevoConsumo);
            System.out.println("Animal actualizado con éxito.");
            return true;
        }
        System.out.println("No se encontró ningún animal con ese nombre.");
        return false;
    }

    public boolean eliminarAnimal(String nombre) {
        Animal eliminado = animales.remove(nombre);
        if (eliminado != null) {
            System.out.println("Animal eliminado correctamente.");
            return true;
        }
        System.out.println("Animal no encontrado para eliminar.");
        return false;
    }

    //metodos calculo hashmap
    public float calcularCosteTotalHashMap(){
        float total = 0;
        for (Animal a : animales.values()){
            total += a.calcularCosteDiario(precio);
        }
        return total;
    }

    public float calcularPesoMedioHashMap(){
        if (animales.isEmpty())
            return 0;
        float suma = 0;
        for (Animal a : animales.values()){
            suma += a.getPesoKg();
        }
        return suma / animales.size();
    }



}
