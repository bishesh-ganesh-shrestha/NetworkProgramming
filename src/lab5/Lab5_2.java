package lab5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab5_2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("time.nist.gov", 13)) {
//            socket.setSoTimeout(5000);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                writer.write("Hello");
                writer.flush();
            }
        } catch (SocketTimeoutException ex) {
            Logger.getLogger(Lab5_2.class.getName()).log(Level.WARNING, "Connection timed out", ex);
        } catch (IOException ex) {
            Logger.getLogger(Lab5_2.class.getName()).log(Level.SEVERE, "I/O error occurred", ex);
        }
    }
}
