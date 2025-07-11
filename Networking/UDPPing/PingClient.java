import java.net.*;
import java.io.*;

public class PingClient {
    public static void main(String[] args) {
        final String SERVER = "localhost";
        final int PORT = 9000;
        final int TIMEOUT = 2000; // milliseconds

        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(TIMEOUT);

            byte[] sendData = "ping".getBytes();
            InetAddress serverAddress = InetAddress.getByName(SERVER);

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PORT);
            socket.send(sendPacket);
            System.out.println("Sent: ping");

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            try {
                socket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received: " + response);
            } catch (SocketTimeoutException e) {
                System.out.println("No response (timeout after " + TIMEOUT + "ms).");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
