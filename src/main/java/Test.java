import accessories.Info;

import java.util.List;

public class Test {
    private static tls.Sender tlsSender = new tls.Sender("sberschooltest@gmail.com", Info.emailFromPass);
    private static ssl.Sender sslSender = new ssl.Sender("sberschooltest@gmail.com", Info.emailFromPass);

    public static void main(String[] args) {
//        DataCustomers dataCustomers = DataCustomers.getInstance();
//        DataCards dataCards = DataCards.getInstance();
        DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();
//        Customer customer1 = new Customer(1, "Nick", "Ivanov", LocalDate.of(2000, Month.FEBRUARY, 22), "nick@mail.com");
//        Customer customer2 = new Customer(2, "Boris", "Petrov", LocalDate.of(1988, Month.JULY, 10), "boris@mail.com");
//        Customer customer3 = new Customer(3, "John", "Smith", LocalDate.of(1950, Month.MARCH, 15), "john@mail.com");
//
//        Card card1 = new Card(1111_1111_1111_1111L, customer1, LocalDate.of(2019, 3, 14), LocalDate.of(2022, 3, 30), true);
//        Card card2 = new Card(1111_1111_1111_2222L, customer2, LocalDate.of(2019, 3, 14), LocalDate.of(2022, 3, 30), true);
//        Card card3 = new Card(1111_1111_1111_3333L, customer3, LocalDate.of(2019, 3, 14), LocalDate.of(2022, 3, 30), true);
//        Card card4 = new Card(1111_1111_1111_4444L, customer3, LocalDate.of(2019, 3, 14), LocalDate.of(2022, 3, 30), true);
//        dataCustomers.put(customer1.getId(), customer1);
//        dataCustomers.put(customer2.getId(), customer2);
//        dataCustomers.put(customer3.getId(), customer3);
//        dataCards.put(card1.getCardNumber(), card1);
//        dataCards.put(card2.getCardNumber(), card2);
//        dataCards.put(card3.getCardNumber(), card3);
//        dataCards.put(card4.getCardNumber(), card4);
        dbFunctionsImp.read();
//        System.out.println(dbFunctionsImp.dataCustomers);
//        for (Long key: dbFunctionsImp.dataCards.keySet()){
//            System.out.println(key + " " + dbFunctionsImp.dataCards.get(key).getCustomer());
//        }
//        dbFunctionsImp.create();
//        dbFunctionsImp.write(dataCustomers, dataCards);
//        dataCards.clear();
//        dataCustomers.clear();


//        dbFunctionsImp.addCard(dbFunctionsImp.dataCustomers.get(6), LocalDate.of(2020, 5, 15), LocalDate.of(2022, 10, 4), true);
        for (Long key: dbFunctionsImp.dataCards.keySet()){
            System.out.println(dbFunctionsImp.dataCards.get(key).getCardNumber() + " " + dbFunctionsImp.dataCards.get(key).getExpirationDate());
        }
        List<Card> lc = CardsHandler.findExpiresSoon();

        System.out.println("---------");
        for (Card card: lc){
            System.out.println(card.getCardNumber() + " " + card.getCustomer() + " " + card.getExpirationDate());
        }

        tlsSender.send("Subject TLS", "TLS: This is a message to remind you about...", "sberschooltest@gmail.com", "vasilev.anton.v@gmail.com");
        sslSender.send("Subject SSL ", "SSL: This is a message to remind you about...", "sberschooltest@gmail.com", "vasilev.anton.v@gmail.com");
    }

}
