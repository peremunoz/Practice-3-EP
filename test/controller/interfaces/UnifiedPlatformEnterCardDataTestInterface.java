package controller.interfaces;

import controller.exceptions.*;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;

public interface UnifiedPlatformEnterCardDataTestInterface {

    @Test
    void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testEnterPIN() throws NotValidPINException, ConnectException, ProceduralException;

    @Test
    void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testIncompleteFormException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testNotValidPaymentDataException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testInsufficientBalanceException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testConnectException() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testObtainCertificate() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException;
}