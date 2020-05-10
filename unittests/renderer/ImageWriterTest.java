package renderer;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ImageWriterTest {

    @Test
    void writeToImage() {
        ImageWriter imageWriter = new ImageWriter("image_name", 1600, 1000, 800, 500);
        int Nx = imageWriter.getNx();
        int Ny = imageWriter.getNy();
        for (int i = 0; i < Ny; i++) {
            for (int j = 0; j < Nx; j++) {
                if (i % 50 == 0 || j % 50 == 0) {
                    imageWriter.writePixel(j, i, Color.PINK);
                } else {
                    imageWriter.writePixel(j, i, Color.BLACK);
                }
            }
        }
        imageWriter.writeToImage();
    }
}