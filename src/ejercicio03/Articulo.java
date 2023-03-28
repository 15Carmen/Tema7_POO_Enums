package ejercicio03;

/**
 * Clase donde se definirán los atributos y métodos de los objetos Articulo
 */
public class Articulo {

    //Declaramos un enum que guarde distintos departamentos
    enum Departamento {Electronica, Alimentacion, Drogueria}

    //Declaramos los atributos

    /**
     * Atributo que guarda el nombre del artículo
     */
    private String nombre;

    /**
     * Atributo que guarda el precio sin IVA del artículo
     */
    private double precioSinIva;

    /**
     * Atributo que guarda cuantos artículos quedan en el almacén
     */
    private int cuantosQuedan;

    /**
     * Atributo que guarda el porcentaje de IVA del artículo
     */
    public static final double IVA = 0.21;

    /**
     * Atributo que guarda el departamento al que pertenece el artículo
     */
    private Departamento departamento;


    /**
     * Constructor con parámetros de la clase Articulo
     *
     * @param nombre
     * @param precioSinIva
     * @param cuantosQuedan
     * @param departamento
     */
    public Articulo(String nombre, double precioSinIva, int cuantosQuedan, Departamento departamento) {

        if (!nombre.isEmpty() || nombre != null) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre del artículo no puede estar vacío");
        }

        if (precioSinIva > 0) {
            this.precioSinIva = precioSinIva;
        } else {
            System.out.println("El precio sin IVA del artículo no puede ser menor o igual que 0");
        }

        if (cuantosQuedan >= 0) {
            this.cuantosQuedan = cuantosQuedan;
        } else {
            System.out.println("La cantidad de artículos en el almacén no puede ser menor que 0");
        }

        this.departamento = departamento;

    }

    //Declaramos los getter y setter

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        //Comprobamos que el nombre no esté vacío
        if (!nombre.isEmpty() || nombre != null) {
            this.nombre = nombre;
        }
    }

    public double getPrecioSinIva() {
        return precioSinIva;
    }
    public void setPrecioSinIva(double precioSinIva) {
        //Comprobamos que el precio sin IVA sea mayor que 0
        if (precioSinIva > 0) {
            this.precioSinIva = precioSinIva;
        }
    }

    public int getCuantosQuedan() {
        return cuantosQuedan;
    }
    public void setCuantosQuedan(int cuantosQuedan) {
        //Comprobamos que la cantidad de artículos en el almacén sea mayor o igual que 0
        if (cuantosQuedan >= 0) {
            this.cuantosQuedan = cuantosQuedan;
        }
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    //Creamos los métodos de la clase Articulo

    /**
     * Método que va a imprimir la información del artículo por pantalla
     *
     * @return String con la información del artículo
     */
    @Override
    public String toString() {
        String cadena = "";

        cadena = "Nombre: " + nombre +
                "\nPrecio sin IVA: " + precioSinIva + "€" +
                "\nIVA: " + IVA +
                "\nCantidad en stock: " + cuantosQuedan +
                "\nDepartamento: " + departamento;

        return cadena;
    }

    /**
     * Precondición: el precio del artículo debe ser mayor que 0
     * Método para calcular el precio de venta al público del artículo con el IVA incluido
     *
     * @return double con el precio de venta al público
     */
    public double getPVP() {
        //Declaramos las variables
        double PVP; //Variable que guarda el precio de venta al público

        //Calculamos el precio de venta al público, sumando el precio sin IVA más el IVA
        PVP = precioSinIva + (precioSinIva * IVA);

        //Devolvemos el precio de venta al público
        return PVP;
    }

    /**
     * Método para calcular el precio de venta al público del artículo con el IVA incluido y con el descuento aplicado.
     *
     * @param descuento : porcentaje de descuento que se va a aplicar
     * @return double con el precio de venta al público con el descuento aplicado
     */
    public double getPVPDescuento(double descuento) {
        //Declaramos las variables
        double PVP; //Variable que guarda el precio de venta al público
        double PVPDescuento; //Variable que guarda el precio de venta al público con el descuento aplicado
        descuento = descuento / 100; //Convertimos el porcentaje a decimal

        PVP = getPVP(); //Obtenemos el precio de venta al público utilizando el metodo anterior
        PVPDescuento = PVP - (PVP * descuento); //Calculamos el precio de venta al público con el descuento aplicado

        //Devolvemos el precio de venta al público
        return PVPDescuento;
    }

    /**
     * Precondición: la cantidad de artículos que quedan en el almacén debe ser mayor o igual que la cantidad que se quiere vender
     * Método que le restará al atributo cuantosQuedan la cantidad de artículos que se pasen por parámetros.
     *
     * @param cantidadVender :  cantidad de artículos que se van a vender
     * @return true si se puede vender la cantidad de artículos especificada y false si no es posible
     */
    public boolean vender(int cantidadVender) {
        //Declaramos las variables
        boolean vender = false;   //Variable que guarda si se puede vender o no

        //Si la cantidad de artículos que quedan es mayor que la cantidad que se quiere vender, se puede vender
        if (this.cuantosQuedan >= cantidadVender) {
            vender = true;
            //Restamos la cantidad de artículos que se van a vender al atributo cuantosQuedan
            this.cuantosQuedan -= cantidadVender;
        }
        //Devolvemos si se puede vender o no
        return vender;
    }

    /**
     * Método que le sumará al atributo cuantosQuedan la cantidad de artículos que se pasen por parámetros.
     *
     * @param cantidadAlmacenar : cantidad de artículos que se van a almacenar
     */
    public void almacenar(int cantidadAlmacenar) {
        //Sumamos la cantidad de artículos que se van a almacenar al atributo cuantosQuedan
        this.cuantosQuedan += cantidadAlmacenar;
    }
}
