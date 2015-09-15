package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dren on 9/14/15.
 */
public class Happy extends Mood {

    public Happy(Date date) {
        super(date);
    }

    public Happy() {
    }

    public String whatMood(){
        return "happy";
    }
}
