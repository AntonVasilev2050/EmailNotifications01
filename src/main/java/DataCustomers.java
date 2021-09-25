import java.util.HashMap;

public class DataCustomers extends HashMap<Integer, Customer>{
    private  static DataCustomers customers;
    private DataCustomers(){
    }
    private static final Object LOCK = new Object();
    public static DataCustomers getInstance(){
        synchronized (LOCK){
            if(customers == null){
                customers = new DataCustomers();
            }
            return customers;
        }
    }


}
