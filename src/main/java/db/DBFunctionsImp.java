package db;

import java.io.*;
import java.time.LocalDate;

public class DBFunctionsImp implements DBFunctions {
    private static final String path = "C://temp/";
    private static final String customersFileName = "customers.data";
    private static final String cardsFileName = "cards.data";
    public DataCustomers dataCustomers = DataCustomers.getInstance();
    public DataCards dataCards = DataCards.getInstance();
    @Override
    public void create() {
        // Create Files
        try {
            File file = new File(path);
            file.mkdirs();
            file = new File(path + customersFileName);
            file.createNewFile();
            file = new File(path + cardsFileName);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(DataCustomers dataCustomers, DataCards dataCards) {
        try (ObjectOutputStream outputStreamCustomers = new ObjectOutputStream(new FileOutputStream(path + customersFileName));
             ObjectOutputStream outputStreamCards = new ObjectOutputStream(new FileOutputStream(path + cardsFileName))) {
            outputStreamCustomers.writeObject(dataCustomers);
            outputStreamCards.writeObject(dataCards);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        try (ObjectInputStream inputStreamCustomers = new ObjectInputStream(new FileInputStream(path + customersFileName));
             ObjectInputStream inputStreamCards = new ObjectInputStream(new FileInputStream(path + cardsFileName))) {

            dataCustomers = (DataCustomers) inputStreamCustomers.readObject();
            dataCards = (DataCards) inputStreamCards.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addCustomer(String name, String lastName, LocalDate birthDate, String email) {
        read();
        int newID =  dataCustomers.size() + 1;
        Customer customer = new Customer(newID, name, lastName, birthDate, email);
        for(Customer customerFromDB: dataCustomers.values()){
            //'equals' checks all except 'id'
            if(customer.equals(customerFromDB)){
                return customerFromDB.getId();
            }
        }
        dataCustomers.put(newID, customer);
        write(dataCustomers, dataCards);
        return newID;
    }

    @Override
    public long addCard(Customer customer, LocalDate dateOfIssue, LocalDate dateOfExpiration, boolean active) {
        read();
        long newCardNumber = 5111_0000_0000_0000L + dataCards.size() + 1;
        //just in case)
        for (Card cardFromDB: dataCards.values()){
            if(newCardNumber == cardFromDB.getCardNumber()){
                return 0;
            }
        }
        dataCards.put(newCardNumber, new Card(newCardNumber, customer, dateOfIssue, dateOfExpiration, active));
        write(dataCustomers, dataCards);
        return newCardNumber;
    }

    @Override
    public boolean setCardClosed(long cardNumberToSetClose) {
        read();
        for (long number: dataCards.keySet()){
            if(number == cardNumberToSetClose){
                dataCards.get(cardNumberToSetClose).setActive(false);
                write(dataCustomers, dataCards);
                return true;
            }
        }
        return false;
    }
}
