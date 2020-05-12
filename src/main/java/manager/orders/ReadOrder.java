package manager.orders;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import manager.list.GameProduct;
import utilities.AlertBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadOrder {


    public static ObservableList<OrderObject> getData(String path)
    {
        try {
            return get(path);
        }
        catch (Exception e)
        {
            AlertBox.display("Error","Problems reading data");
            return null;
        }
    }



    private static ObservableList<OrderObject> get(String name) throws Exception
    {

        ObservableList<OrderObject> orders = FXCollections.observableArrayList();
        final File storeFile = new File(System.getProperty("user.dir") +
                "\\Messages\\" + name + ".txt");


            storeFile.getParentFile().mkdirs();
            storeFile.createNewFile();



        BufferedReader readFile = new BufferedReader(new FileReader(storeFile));
        String line =  readFile.readLine();
        while(line != null)
        {
            OrderObject aux = makeOrder(line);
            orders.add(aux);
            line = readFile.readLine();
        }
        readFile.close();

        return orders;
    }


    public static OrderObject makeOrder(String line)
    {
        OrderObject order = new OrderObject();
        String[] aux=null;
        int i;

        aux = line.split(",");
        String[] aux2 = null;
        aux2 = aux[0].split("-");
        order.setUser(aux2[1]);

        order.setGame(aux[1]);

        order.setStatus(aux[2]);

        return order;
    }
}
