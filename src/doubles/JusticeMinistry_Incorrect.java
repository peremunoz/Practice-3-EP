package doubles;

import controller.exceptions.DigitalSignatureException;
import data.DigitalSignature;
import data.Goal;
import publicadministration.Citizen;
import publicadministration.CrimConvictionsColl;
import publicadministration.CriminalRecordCertf;

import java.net.ConnectException;

public class JusticeMinistry_Incorrect implements services.JusticeMinistry{
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g) throws DigitalSignatureException, ConnectException {
        try {
            return null;
        } catch (Exception e) {
            throw new DigitalSignatureException("Error al firmar el certificado");
        }
    }
}
