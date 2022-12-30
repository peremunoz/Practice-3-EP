package publicadministration;

import data.DocPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.interfaces.PDFDocumentTestInterface;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PDFDocumentTest implements PDFDocumentTestInterface {

    private PDFDocument pdfDocument;
    private String defaultPath;
    private File file;

    @BeforeEach
    void setUp() {
        pdfDocument = new PDFDocument();
        defaultPath = "defaultPath.pdf";
        file = new File(defaultPath);
    }

    @Override
    @Test
    public void testGetPath() {
        assertEquals(defaultPath, pdfDocument.getPath().getPath());
    }

    @Override
    @Test
    public void testGetFile() {
        assertEquals(file, pdfDocument.getFile());
    }

    @Override
    @Test
    public void testMoveDoc() throws IOException {
        DocPath destPath = new DocPath("dest.pdf");
        pdfDocument.moveDoc(destPath);
        assertEquals(destPath, pdfDocument.getPath());
    }

    @Override
    @Test
    public void testOpenDoc() throws IOException {
        pdfDocument.openDoc(pdfDocument.getPath());
    }

    @Override
    @Test
    public void testOpenDocException() {
        assertThrows(Exception.class, () -> pdfDocument.openDoc(new DocPath("")));
    }

    @Override
    @Test
    public void testMoveDocException() {
        assertThrows(Exception.class, () -> pdfDocument.moveDoc(new DocPath("")));
    }
}
