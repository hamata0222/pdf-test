package jp.ne.hiroshi.pdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class CreatePDF {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String message = "Hello, World!";
     
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            page.setRotation(270);
            doc.addPage(page);

            PDFont font = PDType1Font.HELVETICA_BOLD;

            try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {
                contents.beginText();
                contents.setFont(font, 12);
                contents.newLineAtOffset(100, 700);
                contents.showText(message);
                contents.endText();
            }

            doc.save(fileName);
        }
    }
}

