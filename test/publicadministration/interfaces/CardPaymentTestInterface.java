package publicadministration.interfaces;

import org.junit.jupiter.api.Test;

public interface CardPaymentTestInterface {

    @Test
    void testGetReference();

    @Test
    void testGetNif();

    @Test
    void testGetDate();

    @Test
    void testGetPrice();
}