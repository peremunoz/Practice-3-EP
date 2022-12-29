package doubles;

import controller.exceptions.InsufficientBalanceException;
import controller.exceptions.NotValidPaymentDataException;
import publicadministration.CreditCard;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

public class CAS implements services.CAS {
    BigDecimal balance;

    public CAS() {
        balance = new BigDecimal(0);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException {
        if (cardData == null || date == null || imp == null) {
            throw new NotValidPaymentDataException("Los datos de pago no son válidos");
        }

        if (balance.compareTo(imp) < 0) {
            throw new InsufficientBalanceException("El saldo es insuficiente");
        }

        return true;
    }
}
