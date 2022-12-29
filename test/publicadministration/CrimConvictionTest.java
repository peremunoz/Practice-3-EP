package publicadministration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.interfaces.CrimConvictionTestInterface;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrimConvictionTest implements CrimConvictionTestInterface {

    CrimConviction crimConviction;
    Date commitDate;
    String offense;
    String sentence;

    @BeforeEach
    void setUp() {
        commitDate = new Date();
        offense = "Murder";
        sentence = "2 years";
        crimConviction = new CrimConviction(commitDate, offense, sentence);
    }

    @Override
    @Test
    public void testGetCommitDate() {
        assertEquals(commitDate, crimConviction.getCommitDate());
    }

    @Override
    @Test
    public void testGetOffense() {
        assertEquals(offense, crimConviction.getOffense());
    }

    @Override
    @Test
    public void testGetSentence() {
        assertEquals(sentence, crimConviction.getSentence());
    }
}