package client.list;

import manager.orders.OrderObject;
import utilities.AlertBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteManagerMessage
{
    public static void send(String m, String c,String g) {

        try{
            sendMessage(m,c,g);
        }
        catch (Exception e)
        {
            AlertBox.display("Error","Problem sending message");
        }
    }

    private static void sendMessage(String manager, String client,String game) throws Exception
    {
        final File path = new File(System.getProperty("user.dir") +
                "\\Messages\\" + "M-" + manager + ".txt");

        path.getParentFile().mkdirs();
        path.createNewFile();


        StringBuffer out = new StringBuffer("");
        out.append(client + "," + game + "," + "Pending" + "\n");

        BufferedReader readFile = new BufferedReader(new FileReader(path));
        String line =  readFile.readLine();
        while(line != null)
        {
            line = readFile.readLine();
            out.append(line + "\n");
        }
        readFile.close();

        FileWriter storeFW=new FileWriter(path);
        storeFW.write(out.toString());
        storeFW.close();
    }
}
