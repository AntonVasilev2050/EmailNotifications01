import java.io.*;

public class DBFunctionsImp implements DBFunctions {
    private final String path = "C://temp/";
    private final String customersFileName = "customers.data";
    private final String cardsFileName = "cards.data";
    private File file;

    @Override
    public void create() {
        // Create Files
        try {
            file = new File(path);
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
    public void read(DataCustomers dataCustomers, DataCards dataCards) {
        try (ObjectInputStream inputStreamCustomers = new ObjectInputStream(new FileInputStream(path + customersFileName));
             ObjectInputStream inputStreamCards = new ObjectInputStream(new FileInputStream(path + cardsFileName))) {
            dataCustomers = (DataCustomers) inputStreamCustomers.readObject();
            dataCards = (DataCards) inputStreamCards.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
