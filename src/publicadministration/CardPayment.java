package publicadministration;

import data.Nif;

import java.math.BigDecimal;
import java.util.Date;

public class CardPayment {

    // The information associated to the payment realized via internet

    private final String reference; // The code of the operation (nif + date)

    private final Nif nif; // The nif of the user

    private final Date date; // The date of the operation

    private final BigDecimal price; // The import of the payment

    public CardPayment (Nif nif, BigDecimal imp) {
        this.nif = nif;
        this.price = imp;
        this.date = new Date();
        this.reference = nif.getNif() + date;
    }

    public String getReference() {
        return reference;
    }

    public Nif getNif() {
        return nif;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString () {
        return "Reference: " + reference + " Nif: " + nif + " Date: " + date + " Import: " + price;
    }
}