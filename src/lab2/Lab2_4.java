package lab2;

import java.net.URI;
import java.net.URISyntaxException;

public class Lab2_4 {
    public static void main(String[] args) {
        try {
            String uribase = "https://kathford.edu.np/about-us/";
            String urirelative = "/kathford-scholarships";
            URI baseURI = new URI(uribase);
            URI relativeURI = new URI(urirelative);
            System.out.println("Base URI: "+baseURI);
            System.out.println("Relative URI: "+relativeURI);
            URI resolvedURI = baseURI.resolve(relativeURI);
            System.out.println("Resolved URI: "+ resolvedURI);
        } catch (URISyntaxException ex) {
            System.out.println(ex);
        }
    }
}
