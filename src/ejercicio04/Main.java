package ejercicio04;

import java.util.Scanner;

public class Main {

    /**
     * Declaramos el scanner para poder leer por teclado
     */
    static Scanner sc = new Scanner(System.in);

    /**
     * Método principal
     *
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int opc;                //Variable donde vamos a guardar la opción del menú que el usuario elija
        int contador = 0;       //Variable que usaremos para contar los discos que hay en el array

        //Declaramos un array de discos tipo Disco de 10 posiciones
        Disco[] arrayDiscos = new Disco[10];

        //Crear u objeto tipo disco y asignarlo a cada posición del array
        for (int i = 0; i < arrayDiscos.length; i++) {
            arrayDiscos[i] = new Disco();
        }

        //Mientras salir sea false, seguimos ejecutando el menú
        do {
            //Mostramos el menú por pantalla
            pintarMenu();
            opc = sc.nextInt();

            //Según la opción que elija el usuario, ejecutamos el código correspondiente
            switch (opc) {
                case 1: {   //Listado de los discos introducidos en el array
                    listado(arrayDiscos);
                    break;
                }
                case 2: {   //Introducimos un nuevo disco en el array

                    //Si el método posicionLibre devuelve un resultado menor que 0, es que no hay más espacio en el array
                    if (posicionLibre(arrayDiscos) < 0) {
                        System.out.println("No hay más espacio en el array");
                    } else {   //Si el método devuelve un número mayor o igual que 0, es que hay espacio en el array
                        //Llamamos al método que nos permite añadir un nuevo disco
                        contador = posicionLibre(arrayDiscos);
                        nuevoDisco(arrayDiscos, contador);

                    }
                    break;
                }

                case 3: {    //Modificamos un disco del array
                    modificarDisco(arrayDiscos);
                    break;
                }
                case 4: {    //Borramos un disco del array

                    borrarDisco(arrayDiscos);
                    break;
                }
                case 5: {    //Salimos del menú
                    System.out.println("Hasta pronto!");
                    break;
                }
                default: {   //Si el usuario introduce una opción no válida, mostramos un mensaje de error
                    System.out.println("Opción no válida");
                }
            }
        } while (opc != 5);  //Fin del do-while

        //Cerramos el scanner
        sc.close();

    }//Fin del main

    /**
     * Método para mostrar el menú
     */
    private static void pintarMenu() {
        System.out.println("""
                COLECCIÓN DE DISCOS
                ===================
                1. Listado.
                2. Nuevo Disco.
                3. Modificar.
                4. Borrar.
                5. Salir.
                """);
    }   //Fin del método pintarMenu

    /**
     * Método para mostrar el listado de discos
     *
     * @param arrayDiscos
     */
    private static void listado(Disco[] arrayDiscos) {
        for (Disco disco : arrayDiscos) {
            if (!disco.getCodigo().equals("LIBRE")) {
                System.out.println(disco);
            }

        }
    }   //Fin del método listado

    /**
     * Método para añadir un nuevo disco al array de discos
     *
     * @param discos   Array de discos
     * @param contador Contador de la posición del array
     * @return Devuelve el contador
     */
    private static int nuevoDisco(Disco[] discos, int contador) {

        //Declaramos las variables
        String codigo;          //Variable donde vamos a guardar el código del disco
        String autor;           //Variable donde vamos a guardar el autor del disco
        String titulo;          //Variable donde vamos a guardar el título del disco
        String genero;          //Variable donde vamos a guardar el género del disco
        int duracion;           //Variable donde vamos a guardar la duración del disco

        codigo = String.valueOf(contador);

        //Pedimos los datos del disco al usuario

        System.out.println("Introduce el autor del disco: ");
        autor = sc.next();

        System.out.println("Introduce el título del disco: ");
        titulo = sc.next();

        System.out.println("Introduce el género del disco: ");
        genero = sc.next();

        System.out.println("Introduce la duración del disco: ");
        sc.nextLine();
        duracion = sc.nextInt();

        //Creamos el objeto disco
        discos[posicionLibre(discos)] = new Disco(codigo, autor, titulo, Disco.Genero.valueOf(genero), duracion);

        contador++;

        return contador;

    }   //Fin del método nuevoDisco

    /**
     * Metodo para buscar la primera posición libre del array
     *
     * @param arrayDisco array de discos
     * @return la posición libre del array si hay alguna, -1 si el array está lleno
     */
    private static int posicionLibre(Disco[] arrayDisco) {
        //Declaramos la variable
        int posicion = 0;

        //Recorremos el array hasta encontrar una posición libre
        while (posicion < arrayDisco.length && !arrayDisco[posicion].getCodigo().equals("LIBRE")) {
            posicion++;
        }

        //Si el array está lleno, devolvemos -1
        if (posicion == arrayDisco.length) {
            posicion = -1;
        }

        return posicion;
    }   //Fin del método posicionLibre

    /**
     * Método que modificará un disco elegido por el usuario del array de discos
     *
     * @param arrayDiscos Array de discos
     */
    private static void modificarDisco(Disco[] arrayDiscos) {

        //Pedimos el código del disco que queremos modificar
        System.out.println("Introduce el código del disco que quieres modificar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        //Buscamos el disco en el array

        //Si el codigo del disco es distinto de "LIBRE", es que existe un disco con ese código
        if (!arrayDiscos[codigo].getCodigo().equals("LIBRE")) {
            //Pedimos los nuevos datos del disco al usuario
            System.out.println("Introduzca el autor del disco:");
            String autor = sc.nextLine();
            arrayDiscos[codigo].setAutor(autor);

            System.out.println("Introduzca el titulo del disco:");
            String titulo = sc.nextLine();
            arrayDiscos[codigo].setTitulo(titulo);

            System.out.println("Introduzca el genero del disco:");
            String genero = sc.nextLine();
            arrayDiscos[codigo].setGenero(Disco.Genero.valueOf(genero));

            System.out.println("Introduzca la duración del disco:");
            int duracion = sc.nextInt();
            arrayDiscos[codigo].setDuracion(duracion);

        }else { //Si el código del disco es "LIBRE", es que no existe ningún disco con ese código
            System.out.println("No existe ningún disco con ese código");
        }

    }   //Fin del método modificarDisco

    /**
     * Método que borra un disco del array de discos
     * @param arrayDiscos Array de discos
     */
    private static void borrarDisco(Disco[] arrayDiscos) {

        //Le pedimos al usuario el código del disco que quiere borrar
        System.out.println("Introduzca el código del disco a borrar");
        int posicion = sc.nextInt();
        //Leemos la siguiente línea para que no se quede el salto de línea en el buffer
        sc.nextLine();

        //Si la posición es válida, borramos el disco, es decir, ponemos el código a "LIBRE"
        if(posicion>=0 && posicion<arrayDiscos.length) {
            arrayDiscos[posicion].setCodigo("LIBRE");
        } else {    //Si la posición no es válida, mostramos un mensaje de error
            System.out.println("Código no válido");
        }
    }   //Fin del método borrarDisco



}
