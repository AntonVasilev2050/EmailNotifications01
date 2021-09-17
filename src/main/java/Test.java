import java.time.LocalDate;
import java.time.Month;

public class Test {
    public static void main(String[] args) {
        DataCustomers dataCustomers = DataCustomers.getInstance();
        DataCards dataCards = DataCards.getInstance();
        DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();
        Customer customer1 = new Customer(1, "Nick", "Ivanov", LocalDate.of(2000, Month.FEBRUARY, 22), "nick@mail.com");
        Customer customer2 = new Customer(2, "Boris", "Petrov", LocalDate.of(1988, Month.JULY, 10), "boris@mail.com");
        Customer customer3 = new Customer(3, "John", "Smith", LocalDate.of(1950, Month.MARCH, 15), "john@mail.com");

        Card card1 = new Card(1111_1111_1111_1111L, customer1, LocalDate.of(2019, 3, 14), LocalDate.of(2022, 3, 30), true);
        Card card2 = new Card(1111_1111_1111_2222L, customer2, LocalDate.of(2019, 3, 14), LocalDate.of(2022, 3, 30), true);
        Card card3 = new Card(1111_1111_1111_3333L, customer3, LocalDate.of(2019, 3, 14), LocalDate.of(2022, 3, 30), true);
        Card card4 = new Card(1111_1111_1111_4444L, customer3, LocalDate.of(2019, 3, 14), LocalDate.of(2022, 3, 30), true);
        dataCustomers.put(customer1.getId(), customer1);
        dataCustomers.put(customer2.getId(), customer2);
        dataCustomers.put(customer3.getId(), customer3);
        dataCards.put(card1.getCardNumber(), card1);
        dataCards.put(card2.getCardNumber(), card2);
        dataCards.put(card3.getCardNumber(), card3);
        dataCards.put(card4.getCardNumber(), card4);
        System.out.println(dataCustomers);
        for (Long key: dataCards.keySet()){
            System.out.println(key + " " + dataCards.get(key).getCustomer());
        }
        System.out.println(dbFunctionsImp.dataCustomers);
        for (Long key: dbFunctionsImp.dataCards.keySet()){
            System.out.println(key + " " + dbFunctionsImp.dataCards.get(key).getCustomer());
        }

        dbFunctionsImp.create();
        dbFunctionsImp.write(dataCustomers, dataCards);
//        dataCards.clear();
        dataCards.remove(1111_1111_1111_4444L);
        dataCustomers.clear();
        System.out.println(dataCards);
        System.out.println(dataCustomers);
        dbFunctionsImp.read();
        System.out.println(dbFunctionsImp.dataCards);
        System.out.println(dbFunctionsImp.dataCustomers);

//        dataCustomers.put
//        dataCards.put()
    }

}
