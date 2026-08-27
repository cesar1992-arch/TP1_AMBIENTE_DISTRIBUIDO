import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {

        int puerto = 5500;

        try (ServerSocket servidor = new ServerSocket(puerto)) {

            System.out.println("Servidor iniciado.");
            System.out.println("Esperando conexiones en el puerto " + puerto + "...");

            try (Socket socket = servidor.accept()) {

                System.out.println("Cliente conectado.");

                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                PrintWriter salida = new PrintWriter(
                        socket.getOutputStream(), true
                );

                // Recibir mensaje del cliente
                String mensaje = entrada.readLine();

                System.out.println("Datos recibidos: " + mensaje);

                // Separar los datos: ejemplo "15;+;30"
                String[] datos = mensaje.split(";");

                int numero1 = Integer.parseInt(datos[0]);
                String operacion = datos[1];
                int numero2 = Integer.parseInt(datos[2]);

                String resultado;

                // Realizar la operación
                switch (operacion) {

                    case "+":
                        resultado = String.valueOf(numero1 + numero2);
                        break;

                    case "-":
                        resultado = String.valueOf(numero1 - numero2);
                        break;

                    case "*":
                        resultado = String.valueOf(numero1 * numero2);
                        break;

                    case "/":
                        if (numero2 == 0) {
                            resultado = "ERROR: Division por cero";
                        } else {
                            resultado = String.valueOf((double) numero1 / numero2);
                        }
                        break;

                    default:
                        resultado = "ERROR: Operacion no valida";
                }

                // Enviar resultado al cliente
                salida.println(resultado);

                System.out.println("Resultado enviado: " + resultado);
            }

        } catch (IOException e) {

            System.out.println("Error de comunicacion: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Error: los numeros recibidos no son validos.");
        }
    }
}
