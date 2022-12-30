package controller;

import controller.exceptions.*;
import controller.interfaces.UnifiedPlatformEnterNIFandPINobtTestInterface;
import controller.interfaces.UnifiedPlatformTestInterface;
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

@DisplayName("UnifiedPlatform.enterNIFandPINobt function Test")
public class UnifiedPlatformEnterNIFandPINobtTest implements UnifiedPlatformEnterNIFandPINobtTestInterface {

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
    }


    @Override
    @Test
    public void testNifNotRegisteredException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException {
        unifiedPlataform.setRegisteredCitizens(new HashMap<>());
        assertThrows(NifNotRegisteredException.class, () -> unifiedPlataform.enterNIFandPINobt(nif, date));
        unifiedPlataform.setRegisteredCitizens(registeredCitizens);
    }

    @Override
    @Test
    public void testIncorrectValDateException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException {
        assertThrows(IncorrectValDateException.class, () -> unifiedPlataform.enterNIFandPINobt(nif, new Date(0)));
    }

    @Override
    @Test
    public void testAnyMobileRegisteredException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException {
        citizen.setMobileNumber(null);
        assertThrows(AnyMobileRegisteredException.class, () -> unifiedPlataform.enterNIFandPINobt(nif, date));
        citizen.setMobileNumber("123456789");
    }

    @Override
    @Test
    public void testConnectException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException {
        unifiedPlataform.setExceptionDoublesVer1();
        assertThrows(ConnectException.class, () -> unifiedPlataform.enterNIFandPINobt(nif, date));
    }

    @Override
    @Test
    public void testEnterPIN() throws NotValidPINException, ConnectException, ProceduralException {
        assertThrows(ProceduralException.class, () -> unifiedPlataform.enterPIN(new SmallCode("123")));
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