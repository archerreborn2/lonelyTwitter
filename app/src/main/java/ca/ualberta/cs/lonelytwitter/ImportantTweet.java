package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by dren on 9/14/15.
 */
public class ImportantTweet extends Tweet implements Tweetable {

    public ImportantTweet(String text, Date date, Mood mood) {
        super(text, date, mood);
    }

    public ImportantTweet(String text) throws IOException {
        super(text);
        this.setText(text);
    }

    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
