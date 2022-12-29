package publicadministration;

import java.util.Date;
import java.util.HashMap;

public class CrimConvictionsColl {

    // Represents a collection of criminal convictions registered for a citizen

    private final HashMap<Date, CrimConviction> convictions;

    public CrimConvictionsColl () {
        convictions = new HashMap<>();
    }

    public HashMap<Date, CrimConviction> getConvictions() {
        return convictions;
    }

    public void addCriminalConviction (CrimConviction crmC) {
        convictions.put(crmC.getCommitDate(), crmC);
    }

    public CrimConviction getCriminalConviction (Date date) {
        return convictions.get(date);
    }

    public String toString () {
        StringBuilder s = new StringBuilder("Criminal Convictions: ");
        for (CrimConviction crmC : convictions.values()) {
            s.append(crmC.toString()).append(" ");
        }
        return s.toString();
    }
}
