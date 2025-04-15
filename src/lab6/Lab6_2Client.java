package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Lab6_2Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 13;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Writer writer = new OutputStreamWriter(socket.getOutputStream());
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to Echo Server. Type your message:");

            String message;
            while (true) {
                System.out.print("> ");
                message = userInput.readLine();

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Closing connection...");
                    break;
                }

                writer.write(message);
                String response = in.readLine();
                System.out.println("Server echoed: " + response);
            }
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
