package doubles;

import controller.exceptions.IncorrectVerificationException;
import data.Goal;
import publicadministration.Citizen;

import java.net.ConnectException;

public class GPD_AllCorrect implements services.GPD{
    @Override
    public boolean verifyData(Citizen persData, Goal goal) throws IncorrectVerificationException, ConnectException {
        return true;
    }
}
