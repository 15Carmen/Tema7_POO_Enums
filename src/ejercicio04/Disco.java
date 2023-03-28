package ejercicio04;

/**
 * Clase donde se definirán los atributos y métodos de los objetos Disco
 */
public class Disco {

    //Declaramos un enum de generos musicales
    enum Genero{Rock, Pop, Electronica, Reggeaton}

    //Declaramos los atributos
    /**
     * Atributo donde guardaremos el código del disco
     */
    private String codigo = "LIBRE";
    /**
     * Atributo donde guardaremos el autor del disco
     */
    private String autor = "";
    /**
     * Atributo donde guardaremos el título del disco
     */
    private String titulo = "";
    /**
     * Atributo donde guardaremos el género del disco
     */
    private Genero genero;
    /**
     * Atributo donde guardaremos la duración del disco
     */
    private int duracion = 0;

    //Constructor por defecto
    public Disco() {
    }

    //Constructor con un parámetro
    public Disco(String codigo) {
        this.codigo = codigo;
    }

    //Constructor con parámetros
    public Disco(String codigo, String autor, String titulo, Genero genero, int duracion) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    //Constructor copia
    public Disco(Disco disco) {
        this.codigo = disco.codigo;
        this.autor = disco.autor;
        this.titulo = disco.titulo;
        this.genero = disco.genero;
        this.duracion = disco.duracion;
    }

    //Declaramos los getter y setter

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }
    }


    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String cadena = "";

        cadena = "Código: " + codigo + "\n" +
                "Autor: " + autor + "\n" +
                "Título: " + titulo + "\n" +
                "Género: " + genero + "\n" +
                "Duración: " + duracion + "\n";
        return cadena;
    }


}
