import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        String host = "localhost";
        int puerto = 5500;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        int numero1 = teclado.nextInt();

        System.out.print("Ingrese la operacion (+, -, *, /): ");
        String operacion = teclado.next();

        System.out.print("Ingrese el segundo numero: ");
        int numero2 = teclado.nextInt();

        String mensaje = numero1 + ";" + operacion + ";" + numero2;

        try (Socket socket = new Socket(host, puerto)) {

            System.out.println("Conectado al servidor.");

            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(), true
            );

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            salida.println(mensaje);

            System.out.println("Datos enviados: " + mensaje);

            String resultado = entrada.readLine();

            System.out.println("Resultado recibido: " + resultado);

        } catch (ConnectException e) {

            System.out.println("ERROR: No se pudo conectar con el servidor.");
            System.out.println("Detalle: " + e.getMessage());

        } catch (IOException e) {

            System.out.println("Error de comunicacion: " + e.getMessage());
        }

        teclado.close();
    }
}