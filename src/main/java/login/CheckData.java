package login;

import java.io.*;
import java.nio.file.Files;

public class CheckData {

    public static File verifyData(String name, String password) {
        try {
            return findUser(name, password);
        }
        catch(Exception e){
            System.out.println("File not found!");
            return null;
        }


    }

    public static File findUser(String name, String password) throws Exception
    {
        final File usersDir = new File(System.getProperty("user.dir") + "\\Users");

        String userLoc=null;

        for (String pathname : usersDir.list()) {

            if(pathname.equals("M-" + name))
            {
                userLoc = usersDir + "\\" + pathname;
                break;
            }
            else if(pathname.equals("C-" + name))
            {
                userLoc = usersDir + "\\" + pathname;
                break;
            }
        }
        if(userLoc==null) return null;

        File passFile = new File(userLoc + "\\password.txt");
        BufferedReader readPass = new BufferedReader(new FileReader(passFile));

        String passwordAux;
        if((passwordAux = readPass.readLine())==null) return null;

        if (password.equals(passwordAux)) return new File(userLoc);
        else return  null;
    }

}
