package org.example.pdftransformer.model.service;


import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertPdfToJpgService {
    public void convertPdfToJpeg() throws IOException {
        try (PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("/Users/vivianealvesdepontes/Downloads/Curriculo_Fabricio_Alves.pdf"))) {

            int totalPages = document.getNumberOfPages();
            PDFRenderer renderer = new PDFRenderer(document);

            for (int page = 0; page < totalPages ; page++) {
                BufferedImage image = renderer.renderImageWithDPI(page,300);
                ImageIO.write(image, "JPEG", new File("/Users/vivianealvesdepontes/Downloads/Curriculo_Fabricio_Alves page"+ (page + 1) +".jpg"));

            }
            System.out.println("JPG created");
        }
    }
}