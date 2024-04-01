import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//nu uita ca ai nevoie sa setezi userul
public class Task {
    public User user;
    public String title, description;

    public Date dueDate;

    public TaskPriority priority;
    public TaskStatus status;


    public Task(User user, String title, String description, Date dueDate, TaskPriority priority, TaskStatus status) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }
    public Task(){}

    public void read(Scanner in) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Enter task details:");
        System.out.println("Title: ");
        title = in.nextLine();
        System.out.println("Description: ");
        description = in.nextLine();
        System.out.println("Due Date (yyyy-MM-dd): ");
        String dueDateString = in.nextLine();
        try {
            dueDate = dateFormat.parse(dueDateString); // Parse the due date string into a Date object
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            return; // Exit the method if parsing fails
        }

        System.out.println("Priority (LOW, MEDIUM, HIGH): ");
        String priorityString = in.nextLine();
        try {
            priority = TaskPriority.valueOf(priorityString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority value. Please enter LOW, MEDIUM, or HIGH.");
            return;
        }

        System.out.println("Status (TODO, IN_PROGRESS, DONE): ");
        String statusString = in.nextLine();
        try {
            status = TaskStatus.valueOf(statusString.toUpperCase()); // Convert input string to TaskStatus enum
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status value. Please enter TODO, IN_PROGRESS, or DONE.");
            return;
        }
    }
    public void printTask(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format for displaying dates

        System.out.println("Task Details:");
        System.out.println("User: " + user);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Due Date: " + dateFormat.format(dueDate));
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
    }
    @Override
    public String toString() {
        return "Task{" +
                "user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public TaskPriority getPriority() {
        return priority;
    }
    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }
    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }


}
