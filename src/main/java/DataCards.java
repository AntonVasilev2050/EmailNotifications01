import java.util.HashMap;

public class DataCards extends HashMap<Long, Card> {
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
