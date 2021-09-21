import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CardsHandler {
    public static DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();

    public static List<Card> findExpiresSoon() {
        List<Card> expiresSoonCardList = new ArrayList<>();
        dbFunctionsImp.read();
        LocalDate today = LocalDate.now();
        for (Long cardNumber : dbFunctionsImp.dataCards.keySet()) {
            Card cardToCheck = dbFunctionsImp.dataCards.get(cardNumber);
            LocalDate dateOfExpiration = cardToCheck.getDateOfExpiration();
            if (dateOfExpiration.isBefore(today.plusDays(30))) {
                expiresSoonCardList.add(cardToCheck);
            }
        }
        return expiresSoonCardList;
    }

    public static void findExpired(){
        dbFunctionsImp.read();
        LocalDate today = LocalDate.now();
        for (Long cardNumber : dbFunctionsImp.dataCards.keySet()){
            Card cardToCheck = dbFunctionsImp.dataCards.get(cardNumber);
            LocalDate dateOfExpiration = cardToCheck.getDateOfExpiration();
            if(dateOfExpiration.isAfter(today)){
                dbFunctionsImp.dataCards.get(cardNumber).setActive(false);
            }
            dbFunctionsImp.write(dbFunctionsImp.dataCustomers, dbFunctionsImp.dataCards);
        }
    }

    public static void remind(List<Card> expiresSoonCardList){

    }

}
