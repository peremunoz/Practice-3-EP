package publicadministration;

import data.Nif;
import data.SmallCode;

import java.math.BigDecimal;
import java.util.Date;

public class CreditCard {

    // The payment information for using the card via internet

    private final Nif nif; // The nif of the user

    private String cardNumb; // The number of the credit card

    private final Date expirDate; // The expiration date for the credit card

    private final SmallCode svc; // The Safe Verification Code

    private BigDecimal balance;

    public CreditCard (Nif nif, String cNum, Date d, SmallCode c) {
        this.nif = nif;
        this.cardNumb = cNum;
        this.expirDate = d;
        this.svc = c;
        this.balance = new BigDecimal(0);
    }

    public Nif getNif() {
        return nif;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public Date getExpirDate() {
        return expirDate;
    }

    public SmallCode getSvc() {
        return svc;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean fullyRegistered() {
        return nif != null && cardNumb != null && expirDate != null && svc != null;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumb = cardNumber;
    }

    @Override
    public String toString () {
        return "Nif: " + nif + " Card Number: " + cardNumb + " Expiration Date: " + expirDate + " SVC: " + svc;
    }
}
