import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;


//basically register testing
//used for testing if files are created correctly
//the created files are deleted at the end so the test is done every run
//necessary for saving data
public class MakeAccountTest {

    @Test
    public void create() {




        boolean test; // used for checking if the creation took place correctly
        test = true;



        final String mainDir = System.getProperty("user.dir");
        final File userDir = new File(mainDir + "\\Tests");
        if (!userDir.exists()) userDir.mkdir();


        File nameDir = new File(userDir.getName() + "\\regTest");
        if (!nameDir.exists()) nameDir.mkdir();


        File passFile = new File(nameDir + "\\password.txt");



        try{
            FileWriter passFW=new FileWriter(passFile);
            passFW.write("passwordTest");
            passFW.close();
        }catch(Exception e){

            test = false;
        }






        //checking if file creation failed
        if(! userDir.exists()) test = false;
        if(! nameDir.exists() ) test = false;
        if(! passFile.exists()) test = false;


        Assert.assertTrue(test);

    }
}