package manager;


import java.io.*;
import java.nio.file.Files;



public class ReadStoreData {

    public static void main(String[] args) {
        getData();
    }

    public static void getData()
    {

        final File storeFile = new File(System.getProperty("user.dir") +
                                        "\\Stores\\store.txt");

        System.out.println(storeFile);
    }


}
