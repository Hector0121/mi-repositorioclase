import java.util.Scanner;
import modelo.Refugio;
import modelo.Animal;
import modelo.Cuidador;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Refugio refugio = new Refugio();
        int opcion = 0;

        do{
            System.out.println("\n\tMENÚ REFUGIO DE ANIMALES");
            System.out.println("1. Crear registro de animales");
            System.out.println("2. Configurar precio del alimento");
            System.out.println("3. Registrar un animal");
            System.out.println("4. Mostrar información y costes");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: "); 
            
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.print("Introduce la capacidad del refugio: ");
                    int capacidad = scanner.nextInt();
                    refugio.crearRegistro(capacidad);
                    break;

                case 2:
                    System.out.print("Introduce el nuevo precio por kg: ");
                    float nuevoPrecio = scanner.nextFloat();
                    refugio.modificarPrecio(nuevoPrecio);
                    break;

                case 3:
                    System.out.println("\n\tREGISTRAR NUEVO ANIMAL");

                    //primero pedimos el cuidador
                    System.out.println("Datos del cuidador: ");
                    System.out.print("Nombre del cuidador: ");
                    String nombreCuidador = scanner.nextLine();
                    System.out.print("Apellidos del cuidador: ");
                    String apellidosCuidador = scanner.nextLine();
                    System.out.print("¿Tiene formacion? (true/false): ");
                    boolean formacion = scanner.nextBoolean();
                    scanner.nextLine();

                    Cuidador cuidador = new Cuidador(nombreCuidador, apellidosCuidador, formacion);

                    //ahora ya pedimos el animal
                    System.out.println("Datos del animal: ");
                    System.out.print("Nombre del animal: ");
                    String nombreAnimal = scanner.nextLine();
                    System.out.print("Especie: ");
                    String especie = scanner.nextLine();
                    System.out.print("Peso (en Kg): ");
                    float peso = scanner.nextFloat();
                    System.out.print("Consumo diario de alimento (en Kg): ");
                    float consumo = scanner.nextFloat();
                    scanner.nextLine();

                    Animal nuevoAnimal = new Animal(cuidador, nombreAnimal, especie, peso, consumo);

                    //llamamos a la funcion para registrarlo
                    refugio.registrarAnimal(nuevoAnimal);

                    break;
                
                case 4:
                    imprimirResultados(refugio);

                    break;
                
                case 5:
                    System.out.println("Saliendo...");
                    break; 

                default:
                    System.out.println("Error: introduce un numero válido");
            }

        } while (opcion != 5);

        scanner.close();
    }

    public static void imprimirResultados(Refugio miRefugio){
        String separador = "|-----------------------------------------------------------------------------------------|";
        System.out.println(separador);
        System.out.println("| ANIMALES DEL REFUGIO                                                                    |");
        System.out.println(separador);
        System.out.printf("| %-8s | %-8s | %-13s | %-10s | %-10s | %-10s | %-10s |\n", "Nombre", "Especie", "Cuidador", "Formacion", "Peso (Kg)", "Consumo kg", "Coste EUR");
        
        //recorremos el array de animales de miRefugio
        Animal[] listaAnimales = miRefugio.getAnimales();
        for (Animal animal : listaAnimales){
            if (animal != null){
                System.out.printf("| %-8s | %-8s | %-13s | %-10s | %-10.2f | %-10.2f | %-10.2f |\n", 
                                                animal.getNombre(),
                                                animal.getEspecie(),
                                                animal.getCuidador().getNombre()+" "+animal.getCuidador().getApellidos(),
                                                animal.getCuidador().getFormacion(),
                                                animal.getPesoKg(),
                                                animal.getConsumoDiario(),
                                                animal.calcularCosteDiario(miRefugio.getPrecio()));
            }
        }
        System.out.println(separador);
        System.out.printf("| Coste diario total de alimentacion: %.2f EUR                                            |\n", miRefugio.calcularCosteTotal());
        System.out.printf("| Peso medio de los animales: %.2f kg                                                     |\n", miRefugio.calcularPesoMedio());
        System.out.println(separador);
    }
}