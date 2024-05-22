package model;

import enums.TaskPriority;
import enums.TaskStatus;
import model.Task;
import model.User;

import java.util.Date;
import java.util.Scanner;

public class WorkTask extends Task {
    private String project;
    private String boss;

    public WorkTask(User user, String title, String description, Date dueDate, TaskPriority priority, TaskStatus status, String project) {
        super(user, title, description, dueDate, priority, status);
        this.project = project;
        this.boss = boss;
    }

    public WorkTask(){}


    @Override
    public String toString() {
        return "model.WorkTask{" +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", status=" + status +
                "project='" + project + '\'' +
                ", boss='" + boss + '\'' +
                '}';
    }

    @Override
    public void read(Scanner in) {
        super.read(in);
        System.out.println("Project: ");
        project = in.nextLine();
        System.out.println("Boss: ");
        boss = in.nextLine();
    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.println("Project: " + project);
        System.out.println("Boss" + boss);
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }
}
