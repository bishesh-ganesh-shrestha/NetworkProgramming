package lab1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab1_4 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> adapters = NetworkInterface.getNetworkInterfaces();
            while(adapters.hasMoreElements()){
                NetworkInterface adapter = adapters.nextElement();
                System.out.println("Name: " + adapter.getName());
                System.out.println("Display Name: " + adapter.getDisplayName());
                System.out.println();
                Enumeration<InetAddress> addrs = adapter.getInetAddresses();
                while(addrs.hasMoreElements()){
                    System.out.println(addrs.nextElement());
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(Lab1_4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
