package controller;

import controller.exceptions.*;
import data.DocPath;
import data.Goal;
import data.Nif;
import data.SmallCode;
import doubles.CAS_AllCorrect;
import doubles.CertificationAuthority_AllCorrect;
import doubles.GPD_AllCorrect;
import doubles.JusticeMinistry_AllCorrect;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import publicadministration.CriminalRecordCertf;
import services.CAS;
import services.CertificationAuthority;
import services.GPD;
import services.JusticeMinistry;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;

public class UnifiedPlataform {

    static String[] tramits = new String[] {"Obtener certificado de antecedentes penales"};
    static String[] identificaciones = new String[] {"Autenticar con Cl@ve PIN"};

    HashMap<String, Citizen> registeredCitizens;

    Nif nif;

    CertificationAuthority certAuth;

    GPD police;

    CAS sac;

    JusticeMinistry justicia;

    Citizen citz;

    Goal goal;

    CriminalRecordCertf certificate;

    // Global variables for checking the procedural exceptions
    byte authMethod; // 0 = Cl@ve PIN, we can add more methods later

    boolean correctSendPin;
    boolean verifiedPin;
    boolean correctPersonData;
    boolean correctPayment;
    String transactionNumber;

    public UnifiedPlataform() {
        certAuth = new CertificationAuthority_AllCorrect();
        police = new GPD_AllCorrect();
        sac = new CAS_AllCorrect();
        justicia = new JusticeMinistry_AllCorrect();
        authMethod = 0;
        transactionNumber = "123456789";

        registeredCitizens = new HashMap<>();

    }

    public void selectJusMin () {
        System.out.println("[Pantalla: Sección Ministerio de Justícia]");
    }

    public void selectProcedures() {
        System.out.println("[Pantalla: Apartado tramites] Trámites posibles:");
        for (int i = 0; i < tramits.length; i++) {
            System.out.println((i+1) + "." + tramits[i]);
        }
    }

    public void selectCriminalReportCertf() {
        for (int i = 0; i < identificaciones.length; i++) {
            System.out.println((i) + "." + identificaciones[i]);
        }
    }

    public void selectAuthMethod(byte opc) {
        System.out.println("[Mensaje por Pantalla] Ha seleccionado la opción:" + opc);
        authMethod = opc;
    }

    public void enterNIFandPINobt(Nif nif, Date valDate) throws NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException, ProceduralException {

        if(authMethod != 0) {
            throw new ProceduralException("No se ha seleccionado un método de autenticación válido");
        }

        if (!registeredCitizens.containsKey(nif.getNif())) {
            throw new NifNotRegisteredException("El NIF introducido no está registrado");
        }

        this.nif = nif;
        citz = registeredCitizens.get(nif.getNif());

        boolean correctValDate = citz.getValidationDate().equals(valDate.toString());
        if (!correctValDate) {
            throw new IncorrectValDateException("La fecha de validación introducida no es correcta");
        }

        if (citz.getMobileNumb() == null) {
            throw new AnyMobileRegisteredException("No hay ningún móvil registrado");
        }

        correctSendPin = certAuth.sendPIN(nif, valDate);

        if (!correctSendPin) {
            throw new ConnectException("Error al conectar con el servidor de la CA");
        }

        System.out.println("[Campo de texto por Pantalla] Introducir PIN: ");
    }

    public void enterPIN(SmallCode pin) throws NotValidPINException, ConnectException, ProceduralException {
        if(!correctSendPin) {
            throw new ProceduralException("No se ha enviado el PIN");
        }
        boolean correctPin = certAuth.checkPIN(this.nif, pin);
        if (!correctPin) {
            throw new NotValidPINException("El PIN introducido no es correcto");
        }
        verifiedPin = true;
        System.out.println("[Mensaje por Pantalla] Pin correcto");
        System.out.println("[Mensaje por Pantalla] Se debe completar un formualario de verificacion de datos personales");
        System.out.println("[Formulario por Pantalla] Formulario");
    }

    private void enterForm(Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException,
            ConnectException, ProceduralException {
        if (!verifiedPin) {
            throw new ProceduralException("No se ha verificado el PIN");
        }

        if (!citz.fullyRegistered()) {
            throw new IncompleteFormException("El formulario no está completo");
        }

        correctPersonData = police.verifyData(citz, goal);

        if (!correctPersonData) {
            throw new IncorrectVerificationException("Los datos introducidos no son correctos");
        }
        System.out.println("[Mensaje por Pantalla] Verificación Correcta");
        System.out.println("[Mensaje por Pantalla] Importe a pagar");
    }

    private void realizePayment() {
        System.out.println("[Mensaje por Pantalla] Iniciando proceso de pago");
        System.out.println("[Formulario por Pantalla] Formulario de pago");
    }

    private void enterCardData(CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException,
            InsufficientBalanceException, ConnectException, ProceduralException {
        if (!verifiedPin || !correctPersonData) {
            throw new ProceduralException("No se ha verificado el PIN o los datos personales");
        }
        if (!cardD.fullyRegistered()) {
            throw new IncompleteFormException("El formulario no está completo");
        }
        correctPayment = sac.askForApproval(transactionNumber, cardD, new Date(), new BigDecimal(10));
        if (!correctPayment) {
            throw new ConnectException("Error al conectar con el servidor del SAC");
        }
        this.registerPayment();
        System.out.println("[Mensaje por Pantalla] Pagamiento correcto");
        System.out.println("[Pantalla] Opciones Certificado" );/*??*/
    }

    private void obtainCertificate() throws BadPathException,
            DigitalSignatureException, ConnectException, ProceduralException {
        if (!verifiedPin || !correctPersonData || !correctPayment) {
            throw new ProceduralException("No se ha verificado el PIN o los datos personales o pago incorrecto");
        }
        System.out.println("[Mensaje por Pantalla] Obteniendo certificado...");
        certificate = justicia.getCriminalRecordCertf(this.citz, this.goal);
        if (certificate == null) {
            throw new ConnectException("Error al obtener el certificado");
        }

        try {
            this.openDocument(certificate.getPath());
        } catch (Exception e) {
            throw new BadPathException("Error al abrir el documento");
        }

        System.out.println("[Visor PDF por Pantalla] Certificado en PDF");
    }

    private void printDocument() throws BadPathException, PrintingException {
        this.printDocument(certificate.getPath());
        System.out.println("[Mensaje por Pantalla] Certificado Impreso");
    }

    // The setter methods for injecting the dependencies

    public void setRegisteredCitizens(HashMap<String, Citizen> registeredCitizens) {
        this.registeredCitizens = registeredCitizens;
    }

    public void setAuthMethod(byte authMethod) {
        this.authMethod = authMethod;
    }

    public void setVerifiedPin(boolean verifiedPin) {
        this.verifiedPin = verifiedPin;
    }

    public void setCorrectSendPin(boolean correctSendPin) {
        this.correctSendPin = correctSendPin;
    }

    public void setCorrectPersonData(boolean correctPersonData) {
        this.correctPersonData = correctPersonData;
    }

    public void setCorrectPayment(boolean correctPayment) {
        this.correctPayment = correctPayment;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public void firstStepCorrect() {
        this.setCorrectSendPin(true);
    }

    public void secondStepCorrect() {
        this.firstStepCorrect();
        this.setVerifiedPin(true);
    }

    public void thirdStepCorrect() {
        this.secondStepCorrect();
        this.setCorrectPersonData(true);
    }

    public void fourthStepCorrect() {
        this.thirdStepCorrect();
        this.setCorrectPayment(true);
    }

    public void setExceptionDoublesVer1() {
        certAuth = new doubles.CertificationAuthority_FalseTrue();
        police = new doubles.GPD_Incorrect();
        sac = new doubles.CAS_Incorrect();
        justicia = new doubles.JusticeMinistry_Incorrect();
    }

    public void setExceptionDoublesVer2() {
        certAuth = new doubles.CertificationAuthority_TrueFalse();
    }

    public void setJusticeMinistry_DigitalSignatureException() {
        justicia = new doubles.JusticeMinistry_DigitalSignatureException();
    }

    public void setCorrectDoubles() {
        certAuth = new doubles.CertificationAuthority_AllCorrect();
        police = new doubles.GPD_AllCorrect();
        sac = new doubles.CAS_AllCorrect();
        justicia = new doubles.JusticeMinistry_AllCorrect();
    }

    public void getEnterForm(Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException,
            ConnectException, ProceduralException {
        this.enterForm(citz, goal);
    }

    public void getEnterCardData(CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, /*REVISAR*/
            InsufficientBalanceException, ConnectException, ProceduralException {
        this.enterCardData(cardD);
    }

    public void getObtainCertificate() throws BadPathException,
            DigitalSignatureException, ConnectException, ProceduralException {
        this.obtainCertificate();
    }

    // Other input events (not required)

    // Other internal operations (not required)

    private void registerPayment() {

    }

    private void openDocument(DocPath path) throws BadPathException {

    }

    private void printDocument(DocPath path) throws BadPathException, PrintingException{

    }


}
