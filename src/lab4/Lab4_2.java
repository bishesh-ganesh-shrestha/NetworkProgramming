package lab4;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class Lab4_2 {
    public static void main(String[] args) {
        String urlString = "https://kathford.edu.np/"; // Replace with the URL you want to check

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD"); // Use HEAD to fetch only headers, not content
            
            // Get content type
            String contentType = connection.getContentType();
            
            // Get content length
            int contentLength = connection.getContentLength();
            
            // Get last modified date
            long lastModified = connection.getLastModified();
            
            // Get access date (approximation using response time)
            long accessDate = connection.getDate();

            // Print results
            System.out.println("Content Type: " + (contentType != null ? contentType : "Unknown"));
            System.out.println("Content Length: " + (contentLength != -1 ? contentLength + " bytes" : "Unknown"));
            System.out.println("Last Modified: " + (lastModified != 0 ? new Date(lastModified) : "Unknown"));
            System.out.println("Access Date: " + (accessDate != 0 ? new Date(accessDate) : "Unknown"));

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Error fetching URL metadata: " + e.getMessage());
        }

    }
}
