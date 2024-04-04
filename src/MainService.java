import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainService {

    private Data data;
    private AuthenticationService authenticationService = new AuthenticationService(data);
    private TaskService taskService = new TaskService(data);
    public MainService(Data data) throws ParseException {
        this.data = data;
        this.authenticationService = new AuthenticationService(data);
        this.taskService = new TaskService(data);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date dateOfBirth = dateFormat.parse("04-04-2024");
    User admin = new User("admin", "admin","admin", dateOfBirth, "admin@admin.ro", "admin");

    public void startapp(){
        System.out.println("####### Task Manager #######");
        System.out.println("Welcome to your Task Manager!");
        data.getUsers().add(admin);
    }
    public void authentication() throws ParseException {
        boolean ok = true;
        while(ok){

        System.out.println("Are you a user or an admin? (Enter 1 for user, 2 for admin: ");
        String typeofuser = data.in.nextLine();

        switch (typeofuser) {
            case "1": { //user auth
                boolean tru = true;
                while (tru) {
                    System.out.println("# # # # # # # # # # \n 1. Register \n 2.Login\n");
                    String auth = data.in.nextLine();

                    switch (auth) {
                        case "1": {
                            authenticationService.register(data.in);
                            tru = false;
                        }
                        case "2": {
                            authenticationService.logIn(data.in);
                            tru = false;
                        }
                        default: {
                            System.out.println("\nThis is not a valid value. Please re-enter a valid choice: ");
                        }
                    }
                }
                ok = false;

            }

                case "2": {
                    System.out.println("Enter admin username: ");
                    String usern = data.in.nextLine();
                    System.out.println("Enter admin password: ");
                    String pass = data.in.nextLine();
                    authenticationService.loginAdmin(usern,pass);
                    if(data.getLoggedin().equals(admin)){
                        admin();
                    }
                    ok = false;
                }

                default: {
                    System.out.println("This is not a valid value.");
                    ok = false;
                }
            }
        }
    }

    //admin part:
    public void admin()throws ParseException{
        if (data.getLoggedin().equals(admin)){
            System.out.println("What do you want to do : \n 1. See all users \n 2.Delete an user.");
            String choice = data.in.nextLine();
            boolean ok = true;
            while( ok == true){
            switch (choice){
                case "1": {
                    authenticationService.seeAllUsers();
                    ok = false;
                }
                case "2": {
                    authenticationService.deleteUser(authenticationService.chooseUser());
                    ok = false;
                }
                default: {
                    System.out.println("Not a valid choice.Try again.");
                    System.out.println("Do you want to continue? Y/N:");
                    String yesorno = data.in.nextLine();
                    if( yesorno.toLowerCase().equals("n")) ok = false;
                }
            }
            }

        }
    }


        //getters and setters


        public void setData (Data data){
            this.data = data;
        }


        public Data getData () {
            return data;
        }
    }