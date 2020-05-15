import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;




//tests if the creation of objects using information from a file works
//necessary for creating lists for both client and manager
public class ReadOrderTest {

    @Test
    public void getData() {

        boolean test = true;

        ArrayList <OrderObject> testArray = new ArrayList<>();
        final File storeFile = new File(System.getProperty("user.dir") +
                "\\Tests\\objectCreationTest\\testFile.txt");

        String line=null;

        BufferedReader readFile = null;
        try {
            readFile = new BufferedReader(new FileReader(storeFile));
            line =  readFile.readLine();
        } catch (Exception e) {
            test = false;
        }

        while(line != null)
        {
            OrderObject aux = makeOrder(line);
            testArray.add(aux);
            try {
                line = readFile.readLine();
            } catch (IOException e) {
                test = false;
            }
        }
        try {
            readFile.close();
        } catch (IOException e) {
            test = false;
        }

        OrderObject a = testArray.get(0);
        OrderObject b = new OrderObject("User","Game","Status");
        if(!a.equals(b)) test = false;

        a=testArray.get(1);
        if(!a.equals(new OrderObject("Vlad","The Witcher 3","Accepted - 4"))) test = false;


        assertTrue(test);
    }


    public OrderObject makeOrder(String line) {
        OrderObject order = new OrderObject();
        String[] aux=null;


        aux = line.split(",");
        String[] aux2 = null;

        order.setUser(aux[0]);

        order.setGame(aux[1]);

        order.setStatus(aux[2]);

        return order;
    }
}