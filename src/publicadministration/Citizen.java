package publicadministration;

import data.Nif;

import java.util.Date;

public class Citizen {

    // Represents all the information required for a citizen

    private final Nif nif;
    private final String name;
    private final String address;
    private String mobileNumb;
    private final Date validationDate;

    public Citizen (Nif nif, String name, String add, String mobile){
        this.nif = nif;
        this.name = name;
        this.address = add;
        this.mobileNumb = mobile;
        this.validationDate = new Date();
    }

    public Nif getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumb() {
        return mobileNumb;
    }

    public String getValidationDate() {
        return validationDate.toString();
    }

    public boolean fullyRegistered() {
        return (nif != null && name != null && address != null && mobileNumb != null);
    }
    public String toString () {
        return "Name: " + name + " Address: " + address + " Mobile: " + mobileNumb;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumb = mobileNumber;
    }
}