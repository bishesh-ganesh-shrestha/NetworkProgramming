package lab1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab1_3 {
    public static void main(String[] args) {
        try {
            InetAddress addr1 = InetAddress.getByName("127.0.0.1");
            InetAddress addr2 = InetAddress.getByName("localhost");
            System.out.println("Address1: " + addr1);
            System.out.println("Address2: " + addr2);
            System.out.println("Are they same? => " + addr1.equals(addr2));
        } catch (UnknownHostException ex) {
            Logger.getLogger(Lab1_3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
