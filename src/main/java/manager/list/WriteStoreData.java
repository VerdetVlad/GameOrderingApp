package manager.list;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;

public class WriteStoreData {

    public static void writeData(ObservableList<GameProduct> games, String fileName)
    {
        File path = new File(System.getProperty("user.dir") + "\\Stores\\" + fileName + ".txt");

        StringBuffer out = new StringBuffer("");

        games.forEach((tab) ->
        {
            out.append( tab.getName() + "," + tab.getGenre() + "," + tab.getPrice() + "\n");

        });

        try{
            FileWriter storeFW=new FileWriter(path);
            storeFW.write(out.toString());
            storeFW.close();
        }catch(Exception e){System.out.println(e);}

    }
}
