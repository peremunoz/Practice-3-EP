package services;
import controller.exceptions.AnyMobileRegisteredException;
import controller.exceptions.IncorrectValDateException;
import controller.exceptions.NifNotRegisteredException;
import controller.exceptions.NotValidPINException;
import data.*;

import java.net.ConnectException;
import java.util.Date;

public interface CertificationAuthority {

    // External service that represents the different trusted certification entities
    boolean sendPIN (Nif nif, Date date) throws NifNotRegisteredException,
            IncorrectValDateException, AnyMobileRegisteredException,
            ConnectException;
    boolean checkPIN (Nif nif, SmallCode pin) throws NotValidPINException,
            ConnectException;
}