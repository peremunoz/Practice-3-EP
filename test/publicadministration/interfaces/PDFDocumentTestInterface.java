package publicadministration.interfaces;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public interface PDFDocumentTestInterface {

    @Test
    void testGetPath();

    @Test
    void testGetFile();

    @Test
    void testMoveDoc() throws IOException;

    @Test
    void testOpenDoc() throws IOException;

    @Test
    void testOpenDocException();

    @Test
    void testMoveDocException();
}
