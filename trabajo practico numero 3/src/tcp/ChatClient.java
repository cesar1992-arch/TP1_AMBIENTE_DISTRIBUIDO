package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 5000);

            BufferedReader entrada =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter salida =
                    new PrintWriter(
                            socket.getOutputStream(),
                            true);

            Scanner teclado =
                    new Scanner(System.in);

            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();

            Thread recibir = new Thread(() -> {

                try {

                    String mensaje;

                    while ((mensaje = entrada.readLine()) != null) {

                        System.out.println(mensaje);
                    }

                } catch (Exception e) {
                    System.out.println("Conexión cerrada");
                }
            });

            recibir.start();

            while (true) {

                String mensaje = teclado.nextLine();

                salida.println(nombre + ": " + mensaje);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}