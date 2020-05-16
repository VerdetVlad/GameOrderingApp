package manager.orders;

import utilities.AlertBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteClientMessage {


    public static void send(OrderObject a, String m) {

            try{
                sendMessage(a,m);
            }
            catch (Exception e)
            {
                AlertBox.display("Error","Problem sending message");
            }
    }


    private static void sendMessage(OrderObject client, String manager) throws Exception
    {

        final File path = new File(System.getProperty("user.dir") +
                "\\Messages\\" + "C-" + client.getUser() + ".txt");


        path.getParentFile().mkdirs();
        path.createNewFile();


        StringBuffer out = new StringBuffer("");
        out.append( manager + "," + client.getGame() + "," + client.getStatus() + "\n");

        BufferedReader readFile = new BufferedReader(new FileReader(path));
        String line =  readFile.readLine();

        String mask=manager + "," + client.getGame() + "," + "Pending";
        while(line != null)
        {
            if(!line.equals(mask))
                 out.append(line + "\n");

            line = readFile.readLine();
        }
        readFile.close();

        FileWriter storeFW=new FileWriter(path);
        storeFW.write(out.toString());
        storeFW.close();
    }



}
