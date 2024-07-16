import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monedaOrigen = null;
        String monedaDestino = null;
        double cantidad = -1;
        System.out.println("Convertidor de moneda");

        while (true) {
            System.out.println("********************");
            System.out.println("Monedas disponibles: ");
            System.out.println("1. ARS - Peso argentino");
            System.out.println("2. BOB - Boliviano boliviano");
            System.out.println("3. BRL - Real brasileño");
            System.out.println("4. CLP - Peso chileno");
            System.out.println("5. COP - Peso colombiano");
            System.out.println("6. USD - Dólar estadounidense");
            System.out.println("7. MXN - Peso mexicano");
            System.out.println("0. Salir");

            while (monedaOrigen == null) {
                System.out.println("********************");
                System.out.print("Selecciona la moneda origen: ");
                monedaOrigen = Moneda.obtenerCodigo(scanner.nextLine());
                if (monedaOrigen == null) {
                    System.out.println("Opción invalida");
                }
            }

            if (monedaOrigen.isEmpty()) {
                break;
            }

            while (monedaDestino == null) {
                System.out.println("********************");
                System.out.print("Selecciona la moneda destino: ");
                monedaDestino = Moneda.obtenerCodigo(scanner.nextLine());
                if (monedaDestino == null) {
                    System.out.println("Opción invalida");
                }
            }

            if (monedaDestino.isEmpty()) {
                break;
            }

            double taza = Moneda.obtenerTaza(monedaOrigen, monedaDestino);
            if (taza == 0) {
                System.out.println("No es posible obtener la taza de cambio en este momento");
                break;
            } else {
                System.out.println("********************");
                System.out.println("Taza de cambio " + monedaOrigen + " -> " + monedaDestino + ": " + taza);
            }

            while (cantidad < 0) {
                try {
                    System.out.println("********************");
                    System.out.print("Cantidad a convertir: ");
                    cantidad = scanner.nextDouble();
                    scanner.nextLine();
                    if (cantidad < 0) {
                        System.out.println("La cantidad proporcionada no es valida");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("La cantidad proporcionada no es valida");
                    scanner.nextLine();
                }
            }

            System.out.println("********************");
            System.out.println(cantidad + " " + monedaOrigen + " -> " + monedaDestino + " = " + taza * cantidad + " " + monedaDestino);
            System.out.println("Presiona ENTER para continuar...");
            scanner.nextLine();

            monedaOrigen = null;
            monedaDestino = null;
            cantidad = -1;
        }
        System.out.println("********************");
        System.out.println("Finalizando programa");
    }
}
