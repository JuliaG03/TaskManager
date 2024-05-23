package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitialiser {

    public static void initialize(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            createUserTable(statement);
            createTaskTable(statement);
            createWorkTaskTable(statement);
            createShopObjTable(statement);
            createShoppingTaskTable(statement);
        }
    }

    private static void createUserTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "userId VARCHAR(50) PRIMARY KEY," +
                "firstName VARCHAR(50) NOT NULL," +
                "lastName VARCHAR(50) NOT NULL," +
                "username VARCHAR(50) UNIQUE NOT NULL," +
                "birthDate DATE NOT NULL," +
                "email VARCHAR(100) UNIQUE NOT NULL," +
                "password VARCHAR(255) NOT NULL" +
                ")";
        statement.executeUpdate(sql);
    }

    private static void createTaskTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS task (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "title VARCHAR(255) NOT NULL," +
                "description VARCHAR(255) NOT NULL," +
                "dueDate DATE NOT NULL," +
                "priority ENUM('LOW', 'MEDIUM', 'HIGH') NOT NULL," +
                "status ENUM('TODO', 'IN_PROGRESS', 'DONE') NOT NULL," +
                "user_id VARCHAR(50) NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES user(userId)" +
                ")";
        statement.executeUpdate(sql);
    }

    private static void createWorkTaskTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS work_task (" +
                "id INT PRIMARY KEY," +
                "project VARCHAR(255) NOT NULL," +
                "boss VARCHAR(255) NOT NULL," +
                "FOREIGN KEY (id) REFERENCES task(id)" +
                ")";
        statement.executeUpdate(sql);
    }

    private static void createShopObjTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS shop_obj (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "description VARCHAR(255)," +
                "quantity INT NOT NULL," +
                "price_per_unit DECIMAL(10, 2) NOT NULL," +
                "final_price DECIMAL(10, 2) NOT NULL" +
                ")";
        statement.executeUpdate(sql);
    }

    private static void createShoppingTaskTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS shopping_task (" +
                "id INT PRIMARY KEY," +
                "store VARCHAR(255) NOT NULL," +
                "FOREIGN KEY (id) REFERENCES task(id)" +
                ")";
        statement.executeUpdate(sql);
    }
}
