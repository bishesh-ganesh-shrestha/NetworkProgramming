import java.io.IOException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.net.URL;
import java.security.cert.Certificate;

public class Lab4_3 {
    public static void main(String[] args) {
        // URLs to check
        String[] urls = {
            "https://kathford.edu.np/contact-us/",
            "https://kathford.edu.np"
        };

        for (String urlString : urls) {
            System.out.println("Checking security details for: " + urlString);
            getSSLCertificateDetails(urlString);
            System.out.println("---------------------------------------------------");
        }
    }

    private static void getSSLCertificateDetails(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.connect(); // Establish the connection

            System.out.println("Response Code: " + connection.getResponseCode());

            // Fetching SSL Certificate details
            try {
                Certificate[] certificates = connection.getServerCertificates();
                for (Certificate cert : certificates) {
                    System.out.println("Certificate Type: " + cert.getType());
                    System.out.println("Certificate Details: " + cert.toString());
                }
            } catch (SSLPeerUnverifiedException e) {
                System.out.println("SSL Certificate not verified: " + e.getMessage());
            }

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Error fetching SSL details: " + e.getMessage());
        }
    }
}
