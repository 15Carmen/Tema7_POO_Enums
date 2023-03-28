package ejercicio02;


public class Libro {

    /**
     * Enum de generos literarios
     */
    enum Genero {Narrativo, Lirico, Dramatico, Didactico, Poetico}

    /**
     * Atributo que guarda el género del libro
     */
    private Genero genero;

    /**
     * Atributo que guarda el título del libro
     */
    private String titulo;
    /**
     * Atributo que guarda el autor del libro
     */
   private String autor;
    /**
     * Atributo que guarda el número de ejemplares del libro
     */
    private int numEjemplares;
    /**
     * Atributo que guarda el número de ejemplares prestados del libro
     */
    private int numPrestados;



    /**
     * Constructor de la clase Libro sin parámetros
     */
    public Libro() {
    }

    /**
     * Constructor de la clase Libro con todos los atributos
     * @param titulo
     * @param autor
     * @param numEjemplares
     * @param numPrestados
     */
    public Libro(String titulo, String autor, int numEjemplares, int numPrestados, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = numEjemplares;
        this.numPrestados = numPrestados;
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
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

    public int getNumEjemplares() {
        return numEjemplares;
    }
    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public int getNumPrestados() {
        return numPrestados;
    }
    public void setNumPrestados(int numPrestados) {
        this.numPrestados = numPrestados;
    }

    /**
     * Método que devuelve si un libro se ha prestado o no
     * @return true si se ha prestado, false si no se ha prestado
     */
    public boolean prestamo() {
        //Declaro las variables
        boolean prestado = false;

        //Si el numero de ejemplares prestados es menor que el número de ejemplares total
        if (numPrestados < numEjemplares) {
            numPrestados++;
            //Indico que el libro se ha prestado
            prestado = true;
        }
        //Devuelvo el valor de la variable prestado
        return prestado;
    }

    /**
     * Método que devuelve si un libro se ha devuelto o no
     * @return true si se ha devuelto, false si no se ha devuelto
     */
    public boolean devolucion() {
        //Declaro las variables
        boolean devuelto = false;

        //Si hay ejemplares prestados, incremento el número de ejemplares disponibles y decremento el número de ejemplares prestados
        if (numPrestados > 0) {
            numPrestados--;
            //Indico que el libro se ha devuelto
            devuelto = true;
        }
        //Devuelvo el valor de la variable devuelto
        return devuelto;
    }

    @Override
    public String toString() {
        return
                "Titulo: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Género: " + genero + "\n" +
                "Número de ejemplares: " + numEjemplares + "\n" +
                "Número de ejemplares prestados: " + numPrestados;
    }
}
