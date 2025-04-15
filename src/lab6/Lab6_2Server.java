package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Lab6_2Server {
    public static void main(String[] args) {
        int port = 13;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Echo Server is running on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     Writer writer = new OutputStreamWriter(clientSocket.getOutputStream())) {

                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    String receivedMessage;
                    while ((receivedMessage = in.readLine()) != null) {
                        System.out.println("Received: " + receivedMessage);
                        writer.write(receivedMessage); // Echoing back the same message
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
