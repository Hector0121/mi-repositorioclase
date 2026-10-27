package modelo;

import java.util.HashSet;

public class RefugioHashSet {
    private HashSet<Animal> animales;
    private float precio;

    public RefugioHashSet(){
        this.animales = new HashSet<>();
        this.precio = 3;
    }

    public float getPrecio(){
        return precio;
    }
    public void setPrecio(float precio){
        if (precio > 0)
            this.precio = precio;
    }
    public HashSet<Animal> getAnimales(){
        return animales;
    }

    //metodos
    public boolean agregarAnimal(Animal animal){
        boolean agregado = animales.add(animal);
        if (agregado) {
            System.out.println("Animal añadido correctamente.");
        } else {
            System.out.println("El animal ya existe en el conjunto.");
        }
        return agregado;
    }

    public Animal buscarAnimal(String nombre){
        for (Animal a : animales){
            if (a.getNombre().equals(nombre))
                return a;
        }
        return null;
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
        Animal a = buscarAnimal(nombre);
        if (a != null) {
            animales.remove(a);
            System.out.println("Animal eliminado correctamente.");
            return true;
        }
        System.out.println("Animal no encontrado para eliminar.");
        return false;
    }

    public float calcularCosteTotalHashSet() {
        float total = 0;
        for (Animal a : animales) {
            total += a.calcularCosteDiario(precio);
        }
        return total;
    }

    public float calcularPesoMedioHashSet() {
        if (animales.isEmpty()) return 0;
        float suma = 0;
        for (Animal a : animales) {
            suma += a.getPesoKg();
        }
        return suma / animales.size();
    }



}
