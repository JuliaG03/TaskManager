import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import static java.lang.System.in;

public class User {
    private  String  userId = generateUserId();
    private String firstName, lastName;
    private String username;
    private Date birthDate;
    private String email, password;

    private TaskList<Task> tasks;
    private TaskList<ShoppingTask> shoppingTasks;
    private TaskList<WorkTask>  workTasks;

    //added these 3 attributes - to do getters,setters, function to add to them, print,
    //dont forget - toString to TaskList class
    //



    public User( String firstName, String lastName, String username,Date birthDate, String email, String password) {
        this.userId = generateUserId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.tasks = new TaskList<Task>();
        this.shoppingTasks = new TaskList<ShoppingTask>();
        this.workTasks = new TaskList<WorkTask>();
    }

    public User(){}

    public User(String userId, Scanner in) throws ParseException{

        this.read(in);
    }
  /*
    public User(int userId, ResultSet in ) throws SQLException{
        this.userId = userId;
        this.read(in);
    }


   */
  private String generateUserId() {
      return UUID.randomUUID().toString();
  }
    public void read( ResultSet in) throws SQLException{
        this.userId = generateUserId();
        this.firstName = in.getString("first name");
        this.lastName = in.getString("last name");
        this.username = in.getString("username");
        this.birthDate = in.getDate("Birth date");
        this.email = in.getString("Email");
        this.password = in.getString("Password");

    }

    public void read(Scanner in) throws ParseException{
      this.userId = generateUserId();
        System.out.println("First name: ");
        this.firstName = in.nextLine();
        System.out.println("Last name: ");
        this.lastName = in.nextLine();
        System.out.println("Username: ");
        this.username = in.nextLine();
        System.out.println("Birth date: ");
        String birthDateStr = in.nextLine();
        this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
        System.out.println("Email: ");
        this.email = in.nextLine();
        System.out.println("Password: ");
        this.password = in.nextLine();

    }

    public void printUser(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("User ID: " + getUserId());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Username: "+ getUsername());
        System.out.println("Birth Date: " + dateFormat.format(getBirthDate()));
        System.out.println("Email: " + getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username +'\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean verifyCredentials ( String username, String password){
        if (( username == this.username) || (password == this.password)){
            return true;
        }else{return false;}
    }


    //getters + setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TaskList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(TaskList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList<ShoppingTask> getShoppingTasks() {
        return shoppingTasks;
    }

    public void setShoppingTasks(TaskList<ShoppingTask> shoppingTasks) {
        this.shoppingTasks = shoppingTasks;
    }

    public TaskList<WorkTask> getWorkTasks() {
        return workTasks;
    }

    public void setWorkTasks(TaskList<WorkTask> workTasks) {
        this.workTasks = workTasks;
    }

    public String getUserId(){
        return userId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){ return lastName;}
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Date getBirthDate(){ return birthDate;}
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    public String getEmail(){return email;}

    public void setEmail( String email){
        this.email = email;
    }

    public String getPassword(){return password;}

    public void setPassword(String password){
        this.password = password;
    }


}
