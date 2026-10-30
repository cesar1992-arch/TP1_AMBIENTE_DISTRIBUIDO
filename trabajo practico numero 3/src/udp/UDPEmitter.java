package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEmitter {

    public static void main(String[] args) {

        try (DatagramSocket socket =
                     new DatagramSocket()) {

            InetAddress address =
                    InetAddress.getByName("localhost");

            while (true) {String alert = "ALERTA: Sensor activo";
                byte[] buffer = alert.getBytes();

                DatagramPacket packet =
                        new DatagramPacket(buffer, buffer.length, address, 6000);

                socket.send(packet);

                System.out.println("Alerta enviada.");

                Thread.sleep(3000);
            }

        } catch (Exception e) {e.printStackTrace();
        }
    }
}