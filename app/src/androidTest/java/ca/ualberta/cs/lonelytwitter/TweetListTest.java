package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dren on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver{
    private Boolean wasNotified = Boolean.FALSE;
    public TweetListTest(){
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void myNotify(MyObservable observable){
        wasNotified = Boolean.TRUE;
    }

    public void testAddObserver(){
        TweetList list = new TweetList();
        list.addObserver(this);
        wasNotified = Boolean.FALSE;
        list.add(new NormalTweet("test"));
        //at this point we expect to be notified!
        assertTrue(wasNotified);

    }

    public void testTweetObserver(){
        TweetList list = new TweetList();
        list.addObserver(this);
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        wasNotified = Boolean.FALSE;
        tweet.setText("Different");
        assertTrue(wasNotified);

    }



    public void testAddTweet(){
        TweetList list = new TweetList();
        list.add(new NormalTweet("test"));
    }

    public void testRemoveTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.contains(tweet));

    }

    public void testContains(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.contains(tweet));
    }

    public void testgetCount(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.getCount() == 1);

    }

    public void testgetTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test",new Date(2000, 10, 20));
        Tweet tweet2 = new NormalTweet("test2", new Date(1998, 9, 15));
        list.add(tweet2);
        list.add(tweet);
        ArrayList<Tweet> list2 = new ArrayList<Tweet>();

        list2 = list.getTweets();


    }
}
