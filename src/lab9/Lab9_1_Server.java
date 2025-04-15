package lab9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class Lab9_1_Server {
    public static void main(String[] args) throws SocketException, IOException {
        System.out.println("Time Server started on port " + 3000);
        DatagramSocket socket = new DatagramSocket(3000);
        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            String currentTime = new Date().toString();
            byte[] responseData = currentTime.getBytes("US-ASCII");

            DatagramPacket response = new DatagramPacket(
                responseData, responseData.length, 
                request.getAddress(), request.getPort()
            );

            socket.send(response);
            System.out.println("Responded to " + request.getAddress() + " with time: " + currentTime);
        }
    }
}
