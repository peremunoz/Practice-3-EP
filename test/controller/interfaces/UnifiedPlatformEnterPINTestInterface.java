package controller.interfaces;

import controller.exceptions.*;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;

public interface UnifiedPlatformEnterPINTestInterface {

    @Test
    void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testNotValidPINException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testEnterCardData() throws NotValidPaymentDataException, IncompleteFormException, InsufficientBalanceException, ConnectException, ProceduralException;

    @Test
    void testObtainCertificate() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException;
}