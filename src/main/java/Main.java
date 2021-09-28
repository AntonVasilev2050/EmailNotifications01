import db.Card;
import db.Customer;
import db.DBFunctionsImp;
import gui.Administrate;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();
        dbFunctionsImp.read();
//        dbFunctionsImp.addCustomer("Anton", "Vasilev", LocalDate.of(1963, 8, 22), "vasilev.anton.v@gmail.com");
//        dbFunctionsImp.addCustomer("Avv", "Soft", LocalDate.of(1980, 7, 12), "avvsoft2050@gmail.com");
//        dbFunctionsImp.addCard(dbFunctionsImp.dataCustomers.get(1), LocalDate.of(2018, 9, 20), LocalDate.of(2021, 9, 25), true);



        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new EmailReminder(), 0, 20, TimeUnit.SECONDS);
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        Administrate.showOperatingScreen();



    }
}

