package model;

import enums.TaskPriority;
import enums.TaskStatus;

import java.text.ParseException;
import java.util.*;

public class ShoppingTask extends Task {

    private String store;
    private List<ShopObj> shoppingList;

    public ShoppingTask(User user, String title, String description, Date dueDate, TaskPriority priority, TaskStatus status, List<ShopObj> shoppingList) {
        super(user, title, description, dueDate, priority, status);
        this.shoppingList = shoppingList;
    }
    public ShoppingTask(){}
    Scanner scanner = new Scanner(System.in);


   public void addObj() throws ParseException {
        ShopObj shopObj = new ShopObj();
        shopObj.read( scanner);
        shoppingList.add(shopObj);
   }

    @Override
    public String toString() {
        return "model.ShoppingTask{" +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", status=" + status +
                "store='" + store + '\'' +
                ", shoppingList=" + shoppingList +
                '}';
    }

    @Override
    public void read(Scanner in) {
        super.read(in);
        System.out.println("Store: ");
        store = in.nextLine();

        System.out.println("Start writing down your shopping list: ");
        ShopObj obj = new ShopObj();
        try {
            obj.read(scanner);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String ok = "";
        System.out.println("Do you want to add another? y/n:");
        ok = in.nextLine().toLowerCase();
        while(ok.equals("y")){
            try {
                obj.read(scanner);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Do you want to add another? y/n:");
            ok = in.nextLine();

        }

    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.println("Store: " + store );
        for (ShopObj obj : shoppingList) {
            obj.print();
        }

    }

    //getters and setters
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public List<ShopObj> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<ShopObj> shoppingList) {
        this.shoppingList = shoppingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingTask that)) return false;
        return Objects.equals(getStore(), that.getStore()) && Objects.equals(getShoppingList(), that.getShoppingList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStore(), getShoppingList());
    }
}
