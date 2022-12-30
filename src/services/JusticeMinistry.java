package services;

import controller.exceptions.DigitalSignatureException;
import data.Goal;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

import java.net.ConnectException;

/**
 * External services involved in procedures from population
 */

public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g)
            throws DigitalSignatureException, ConnectException;
}

