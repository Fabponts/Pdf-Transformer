package org.example.service;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfToJpgService {

    public void pdfToJpeg() throws IOException {
        try (PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("/Users/vivianealvesdepontes/Downloads/Carta de apresentaçao.pdf"))) {

            PDFRenderer renderer = new PDFRenderer(document);
            BufferedImage image = renderer.renderImage(0);

            ImageIO.write(image, "JPEG", new File("/Users/vivianealvesdepontes/Downloads/Carta de apresentaçao.jpg"));

            document.close();
            System.out.println("JPG created");
        }
    }
}
