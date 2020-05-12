package manager.orders;

import utilities.AlertBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WriteClientMessage {


    public static void send(OrderObject a) {

            try{
                sendMessage(a);
            }
            catch (Exception e)
            {
                AlertBox.display("Error","Problem sending message");
            }
    }


    public static void sendMessage(OrderObject client) throws Exception
    {


        final File storeFile = new File(System.getProperty("user.dir") +
                "\\Messages\\" + client.getUser() + ".txt");

            storeFile.getParentFile().mkdirs();
            storeFile.createNewFile();



    }



}
