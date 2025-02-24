package lab1;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab1_5 {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            InetAddress addr = InetAddress.getByName(host);
            System.out.println("Address: " + addr);
            System.out.println("Is it reachable? => " + addr.isReachable(10));
        } catch (IOException ex) {
            Logger.getLogger(Lab1_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
