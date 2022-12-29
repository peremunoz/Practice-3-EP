package publicadministration;

import data.Nif;
import data.SmallCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.interfaces.CreditCardTestInterface;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest implements CreditCardTestInterface {

    CreditCard creditCard;
    Nif nif;
    String cardNumb;
    Date expirDate;
    SmallCode svc;

    @BeforeEach
    public void setUp() {
        nif = new Nif("12345678A");
        cardNumb = "1234567890123456";
        expirDate = new Date();
        svc = new SmallCode("123");
        creditCard = new CreditCard(nif, cardNumb, expirDate, svc);
    }

    @Override
    @Test
    public void testGetNif() {
        assertEquals(nif, creditCard.getNif());
    }

    @Override
    @Test
    public void testGetCardNumb() {
        assertEquals(cardNumb, creditCard.getCardNumb());
    }

    @Override
    @Test
    public void testGetExpirDate() {
        assertEquals(expirDate, creditCard.getExpirDate());
    }

    @Override
    @Test
    public void testGetSvc() {
        assertEquals(svc, creditCard.getSvc());
    }
}