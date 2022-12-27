package data;

import data.interfaces.DocPathTestInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DocPathTest implements DocPathTestInterface {

    private DocPath docPath;

    @BeforeEach
    void setUp() {
        String correctPath = "C:\\Users\\User\\Desktop\\test.txt";
        docPath = new DocPath(correctPath);
    }

    @Test
    @Override
    public void getDocPathTest() {
        assertEquals("C:\\Users\\User\\Desktop\\test.txt", docPath.getPath());
    }

    @Test
    @Override
    public void nullDocPathTest() {
        assertThrows(NullPointerException.class, () -> new DocPath(null));
    }
}