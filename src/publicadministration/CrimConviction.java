package publicadministration;

import java.util.Date;

public class CrimConviction {

    // Represents a criminal conviction registered

    private final Date commitDate;
    private final String offense;
    private final String sentence;

    public CrimConviction (Date commit, String off, String sentc){
        commitDate = commit;
        offense = off;
        sentence = sentc;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public String getOffense() {
        return offense;
    }

    public String getSentence() {
        return sentence;
    }
    public String toString () {
        return "Date of conviction: " + commitDate + " Offense: " + offense + " Sentence: " + sentence;
    }
}