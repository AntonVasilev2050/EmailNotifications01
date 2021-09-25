package db;

import java.util.TreeMap;

public class DataCards extends TreeMap<Long, Card> {
    private static DataCards cards;
    private DataCards(){}
    private final static Object LOCK = new Object();
    public static DataCards getInstance(){
        synchronized (LOCK){
            if(cards == null){
                cards = new DataCards();
            }
            return cards;
        }
    }

}
