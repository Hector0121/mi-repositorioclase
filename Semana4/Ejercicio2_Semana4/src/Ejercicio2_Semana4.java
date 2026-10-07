

public class Ejercicio2_Semana4 {
    public static class Persona{

        //Atributos
        private String nomb;
        private float peso;
        private float altura;
        
        //Constructor 
        public Persona(String nomb, float altura, float  peso){
            this.nomb=nomb;
            this.altura=altura;
            this.peso=peso;
        }
        public Persona(){
        }

        //Metodos

        public static Persona crearDesdeArray(String[] datos) {
            String nombre = datos[0];
            float peso = Float.parseFloat(datos[1]);
            float altura = Float.parseFloat(datos[2]);
            
            // Llama a tu constructor
            return new Persona(nombre, altura, peso);
        }

        public float calcularIMC(float peso, float altura){
            float IMC;
            altura=altura/100;
            IMC=peso/(altura*altura);
            return IMC;
        }

        //Getter y Setter

        public String getNombre(){
            return this.nomb;
        }
        public float getAltura(){
            return this.altura;
        }
        public float getPeso(){
            return this.peso;
        }

        public void setNombre ( String nombre){
            this.nomb= nombre;
        }
        public void setAltura(float alt){
            this.altura=alt;
        }
        public void setPeso(float pes){
            this.peso=pes;
        }

    }
    public static void main(String[] args) {
        // En lugar de usar Scanner y bucles, creamos LA persona
        // directamente desde el array 'args' usando el método estático:
        Persona p = Persona.crearDesdeArray(args);

        // Tu formateo de tabla mantenido:
        float IMC = p.calcularIMC(p.getPeso(), p.getAltura());
        System.out.println("----------------------------------------------");
        System.out.printf("|Nombre |\tAltura |\tPeso  |\tIMC  |\n| %-5s |\t%-6.2f |\t%-2.2f |\t%-4.2f|\n", 
                p.getNombre(), p.getAltura(), p.getPeso(), IMC);
        System.out.println("----------------------------------------------");
    }

        
    
}
