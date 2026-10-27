import modelo.Animal;
import modelo.Cuidador;
import modelo.RefugioHashMap;

import java.util.HashMap;

import static es.usal.progiii.tools.Esdia.*;

public class AppHashMap {
    
    private static RefugioHashMap refugio = new RefugioHashMap();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n\tMENÚ REFUGIO DE ANIMALES (HashMap + Esdia)");
            System.out.println("1. Configurar precio del alimento");
            System.out.println("2. Registrar un animal");
            System.out.println("3. Buscar un animal");
            System.out.println("4. Actualizar un animal");
            System.out.println("5. Eliminar un animal");
            System.out.println("6. Mostrar información y costes");
            System.out.println("7. Salir");
            
            opcion = readInt("Elige una opción: ");

            switch (opcion) {
                case 1:
                    float nuevoPrecio = readFloat("Introduce el nuevo precio por kg: ");
                    refugio.setPrecio(nuevoPrecio);
                    System.out.println("Precio actualizado con éxito.");
                    break;

                case 2:
                    System.out.println("\n\tREGISTRAR NUEVO ANIMAL");
                    String nombreCuidador = readString_ne("Nombre del cuidador: ");
                    String apellidosCuidador = readString_ne("Apellidos del cuidador: ");
                    String formacionStr = readString_ne("¿Tiene formación? (true/false): ");
                    boolean formacion = Boolean.parseBoolean(formacionStr);

                    Cuidador cuidador = new Cuidador(nombreCuidador, apellidosCuidador, formacion);

                    String nombreAnimal = readString_ne("Nombre del animal: ");
                    String especie = readString_ne("Especie: ");
                    float peso = readFloat("Peso (en Kg): ");
                    float consumo = readFloat("Consumo diario de alimento (en Kg): ");

                    Animal nuevoAnimal = new Animal(cuidador, nombreAnimal, especie, peso, consumo);
                    refugio.agregarAnimal(nuevoAnimal);
                    break;

                case 3:
                    String busqueda = readString_ne("Introduce el nombre del animal a buscar: ");
                    Animal encontrado = refugio.buscarAnimal(busqueda);
                    if (encontrado != null) {
                        System.out.println("¡Animal encontrado! -> Especie: " + encontrado.getEspecie() + ", Peso: " + encontrado.getPesoKg() + "kg");
                    } else {
                        System.out.println("No se encontró ningún animal con ese nombre.");
                    }
                    break;

                case 4:
                    String nombreAct = readString_ne("Introduce el nombre del animal que quieres actualizar: ");
                    String nuevaEsp = readString_ne("Nueva especie: ");
                    float nuevoPesoAnim = readFloat("Nuevo peso (Kg): ");
                    float nuevoConsumoAnim = readFloat("Nuevo consumo diario (Kg): ");

                    refugio.actualizarAnimal(nombreAct, nuevaEsp, nuevoPesoAnim, nuevoConsumoAnim);
                    break;

                case 5:
                    String nombreDel = readString_ne("Introduce el nombre del animal a eliminar: ");
                    refugio.eliminarAnimal(nombreDel);
                    break;

                case 6:
                    imprimirResultados(refugio);
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Error: introduce un número válido.");
            }

        } while (opcion != 7);
    }

    public static void imprimirResultados(RefugioHashMap miRefugio) {
        String separador = "|-----------------------------------------------------------------------------------------|";
        System.out.println(separador);
        System.out.println("| ANIMALES DEL REFUGIO (HashMap)                                                          |");
        System.out.println(separador);
        System.out.printf("| %-8s | %-8s | %-13s | %-10s | %-10s | %-10s | %-10s |\n", "Nombre", "Especie", "Cuidador", "Formación", "Peso (Kg)", "Consumo kg", "Coste EUR");
        
        for (Animal animal : miRefugio.getAnimalesMap().values()) {
            if (animal != null) {
                System.out.printf("| %-8s | %-8s | %-13s | %-10s | %-10.2f | %-10.2f | %-10.2f |\n", 
                                                animal.getNombre(),
                                                animal.getEspecie(),
                                                animal.getCuidador().getNombre() + " " + animal.getCuidador().getApellidos(),
                                                animal.getCuidador().getFormacion(),
                                                animal.getPesoKg(),
                                                animal.getConsumoDiario(),
                                                animal.calcularCosteDiario(miRefugio.getPrecio()));
            }
        }
        System.out.println(separador);
        System.out.printf("| Coste diario total de alimentación: %.2f EUR                                            |\n", miRefugio.calcularCosteTotalHashMap());
        System.out.printf("| Peso medio de los animales: %.2f kg                                                     |\n", miRefugio.calcularPesoMedioHashMap());
        System.out.println(separador);
    }
}