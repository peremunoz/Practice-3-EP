package doubles;

import controller.exceptions.InsufficientBalanceException;
import controller.exceptions.NotValidPaymentDataException;
import publicadministration.CreditCard;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

public class CAS_AllCorrect implements services.CAS {

    public CAS_AllCorrect() {}

    @Override
    public boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException {
        if (cardData == null || date == null || imp == null || nTrans == null) {
            throw new NotValidPaymentDataException("Los datos de pago no son válidos");
        }

        BigDecimal balance = cardData.getBalance();

        if (balance.compareTo(imp) < 0) {
            throw new InsufficientBalanceException("El saldo es insuficiente");
        }

        return true;
    }
}
