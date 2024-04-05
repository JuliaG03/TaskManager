public class TaskService {

    private Data data;

    public TaskService(Data data) {
        this.data = data;
    }


    public void setUsertoTask(Task task){
        task.setUser(data.getLoggedin());
    }

    public Task createTask(){
        System.out.println("What type of task do you want to add? ");
        System.out.println("1. Task \n 2. Work Task \n 3.Shopping Task\n Please wirte 1, 2 or 3");
        String type = data.in.nextLine();
        switch(type){
            case "1":
                Task task = new Task();
                task.read(data.in);

    }
        return null;
    }

    public Task createSimpleTask(){
        Task task = new Task();
        task.read(data.in);
        task.setUser(data.getLoggedin());
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
        System.out.println("Give the index number of the ShoppingTask you want to select: ");
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
        System.out.println("Give the index number of the ShoppingTask you want to select: ");
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
        System.out.println("Give the index number of the ShoppingTask you want to select: ");
        selected = data.in.nextLine();
        return data.getLoggedin().getWorkTasks().getTaskList().get(Integer.parseInt(selected));
    }

    public void deleteTask(){data.getLoggedin().getTasks().getTaskList().remove(selectTask());}

    public void deleteShoppingTask(){data.getLoggedin().getShoppingTasks().getTaskList().remove(selectShoppingTask());}
    public void deleteWorkTask(){data.getLoggedin().getWorkTasks().getTaskList().remove(selectWorkTask());}


    public void seeAllSimpleTasks(){
        for( Task task : data.getLoggedin().getTasks().getTaskList()){
            task.printTask();
        }
    }

    public void seeAllWorkTasks(){
        for( Task task : data.getLoggedin().getWorkTasks().getTaskList()){
            task.printTask();
        }
    }
    public void seeAllShoppingTasks(){
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
