import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class CheckDataTest {

    @Test
    //basically login testing
    //some test files have already been created
    //this method aims to find a particular user and check its password
    //the user and password are already crated
    public void verifyData() {



        boolean test; // used for checking if the creation took place correctly
        test = true;


        final File usersDir = new File(System.getProperty("user.dir") + "\\Users");
        String userLoc=null;

        for (String pathname : usersDir.list()) {

            if(pathname.equals("loginTest"))
            {
                userLoc = usersDir + "\\" + pathname;
                break;
            }
        }
        if(userLoc==null) test=false;

        File passFile = new File(userLoc + "\\passTest.txt");
        BufferedReader readPass = null;
        try {
            readPass = new BufferedReader(new FileReader(passFile));
        } catch (FileNotFoundException e) {
            test = false;
        }

        String passwordAux= null;
        try {
            passwordAux = readPass.readLine();
        } catch (IOException e) {
            test = false;
        }
        try {
            readPass.close();
        } catch (IOException e) {
            test = false ;
        }
        if(passwordAux ==null) test = false;
        else if (!passwordAux.equals("test")) test = false;

        Assert.assertTrue(test);

    }
}