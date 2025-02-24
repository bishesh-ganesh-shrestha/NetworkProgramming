package lab2;

import java.net.MalformedURLException;
import java.net.URL;

public class Lab2_2 {
    public static void main(String[] args) {
        String urlStr = "kathford.edu.np";
        String[] protocol = {"http", "https", "ftp", "telnet", "mailto", "gopher"};
        for(String p: protocol){
            try {
                URL url = new URL(p+"://"+urlStr);
                System.out.println(p + " is working in "+url);
            } catch (MalformedURLException ex) {
                System.out.println("*** Error: "+ p + " does not work");
            }
        }
    }
}
