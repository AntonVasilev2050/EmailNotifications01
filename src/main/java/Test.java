import java.time.LocalDate;
import java.time.Month;

public class Test {
    public static void main(String[] args) {
        DataCustomers dataCustomers = DataCustomers.getInstance();
        DataCards dataCards = DataCards.getInstance();
        Customer customer1 = new Customer(1, "Nick", "Ivanov", LocalDate.of(2000, Month.FEBRUARY, 22), "nick@mail.com");
//        dataCustomers.put
//        dataCards.put()
    }

}
