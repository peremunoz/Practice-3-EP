package publicadministration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.interfaces.CrimConvictionsCollTestInterface;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CrimConvictionsCollEmptyTest implements CrimConvictionsCollTestInterface {

    CrimConvictionsColl crimConvictionsColl;
    Date date;

    @BeforeEach
    void setUp() {
        crimConvictionsColl = new CrimConvictionsColl();
        date = new Date();
    }

    @Override
    @Test
    public void testAddCriminalConviction() {
        crimConvictionsColl.addCriminalConviction(new CrimConviction(new Date(), "Offense", "Sentence"));
        assertEquals(1, crimConvictionsColl.getConvictions().size());
    }

    @Override
    @Test
    public void testGetCriminalConviction() {
        crimConvictionsColl.addCriminalConviction(new CrimConviction(date, "Offense", "Sentence"));
        assertEquals("Offense", crimConvictionsColl.getConvictions().get(date).getOffense());
    }
}