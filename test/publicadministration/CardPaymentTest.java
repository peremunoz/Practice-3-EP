package publicadministration;

import data.Nif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.interfaces.CardPaymentTestInterface;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardPaymentTest implements CardPaymentTestInterface {

    CardPayment cardPayment;
    String reference;
    Nif nif;
    Date date;
    BigDecimal price;

    @BeforeEach
    void setUp() {
        nif = new Nif("12345678A");
        date = new Date();
        price = new BigDecimal(10);
        reference = nif.getNif() + date;
        cardPayment = new CardPayment(nif, price);
    }

    @Override
    @Test
    public void testGetReference() {
        assertEquals(reference, cardPayment.getReference());
    }

    @Override
    @Test
    public void testGetNif() {
        assertEquals(nif, cardPayment.getNif());
    }

    @Override
    @Test
    public void testGetDate() {
        assertEquals(date, cardPayment.getDate());
    }

    @Override
    @Test
    public void testGetPrice() {
        assertEquals(price, cardPayment.getPrice());
    }
}