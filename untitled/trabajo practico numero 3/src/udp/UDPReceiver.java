package udp;

import java.net.*;

public class UDPReceiver {

    public static void main(String[] args) {

        int port = 6000;

        try (DatagramSocket socket =
                     new DatagramSocket(port)) {

            socket.setSoTimeout(5000);

            System.out.println(
                    "Servidor UDP escuchando...");

            while (true) {

                try {

                    byte[] buffer =
                            new byte[1024];

                    DatagramPacket packet =
                            new DatagramPacket(
                                    buffer,
                                    buffer.length);

                    socket.receive(packet);

                    String message =
                            new String(
                                    packet.getData(),
                                    0,
                                    packet.getLength());

                    System.out.println(
                            "Alerta recibida: "
                                    + message);

                } catch (SocketTimeoutException e) {

                    System.out.println(
                            "[ADVERTENCIA] No se recibieron paquetes en los últimos 5 segundos.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}