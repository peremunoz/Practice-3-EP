package controller;

import controller.exceptions.*;
import controller.interfaces.UnifiedPlatformEnterCardDataTestInterface;
import controller.interfaces.UnifiedPlatformEnterFormTestInterface;
import data.Goal;
import data.GoalTypes;
import data.Nif;
import data.SmallCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("UnifiedPlatform.enterForm function Test")
public class UnifiedPlatformEnterCardDataTest implements UnifiedPlatformEnterCardDataTestInterface {

    static UnifiedPlataform unifiedPlataform;
    static HashMap<String, Citizen> registeredCitizens;
    static Nif nif;
    static Date date;
    static Citizen citizen;
    static CreditCard creditCard;

    @BeforeAll
    static void setUp() {
        nif = new Nif("12345678A");
        date = new Date();
        unifiedPlataform = new UnifiedPlataform();
        registeredCitizens = new HashMap<>();
        citizen = new Citizen(nif, "1234", "1234567890123456", "123");
        creditCard = new CreditCard(nif, "1234567890123456", date, new SmallCode("123"));
        registeredCitizens.put(nif.getNif(), citizen);
        unifiedPlataform.setRegisteredCitizens(registeredCitizens);
        creditCard.setBalance(new BigDecimal(100));

        unifiedPlataform.thirdStepCorrect();
    }

    @Override
    @Test
    public void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException {
        unifiedPlataform.enterNIFandPINobt(nif, date);
    }

    @Override
    @Test
    public void testEnterPIN() throws NotValidPINException, ConnectException, ProceduralException {
        unifiedPlataform.enterPIN(new SmallCode("123"));
    }

    @Override
    @Test
    public void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        unifiedPlataform.getEnterForm(citizen, new Goal(GoalTypes.GAMESECTOR));
    }

    @Override
    @Test
    public void testIncompleteFormException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        creditCard.setCardNumber(null);
        assertThrows(IncompleteFormException.class, () -> unifiedPlataform.getEnterCardData(creditCard));
        creditCard.setCardNumber("1234567890123456");
    }

    @Override
    @Test
    public void testNotValidPaymentDataException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        unifiedPlataform.setTransactionNumber(null);
        assertThrows(NotValidPaymentDataException.class, () -> unifiedPlataform.getEnterCardData(creditCard));
        unifiedPlataform.setTransactionNumber("1234567890123456");
    }

    @Override
    @Test
    public void testInsufficientBalanceException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        creditCard.setBalance(BigDecimal.ZERO);
        assertThrows(InsufficientBalanceException.class, () -> unifiedPlataform.getEnterCardData(creditCard));
        creditCard.setBalance(new BigDecimal(100));
    }

    @Override
    @Test
    public void testConnectException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        unifiedPlataform.setExceptionDoublesVer1();
        assertThrows(ConnectException.class, () -> unifiedPlataform.getEnterCardData(creditCard));
        unifiedPlataform.setCorrectDoubles();
    }

    @Override
    @Test
    public void testObtainCertificate() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException {
        assertThrows(ProceduralException.class, () -> unifiedPlataform.getObtainCertificate());
    }
}