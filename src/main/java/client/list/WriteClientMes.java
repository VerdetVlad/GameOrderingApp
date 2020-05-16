package client.list;

import utilities.AlertBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteClientMes {
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
                "\\Messages\\" + client + ".txt");

        path.getParentFile().mkdirs();
        path.createNewFile();


        StringBuffer out = new StringBuffer("");
        out.append(manager + "," + game + "," + "Pending" + "\n");



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
