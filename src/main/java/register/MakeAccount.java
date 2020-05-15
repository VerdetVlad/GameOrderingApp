package register;

import java.io.*;


public class MakeAccount {



    public static void create(String n, String p, boolean c )
    {
        try
        {
             makePath(n,p,c);
        }
        catch (Exception e)
        {
            return;
        }
    }






    public static void makePath(String name, String password,
                              boolean check ) throws Exception
    //true = client; false = manager
    {
        final String mainDir = System.getProperty("user.dir");
        final File userDir = new File(mainDir + "\\Users");


        if (check) name = "C-" + name;
        else name = "M-" + name;

        File nameDir = new File(userDir.getName() + "\\" + name);

        File passFile = new File(nameDir + "\\password.txt");

        passFile.getParentFile().mkdirs();
        passFile.createNewFile();


        FileWriter passFW=new FileWriter(passFile);
        passFW.write(password);
        passFW.close();



    }


}
