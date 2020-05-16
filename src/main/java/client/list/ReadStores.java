package client.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

import java.io.*;

public class ReadStores
{
    public static ObservableList<Stores> getData() {
        try {
            return getStore();
        } catch (Exception e)
        {
            return null;
        }
    }


    private static ObservableList<Stores> getStore() throws Exception
    {
        ObservableList<Stores> stores = FXCollections.observableArrayList();
        final File storeFile = new File(System.getProperty("user.dir") +
                "\\Stores");

        storeFile.getParentFile().mkdirs();


        for (String fpath : storeFile.list())
        {
            String[] aux = new String[3];
            String[] aux2 = new String[3];

            aux = fpath.split(".txt");
            Stores a = new Stores();
            a.setName(aux[0].substring(2));
            stores.add(a);
        }
        return stores;
    }
}