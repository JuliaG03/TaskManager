package services;

import model.User;
import services.AuthenticationService;
import services.ShopService;
import utility.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainService {

    private Data data;
    private AuthenticationService authenticationService = new AuthenticationService(data);
    private TaskService taskService = new TaskService(data);
    private ShopService shopService = new ShopService(data);
    public MainService(Data data) throws ParseException {
        this.data = data;
        this.authenticationService = new AuthenticationService(data);
        this.taskService = new TaskService(data);
        this.shopService = new ShopService(data);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date dateOfBirth = dateFormat.parse("04-04-2024");
    User admin = new User("admin", "admin","admin", dateOfBirth, "admin@admin.ro", "admin");

    public void startapp(){
        System.out.println("####### model.Task Manager #######");
        System.out.println("Welcome to your model.Task Manager!");
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


    public void user() throws ParseException {
        System.out.println("Welcome, " + data.getLoggedin().getFirstName());
        System.out.println("What do you want to do today? " +
                "\n 1.See all tasks" +
                "\n 2.See all simple tasks" +
                "\n 3.See all Work tasks" +
                "\n 4.See all Shopping Tasks" +
                "\n 5.Add new simple task" +
                "\n 6.Add new work task" +
                "\n 7.Add new shopping task" +
                "\n 8.Delete a simple task" +
                "\n 9.Delete a work task" +
                "\n 10.Delete a shopping task" +
                "\n 11.Settings" +
                "\n 0. Exit");

        System.out.println("Please input the number of your choice.");
        String choice = data.in.nextLine();
        while(choice!= "0"){

            switch (choice){
                case "1":{
                    System.out.println("Here are all of your tasks:\n");
                    taskService.seeAllTasks();
                }
                case "2":{
                    System.out.println("Here are all of your simple tasks: \n");
                    taskService.seeAllSimpleTasks();
                }
                case "3":{
                    System.out.println("Here are all of your work tasks : \n");
                    taskService.seeAllWorkTasks();
                }
                case "4":{
                    System.out.println("Here are all of your shopping tasks: ");
                    taskService.seeAllShoppingTasks();
                }
                case "5":{
                    System.out.println("Add a new simple task");
                    taskService.addAndCreateSimpleTask();

                }
                case "6":{
                    System.out.println("Add a new work task: ");
                    taskService.addAndCreteWorkTask();
                }
                case "7":{
                    System.out.println("Add a new shopping task");
                    taskService.addandCreateShoppingTask();
                }
                case "8":{
                    System.out.println("Delete a simple task: ");
                    taskService.deleteTask();
                }
                case "9":{
                    System.out.println("Delete a work task: ");
                    taskService.deleteWorkTask();
                }
                case "10": {
                    System.out.println("Delete a shopping task: ");
                    taskService.deleteShoppingTask();
                }
                case "11":{
                    System.out.println("##########Settings ###### ");
                    System.out.println("\nWhat do you want to do? " +
                            "\n1. See your personal data" +
                            "\n2. Update your credentials" +
                            "\n3. Update Password"+
                            "\n4. Wipe all of your tasks lists"+
                            "\n5. Delete your account");

                    String input = data.in.nextLine();
                    while ("12345".contains(input)) {


                        switch (input) {
                            case "1": {
                                System.out.println("See your personal data");
                                data.getLoggedin().printUserDetails();
                            }
                            case "2": {
                                System.out.println("2. Update your credentials:");
                                authenticationService.updateCredentials(data.getLoggedin());}
                            case "3": {
                                System.out.println("3. Update your password: ");
                               authenticationService.updatePassword(data.getLoggedin());         }
                            case "4": {
                                System.out.println("Wipe all of your tasks and start fresh");
                                taskService.deleteAllTasklists();
                            }
                            case "5": {
                                System.out.println("Delete your account");
                                data.getUsers().remove(data.getLoggedin());
                                data.setLoggedin(null);
                            }
                            default:
                                break;
                        }
                    }
                }


            }
            System.out.println("Please input the number of your choice.");
            choice = data.in.nextLine();
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