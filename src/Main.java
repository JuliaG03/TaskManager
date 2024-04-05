import java.text.ParseException;
import java.util.*;

public class Main {


    public Main() {}

    public static void main(String[] args) throws ParseException{
        List<User> userssss = new ArrayList<>();
        User loggedinnnnn = new User();
        Data data = new Data(userssss,loggedinnnnn);
        AuthenticationService authenticationService = new AuthenticationService(data);
        MainService mainService = new MainService(data) ;

        mainService.startapp();

        mainService.authentication();  // + methods for admin

        mainService.user();

        //mainService.admin();




        data.getLoggedin().printUser();



    }




    /*
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        boolean end = false;
         User loggedinUser = null;
         MainService mainService = new MainService();
       while(!end){

           System.out.println("Welcome to Task manager!");
           System.out.println("\n What are you ? \n 1. User \n 2. Admin\n (Enter 1 or 2)\n");
           String typeofUser = in.nextLine();
           System.out.println(typeofUser + "user type \n");
           if (Objects.equals(typeofUser, "1")){  //admin
               mainService.logIn(in);
               System.out.println("\nWhat do you want to do?\n");
               System.out.println("1. See all users \n2.Delete a user\n 3.Exit");
               String choice = in.nextLine();
                       if(Objects.equals(choice, "1")) mainService.seeAllUsers();
                       else if(choice == "2"){
                           //to write function that has the admin choose a user by index:
                           //User usertoDelete = mainService.chooseUser();
                          // mainService.deleteUser(userToDelete);
                       }
                       else {end = true;}
           }
           else if (Objects.equals(typeofUser, "2")){ //user
           System.out.println("\nWhat do you want to do today? ");
           System.out.println(" 1. Register \n" +
                                " 2. Login\n"+
                                " 3. ");}

           else {
               System.out.println("Invalid command.");
               end = true;}



       }

        }

*/


    }
