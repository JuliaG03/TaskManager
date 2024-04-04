import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Admin extends User{

    //see all users

    //delete user account


    public Admin(String firstName, String lastName, String username, Date birthDate, String email, String password) {
        super(firstName, lastName, username, birthDate, email, password);
    }

    public Admin() {
    }

    public Admin(String userId, Scanner in) throws ParseException {
        super(userId, in);
    }


}
