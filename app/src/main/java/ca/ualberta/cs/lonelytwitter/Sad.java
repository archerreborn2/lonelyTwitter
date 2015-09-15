package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dren on 9/14/15.
 */
public class Sad extends Mood {

    public Sad(Date date) {
        super(date);
    }

    public Sad() {
    }

    public String whatMood(){
        return "sad";
    }
}
