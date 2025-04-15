import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SSLClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8888;
    private static final String TRUSTSTORE_PATH = "client.truststore";
    private static final String TRUSTSTORE_PASSWORD = "hello123";

    public static void main(String[] args) {
        try {
            // Load the truststore
            char[] truststorePassword = TRUSTSTORE_PASSWORD.toCharArray();
            KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream fis = new FileInputStream(TRUSTSTORE_PATH);
            truststore.load(fis, truststorePassword);

            // Create the trust manager
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(truststore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            // Create the SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, null);

            // Create the SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Create the client socket
            SSLSocket clientSocket = (SSLSocket) sslSocketFactory.createSocket(HOST, PORT);

            // Send request to server
            String request = "Hello from client!";
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(request);

            // Read response from server
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String response = reader.readLine();

            System.out.println("Received response: " + response);

            // Close the client socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
