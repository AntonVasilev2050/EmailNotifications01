import accessories.Info;
import db.Card;
import db.Customer;
import db.DBFunctionsImp;
import ssl.Sender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsHandler {
    public static DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();

    public static List<Card> findExpiresSoon() {
        List<Card> expiresSoonCardList = Collections.synchronizedList(new ArrayList<>());
        dbFunctionsImp.read();
        LocalDate today = LocalDate.now();
        for (Long cardNumber : dbFunctionsImp.dataCards.keySet()) {
            Card cardToCheck = dbFunctionsImp.dataCards.get(cardNumber);
            LocalDate dateOfExpiration = cardToCheck.getExpirationDate();
            if (dateOfExpiration.isBefore(today.plusDays(30)) && cardToCheck.isActive()) {
                expiresSoonCardList.add(cardToCheck);
            }
        }
        return expiresSoonCardList;
    }

    public static List<Card> findExpired() {
        List<Card> expiredCardList = Collections.synchronizedList(new ArrayList<>());
        dbFunctionsImp.read();
        LocalDate today = LocalDate.now();
        for (Long cardNumber : dbFunctionsImp.dataCards.keySet()) {
            Card cardToCheck = dbFunctionsImp.dataCards.get(cardNumber);
            LocalDate dateOfExpiration = cardToCheck.getExpirationDate();
            if (dateOfExpiration.isBefore(today) && cardToCheck.isActive()) {
                cardToCheck.setActive(false);
                dbFunctionsImp.write(dbFunctionsImp.dataCustomers, dbFunctionsImp.dataCards);
                expiredCardList.add(cardToCheck);
            }
        }
        return expiredCardList;
    }

    public static List<Card[]> generateNewCards(List<Card> expiredCardList) {
        List<Card[]> expiredAndNewCardList = Collections.synchronizedList(new ArrayList<>());
        long newCardNumber;
        for (int i = 0; i < expiredCardList.size(); i++) {
            Card[] cards = new Card[2];
            cards[0] = expiredCardList.get(i);
            newCardNumber = dbFunctionsImp.addCard(
                    cards[0].getCustomer(),
                    LocalDate.now(),
                    LocalDate.now().plusYears(3),
                    true);
            cards[1] = dbFunctionsImp.dataCards.get(newCardNumber);
            expiredAndNewCardList.add(i, cards);
        }
        return expiredAndNewCardList;
    }

    public static void remindAndCreateNew(List<Card[]> expiredAndNewCardList) {
        Sender sslSender = new ssl.Sender(Info.getEmailFrom(), Info.getEmailFromPass());
        for (Card[] card : expiredAndNewCardList) {
            String remindingMessage = String.format("???????? ???????????????? ???????????????????? ?????????? %s ???????????????????? %s. ???????????????? ?????????? ??????????: %s. ",
                    card[0].getCardNumber(), card[0].getExpirationDate(), card[1].getCardNumber());
            String customerEmail = card[1].getCustomer().getEmail();
            sslSender.send("???????? ???????????????? ??????????", remindingMessage, Info.getEmailFrom(), customerEmail);
        }
    }
}

class EmailReminder implements Runnable {
    List<Card> expiredCardList = Collections.synchronizedList(new ArrayList<>());
    List<Card[]> expiredAndNewCardList = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void run() {
        expiredCardList = CardsHandler.findExpired();
        expiredAndNewCardList = CardsHandler.generateNewCards(expiredCardList);
//        for (Card[] cards : expiredAndNewCardList) {
//            Card oldCard = cards[0];
//            Card newCard = cards[1];
//            System.out.println(oldCard + " " + newCard);
//        }
        System.out.println("an attempt finished");

        CardsHandler.remindAndCreateNew(expiredAndNewCardList);
    }
}
