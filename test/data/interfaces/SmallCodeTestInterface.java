package data.interfaces;

import org.junit.jupiter.api.Test;

public interface SmallCodeTestInterface {

    @Test
    void getSmallCodeTest();

    @Test
    void nullSmallCodeTest();

    @Test
    void smallCodeWithLessThanThreeCharactersTest();

    @Test
    void smallCodeWithMoreThanThreeCharactersTest();

    @Test
    void smallCodeWithTwoDigitsAndOneLowerCaseLetterTest();

    @Test
    void smallCodeWithTwoDigitsAndOneSpecialCharacterTest();

    @Test
    void smallCodeWithTwoDigitsAndOneSpaceTest();
}