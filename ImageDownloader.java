import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageDownloader {

    public static void main(String[] args) {
        // get user input for folder path
        String folderPath = "";

        // read image URLs from file or hardcode them
        String[] imageUrls = {""};

        // download and save each image to folder path
        boolean foundErrors = false;
        for (String imageUrl : imageUrls) {
            try {
                URL url = new URL(imageUrl);
                BufferedImage image = ImageIO.read(url);
                String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
                File outputFile = new File(folderPath + "/" + fileName);
                ImageIO.write(image, "png", outputFile);
                System.out.println(fileName + " downloaded successfully.");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage() +" ("+imageUrl.substring(imageUrl.lastIndexOf("/") + 1)+")");
                foundErrors = true;
            }
        }

        if(!foundErrors) {
            System.out.println("All images downloaded successfully.");        	
        } else {
        	System.out.println("Some errors occured while downloading images.");
        }

    }
}
