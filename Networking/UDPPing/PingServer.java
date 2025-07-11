import java.net.*;
import java.io.*;

public class PingServer {
    public static void main(String[] args) {
        final int PORT = 9000;

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("PingServer listening on port " + PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received: " + message);

                if (message.equalsIgnoreCase("ping")) {
                    byte[] responseData = "pong".getBytes();
                    DatagramPacket responsePacket = new DatagramPacket(
                        responseData,
                        responseData.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                    );
                    socket.send(responsePacket);
                    System.out.println("Responded: pong");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
