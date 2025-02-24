package lab1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab1_2 {
    public static void main(String[] args) {
        try{
            String host = "dns.google.com";
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for(int i=0; i<addresses.length;i++){
                System.out.println("Address ["+ i+1 +"]");
                System.out.println("Host Name: "+ addresses[i].getHostName());
                System.out.println("Canonical Host Name: " + addresses[i].getCanonicalHostName());
                System.out.println("Host Address: " + addresses[i].getHostAddress());
                System.out.println();
            }
        }catch(UnknownHostException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
