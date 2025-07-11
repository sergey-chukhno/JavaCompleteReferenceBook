import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        final String SERVER = "localhost";
        final int PORT = 5000;

        try (
            Socket socket = new Socket(SERVER, PORT);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            System.out.println("Connected to EchoServer on " + SERVER + ":" + PORT);
            String input;
            while (true) {
                System.out.print("You: ");
                input = userInput.readLine();
                out.println(input);
                String response = in.readLine();
                System.out.println(response);

                if ("bye".equalsIgnoreCase(input.trim())) {
                    System.out.println("Disconnected.");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
