package controller;

import controller.exceptions.*;
import controller.interfaces.UnifiedPlatformEnterNIFandPINobtTestInterface;
import controller.interfaces.UnifiedPlatformEnterPINTestInterface;
import data.Goal;
import data.GoalTypes;
import data.Nif;
import data.SmallCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("UnifiedPlatform.enterPIN function Test")
public class UnifiedPlatformEnterPINTest implements UnifiedPlatformEnterPINTestInterface {

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

        unifiedPlataform.setExceptionDoublesVer2();
        unifiedPlataform.firstStepCorrect();
    }

    @Override
    @Test
    public void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException {
        unifiedPlataform.setAuthMethod((byte) 1);
        assertThrows(ProceduralException.class, () -> unifiedPlataform.enterNIFandPINobt(nif, date));
    }

    @Override
    @Test
    public void testNotValidPINException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException {
        assertThrows(NotValidPINException.class, () -> unifiedPlataform.enterPIN(new SmallCode("123")));
    }

    @Override
    @Test
    public void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        assertThrows(ProceduralException.class, () -> unifiedPlataform.getEnterForm(citizen, new Goal(GoalTypes.GAMESECTOR)));
    }

    @Override
    @Test
    public void testEnterCardData() throws NotValidPaymentDataException, IncompleteFormException, InsufficientBalanceException, ConnectException, ProceduralException {
        assertThrows(ProceduralException.class, () -> unifiedPlataform.getEnterCardData(creditCard));
    }

    @Override
    @Test
    public void testObtainCertificate() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException {
        assertThrows(ProceduralException.class, () -> unifiedPlataform.getObtainCertificate());
    }
}