package publicadministration;

import data.Nif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.interfaces.CitizenTestInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitizenTest implements CitizenTestInterface {

    Citizen citizen;
    Nif nif;
    String name;
    String address;
    String mobile;

    @BeforeEach
    public void setUp() {
        nif = new Nif("12345678A");
        name = "John Doe";
        address = "1234 Main Street";
        mobile = "123456789";
        citizen = new Citizen(nif, name, address, mobile);
    }

    @Override
    @Test
    public void testGetNif() {
        assertEquals(nif, citizen.getNif());
    }

    @Override
    @Test
    public void testGetName() {
        assertEquals(name, citizen.getName());
    }

    @Override
    @Test
    public void testGetAddress() {
        assertEquals(address, citizen.getAddress());
    }

    @Override
    @Test
    public void testGetMobileNumb() {
        assertEquals(mobile, citizen.getMobileNumb());
    }
}