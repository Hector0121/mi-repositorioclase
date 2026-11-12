package modelo;

public class Persona {
    private String nombre;
    private String telefono;
    private double peso;

    public Persona(String nombre, String telefono, double peso){
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    //factory method
    public static Persona getPersonaFromDelimitedString(String delimitedString, String delimiter){
        String[] chunks = delimitedString.split(delimiter);

        if (chunks.length != 3)
            return null;

        try{
            String nombre = chunks[0];
            String telefono = chunks[1];
            double peso = Double.parseDouble(chunks[2]);

            return new Persona(nombre, telefono, peso);
        }
        catch (Exception e){
            return null;
        }
    }



    //getters
    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public double getPeso(){
        return peso;
    }


    //para tablas
    public String[] getInstanceAsArrayOfStrings() {
        return new String[]{
            nombre,
            telefono,
            String.format("%.2f kg", peso)
        };
    }

    public static String[] getCabeceraTabla() {
        return new String[]{"Nombre", "Teléfono", "Peso"};
    }


    //para imprimir persona por pantalla
    public String getEstadoComoString(){
        return String.format("Nombre: %s | Telefono: %s | Peso: %.2f", nombre, telefono, peso);
    }

    //para poder escribir en otro fichero
    public String getInstanceDelimitedString(String delimiter){
        return nombre + delimiter + telefono + delimiter + peso;
    }


}