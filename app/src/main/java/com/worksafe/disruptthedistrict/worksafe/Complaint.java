package com.worksafe.disruptthedistrict.worksafe;

import java.util.ArrayList;

/**
 * Created by KevinYangMac on 3/3/18.
 */

public class Complaint {
    private boolean sexualAssault;
    private boolean racialSlurs;
    private boolean verbalAbuse;
    private boolean physicalAbuse;
    private String details;


    public Complaint(boolean sexualAssault, boolean racialSlurs, boolean verbalAbuse, boolean physicalAbuse, String details){
        this.sexualAssault = sexualAssault;
        this.racialSlurs = racialSlurs;
        this.verbalAbuse = verbalAbuse;
        this.physicalAbuse = physicalAbuse;
        this.details = details;
    }

    public boolean isSexualAssault() {
        return this.sexualAssault;
    }

    public boolean isRacialSlurs() {
        return this.racialSlurs;
    }

    public boolean isVerbalAbuse() {
        return this.verbalAbuse;
    }

    public boolean isPhysicalAbuse() {
        return this.physicalAbuse;
    }

    public String getDetails() {
        return this.details;
    }

    public String toString() {
        String retval = "";
        if(this.sexualAssault) retval += "Sexual Assault\n";
        if(this.racialSlurs) retval += "Racial Slurs\n";
        if(this.verbalAbuse) retval += "Verbal Abuse\n";
        if(this.physicalAbuse) retval += "Physical Abuse\n";
        retval += this.details + "\n";

        return retval;
    }
}
