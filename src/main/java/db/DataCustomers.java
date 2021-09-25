package db;

import java.util.TreeMap;

public class DataCustomers extends TreeMap<Integer, Customer> {
    private  static DataCustomers customers;
    private DataCustomers(){}
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
