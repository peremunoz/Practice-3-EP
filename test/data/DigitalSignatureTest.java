package data;

import data.interfaces.DigitalSignatureTestInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DigitalSignatureTest implements DigitalSignatureTestInterface {

    DigitalSignature digitalSignature;

    @BeforeEach
    public void setUp() {
        byte[] signature = new byte[10];
        digitalSignature = new DigitalSignature(signature);
    }

    @Override
    @Test
    public void getDigitalSignatureTest() {
        byte[] signature = new byte[10];
        assertArrayEquals(signature, digitalSignature.getDigitalSignature());
    }

    @Override
    @Test
    public void nullDigitalSignatureTest() {
        assertThrows(NullPointerException.class, () -> digitalSignature = new DigitalSignature(null));
    }
}
