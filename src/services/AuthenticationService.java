package services;

import model.User;
import utility.Data;
import java.text.ParseException;
import java.util.Scanner;

import static java.lang.System.in;

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
                System.out.println("\nRegistration done. Please Login.\n");
                logIn(data.in);
                break;
            } else {
                System.out.println("\n Username already exists. Please register again.");
            }
        }

    }
    public void logIn(Scanner in) throws ParseException{
        System.out.println("\nPlease Log in: \n");
        User user = new User();
        System.out.println("\nUsername: ");
        String username = in.nextLine();
        System.out.println("\nPassword: ");
        String password = in.nextLine();
        for(User userr: data.getUsers()){
            if(userr.verifyCredentials(username,password)){
                data.setLoggedin(userr);
                System.out.println("\nLogin Credentials correct!");
                break;
            }
        }
        if(data.getLoggedin().getUsername()!=username){
            System.out.println("There is no user registered with this username and password! Try again.");
        }
    }

    public void loginAdmin(String username, String password){
       if (data.getUsers() != null) { // Check if users list is not null
            for(User userr: data.getUsers()){
                if(userr.verifyCredentials(username,password)){
                    data.setLoggedin(userr);
                    System.out.println("\nLogin Credentials correct!");
                    return; // Exit method after successful login
                }
            }
       }
       System.out.println("There is no admin registered with this username and password! Try again.");
    }


    public User chooseUser(){
        Scanner in = new Scanner(System.in);
        int index=0;
        for(User userr: data.getUsers()){
            System.out.println(index +". \n" );
            userr.printUserDetails();
        }
        System.out.println("Choose user index: ");
        index = Integer.parseInt(in.nextLine());
        return data.getUsers().get(index);
    }


    public void updateCredentials(User user) throws ParseException {
        Scanner scanner = new Scanner(in);
        System.out.println("Initial Credentials: ");
        user.printUserDetails();
        System.out.println("Introduce your new credentials: ");
        user.read(scanner);
    }

    public void updatePassword(User user) throws ParseException{
        Scanner in  =new Scanner(System.in);
        System.out.println("\nVerify your  old password: ");
        String password = in.nextLine();
        if( user.getPassword().equals(password)){
            System.out.println("\nCorrect password! Please enter your new password: ");
            password = in.nextLine();
            user.setPassword(password);
            System.out.println("\nPassword changed successfully. ");
        } else{
            System.out.println("/nIncorrect password.");}

    }
    //----------------------ADMIN:



    public void deleteUser(User user){
        if(findUserIndex(user)!=data.getUsers().size()+1) data.getUsers().remove(findUserIndex(user));

    }

    public void seeAllUsers(){
        int i =0;
        for(User user: data.getUsers()){
            i++;
            System.out.println("\n" + i +". ");
            user.printUserDetails();
        }
    }

}
