package org.example.service;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfToJpgService {

    public void pdfToJpeg() throws IOException {
        try (PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("/Users/vivianealvesdepontes/Downloads/Curriculo_Fabricio_Alves.pdf"))) {

            int totalPages = document.getNumberOfPages();
            PDFRenderer renderer = new PDFRenderer(document);

            for (int pages = 0; pages < totalPages ; pages++) {
                BufferedImage image = renderer.renderImage(pages);
                ImageIO.write(image, "JPEG", new File("/Users/vivianealvesdepontes/Downloads/Curriculo_Fabricio_Alves page"+  pages +".jpg"));

            }
            System.out.println("JPG created");
        }
    }
}
