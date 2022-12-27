package data;

/**
 * Essential data classes
 */

final public class Nif {

    // The tax identification number in the Spanish state.

    private final String nif;

    public Nif (String code) {
        if (code == null) throw new NullPointerException("Nif cannot be null");
        checkNif(code);

        this.nif = code;
    }

    private void checkNif (String code) {
        if (code.length() != 9) throw new IllegalArgumentException("Nif must have 9 characters");
        if (!code.matches("[0-9]{8}[A-Z]")) throw new IllegalArgumentException("Nif must have 8 digits and 1 capital letter");
    }

    public String getNif () { return nif; }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif niff = (Nif) o;
        return nif.equals(niff.nif);
    }

    @Override
    public int hashCode () { return nif.hashCode(); }

    @Override
    public String toString () {
        return "Nif{" + "nif ciudadano='" + nif + '\'' + '}';
    }
}
