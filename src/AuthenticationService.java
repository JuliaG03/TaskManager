import java.text.ParseException;
import java.util.Scanner;

public class AuthenticationService {
    private Data data;

    public AuthenticationService(Data data) {
        this.data = data;
    }

    public boolean verifyUsername(String username){
        for (User userr: data.getUsers()){
            if( userr.getUsername().equals(username))
                return false;
        }
        return true;
    }

    public int findUserIndex(User user){
        int index = 0;
        for(User userr: data.getUsers()) {

            if (userr.equals(user)) return index+1;
            index++;
        }
        return data.getUsers().size()+1;
    }
    public void register(Scanner in) throws ParseException {
        User user = new User();
        System.out.println("\nPlease introduce your data: ");
        while(true) {
            user.read(in);
            if (verifyUsername(user.getUsername())) {
                this.data.getUsers().add(user);
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
        for(User userr: data.getUsers()){
            if(userr.verifyCredentials(username,password)){
                data.setLoggedin(userr);
                System.out.println("\nLogin Credentials correct!");
                break;
            }
            else {
                System.out.println("There is no user registered with this username and password! Try again.");
            }
        }
    }


    public int chooseUser(){
        Scanner in = new Scanner(System.in);
        int index=0;
        for(User userr: data.getUsers()){
            System.out.println(index +". \n" );
            userr.printUser();
        }
        System.out.println("Choose user index: ");
        index = Integer.parseInt(in.nextLine());
        return index;
    }

    //----------------------ADMIN:

    Admin admin = new Admin();

    public void deleteUser(User user){
        if(findUserIndex(user)!=data.getUsers().size()+1) data.getUsers().remove(findUserIndex(user));

    }

    public void seeAllUsers(){
        int i =0;
        for(User user: data.getUsers()){
            i++;
            System.out.println("\n" + i +". ");
            user.printUser();
        }
    }

}
