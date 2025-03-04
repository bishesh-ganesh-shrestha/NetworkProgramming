package lab5;

import java.net.*;
import java.io.*;

public class Lab5_3 {
    public static void main(String[] args) {
        String host = "time.nist.gov";
        
        for (int i = 7000; i <= 9000; i++) {
            try {
                Socket s = new Socket(host, i);
                System.out.println("There is a server on port " + i + " of " + host);
                s.close();
            } catch (UnknownHostException ex) {
                System.err.println("Unknown host: " + host);
                break;
            } catch (IOException ex) {
                // No server on this port, ignore
            }
        }
    }
}
