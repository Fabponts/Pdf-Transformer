package org.example.pdftransformer.model.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class ConvertJpgToPdfService {
    public void convertJpgToPdf() throws IOException {
        //Create the Pdf file
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        String jpgFile = "/Users/vivianealvesdepontes/Downloads/Carta de apresentaçao.jpg";

        PDImageXObject pdImageXObject = PDImageXObject.createFromFile(jpgFile, document);

        // Criar um stream de conteúdo para a página
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.drawImage(pdImageXObject, 20, 20, pdImageXObject.getWidth(), pdImageXObject.getHeight());
        contentStream.close();

        String outPath = "/Users/vivianealvesdepontes/Downloads/Carta de apresentaçao&.pdf";
        System.out.println("Converted to PDF");
        document.save(outPath) ;

    }

}
