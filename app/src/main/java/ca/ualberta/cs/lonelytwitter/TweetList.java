package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by dren on 9/28/15.
 */
public class TweetList implements MyObservable{
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    private void notifyAllObservers(){
        for (MyObserver observer : observers){
            observer.myNotify(this);
        }
    }

    public void setUp(){

    }

    public void add(Tweet tweet){
        if(contains(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
        notifyAllObservers();
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);

    }

    public Boolean contains(Tweet tweet){
       return tweets.contains(tweet);
    }

    public int getCount(){
        int i = 0;
        while(i < tweets.size()){
            i++;
        }

        return i;
    }

    public ArrayList<Tweet> getTweets(){
        ArrayList<Tweet> sorted = new ArrayList<Tweet>();
            while(tweets.isEmpty() == false){
                Tweet tweet = tweets.get(0);
                Date date = tweet.getDate();
                for(int i = 0; i < tweets.size(); i++){
                    Tweet tweet2 = tweets.get(i);
                    Date date2 = tweet2.getDate();
                    if(date.compareTo(date2) < 0){
                        tweet = tweet2;
                        date = date2;
                    }
                }
                sorted.add(tweet);
                tweets.remove(tweet);
            }
        tweets = sorted;

        return sorted;
    }

    public void addObserver(MyObserver observer){

        observers.add(observer);
    }

    public void myNotify(MyObservable observable){
        notifyAllObservers();
    }


}
