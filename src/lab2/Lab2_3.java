package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Lab2_3 {
    public static void main(String[] args) {
        String webAddress = "https://www.kathford.edu.np";

        try {
            URL url = new URL(webAddress);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("downloaded_page.html"));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Web page downloaded successfully!");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
