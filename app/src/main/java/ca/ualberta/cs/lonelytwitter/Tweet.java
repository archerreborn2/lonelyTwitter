package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by dren on 9/14/15.
 *
 * We don't want to allow someone to go tweet.text = ""
 * we want to force them to call a method instead
 */
public abstract class Tweet {
    private String text;
    private Date date;
    private Mood mood;
    private static Integer something;

    public Tweet(String text, Date date, Mood mood) {
        this.text = text;
        this.date = date;
        this.mood = mood;
    }

    public Tweet(String text) {
        this.text = text;
        date = new Date();
    }

    public String getText() {
        return text;
    }

    //x.y in java is basically x->y in C
    public void setText(String text) throws IOException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IOException("Tweet was too long!");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();


}
