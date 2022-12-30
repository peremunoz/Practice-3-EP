package controller.interfaces;

import controller.exceptions.*;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;

public interface UnifiedPlatformEnterNIFandPINobtTestInterface {

    @Test
    void testNifNotRegisteredException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testIncorrectValDateException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testAnyMobileRegisteredException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testConnectException() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    void testEnterPIN() throws NotValidPINException, ConnectException, ProceduralException;

    @Test
    void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    void testEnterCardData() throws NotValidPaymentDataException, IncompleteFormException, InsufficientBalanceException, ConnectException, ProceduralException;

    @Test
    void testObtainCertificate() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException;
}