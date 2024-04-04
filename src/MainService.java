import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainService {

    //storage
    private List<User> users = new ArrayList<>();
    private User loggedinUser = null;

    public MainService(List<User> users) {
        this.users = users;
    }
    public MainService(){}

    public void register(Scanner in) throws ParseException{
        User user = new User();
        user.read(in);
        this.users.add(user);

    }
    public void logIn(Scanner in) throws ParseException{
        User user = new User();
        System.out.println("Username: ");
        String username = in.nextLine();
        System.out.println("Password: ");
        String password = in.nextLine();
        for( User user: users){
            if(verify)  //daca gasesc un user sa se potribeasca
        }
    }

    //getters and setters

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
