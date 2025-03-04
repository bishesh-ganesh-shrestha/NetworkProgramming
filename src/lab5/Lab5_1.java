package lab5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab5_1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read())
            {
                time.append((char) c);
            }
            System.out.println(time);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Lab5_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
