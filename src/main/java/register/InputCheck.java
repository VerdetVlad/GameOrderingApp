package register;

import utilities.AlertBox;
import utilities.SpellCheck;

public class InputCheck {

    public static boolean badImput(String userName, String passWord)
    {
        if(SpellCheck.isEmpty(userName))
        {
            AlertBox.display("Error","Must introduce a name.");
            return true;
        }

        if(SpellCheck.isEmpty(passWord))
        {
            AlertBox.display("Error","Must introduce a password.");
            return true;
        }

        if(UsersCheck.userExists(userName))
        {
            AlertBox.display("Error","Name taken, try another one.");
            return true;
        }

        if(SpellCheck.containsSpecialChar( userName))
        {
            AlertBox.display("Error","Do not use special characters inside username.");
            return true;
        }

        if(SpellCheck.tooLong(userName,30))
        {
            AlertBox.display("Error","Name too long.");
            return true;
        }

        if(SpellCheck.tooLong(passWord,60))
        {
            AlertBox.display("Error","Password too long.");
            return true;
        }



        return false;
    }

}
