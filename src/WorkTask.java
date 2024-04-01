import java.util.Date;

public class WorkTask extends Task{
    public String project;
    public String boss;

    public WorkTask(User user, String title, String description, Date dueDate, TaskPriority priority, TaskStatus status, String project) {
        super(user, title, description, dueDate, priority, status);
        this.project = project;
        this.boss = boss;
    }



    @Override
    public String toString() {
        return "WorkTask{" +
                "project='" + project + '\'' +
                ", boss='" + boss + '\'' +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", status=" + status +
                '}';
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
