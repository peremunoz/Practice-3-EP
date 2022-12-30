package controller.interfaces;

import controller.exceptions.*;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;

public interface UnifiedPlatformObtainCertificateTestInterface {

    @Test
    void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testEnterPIN() throws NotValidPINException, ConnectException, ProceduralException;

    @Test
    void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testEnterCardData() throws NotValidPaymentDataException, IncompleteFormException, InsufficientBalanceException, ConnectException, ProceduralException;

    @Test
    void testDigitalSignatureException() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException;

    @Test
    void testConnectException() throws ConnectException, ProceduralException;
}