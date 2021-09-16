import java.io.File;
import java.io.IOException;

public  class DBFunctionsImp implements DBFunctions {
    private String path = "C://temp/";
    private File file;

    @Override
    public void create() {
        // Create Files
        try {
            file = new File(path);
            file.mkdirs();
            file = new File(path + "customers.data");
            file.createNewFile();
            file = new File(path + "cards.data");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write() {

    }

    @Override
    public void read() {

    }
}
