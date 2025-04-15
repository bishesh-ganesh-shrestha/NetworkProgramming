import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Lab9_2_Server {
    public static void main(String[] args) throws SocketException, IOException {
        System.out.println("Chat Server started on port " + 4000);
        
        DatagramSocket serverSocket = new DatagramSocket(4000);
        byte[] receiveBuffer = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);

            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
            System.out.println("Client: " + clientMessage);

            String response = "Server received: " + clientMessage;
            byte[] responseData = response.getBytes("UTF-8");

            DatagramPacket sendPacket = new DatagramPacket(
                responseData, responseData.length,
                receivePacket.getAddress(), receivePacket.getPort()
            );

            serverSocket.send(sendPacket);
        }
    }
}

