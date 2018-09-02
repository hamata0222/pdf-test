package jp.ne.hiroshi.pdf;

import java.io.IOException;
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class EditPDF {
    private String fileName;

    public EditPDF(String fileName) {
        this.fileName = fileName;
    }

    private EditPDF() {
        // must make the instance with fileName
    }

    public void rotatePage(int pageIndex, int rotation) throws IOException {
        try (PDDocument doc = PDDocument.load(new File(fileName))) {
            doc.getPage(pageIndex).setRotation(rotation);
            doc.save(fileName);
        }
    }

    public static void main(String[] args) {
        EditPDF me = new EditPDF(args[0]);
        try {
            me.rotatePage(1, 270);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

