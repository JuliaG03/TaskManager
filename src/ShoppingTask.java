import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShoppingTask extends Task{

    public String store;
    private List<ShopObj> shoppingList;

    public ShoppingTask(User user, String title, String description, Date dueDate, TaskPriority priority, TaskStatus status, List<ShopObj> shoppingList) {
        super(user, title, description, dueDate, priority, status);
        this.shoppingList = shoppingList;
    }

    Scanner scanner = new Scanner(System.in);
   public void addObj() throws ParseException {
        ShopObj shopObj = new ShopObj();
        shopObj.read( scanner);
        shoppingList.add(shopObj);
   }

    @Override
    public String toString() {
        return "ShoppingTask{" +
                "store='" + store + '\'' +
                ", shoppingList=" + shoppingList +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", status=" + status +
                '}';
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
}
