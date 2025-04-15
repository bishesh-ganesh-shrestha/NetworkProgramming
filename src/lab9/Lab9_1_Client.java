package lab9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Lab9_1_Client {
    public static void main(String[] args) throws SocketTimeoutException, IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(10000);

        InetAddress serverAddress = InetAddress.getByName("localhost");
        byte[] buffer = new byte[1];
        DatagramPacket request = new DatagramPacket(buffer, buffer.length, serverAddress, 3000);
        socket.send(request);

        byte[] responseBuffer = new byte[1024];
        DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
        socket.receive(response);

        String timeReceived = new String(response.getData(), 0, response.getLength(), "US-ASCII");
        System.out.println("Time from server: " + timeReceived);
    }
}
