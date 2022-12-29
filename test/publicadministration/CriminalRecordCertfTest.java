package publicadministration;

import data.DigitalSignature;
import data.Goal;
import data.GoalTypes;
import data.Nif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.interfaces.CriminalRecordCertfTestInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriminalRecordCertfTest implements CriminalRecordCertfTestInterface {

    CriminalRecordCertf criminalRecordCertf;
    Nif nif;
    String name;
    Goal goal;
    DigitalSignature digSign;
    CrimConvictionsColl crimConvs;

    @BeforeEach
    public void setUp() {
        nif = new Nif("12345678A");
        name = "John Doe";
        goal = new Goal(GoalTypes.GAMESECTOR);
        digSign = new DigitalSignature(new byte[]{1, 2, 3, 4, 5});
        crimConvs = new CrimConvictionsColl();
        criminalRecordCertf = new CriminalRecordCertf(nif, name, goal, digSign, crimConvs);
    }

    @Override
    @Test
    public void testGetNif() {
        assertEquals(nif, criminalRecordCertf.getNif());
    }

    @Override
    @Test
    public void testGetName() {
        assertEquals(name, criminalRecordCertf.getName());
    }

    @Override
    @Test
    public void testGetGoal() {
        assertEquals(goal, criminalRecordCertf.getGoal());
    }

    @Override
    @Test
    public void testGetDigSign() {
        assertEquals(digSign, criminalRecordCertf.getDigSign());
    }

    @Override
    @Test
    public void testGetCrimConvs() {
        assertEquals(crimConvs, criminalRecordCertf.getCrimConvs());
    }
}
