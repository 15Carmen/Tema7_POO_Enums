package ejercicio01;


public class CuentaCorriente {

    //Declaramos el enum
    enum Sexo {Masculino, Femenino}
    Sexo sexo;

    //Declaramos los atributos

    /**
     * Atributo que guarda el nombre del titular de la cuenta corriente
     */
    private String nombre;
    /**
     * Atributo que guarda el dni del titular
     */
    private final String DNI;
    /**
     * Atributo que guarda el saldo de la cuenta corriente
     */
    private double saldo;

    /**
     * Constructor de la clase CuentaCorriente con todos los atributos
     *
     * @param nombre
     * @param DNI
     * @param saldo
     * @param sexo
     */
    public CuentaCorriente(String nombre, String DNI, double saldo, String sexo) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.saldo = saldo;
        this.sexo = Sexo.valueOf(sexo);
    }

    /**
     * Constructor de la clase CuentaCorriente con el atributo DNI y saldo
     *
     * @param DNI
     * @param saldo
     */
    public CuentaCorriente(String DNI, double saldo) {
        this.DNI = DNI;
        this.saldo = saldo;
    }

    /**
     * Método que saca tanto dinero de la cuenta corriente como se especifique por parámetro
     *
     * @param cantidadSacar
     */
    public void sacarDinero(double cantidadSacar) {
        if (saldo > 0) {
            if (saldo > cantidadSacar) {
                saldo -= cantidadSacar;
            } else {
                System.out.println("No tiene suficiente saldo para sacresta cantidad de dinero");
            }
        } else {
            System.out.println("No tiene suficiente saldo para sacar dinero");
        }
    }

    /**
     * Precondición: El parámetro cantidadIngresar debe ser mayor que 0
     * Método que ingresa tanto dinero en la cuenta corriente como se especifique por parámetro
     *
     * @param cantidadIngresar
     */
    public void ingresarDinero(double cantidadIngresar) {
        saldo += cantidadIngresar;
    }

    /**
     * Método que muestra la información de la cuenta corriente
     *
     * @return cadena de texto con la información introducida por el usuario
     */
    @Override
    public String toString() {
        String result = "";
        result += "DNI: " + DNI + "\n";
        result += "Nombre: " + nombre + "\n";
        result += "Saldo: " + saldo + "\n";
        result += "Sexo: " + sexo;
        return result;
    }
}
