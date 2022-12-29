package controller;

import controller.exceptions.*;
import controller.interfaces.UnifiedPlatformTestInterface;
import data.Goal;
import data.GoalTypes;
import data.Nif;
import data.SmallCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;

import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;

@DisplayName("Unified Platform Test with one correct citizen")
public class UnifiedPlatformWithOneCorrectCitizenTest implements UnifiedPlatformTestInterface {

    UnifiedPlataform unifiedPlataform;
    HashMap<String, Citizen> registeredCitizens;
    Nif nif;
    Date date;
    Citizen citizen;

    @BeforeEach
    void setUp() {
        nif = new Nif("12345678A");
        date = new Date();
        unifiedPlataform = new UnifiedPlataform();
        registeredCitizens = new HashMap<>();
        citizen = new Citizen(nif, "1234", "1234567890123456", "123");
        registeredCitizens.put(nif.getNif(), citizen);
        unifiedPlataform.setRegisteredCitizens(registeredCitizens);
    }

    @Override
    @Test
    public void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException {
        unifiedPlataform.enterNIFandPINobt(nif, date);
    }

    @Override
    @Test
    public void testEnterPIN() throws NotValidPINException, ConnectException {
        unifiedPlataform.enterPIN(new SmallCode("123"));
    }

    @Override
    @Test
    public void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException {
        unifiedPlataform.getEnterForm(citizen, new Goal(GoalTypes.GAMESECTOR));
    }

    @Override
    @Test
    public void testEnterCardData() {
        // TODO Auto-generated method stub
    }

    @Override
    @Test
    public void testObtainCertificate() {
        // TODO Auto-generated method stub
    }
}