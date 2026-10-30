package tcp;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    // Lista de clientes conectados
    private static ArrayList<ClientHandler> clientes =
            new ArrayList<>();

    public static void main(String[] args) {

        try {

            ServerSocket servidor =
                    new ServerSocket(5000);

            System.out.println("Servidor iniciado en el puerto 5000");

            while (true) {

                // Espera una conexión
                Socket socket =
                        servidor.accept();

                System.out.println("Cliente conectado");

                // Crea un manejador para el cliente
                ClientHandler cliente =
                        new ClientHandler(socket);

                // Lo agrega a la lista
                clientes.add(cliente);

                // Lo atiende en un hilo independiente
                Thread hilo =
                        new Thread(cliente);

                hilo.start();
            }

        } catch (Exception e) {e.printStackTrace();
        }
    }

    // Envía el mensaje a todos los clientes excepto al remitente
    public static void enviarATodos(
            String mensaje,
            ClientHandler remitente) {

        for (ClientHandler cliente : clientes) {

            if (cliente != remitente) {

                cliente.sendMessage(mensaje);
            }
        }
    }

    // Elimina un cliente cuando se desconecta
    public static void eliminarCliente(
            ClientHandler cliente) {

        clientes.remove(cliente);

        System.out.println("Cliente desconectado");
    }
}