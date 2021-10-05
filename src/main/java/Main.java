import db.DBFunctionsImp;
import gui.UsersAndCardsManagement;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();
        dbFunctionsImp.create();
        dbFunctionsImp.read();
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new EmailReminder(), 0, 20, TimeUnit.SECONDS);

        UsersAndCardsManagement.execute();

    }
}

