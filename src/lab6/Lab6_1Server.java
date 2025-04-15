package lab6;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Lab6_1Server {
    public static void main(String[] args) {
        int port = 13;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("DayTime Server started on port " + port);

            while (true) {
                Socket connection = serverSocket.accept();
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                out.write(now.toString()+"\r\n");
                out.flush();
            }            
        } catch (IOException e) {
            e.getMessage();
        } finally {
//            serverSocket.close();
        }
    }
}
