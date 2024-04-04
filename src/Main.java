import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> commandsUser = Arrays.asList(
            "Register",
            "Login",
            "Logout",
            "SeeTasks",
            "AddNewTask",
            "ModifyTask",
            "SeeWorkTasks",
            "SeeShoppingTask",
            "help");
    static List<String> commandsAdmin = Arrays.asList(
            "SeeAllUsers",
            "DeleteUser");

    private static void printAllUserCommands(){
        for(int i  =0; i< commandsUser.size();i++){
            System.out.println("\n"+(i+1) + "." + commandsUser.get(i));
        }
    }
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);


        //public register(User user){

        }




    }
}