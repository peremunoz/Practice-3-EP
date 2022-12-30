package controller.interfaces;

import controller.exceptions.*;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;

public interface UnifiedPlatformEnterFormTestInterface {

    @Test
    void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testEnterPIN() throws NotValidPINException, ConnectException, ProceduralException;

    @Test
    void testIncompleteFormException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testIncorrectVerificationException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testEnterCardData() throws NotValidPaymentDataException, IncompleteFormException, InsufficientBalanceException, ConnectException, ProceduralException;

    @Test
    void testObtainCertificate() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException;
}