package controller.interfaces;

import controller.exceptions.*;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;

public interface UnifiedPlatformTestInterface {

    @Test
    void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException;

    @Test
    void testEnterPIN() throws NotValidPINException, ConnectException;

    @Test
    void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException;

    @Test
    void testEnterCardData();

    @Test
    void testObtainCertificate();
}