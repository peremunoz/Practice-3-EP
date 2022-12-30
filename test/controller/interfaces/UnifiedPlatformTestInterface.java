package controller.interfaces;

import controller.exceptions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.ConnectException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public interface UnifiedPlatformTestInterface {

    @Test
    @Order(1)
    void testEnterNIFandPINobt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, ProceduralException;

    @Test
    @Order(2)
    void testEnterPIN() throws NotValidPINException, ConnectException, ProceduralException;

    @Test
    @Order(3)
    void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException;

    @Test
    @Order(4)
    void testEnterCardData() throws NotValidPaymentDataException, IncompleteFormException, InsufficientBalanceException, ConnectException, ProceduralException;

    @Test
    @Order(5)
    void testObtainCertificate() throws DigitalSignatureException, BadPathException, ConnectException, ProceduralException;
}