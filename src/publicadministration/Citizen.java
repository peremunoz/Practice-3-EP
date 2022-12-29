package publicadministration;

import data.Nif;

public class Citizen {

    // Represents all the information required for a citizen

    private final Nif nif;
    private final String name;
    private final String address;
    private final String mobileNumb;

    public Citizen (Nif nif, String name, String add, String mobile){
        this.nif = nif;
        this.name = name;
        this.address = add;
        this.mobileNumb = mobile;
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
    public String toString () {
        return "Name: " + name + " Address: " + address + " Mobile: " + mobileNumb;
    }
}