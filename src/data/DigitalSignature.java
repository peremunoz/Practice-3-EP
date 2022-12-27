package data;

import java.util.Arrays;

/**
 * Essential data classes
 */

final public class DigitalSignature {

    // Digital signature for representing the electronic signature.

    private final byte[] digitalSignature;

    public DigitalSignature (byte[] digitalSignature) {
        if (digitalSignature == null) throw new NullPointerException("Digital signature cannot be null");
        this.digitalSignature = digitalSignature;
    }

    public byte[] getDigitalSignature () { return digitalSignature; }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature digitalSignature1 = (DigitalSignature) o;
        return Arrays.equals(digitalSignature, digitalSignature1.digitalSignature);
    }

    @Override
    public int hashCode () { return Arrays.hashCode(digitalSignature); }

    @Override
    public String toString () {
        return "DigitalSignature{" + "digitalSignature='" + Arrays.toString(digitalSignature) + '\'' + '}';
    }
}
