package lab1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        String host = "fohss.tu.edu.np";
        try{
            InetAddress addr = InetAddress.getByName(host);
            System.out.println(addr);
            byte[] address = addr.getAddress();
            
            switch (address.length) {
                case 4 -> System.out.println("The IP is of V4.");
                case 16 -> System.out.println("The IP is of V6.");
                default -> System.out.println("Invalid IP.");
            }
        }catch(UnknownHostException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
