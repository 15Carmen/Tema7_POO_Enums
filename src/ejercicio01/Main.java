package ejercicio01;

public class Main {
    public static void main(String[] args) {
        CuentaCorriente cuenta = new CuentaCorriente("12345678Z", "Pepe", 2000, "Femenino");
        CuentaCorriente cuenta2 = new CuentaCorriente("12345678Z", "Lucas", 2000, "Masculino");
        System.out.println(cuenta);
        System.out.println(cuenta2);
    }
}