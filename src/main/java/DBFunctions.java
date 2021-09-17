import java.time.LocalDate;

public interface DBFunctions {
    void create();
    void write(DataCustomers dataCustomers, DataCards dataCards);
    void read();
    int addCustomer(String name, String lastName, LocalDate birthDate, String email);
    long addCard(Customer customer, LocalDate dateOfIssue, LocalDate dateOfExpiration, boolean active);
    boolean setCardClosed();

}
