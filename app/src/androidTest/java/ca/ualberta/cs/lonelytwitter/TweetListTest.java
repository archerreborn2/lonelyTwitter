package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dren on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
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

        list.getTweets();


    }
}
