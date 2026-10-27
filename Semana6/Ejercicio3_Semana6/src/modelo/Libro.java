package modelo;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(){
    }
    public Libro(String isbn, String titulo, String autor, int anioPublicacion){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override 
    public String toString(){
        return "Libro [ISBN=" + isbn + ", Titulo=" + titulo + ",Autor=" + autor + ",Año publicación=" + anioPublicacion + "]";
    }
    
}
