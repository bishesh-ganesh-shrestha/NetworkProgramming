import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SSLServer {

    private static final int PORT = 8888;
    private static final String KEYSTORE_PATH = "server.keystore";
    private static final String KEYSTORE_PASSWORD = "hello123";

    public static void main(String[] args) {
        try {
            // Load the keystore
            char[] keystorePassword = KEYSTORE_PASSWORD.toCharArray();
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream fis = new FileInputStream(KEYSTORE_PATH);
            keystore.load(fis, keystorePassword);

            // Create the key manager
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keystore, keystorePassword);
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

            // Create the SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagers, null, null);

            // Create the SSL server socket factory
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

            // Create the server socket
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                // Accept client connection
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

                // Handle client request
                handleClientRequest(clientSocket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClientRequest(SSLSocket clientSocket) {
        try {
            // Read client request
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = reader.readLine();

            System.out.println("Received request: " + request);

            // Process the request
            String response = "Hello from server!";

            // Send response to client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(response);

            // Close the client socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
