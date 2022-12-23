package data;

import data.interfaces.NifTestInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NifTest implements NifTestInterface {

    Nif nif;

    @BeforeEach
    public void setUp() {
        String correctNif = "12345678A";
        nif = new Nif(correctNif);
    }

    @Test
    @Override
    public void getNifTest() {
        String correctNif = "12345678A";
        assertEquals(correctNif, nif.getNif());
    }

    @Test
    @Override
    public void nullNifTest() {
        assertThrows(IllegalArgumentException.class, () -> new Nif(null));
    }

    @Test
    @Override
    public void nifWithLessThanNineCharactersTest() {
        assertThrows(IllegalArgumentException.class, () -> new Nif("12345678"));
    }

    @Test
    @Override
    public void nifWithMoreThanNineCharactersTest() {
        assertThrows(IllegalArgumentException.class, () -> new Nif("12345678AA"));
    }

    @Test
    @Override
    public void nifWithEightDigitsAndOneLowerCaseLetterTest() {
        assertThrows(IllegalArgumentException.class, () -> new Nif("12345678a"));
    }

    @Test
    @Override
    public void nifWithEightDigitsAndOneNumberTest() {
        assertThrows(IllegalArgumentException.class, () -> new Nif("123456781"));
    }

    @Test
    @Override
    public void nifWithEightDigitsAndOneSpecialCharacterTest() {
        assertThrows(IllegalArgumentException.class, () -> new Nif("12345678@"));
    }

    @Test
    @Override
    public void nifWithEightDigitsAndOneSpaceTest() {
        assertThrows(IllegalArgumentException.class, () -> new Nif("12345678 "));
    }
}
