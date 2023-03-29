package ejercicio03;

import java.util.Scanner;

/**
 * Clase principal
 */
public class Main {

    //Declaramos un objeto de la clase Scanner
    static Scanner sc = new Scanner(System.in);

    /**
     * Método principal
     * <p>
     * En el main lee el departamento por teclado de al menos dos artículos y pásalos a los constructores.
     * Tras realizar modificaciones sobre el objeto, imprímelos usando el método toString o el que hayas creado para
     * imprimir por pantalla.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int opcion; //Variable que guarda la opción que elige el usuario
        int opcionArticulo; //Variable que guarda la opción que elige el usuario para el artículo
        String tieneCupon;  //Variable que guarda si el usuario tiene un cupón de descuento

        //Creamos el primer articulo
        Articulo articulo1 = crearArticulo();

        //Mostramos el precio de venta al público del articulo1
        System.out.println("Precio de venta al público: " + articulo1.getPVP() + "€");

        //Le preguntamos al usuario si tiene un cupón de descuento
        System.out.println("¿Tiene un cupón de descuento para este artículo?");
        tieneCupon = sc.next();

        //Si el usuario tiene un cupón de descuento, se lo aplicamos
        if (tieneCupon.equals("si") || tieneCupon.equals("Si")) {
            hacerDescuento(articulo1);
        }

        //Mostramos la información del artículo
        System.out.println(articulo1);

        //Hacemos un salto de línea estético
        System.out.println();

        Articulo articulo2 = crearArticulo();

        //Mostramos el precio de venta al público del articulo2
        System.out.println("Precio de venta al público: " + articulo2.getPVP() + "€");

        //Le preguntamos al usuario si tiene un cupón de descuento
        System.out.println("¿Tiene un cupón de descuento para este artículo?");
        tieneCupon = sc.next();

        if (tieneCupon.equals("si") || tieneCupon.equals("Si")) {
            hacerDescuento(articulo2);
        }

        //Mostramos la información del segundo artículo
        System.out.println(articulo2);

        //Hacemos un salto de línea estético
        System.out.println();

        do {
            //Mostramos el menú por consola
            pintarMenu();

            opcion = sc.nextInt();

            //Según la opción que elija el usuario, se ejecutará una acción u otra
            switch (opcion) {
                case 1 -> {   //Si elige la opción 1, se venderá el artículo
                    System.out.println("¿Qué artículo desea vender? Introduzca 1 o 2: ");
                    opcionArticulo = sc.nextInt();

                    if (opcionArticulo == 1) {
                        venderArticulo(articulo1);
                    } else if (opcionArticulo == 2) {
                        venderArticulo(articulo2);
                    } else {
                        System.out.println("Opción no válida");
                    }
                }
                case 2 -> {    //Si elige la opción 2, se almacenará el artículo
                    System.out.println("¿Qué artículo desea almacenar? Introduzca 1 o 2: ");
                    opcionArticulo = sc.nextInt();

                    if (opcionArticulo == 1) {
                        almacenarArticulo(articulo1);
                    } else if (opcionArticulo == 2) {
                        almacenarArticulo(articulo2);
                    } else {
                        System.out.println("Opción no válida");
                    }
                }
                case 3 -> {    //Si elige la opción 3, se saldrá del programa
                    System.out.println("Hasta luego! :D");
                }
            }
        } while (opcion != 3);
    }

    /**
     * Método que creará un objeto de la clase Articulo según los datos que introduzca el usuario
     *
     * @return Devuelve el objeto de la clase Articulo
     */
    private static Articulo crearArticulo() {
        //Declaramos las variables
        String nombre; //Variable que guarda el nombre del artículo
        double precioSinIva; //Variable que guarda el precio sin IVA del artículo
        int cuantosQuedan; //Variable que guarda cuantos artículos quedan en el almacén
        String departamento;    //Variable que guarda el departamento del artículo

        //Pedimos los datos al usuario
        System.out.println("Introduce el nombre del artículo");
        nombre = sc.next();
        System.out.println("Introduce el precio sin IVA del artículo");
        precioSinIva = sc.nextDouble();
        System.out.println("Introduce cuantos artículos quedan en el almacén");
        cuantosQuedan = sc.nextInt();
        System.out.println("Introduce el departamento del artículo");
        departamento = sc.next();

        //Creamos el objeto y lo devolvemos
        return new Articulo(nombre, precioSinIva, cuantosQuedan, Articulo.Departamento.valueOf(departamento));
    }

    /**
     * Método que hará el descuento al artículo si el usuario lo desea
     *
     * @param articulo artículo al que se le va a hacer el descuento
     */
    private static void hacerDescuento(Articulo articulo) {
        double descuento;   //Variable que guarda el descuento que se le puede hacer al artículo

        //Le pedimos al usuario que introduzca el descuento
        System.out.println("Introduce el descuento");
        descuento = sc.nextDouble();
        //Mostramos el precio con el descuento por pantalla
        System.out.println("Precio de venta al público con un descuento del " + descuento + "%: " + articulo.getPVPDescuento(descuento) + "€");
    }

    /**
     * Método que pinta el menú por pantalla
     */
    private static void pintarMenu() {
        System.out.println("""
                Indique que desea hacer con el artículo
                [1] Venderlo
                [2] Almacenarlo
                [3] Nada
                """);
    }

    /**
     * Método que va a restar unidades al artículo que se le pasa por parámetro
     *
     * @param articulo : artículo al que se le van a restar unidades
     */
    private static void venderArticulo(Articulo articulo) {
        //Declaramos las variables
        int cuantosVender;  //Variable que guarda cuantos artículos se van a vender

        //Le pedimos al usuario que introduzca cuantas unidades quiere vender
        System.out.println("Introduce cuantas unidades quieres vender");
        cuantosVender = sc.nextInt();

        //Si el usuario quiere vender más unidades de las que hay en el almacén, le mostramos un mensaje de error
        if (cuantosVender > articulo.getCuantosQuedan()) {
            System.out.println("No hay suficientes unidades en stock");
        } else { //Si no, le restamos las unidades que ha pedido y las mostramos por pantalla
            articulo.vender(cuantosVender);
            System.out.println("Quedan en stock " + articulo.getCuantosQuedan() + " unidades del artículo");
        }
    }

    /**
     * Método que va a sumar unidades al artículo que se le pasa por parámetro
     *
     * @param articulo : artículo al que se le van a sumar unidades
     */
    private static void almacenarArticulo(Articulo articulo) {
        int cuantosAlmacenar;   //Variable que guarda cuantos artículos se van a almacenar

        //Le pedimos al usuario que introduzca cuantas unidades quiere almacenar
        System.out.println("Introduce cuantas unidades quieres almacenar");
        cuantosAlmacenar = sc.nextInt();

        //Sumamos las unidades que ha pedido y las mostramos por pantalla
        articulo.almacenar(cuantosAlmacenar);
        System.out.println("Quedan en stock " + articulo.getCuantosQuedan() + " unidades del artículo");
    }
}
