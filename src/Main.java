import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        //User user = new User();
        //user.read(scanner);

        //System.out.print(user.toString());

        Task task = new Task();
        task.read(scanner);
        task.printTask();
    }
}