package services;

import DataBase.DatabaseHelper;
import DataBase.DatabaseInitialiser;
import model.User;
import utility.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import static DataBase.JdbcSettings.connection;
import static java.lang.System.in;

public class UserandAuthenticationService {
    private Data data;

    public UserandAuthenticationService(Data data) {
        this.data = data;
    }

    public boolean verifyUsername(String username) {
        for (User userr : data.getUsersFromJDBC()) {
            if (userr.getUsername().equals(username))
                return false;
        }
        return true;
    }

    public int findUserIndex(User user) {
        int index = 0;
        for (User userr : data.getUsersFromJDBC()) {

            if (userr.equals(user)) return index + 1;
            index++;
        }
        return data.getUsersFromJDBC().size() + 1;
    }

    public void register(Scanner in) throws ParseException, SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TaskManager", "root", "0909");
             Statement statement = connection.createStatement()) {
        DatabaseHelper databaseHelper = new DatabaseHelper(connection);
        User user = new User();
        System.out.println("\nPlease introduce your data: ");
        while (true) {
            user.read(in);
            if (verifyUsername(user.getUsername())) {
                this.data.addUser(user);
                DatabaseHelper.addUserToDatabase(user);
                System.out.println("\nRegistration done. Please Login now.\n");
                break;
            } else {
                System.out.println("\n Username already exists. Please register again.");
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();}

    }

    public void logIn(Scanner in) throws ParseException {
        System.out.println("\nPlease Log in: \n");
        User user = new User();
        System.out.println("\nUsername: ");
        String username = in.nextLine();
        System.out.println("\nPassword: ");
        String password = in.nextLine();
        boolean founduser = false;
        for (User userverify : data.getUsersFromJDBC()) {
            if (userverify.verifyCredentials(username.toLowerCase(), password.toLowerCase())) {
                founduser = true;
                data.setLoggedin(userverify);
                System.out.println("\nLogin Credentials correct!");
                return; // exit the method after correct login

            }
        }
        if (!founduser) {
            System.out.println("There is no user registered with this username and password! Try again.");
        }
        return;

    }

    public boolean loginAdmin(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("\nLogin Credentials correct!");

            return true; // Exit method after successful login
        }

        System.out.println("There is no admin registered with this username and password! Try again.");
        return false;
    }


    public User chooseUser() {
        Scanner in = new Scanner(System.in);
        int index = 0;
        for (User userr : data.getUsersFromJDBC()) {
            System.out.println(index + ". \n");
            userr.printUserDetails();
        }
        System.out.println("Choose user index: ");
        index = Integer.parseInt(in.nextLine());
        return data.getUsersFromJDBC().get(index);
    }


    public void updateCredentials(User user) throws ParseException {
        Scanner scanner = new Scanner(in);
        System.out.println("Initial Credentials: ");
        user.printUserDetails();
        System.out.println("Introduce your new credentials: ");
        user.read(scanner);
    }

    public void updatePassword(User user) throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("\nVerify your  old password: ");
        String password = in.nextLine();
        if (user.getPassword().equals(password)) {
            System.out.println("\nCorrect password! Please enter your new password: ");
            password = in.nextLine();
            user.setPassword(password);
            System.out.println("\nPassword changed successfully. ");
        } else {
            System.out.println("/nIncorrect password.");
        }

    }
    //----------------------ADMIN:


    public void deleteUser(User user) {
        if (findUserIndex(user) != data.getUsersFromJDBC().size() + 1) data.getUsers().remove(findUserIndex(user));

    }

    public void seeAllUsers() {
        int i = 0;
        for (User user : data.getUsersFromJDBC()) {
            i++;
            System.out.println("\n" + i + ". ");
            user.printUserDetails();
        }
        return;
    }

}