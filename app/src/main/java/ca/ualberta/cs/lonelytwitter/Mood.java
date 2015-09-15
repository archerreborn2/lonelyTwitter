package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dren on 9/14/15.
 */
public abstract class Mood {

    private Date date;
    private String mood;

    public Mood(Date date) {
        this.date = date;
    }

    public Mood() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
    public abstract String whatMood();
}
