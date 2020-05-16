package client.orders;

import javafx.collections.ObservableList;
import utilities.AlertBox;

import java.io.File;
import java.io.FileWriter;

public class WriteData {
    public static void writeData(ObservableList<Order> games, String fileName)
    {
        File path = new File(System.getProperty("user.dir") + "\\Stores\\" + fileName + ".txt");

        StringBuffer out = new StringBuffer("");

        games.forEach((tab) ->
                out.append( tab.getNameManager() + "," + tab.getGame() + "," + tab.getStatus() + "\n"));

        try{
            FileWriter storeFW=new FileWriter(path);
            storeFW.write(out.toString());
            storeFW.close();
        }catch(Exception e){
            AlertBox.display("error","Data save issues");
        }

    }
}
