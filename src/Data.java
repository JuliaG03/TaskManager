import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
    private static Data instance;
    private List<User> users = new ArrayList<>();
    private User loggedin = null;

    Scanner in = new Scanner(System.in);

    //constructors
    public Data(){}

    public Data(List<User> users, User loggedin) {
        this.users = users;
        this.loggedin = loggedin;
    }

    //getters and setters
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getLoggedin() {
        return loggedin;
    }

    public void setLoggedin(User loggedin) {
        this.loggedin = loggedin;
    }


    public static Data getInstance(){
        if(instance == null){
            instance = new Data();
        }
        return instance;
    }
}
