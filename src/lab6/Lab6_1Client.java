package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Lab6_1Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 13;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            String response = in.readLine();
            System.out.println("Server Response: " + response);
            socket.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
