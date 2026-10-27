package modelo;

public class Refugio {
    private Animal[] animales;
    private float precio;
    private int numAnimales;

    public Refugio(Animal[] animales, float precio, int numAnimales){
        this.animales = null;
        this.precio = 3.0f;  //pone que el precio inicial siempre es 3€/kg
        this.numAnimales = 0;
    }

    public Refugio() {
        this.animales = null;
        this.precio = 3.0f;  
        this.numAnimales = 0;
    }

    public Animal[] getAnimales() {
        return animales;
    }
    
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio > 0) {
            this.precio = precio;
        }
    }

    public int getNumAnimales() {
        return numAnimales;
    }

    //métodos
    //1. crear array de objetos animal
    public void crearRegistro(int capacidad){
        if (capacidad > 0){
            this.animales = new Animal[capacidad];
            this.numAnimales = 0;
            System.out.println("Se ha creado el registro con éxito");
        }
        else    
            System.out.println("Error: la capcidad debe ser mayor que 0");
    }

    public boolean existeRegistro(){
        return this.animales != null;   //si se ha creado el registro anteriormente, devuelve true
    }

    //2. modificar precio
    public void modificarPrecio(float precio){
        if (precio > 0){
            this.precio = precio;
            System.out.println("Se ha creado el precio por kilogramo con éxito");
        }
        else    
            System.out.println("Error: el precio debe ser mayor que 0");
    }

    //3. añadir animal
    public void registrarAnimal(Animal nuevoAnimal){
        //primero se mira que se creó el registro
        if (!existeRegistro()){
            System.out.println("Error: aún no se creó el registro de animales");
            return;
        }
        //hay que encontrar el hueco donde meter el nuevoAnimal
        for (int i=0; i<this.animales.length; i++){
            if (this.animales[i] == null){
                this.animales[i] = nuevoAnimal;
                this.numAnimales++;
                System.out.println("Se ha registrado el animal con éxito");
                return;   //como ya se encontró un sitio no hace falta que el bucle siga
            }
        }
    }


    //4. calcular otras informaciones
    public float calcularCosteTotal(){
        float costeTotal = 0;
        if (this.animales != null){
            for (Animal animal : this.animales){
                if (animal != null){
                    costeTotal += animal.calcularCosteDiario(this.precio);
                }
            }
        }
        return costeTotal;
    }

    public float calcularPesoMedio(){
        if (this.animales == null || this.numAnimales == 0){
            return 0;
        }

        float sumaPesos = 0;
        for (Animal animal : this.animales){
            if (animal != null){
                sumaPesos += animal.getPesoKg();
            }
        }

        return sumaPesos / this.numAnimales;
    }

    

}