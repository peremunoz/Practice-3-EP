package publicadministration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.interfaces.CrimConvictionsCollTestInterface;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrimConvictionsCollFullTest implements CrimConvictionsCollTestInterface {

    CrimConvictionsColl crimConvictionsColl;
    Date date1;
    Date date2;

    @BeforeEach
    void setUp() {
        crimConvictionsColl = new CrimConvictionsColl();
        date1 = new Date(1);
        date2 = new Date(2);
        crimConvictionsColl.addCriminalConviction(new CrimConviction(date1, "Offense1", "Sentence1"));
        crimConvictionsColl.addCriminalConviction(new CrimConviction(date2, "Offense2", "Sentence2"));
    }

    @Override
    @Test
    public void testAddCriminalConviction() {
        crimConvictionsColl.addCriminalConviction(new CrimConviction(new Date(), "Offense", "Sentence"));
        assertEquals(3, crimConvictionsColl.getConvictions().size());
    }

    @Override
    @Test
    public void testGetCriminalConviction() {
        assertEquals("Offense1", crimConvictionsColl.getCriminalConviction(date1).getOffense());
        assertEquals("Offense2", crimConvictionsColl.getCriminalConviction(date2).getOffense());
    }
}
