package data;

import data.interfaces.SmallCodeTestInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmallCodeTest implements SmallCodeTestInterface {

    SmallCode smallCode;

    @BeforeEach
    public void setUp() {
        String correctSmallCode = "123";
        smallCode = new SmallCode(correctSmallCode);
    }

    @Test
    @Override
    public void getSmallCodeTest() {
        String correctSmallCode = "123";
        assertEquals(correctSmallCode, smallCode.getCode());
    }

    @Test
    @Override
    public void nullSmallCodeTest() {
        assertThrows(NullPointerException.class, () -> new SmallCode(null));
    }

    @Test
    @Override
    public void smallCodeWithLessThanThreeCharactersTest() {
        assertThrows(IllegalArgumentException.class, () -> new SmallCode("12"));
    }

    @Test
    @Override
    public void smallCodeWithMoreThanThreeCharactersTest() {
        assertThrows(IllegalArgumentException.class, () -> new SmallCode("1234"));
    }

    @Test
    @Override
    public void smallCodeWithTwoDigitsAndOneLowerCaseLetterTest() {
        assertThrows(IllegalArgumentException.class, () -> new SmallCode("12a"));
    }

    @Test
    @Override
    public void smallCodeWithTwoDigitsAndOneSpecialCharacterTest() {
        assertThrows(IllegalArgumentException.class, () -> new SmallCode("12!"));
    }

    @Test
    @Override
    public void smallCodeWithTwoDigitsAndOneSpaceTest() {
        assertThrows(IllegalArgumentException.class, () -> new SmallCode("12 "));
    }
}