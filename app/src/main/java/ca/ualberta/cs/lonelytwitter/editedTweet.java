package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dren on 10/16/15.
 */
public class editedTweet {

    Tweet tweet;
    int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public Tweet getTweet() {
        return tweet;
    }


    private static editedTweet ourInstance = new editedTweet();

    public static editedTweet getInstance() {
        return ourInstance;
    }

    private editedTweet() {


    }
}
