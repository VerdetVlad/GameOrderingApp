import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;




public class FilesWritingAndReadingTest {


    @BeforeClass
    //creates files necessary for testing
    public static void create() {

        System.out.println("111111111111");

        //logIN-----------------------------
        final File testDir = new File(System.getProperty("user.dir") + "\\Tests");

        File nameDir = new File(testDir.getName() + "\\userTest");

        File passFile = new File(nameDir + "\\password.txt");

        try {
            passFile.getParentFile().mkdirs();
            passFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter passFW= null;
        try {
            passFW = new FileWriter(passFile);
            passFW.write("passwordTest");
            passFW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //object creation----------------------------------------
        File objectDir = new File(testDir + "\\objectCreationTest");
        File objectFile = new File(objectDir + "\\testFile.txt");


        try {
            objectFile.getParentFile().mkdirs();
            objectFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter objFW= null;
        try {
            objFW = new FileWriter(objectFile);
            objFW.write("User,Game,Status\n" +
                             "Vlad,The Witcher 3,Accepted - 4");
            objFW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //message check-------------------------------------
        File messDir = new File(testDir + "\\messageTest");
        File messFile = new File(messDir + "\\messageTest.txt");

        try {
            messFile.getParentFile().mkdirs();
            messFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter messFW= null;
        try {
            messFW = new FileWriter(messFile);
            messFW.write("altUser,altGame,altStatus\n" +
                             "user,game,status");
            messFW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





    @Test
    //makes sure all files were created
    //does not check if their contents are correct
    public void fileIntegrityTest() {
        System.out.println("444444444444444444");

        boolean test = true;

        File testDir = new File(System.getProperty("user.dir") + "\\Tests");
        File nameDir = new File(testDir.getName() + "\\userTest");
        File passFile = new File(nameDir + "\\password.txt");
        File objectDir = new File(testDir + "\\objectCreationTest");
        File objectFile = new File(objectDir + "\\testFile.txt");



        //checking if file creation failed
        if(! testDir.exists()) test = false;
        if(! nameDir.exists() ) test = false;
        if(! passFile.exists()) test = false;
        if(! objectDir.exists()) test = false;
        if(! objectFile.exists()) test = false;


        if(!test) System.out.println("Problems creating files");

        assertTrue(test);
    }





    @Test
    //basically login testing
    //this method aims to find a particular user and check its password
    public void logInTest() {

        System.out.println("2222222222222");

        boolean test; // used for checking if the creation took place correctly
        test = true;


        final File usersDir = new File(System.getProperty("user.dir") + "\\Tests");
        String userLoc=null;

        for (String pathname : usersDir.list()) {

            if(pathname.equals("userTest"))
            {
                userLoc = usersDir + "\\" + pathname;
                break;
            }
        }
        if(userLoc==null) test=false;

        File passFile = new File(userLoc + "\\password.txt");
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
        else if (!passwordAux.equals("passwordTest")) test = false;



        Assert.assertTrue(test);

    }





    @Test
    //the program relies heavily on creating objects from data inside files
    //this test does just that
    public void readObjectsTest() {



        System.out.println("33333333333333");


        boolean test = true;

        ArrayList<OrderObject> testArray = new ArrayList<>();
        final File storeFile = new File(System.getProperty("user.dir") +
                "\\Tests\\objectCreationTest\\testFile.txt");

        String line=null;

        BufferedReader readFile = null;
        try {
            readFile = new BufferedReader(new FileReader(storeFile));
            line =  readFile.readLine();
        } catch (Exception e) {
            test = false;
        }

        while(line != null)
        {
            OrderObject aux = makeOrder(line);
            testArray.add(aux);
            try {
                line = readFile.readLine();
            } catch (IOException e) {
                test = false;
            }
        }
        try {
            readFile.close();
        } catch (IOException e) {
            test = false;
        }

        OrderObject a = testArray.get(0);
        OrderObject b = new OrderObject("User","Game","Status");
        if(!a.equals(b)) test = false;

        a=testArray.get(1);
        if(!a.equals(new OrderObject("Vlad","The Witcher 3","Accepted - 4"))) test = false;


        assertTrue(test);
    }

    //user with readObjectTest
    public OrderObject makeOrder(String line) {
        OrderObject order = new OrderObject();
        String[] aux=null;


        aux = line.split(",");
        String[] aux2 = null;

        order.setUser(aux[0]);

        order.setGame(aux[1]);

        order.setStatus(aux[2]);

        return order;
    }



    @Test
    //the client and manager communicate trough messages
    //when a message is an update the old message must be removed from the log
    //and the new one placed at the top of the log
    public void messageTest() {
        final File pathClient = new File(System.getProperty("user.dir") +
                "\\Tests\\messageTest\\messageTest.txt");


        StringBuffer out = new StringBuffer("");
        out.append( "user,game,newStatus\n");



        String line=null;
        BufferedReader readFile = null;
        try {
            readFile = new BufferedReader(new FileReader(pathClient));
            line =  readFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }



        String mask="user,game,status";
        while(line != null)
        {
            if(!line.equals(mask))
                out.append(line + "\n");

            try {
                line = readFile.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        try {
            readFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter storeFW= null;
        try {
            storeFW = new FileWriter(pathClient);
            storeFW.write(out.toString());
            storeFW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }












}