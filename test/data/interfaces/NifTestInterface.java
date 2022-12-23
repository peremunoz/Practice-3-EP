package data.interfaces;

import org.junit.jupiter.api.Test;

public interface NifTestInterface {

    @Test
    void getNifTest();

    @Test
    void nullNifTest();

    @Test
    void nifWithLessThanNineCharactersTest();

    @Test
    void nifWithMoreThanNineCharactersTest();

    @Test
    void nifWithEightDigitsAndOneLowerCaseLetterTest();

    @Test
    void nifWithEightDigitsAndOneNumberTest();

    @Test
    void nifWithEightDigitsAndOneSpecialCharacterTest();

    @Test
    void nifWithEightDigitsAndOneSpaceTest();
}
