package tcp;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            out = new PrintWriter(
                    socket.getOutputStream(),
                    true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String message;

        try {

            while ((message = in.readLine()) != null) {

                System.out.println(
                        "Mensaje recibido: "
                                + message);

                ChatServer.enviarATodos(message, this);
            }

        } catch (IOException e) {System.out.println("Cliente desconectado.");

        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ChatServer.eliminarCliente(this);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}