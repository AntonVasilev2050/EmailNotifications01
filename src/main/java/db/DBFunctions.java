package db;

import java.time.LocalDate;
import java.util.List;

public interface DBFunctions {
    void create();
    void write(DataCustomers dataCustomers, DataCards dataCards);
    void read();
    List<Object> addCustomer(String name, String lastName, LocalDate birthDate, String email);
    long addCard(Customer customer, LocalDate dateOfIssue, LocalDate dateOfExpiration, boolean active);
    boolean setCardClosed(long cardNumber);

}
