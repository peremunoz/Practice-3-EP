package doubles;

import controller.exceptions.DigitalSignatureException;
import data.Goal;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

import java.net.ConnectException;

public class JusticeMinistry implements services.JusticeMinistry{
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g) throws DigitalSignatureException, ConnectException {
        return null;
    }
}
