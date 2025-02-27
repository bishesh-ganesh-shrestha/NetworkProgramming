import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lab4_4 {
    public static void main(String[] args) {
        String webpageURL = "https://kathford.edu.np";
        guessMIMETypeFromURL(webpageURL);

        String pdfFilePath = "sample.pdf";
        String pngFilePath = "image.png";

        guessMIMETypeFromFileName(pdfFilePath);
        guessMIMETypeFromFileName(pngFilePath);
    }

    private static void guessMIMETypeFromURL(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            String mimeType = connection.getContentType();
            System.out.println("MIME Type of Webpage (" + urlString + "): " + (mimeType != null ? mimeType : "Unknown"));
        } catch (IOException e) {
            System.out.println("Error fetching MIME type of webpage: " + e.getMessage());
        }
    }

    private static void guessMIMETypeFromFileName(String filePath) {
        try {
            Path path = new File(filePath).toPath();
            String mimeType = Files.probeContentType(path);
            System.out.println("MIME Type of File (" + filePath + "): " + (mimeType != null ? mimeType : "Unknown"));
        } catch (IOException e) {
            System.out.println("Error fetching MIME type of file: " + e.getMessage());
        }
    }
}
