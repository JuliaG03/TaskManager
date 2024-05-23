package services;

import model.*;
import utility.Data;

public class TaskService {

    private utility.Data data;
    private TaskList<Task> tasklist;


    public TaskService(Data data) {
        this.data = data;
    }


    public void setUsertoTask(Task task){
        task.setUser(data.getLoggedin());
    }

    public Task createTask(){
        System.out.println("What type of task do you want to add? ");
        System.out.println("1. Task \n 2. Work Task \n 3.Shopping Task\n Please write 1, 2, 3, or 0 for exit.");
        String type = data.in.nextLine();
        while(type!="0"){
            switch(type){
                case "0":{
                    break;
                }
                case "1":
                {Task task = new Task();
                    task.read(data.in);
                    tasklist.add(task);

                    break;}
                case "2":
                {WorkTask worktask = new WorkTask();
                    worktask.read(data.in);
                    tasklist.add(worktask);
                    break;
                }
                case "3":
                {ShoppingTask shoppingTask = new ShoppingTask();
                    shoppingTask.read(data.in);
                    tasklist.add(shoppingTask);
                    break;
                }
                default:
                    System.out.println("The option you introduced is not correct.");
            }
        }
        return null;
    }

    public Task createSimpleTask(){
        Task task = new Task();
        task.read(data.in);
        task.setUser(data.getLoggedin());  //setez userul al taskului creat
        return task;
    }

    public WorkTask createWorkTask(){
        WorkTask task = new WorkTask();
        task.read(data.in);
        task.setUser(data.getLoggedin());
        return task;
    }

    public ShoppingTask createShoppingTask(){
        ShoppingTask task = new ShoppingTask();
        task.read(data.in);
        task.setUser(data.getLoggedin());
        return task;
    }
    public void addAndCreateSimpleTask(){data.getLoggedin().getTasks().add(createSimpleTask());}
    public void addAndCreteWorkTask(){
        data.getLoggedin().getWorkTasks().add(createWorkTask());
    }
    public void addandCreateShoppingTask(){
        data.getLoggedin().getShoppingTasks().add(createShoppingTask());
    }


    public ShoppingTask selectShoppingTask(){
        int index = 0;
        for( ShoppingTask shoptask: data.getLoggedin().getShoppingTasks().getTaskList()){
            System.out.println((index+1) + "\n" + shoptask);
            shoptask.printTask();
        }
        String selected = null;
        System.out.println("Give the index number of the model.ShoppingTask you want to select: ");
        selected = data.in.nextLine();
        return data.getLoggedin().getShoppingTasks().getTaskList().get(Integer.parseInt(selected));

    }

    public Task selectTask(){
        int index = 0;
        for( Task task: data.getLoggedin().getTasks().getTaskList()){
            System.out.println((index+1) + "\n" + task);
            task.printTask();
        }
        String selected = null;
        System.out.println("Give the index number of the model.ShoppingTask you want to select: ");
        selected = data.in.nextLine();
        return data.getLoggedin().getTasks().getTaskList().get(Integer.parseInt(selected));

    }
    public Task selectWorkTask(){
        int index = 0;
        for( Task task: data.getLoggedin().getWorkTasks().getTaskList()){
            System.out.println((index+1) + "\n" + task);
            task.printTask();
        }
        String selected = null;
        System.out.println("Give the index number of the model.ShoppingTask you want to select: ");
        selected = data.in.nextLine();
        return data.getLoggedin().getWorkTasks().getTaskList().get(Integer.parseInt(selected));
    }

    public void deleteTask(){data.getLoggedin().getTasks().getTaskList().remove(selectTask());}

    public void deleteShoppingTask(){data.getLoggedin().getShoppingTasks().getTaskList().remove(selectShoppingTask());}
    public void deleteWorkTask(){data.getLoggedin().getWorkTasks().getTaskList().remove(selectWorkTask());}


    public void seeAllSimpleTasks(){
        if( data.getLoggedin().getTasks().getTaskList().equals(null)){
            System.out.println("There is no task in your simple Tasklist");
            return;
        }
        for( Task task : data.getLoggedin().getTasks().getTaskList()){
            task.printTask();
        }
    }

    public void seeAllWorkTasks(){
        if( data.getLoggedin().getWorkTasks().getTaskList().equals(null)){
            System.out.println("There is no task in your Work Tasklist");
            return;
        }
        for( Task task : data.getLoggedin().getWorkTasks().getTaskList()){
            task.printTask();
        }
    }
    public void seeAllShoppingTasks(){
        if( data.getLoggedin().getShoppingTasks().getTaskList().equals(null)){
            System.out.println("There is no task in your shopping Tasklist");
            return;
        }
        for( Task task : data.getLoggedin().getShoppingTasks().getTaskList()){
            task.printTask();
        }
    }
    public void seeAllTasks(){
        System.out.println("Simple tasks:");
        seeAllSimpleTasks();
        System.out.println("Work tasks:");
        seeAllWorkTasks();
        System.out.println("Shopping tasks");
        seeAllShoppingTasks();
    }
    public void seeShoppingList(ShoppingTask shoppingTask){
        for(ShopObj shopobj: shoppingTask.getShoppingList()){
            shopobj.print();
            System.out.println("\n");
        }

    }
    //getters and setters
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void deleteAllTasklists(){
        data.getLoggedin().setTasks(null);
        data.getLoggedin().setShoppingTasks(null);
        data.getLoggedin().setWorkTasks(null);
    }
}