package controller;

import data.Nif;

import java.util.zip.ZipException;

public class UnifiedPlataform {

    String[] tramits = new String[] {"Obtener certificado de antecedentes penales"};
    String[] identificaciones = new String[] {"Autenticar con Cl@ve PIN"};

    Nif nif;

    CertificationAutority certAuth;

    GPD police;

    Cas sac;

    JusticeMinistry justicia;

    Citizen citz;

    Goal goal;

    CriminalRecordCertf certificate;

    byte authMethod;

    public UnifiedPlataform() {

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
        this.nif = nif;
        boolean correctSendPin = certAuth.sendPin(nif, valDate);

        System.out.println("[Campo de texto por Pantalla] Introducir PIN: ");
    }

    public void enterPIN(SmallCode pin) throws NotValidPINException, ConnectException {
        boolean correctPin = certAuth.checkPIN(this.nif, pin);
        System.out.println("[Mensaje por Pantalla] Pin correcto");
        System.out.println("[Mensaje por Pantalla] Se debe completar un formualario de verificacion de datos personales");
        System.out.println("[Formulario por Pantalla] Formulario");
    }

    private void enterForm(Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException,
            ConnectException {
        boolean correctPersonData = police.verifyData(citz, goal);
        System.out.println("[Mensaje por Pantalla] Verificación Correcta");
        System.out.println("[Mensaje por Pantalla] Importe a pagar");
    }

    private void realizePayment() {
        System.out.println("[Mensaje por Pantalla] Iniciando proceso de pago");
        System.out.println("[Formulario por Pantalla] Formulario de pagamiento");
    }

    private void enterCardData(CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, /*REVISAR*/
            InsufficientBalanceException, ConnectException {
        boolean correctPayment = sac.askForApproval(); /*Falta acabar*/
        this.registerPayment();
        System.out.println("[Mensaje por Pantalla] Pagamiento correcto");
        System.out.println("[Pantalla] Opciones Certificado" );/*??*/

    }

    private void obtainCertificate() throws BadPathException,
            DigitalSignatureException, ConnectException {
        System.out.println("[Mensaje por Pantalla] Obteniendo certificado...");
        certificate = justicia.getCriminalRecordCertf(this.citz, this.goal);
        this.openDocument(certificate.getPDF()); //S'ha de implementar
        System.out.println("[Visor PDF por Pantalla] Certificado en PDF");
    }

    private void printDocument()  throws BadPathException, PrintingException {
        this.printDocument(certificate.getPDF()); //S'ha de implementar
        System.out.println("[Mensaje por Pantalla] Certificado Impreso");
    }

    // The setter methods for injecting the dependences

    // Other input events (not required)

    // Other internal operations (not required)

    private void registerPayment() {

    };

    private void openDocument(DocPath path) throws BadPathException {

    }

    private void printDocument(DocPath path) throws BadPathException, PrintingException{

    }


}
