package data;

/**
 * Essential data classes
 */

final public class SmallCode {

    // Code composed of 3 digits. Used for the Safe Verification Code and for the Cl@ve system.

    private final String code;

    public SmallCode (String code) {
        if (code == null) throw new NullPointerException("Code cannot be null");
        checkCode(code);
        this.code = code;
    }

    private void checkCode (String code) {
        if (code.length() != 3) throw new IllegalArgumentException("Code must have 3 characters");
        if (!code.matches("[0-9]{3}")) throw new IllegalArgumentException("Code must have 3 digits");
    }

    public String getCode () { return code; }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallCode smallCode = (SmallCode) o;
        return code.equals(smallCode.code);
    }

    @Override
    public int hashCode () { return code.hashCode(); }

    @Override
    public String toString () {
        return "SmallCode{" + "code='" + code + '\'' + '}';
    }
}
