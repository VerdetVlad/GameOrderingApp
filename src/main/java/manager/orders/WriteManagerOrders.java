package manager.orders;

import javafx.collections.ObservableList;
import manager.list.GameProduct;
import utilities.AlertBox;

import java.io.File;
import java.io.FileWriter;

public class WriteManagerOrders {
    public static void writeData(ObservableList<OrderObject> message, String fileName)
    {
        File path = new File(System.getProperty("user.dir") + "\\Messages\\" + fileName + ".txt");

        StringBuffer out = new StringBuffer("");

        message.forEach((tab) ->
        {
            out.append( "C-" + tab.getUser() + "," + tab.getGame() + "," + tab.getStatus() + "\n");

        });

        try{
            FileWriter storeFW=new FileWriter(path);
            storeFW.write(out.toString());
            storeFW.close();
        }catch(Exception e){
            AlertBox.display("ERROR","Issues saving data");
        }

    }
}
