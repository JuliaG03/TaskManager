import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskList <T extends Task>{
    private List<T> taskList;


    public TaskList(List<T> taskList) {
        this.taskList = taskList;
    }

    public TaskList(){}

    //getters and setters
    public List<T> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<T> taskList) {
        this.taskList = taskList;
    }

    public void add(T t){
        taskList.add( t);
    }
    public void delete(T t){
        taskList.remove( t);
    }

    public T search(String title){
        for ( T task: taskList){
            if (task.getTitle().equals(title)){
                return task;}
            }
        System.out.println("Task not found! ");
        return null;}

    public TaskList<T> sortAlfabetically(){
        Collections.sort(taskList, Comparator.comparing(Task::getTitle));
        return this;
    }

    public TaskList<T> sortByPriority() {
        taskList.sort(Comparator.comparing(Task::getPriority, (p1, p2) -> {
            return Integer.compare(p2.ordinal(), p1.ordinal()); //higher priority first
        }));
        System.out.println("Task List sorted successfully");
        return this;
    }

    public TaskList<T> sortByStatus(){
        taskList.sort(Comparator.comparing(Task::getStatus, (p1, p2) -> Integer.compare(p2.ordinal(), p1.ordinal())));
        System.out.println("Task List sorted successfully");
        return this;
    }

    public void seeOnlyDone(){
        for( T task: taskList){
            if( task.getStatus().equals("DONE")){
                task.printTask();
                System.out.println(",\n");
            }
        }

    }

    public void seeOnlyInProgress(){
        for( T task: taskList){
            if( task.getStatus().equals("IN_PROGRESS")){
                task.printTask();
                System.out.println(",\n");
            }
        }

    }

    public void seeOnlyHigh(){
        for( T task: taskList){
            if( task.getPriority().equals("HIGH")){
                task.printTask();
                System.out.println(",\n");
            }
        }

    }

    public void seeOnlyLow(){
        for( T task: taskList){
            if( task.getPriority().equals("LOW")){
                task.printTask();
                System.out.println(",\n");
            }
        }

    }

    public void seeOnlyMedium(){
        for( T task: taskList){
            if( task.getPriority().equals("MEDIUM")){
                task.printTask();
                System.out.println(",\n");
            }
        }

    }

    public void seeOnlyTodo(){
        for( T task: taskList){
            if( task.getStatus().equals("TODO")){
                task.printTask();
                System.out.println(",\n");
            }
        }

    }



}
