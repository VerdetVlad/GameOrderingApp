package utilities;

import java.math.BigDecimal;
import java.util.regex.*;

public class SpellCheck {

    public static boolean containsSpecialChar(String name)
    {
        Pattern p = Pattern.compile("[^a-z0-9_. ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        boolean b = m.find();

        if (b) return true;
        else return false;
    }

    public static boolean tooLong(String name, int size)
    {
        if(name.length()>size) return true;
        else return false;
    }

    public static boolean isEmpty(String name)
    {
        if(name.equals("")) return true;
        else return false;
    }

    public static boolean tooManyDecimals(double price)
    {
        boolean fail = (BigDecimal.valueOf(price).scale() > 2);
        if(fail) return true;
        else return false;
    }

    public static boolean basicCheck(String name)
    {
        if(SpellCheck.isEmpty(name))
        {
            AlertBox.display("Error","Must introduce a name.");
            return true;
        }


        if(SpellCheck.containsSpecialChar( name))
        {
            AlertBox.display("Error","Do not use special characters inside name.");
            return true;
        }

        if(SpellCheck.tooLong(name,30))
        {
            AlertBox.display("Error","Name too long.");
            return true;
        }



        return false;
    }
}
