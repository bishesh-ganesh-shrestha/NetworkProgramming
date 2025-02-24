package lab2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab2_1 {
    public static void main(String[] args) {
        try {
            String urlStr = "https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-";
            URL url = new URL(urlStr);
            System.out.println("protocol = " + url.getProtocol());
            System.out.println("domain = " + url.getHost());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lab2_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
