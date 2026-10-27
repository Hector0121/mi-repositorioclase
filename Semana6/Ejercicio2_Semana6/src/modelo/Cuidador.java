package modelo;

public class Cuidador {
    private String nombre;
    private String apellidos;
    private boolean formacion;

    public Cuidador(String nombre, String apellidos, boolean formacion){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.formacion = formacion;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public boolean getFormacion(){
        return formacion;
    }

    public void setFormacion(boolean formacion){
        this.formacion = formacion;
    } 
}
