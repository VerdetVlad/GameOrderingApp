package register;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeAccount {


    public static void create(String name, String password,
                              boolean check )//true = client; false = manager
    {
        final String mainDir = System.getProperty("user.dir");
        final File userDir = new File(mainDir + "\\Users");
        if (!userDir.exists()) userDir.mkdir();

        if (check) name = "C-" + name;
        else name = "M-" + name;

        File nameDir = new File(userDir.getName() + "\\" + name);
        if (!nameDir.exists()) nameDir.mkdir();


        File passFile = new File(nameDir + "\\password.txt");

        boolean flag = false;
        try {
            flag = passFile.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error while Creating File in Java" + ioe);

        }

        try{
            FileWriter passFW=new FileWriter(passFile);
            passFW.write(password);
            passFW.close();
        }catch(Exception e){System.out.println(e);}


    }


}
