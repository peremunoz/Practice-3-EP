package controller;

import controller.exceptions.*;
import controller.interfaces.UnifiedPlatformTestInterface;
import data.Goal;
import data.GoalTypes;
import data.Nif;
import data.SmallCode;
import org.junit.jupiter.api.*;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;

@DisplayName("Unified Platform Test with one correct citizen")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnifiedPlatformWithOneCorrectCitizenTest implements UnifiedPlatformTestInterface {

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
    @Order(1)
    public void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException {
        unifiedPlataform.enterNIFandPINobt(nif, date);
    }

    @Override
    @Test
    @Order(2)
    public void testEnterPIN() throws NotValidPINException, ConnectException, ProceduralException {
        unifiedPlataform.enterPIN(new SmallCode("123"));
    }

    @Override
    @Test
    @Order(3)
    public void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        unifiedPlataform.getEnterForm(citizen, new Goal(GoalTypes.GAMESECTOR));
    }

    @Override
    @Test
    @Order(4)
    public void testEnterCardData() throws NotValidPaymentDataException, IncompleteFormException, InsufficientBalanceException, ConnectException, ProceduralException {
        creditCard.setBalance(new BigDecimal(100));
        unifiedPlataform.getEnterCardData(creditCard);
    }

    @Override
    @Test
    @Order(5)
    public void testObtainCertificate() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException {
        unifiedPlataform.getObtainCertificate();
    }
}