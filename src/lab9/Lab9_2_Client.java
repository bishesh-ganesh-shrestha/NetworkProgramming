package lab9;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class Lab9_2_Client {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);

        InetAddress serverInetAddress = InetAddress.getByName("localhost");
        byte[] receiveBuffer = new byte[1024];

        System.out.println("Type your message (type 'exit' to quit):");

        while (true) {
            System.out.print("You: ");
            String message = scanner.nextLine();

            if ("exit".equalsIgnoreCase(message)) {
                System.out.println("Chat ended.");
                break;
            }

            byte[] sendData = message.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(
                sendData, sendData.length, serverInetAddress, 4000
            );
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
            System.out.println(response);
        }
    }
}
