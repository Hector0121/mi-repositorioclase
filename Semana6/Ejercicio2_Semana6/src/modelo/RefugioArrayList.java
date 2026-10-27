package modelo;

import java.util.ArrayList;

public class RefugioArrayList {
    private ArrayList<Animal> animales;
    private float precio;

    public RefugioArrayList(){
        this.animales = new ArrayList<>();
        this.precio = 3;
    }

    public float getPrecio(){
        return precio;
    }
    public void setPrecio(float precio){
        if (precio > 0){
            this.precio = precio;
        }
    }
    public ArrayList<Animal> getAnimales(){
        return animales;
    }

    //métodos
    public void agregarAnimal(Animal animal){
        animales.add(animal);
        System.out.println("Animal añadido correctamente.");
    }

    public Animal buscarAnimal(String nombre){
        for (Animal a : animales){
            if (a.getNombre().equals(nombre)){
                return a;
            }
        }
        return null;
    }

    public boolean actualizarAnimal(String nombre, String nuevaEspecie, float nuevoPeso, float nuevoConsumo){
        Animal a = buscarAnimal(nombre);
        if(a != null){
            a.setEspecie(nuevaEspecie);
            a.setPesoKg(nuevoPeso);
            a.setConsumoDiario(nuevoConsumo);
            System.out.println("Animal actualizado con éxito.");
            return true;
        }
        System.out.println("No se ha encontrado el animal.");
        return false;
    }

    public boolean eliminarAnimal(String nombre){
        Animal a = buscarAnimal(nombre);
        if (a != null){
            animales.remove(a);
            System.out.println("Animal eliminado correctamente.");
            return true;
        }
        System.out.println("No se ha encontrado el animal.");
        return false;
    }

    //métodos cálculo
    public float calcularCosteTotalArrayList(){
        float total = 0;
        for (Animal a : animales){
            total += a.calcularCosteDiario(precio);
        }
        return total;
    }
    public float calcularPesoMedioArrayList(){
        if (animales.isEmpty())
            return 0;
        float suma = 0;
        for (Animal a : animales){
            suma += a.getPesoKg();
        }
        return suma / animales.size();
    }
}
