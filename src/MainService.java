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

    public boolean verifyUsername(String username){
        for (User userr: users){
            if( userr.getUsername().equals(username))
                return false;
        }
        return true;
    }

    public int findUser(User user){
        int index = 0;
        for(User userr: users) {

            if (userr.equals(user)) return index+1;
            index++;
        }
        return users.size()+1;
    }
    public void register(Scanner in) throws ParseException{
        User user = new User();
        System.out.println("\nPlease introduce your data: ");
        while(true) {
            user.read(in);
            if (verifyUsername(user.getUsername())) {
                this.users.add(user);
                break;
            } else {
                System.out.println("\n Username already exists. Please register again.");
            }
        }

    }
    public void logIn(Scanner in) throws ParseException{
        User user = new User();
        System.out.println("Username: ");
        String username = in.nextLine();
        System.out.println("Password: ");
        String password = in.nextLine();
        for(User userr: users){
            if(userr.verifyCredentials(username,password)){
                loggedinUser = userr;
                System.out.println("\nLogin Credentials correct!");
                break;
            }
            else {
                System.out.println("There is no user registered with this username and password! Try again.");
            }
        }
    }

    //----------------------ADMIN:

    Admin admin = new Admin();

    public void deleteUser(User user){
        if(findUser(user)!=users.size()+1) users.remove(findUser(user));

    }

    public void seeAllUsers(){
        int i =0;
        for(User user: users){
            i++;
            System.out.println("\n" + i +". ");
            user.printUser();
        }
    }

    //-------------TASKS related method for a user







    //getters and setters

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
