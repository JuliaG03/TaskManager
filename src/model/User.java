package model;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class User {
    private  String  userId = generateUserId();
    private String firstName, lastName;
    private String username;
    private Date birthDate;
    private String email, password;

    private TaskList<Task> tasks;
    private TaskList<ShoppingTask> shoppingTasks;
    private TaskList<WorkTask> workTasks;





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
        System.out.println("Birth date:  (pattern:\"yyyy-MM-dd\") :");
        String birthDateStr = in.nextLine();
        this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
        System.out.println("Email: ");
        this.email = in.nextLine();
        System.out.println("Password: ");
        this.password = in.nextLine();

    }

    public void printUserDetails(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("User ID: " + getUserId());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Username: "+ getUsername());
        System.out.println("Birth Date: " + dateFormat.format(getBirthDate()));
        System.out.println("Email: " + getEmail());
        return;

    }

    public  void printUserCredentials(){
        System.out.println("Username: "+ getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Password: "+ getPassword());
    }
    @Override
    public String toString() {
        return "model.User{" +
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
        return this.username.equals(username.toLowerCase()) && this.password.equals(password.toLowerCase());}


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getBirthDate(), user.getBirthDate()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getTasks(), user.getTasks()) && Objects.equals(getShoppingTasks(), user.getShoppingTasks()) && Objects.equals(getWorkTasks(), user.getWorkTasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getUsername(), getBirthDate(), getEmail(), getPassword(), getTasks(), getShoppingTasks(), getWorkTasks());
    }
}
