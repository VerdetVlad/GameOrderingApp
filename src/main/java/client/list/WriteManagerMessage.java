package client.list;

import client.orders.Order;
import manager.orders.OrderObject;
import utilities.AlertBox;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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


        try {
            out.append(readFile(path.getPath(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileWriter storeFW=new FileWriter(path);
        storeFW.write(out.toString());
        storeFW.close();
    }

    public static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
