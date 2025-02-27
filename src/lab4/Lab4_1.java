package lab4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab4_1 {
    public static void main(String[] args) {
        try {
            URL url;
            url = new URL("http://www.tu.edu.np");
            
            URLConnection urlcon = url.openConnection();
            
            Map<String, List<String>> headers;
            headers = urlcon.getHeaderFields();
            
            for(String key:headers.keySet()){
                System.out.println("Got " +key+ ": "+headers.get(key));
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lab4_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
