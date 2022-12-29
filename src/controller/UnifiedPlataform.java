package controller;

import controller.exceptions.*;
import data.DocPath;
import data.Goal;
import data.Nif;
import data.SmallCode;
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

    byte authMethod; // 0 = Cl@ve PIN, we can add more methods later

    public UnifiedPlataform() {
        certAuth = new doubles.CertificationAuthority();
        police = new doubles.GPD();
        sac = new doubles.CAS();
        justicia = new doubles.JusticeMinistry();

        registeredCitizens = new HashMap<>();

    }

    public void selectJusMin () {
        System.out.println("[Pantalla: Sección Ministerio de Justicia]");
    }

    public void selectProcedures() {
        System.out.println("[Pantalla: Apartado tramites] Tramites possibles:");
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
        System.out.println("[Mensaje por Pantalla] Ha saleccionado la opción:" + opc);
        authMethod = opc;
    }

    public void enterNIFandPINobt(Nif nif, Date valDate) throws NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException {

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

        boolean correctSendPin = certAuth.sendPIN(nif, valDate);

        if (!correctSendPin) {
            throw new ConnectException("Error al conectar con el servidor de la CA");
        }

        System.out.println("[Campo de texto por Pantalla] Introducir PIN: ");
    }

    public void enterPIN(SmallCode pin) throws NotValidPINException, ConnectException {
        boolean correctPin = certAuth.checkPIN(this.nif, pin);
        if (!correctPin) {
            throw new NotValidPINException("El PIN introducido no es correcto");
        }
        System.out.println("[Mensaje por Pantalla] Pin correcto");
        System.out.println("[Mensaje por Pantalla] Se debe completar un formualario de verificacion de datos personales");
        System.out.println("[Formulario por Pantalla] Formulario");
    }

    private void enterForm(Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException,
            ConnectException {
        if (!citz.fullyRegistered()) {
            throw new IncompleteFormException("El formulario no está completo");
        }

        boolean correctPersonData = police.verifyData(citz, goal);

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

    private void enterCardData(CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, /*REVISAR*/
            InsufficientBalanceException, ConnectException {
        if (!cardD.fullyRegistered()) {
            throw new IncompleteFormException("El formulario no está completo");
        }
        boolean correctPayment = sac.askForApproval("12345678", cardD, new Date(), new BigDecimal(10));
        this.registerPayment();
        System.out.println("[Mensaje por Pantalla] Pagamiento correcto");
        System.out.println("[Pantalla] Opciones Certificado" );/*??*/
    }

    private void obtainCertificate() throws BadPathException,
            DigitalSignatureException, ConnectException {
        System.out.println("[Mensaje por Pantalla] Obteniendo certificado...");
        certificate = justicia.getCriminalRecordCertf(this.citz, this.goal);
        if (certificate == null) {
            throw new DigitalSignatureException("Error al obtener el certificado");
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

    public void getEnterForm(Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException,
            ConnectException {
        this.enterForm(citz, goal);
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
