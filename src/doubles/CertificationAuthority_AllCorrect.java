package doubles;

import controller.exceptions.AnyMobileRegisteredException;
import controller.exceptions.IncorrectValDateException;
import controller.exceptions.NifNotRegisteredException;
import controller.exceptions.NotValidPINException;
import data.Nif;
import data.SmallCode;

import java.net.ConnectException;
import java.util.Date;

public class CertificationAuthority_AllCorrect implements services.CertificationAuthority {

    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException {
        return true;
    }

    @Override
    public boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException, ConnectException {
        return true;
    }
}
