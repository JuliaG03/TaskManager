package utility;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
    private static Data instance;
    private List<User> users = new ArrayList<>();
    private User loggedin;

    public Scanner in = new Scanner(System.in);

    //constructors
    public Data(){}

    public Data(List<User> users, User loggedin) {
        this.users = users;
        this.loggedin = loggedin;
    }

    //getters and setters
    public List<User> getUsers() {
        List<User> empty = new ArrayList<>();
        if (users.isEmpty()) {return empty;}
        else {return users;}
    }



    public static List<User> getUsersFromJDBC() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TaskManager", "root", "0909");
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("username"),
                        resultSet.getDate("birthDate"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();}

        return users;
    }

    public void addUser(User user){
        users.add(user);
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
