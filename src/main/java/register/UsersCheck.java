package register;

import java.io.File;

public class UsersCheck {

    public static boolean userExists(String name)
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
        if(userLoc!=null) return true;
        else return false;
    }
}
