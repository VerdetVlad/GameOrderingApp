package manager.orders;

import utilities.AlertBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

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


    private static void sendMessage(OrderObject client) throws Exception
    {


        final File path = new File(System.getProperty("user.dir") +
                "\\Messages\\" + "C-" + client.getUser() + ".txt");

        path.getParentFile().mkdirs();
        path.createNewFile();


        StringBuffer out = new StringBuffer("");
        out.append("C-" + client.getUser() + "," + client.getGame() + "," + client.getStatus() + "\n");

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
