package client.orders;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utilities.AlertBox;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReadOrder {


    public static ObservableList<Order> getData(String fileName)
    {
        try {
             return get(fileName);
        }
        catch (Exception e)
        {
            AlertBox.display("Error","Problems reading data");
            return null;
        }
    }



    private static ObservableList<Order> get(String fileName) throws Exception
    {


        ObservableList<Order> orders = FXCollections.observableArrayList();
        final File storeFile = new File(System.getProperty("user.dir") +
                "\\Messages\\" + fileName + ".txt");


        storeFile.getParentFile().mkdirs();
        storeFile.createNewFile();




        Scanner line = new Scanner(storeFile);


        while(line.hasNextLine())
        {
            Order aux = makeOrder(line.nextLine());
            orders.add(aux);
        }

        line.close();


        return orders;
    }


    public static Order makeOrder(String line)
    {
        Order order = new Order();
        String[] aux=null;
        int i;

        aux = line.split(",");
        order.setNameManager(aux[0]);

        order.setGame(aux[1]);

        order.setStatus(aux[2]);

        return order;
    }
}