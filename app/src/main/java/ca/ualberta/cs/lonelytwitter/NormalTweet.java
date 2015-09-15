package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dren on 9/14/15.
 */
public class NormalTweet extends Tweet implements Tweetable {

    public NormalTweet(String text, Date date, Mood mood) {
        super(text, date, mood);
    }

    public NormalTweet(String text) {
        super(text);
    }

    public Boolean isImportant(){
        return Boolean.FALSE;
    }

}
