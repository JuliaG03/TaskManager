package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcSettings {
    private final static String jdbcURL = "jdbc:mysql://localhost:3306/TaskManager";
    private static Connection connection = null;
    private static JdbcSettings jdbcSettings;

    static {
        registerDriver();
        createConnection();
    }

    public static JdbcSettings getJdbcSettings() {
        if (jdbcSettings == null) {
            jdbcSettings = new JdbcSettings();
        }
        return jdbcSettings;
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("driver registration failed\n");
            e.printStackTrace();
        }
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(jdbcURL, "root", "0909");
            DatabaseInitialiser.initialize(connection);
        } catch (Exception e) {
            System.out.println("ERROR :: Setup createConnection :: could not create connection\n");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
