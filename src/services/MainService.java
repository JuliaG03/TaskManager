package services;

import model.User;

import utility.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainService {

    User admin;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date dateOfBirth = dateFormat.parse("04-04-2024");
    private AuthenticationService authenticationService;
    private TaskService taskService;
    private Data data = new Data();
    public MainService(Data data) throws ParseException {
        this.data = data;
        this.authenticationService = new AuthenticationService(data);
        this.taskService = new TaskService(data);
        admin = new User("admin", "admin", "admin", dateOfBirth, "admin@admin.ro", "admin");
    }

    public void startapp() {
        System.out.println("####### model.Task Manager #######");
        System.out.println("Welcome to your Task Manager!");
        data.getUsersFromJDBC().add(admin);
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
        while (choice != "0") {

            switch (choice) {
                case "0":
                { choice = "0";
                    break;}

                case "1": {
                    System.out.println("Here are all of your tasks:\n");

                    taskService.seeAllTasks();
                    AuditService.getInstance().logAction("See all tasks");
                    break;
                }
                case "2": {
                    System.out.println("Here are all of your simple tasks: \n");
                    taskService.seeAllSimpleTasks();
                    AuditService.getInstance().logAction("see all simple tasks");
                    break;
                }
                case "3": {
                    System.out.println("Here are all of your work tasks : \n");
                    taskService.seeAllWorkTasks();
                    AuditService.getInstance().logAction("See all work tasks");
                    break;
                }
                case "4": {
                    System.out.println("Here are all of your shopping tasks: ");
                    taskService.seeAllShoppingTasks();
                    AuditService.getInstance().logAction("See all shopping tasks");
                    break;
                }
                case "5": {
                    System.out.println("Add a new simple task");
                    //taskService.addAndCreateSimpleTask();
                    data.getLoggedin().getTasks().add(taskService.createSimpleTask());
                    AuditService.getInstance().logAction("Create new task");
                    break;

                }
                case "6": {
                    System.out.println("Add a new work task: ");
                    taskService.addAndCreteWorkTask();
                    AuditService.getInstance().logAction("Create new work task");
                    break;
                }
                case "7": {
                    System.out.println("Add a new shopping task");
                    taskService.addandCreateShoppingTask();
                    AuditService.getInstance().logAction("Create new shopping task");
                    break;
                }
                case "8": {
                    System.out.println("Delete a simple task: ");
                    taskService.deleteTask();
                    AuditService.getInstance().logAction("Delete simple task");
                    break;
                }
                case "9": {
                    System.out.println("Delete a work task: ");
                    taskService.deleteWorkTask();
                    AuditService.getInstance().logAction("Delete work task");
                    break;
                }
                case "10": {
                    System.out.println("Delete a shopping task: ");
                    taskService.deleteShoppingTask();
                    AuditService.getInstance().logAction("Delete shopping task");
                    break;
                }
                case "11": {
                    System.out.println("##########Settings ###### ");
                    System.out.println("\nWhat do you want to do? " +
                            "\n0. Exit" +
                            "\n1. See your personal data" +
                            "\n2. Update your credentials" +
                            "\n3. Update Password" +
                            "\n4. Wipe all of your tasks lists" +
                            "\n5. Delete your account");
                    String input = data.in.nextLine();
                    while (input!="0") {




                        switch (input) {
                            case "0": {
                                input = "0";
                                break;
                            }
                            case "1": {
                                System.out.println("See your personal data");
                                data.getLoggedin().printUserDetails();
                                AuditService.getInstance().logAction("See personal data");
                                break;
                            }
                            case "2": {
                                System.out.println("2. Update your credentials:");
                                authenticationService.updateCredentials(data.getLoggedin());
                                AuditService.getInstance().logAction("Updated user credentials");
                                break;
                            }
                            case "3": {
                                System.out.println("3. Update your password: ");
                                Scanner in = new Scanner(System.in);
                                String newPassword = in.nextLine();
                                authenticationService.updatePassword(data.getLoggedin());
                                AuditService.getInstance().logAction("Updated user password");
                                break;
                            }
                            case "4": {
                                System.out.println("Wipe all of your tasks and start fresh");
                                taskService.deleteAllTasklists();
                                AuditService.getInstance().logAction("Deleted all existing tasks for user");
                                break;
                            }
                            case "5": {
                                System.out.println("Delete your account");
                                data.getUsersFromJDBC().remove(data.getLoggedin());
                                data.setLoggedin(null);
                                System.out.println("Account deleted successfully");
                                AuditService.getInstance().logAction("Deleted user");
                                input = "0";
                                break;
                            }
                            default: {
                                System.out.println("This is not a correct option");
                                break;
                            }
                        }
                        System.out.println("##########Settings ###### ");
                        System.out.println("\nWhat do you want to do? " +
                                "\n0. Exit" +
                                "\n1. See your personal data" +
                                "\n2. Update your credentials" +
                                "\n3. Update Password" +
                                "\n4. Wipe all of your tasks lists" +
                                "\n5. Delete your account");
                        input = data.in.nextLine();}


                }}
            System.out.println("Please input the number of your choice.");
            choice = data.in.nextLine();
        }
    }
    public void authentication() throws ParseException {


         String exit = "1";

        while(exit!="0") {
            System.out.println("Are you a user or an admin? (Enter 1 for user, 2 for admin, 0 for exit) : ");
            String typeofuser = data.in.nextLine();
            switch (typeofuser) {
                case "0":
                {exit = "0";
                    break;}

                case "1": { //user auth
                    String exitauth = "1";
                    while(exitauth !="0"){
                        System.out.println("# # # # # # # # # #\nPlease choose an option! \n0. Exit\n 1. Register \n 2.Login\n");
                        String auth = data.in.nextLine();

                    switch (auth) {
                        case "0":{
                            exitauth = "0";
                            break;
                        }

                        case "1": {
                            authenticationService.register(data.in);
                            AuditService.getInstance().logAction("registered new user");
                            break;
                        }
                        case "2": {
                            authenticationService.logIn(data.in);
                            AuditService.getInstance().logAction("Logged in user");
                            user();
                            break;
                        }
                        default: {
                            System.out.println("\nThis is not a valid value. Please re-enter a valid choice: ");
                            break;}
                    }
                    }
                }

                case "2": {
                    System.out.println("Enter admin username: ");
                    String user_admin = data.in.nextLine();
                    System.out.println("Enter admin password: ");
                    String pass = data.in.nextLine();
                    if(authenticationService.loginAdmin(user_admin, pass))
                        data.setLoggedin(admin);
                    AuditService.getInstance().logAction("Logged in Admin");
                        admin();


                break;
                }

                default: {
                    System.out.println("This is not a valid value.");
                    break;
                }
            }
        }
    }


    //admin part:
    public void admin() {
        if (data.getLoggedin().equals(admin)) {
            String exit= "1";
            while(exit!="0") {
            System.out.println("What do you want to do : \n 0.Exit\n 1. See all users \n 2.Delete an user.");
            String choice = data.in.nextLine();

                switch (choice) {
                    case "0": {
                        exit = "0";
                    }
                    case "1": {
                        authenticationService.seeAllUsers();
                        AuditService.getInstance().logAction("Admin accessed all users");
                        break;
                    }
                    case "2": {

                        AuditService.getInstance().logAction("Admin deleted user");
                        authenticationService.deleteUser(authenticationService.chooseUser());
                        break;
                    }
                    default: {
                        System.out.println("Not a valid choice.Try again.");
                        System.out.println("Do you want to continue? Y/N:");
                        String yesorno = data.in.nextLine();
                        if (yesorno.toLowerCase().equals("n"))
                            exit = "0";
                        break;
                    }
                }

            }
        }

    }




//getters and setters

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}