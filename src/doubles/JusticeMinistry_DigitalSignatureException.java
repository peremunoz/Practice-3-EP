package doubles;

import controller.exceptions.DigitalSignatureException;
import data.DigitalSignature;
import data.Goal;
import data.Nif;
import publicadministration.Citizen;
import publicadministration.CrimConvictionsColl;
import publicadministration.CriminalRecordCertf;

import java.net.ConnectException;

public class JusticeMinistry_DigitalSignatureException implements services.JusticeMinistry{
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g) throws DigitalSignatureException, ConnectException {
        try {
            return new CriminalRecordCertf(new Nif("WRONG_FORMATTED_NIF"), persD.getName(), g, new DigitalSignature(new byte[0]), new CrimConvictionsColl());
        } catch (Exception e) {
            throw new DigitalSignatureException("Error al firmar el certificado");
        }
    }
}
