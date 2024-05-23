package utility;

import DataBase.JdbcSettings;
import model.User;
import services.AuditService;
import services.UserandAuthenticationService;
import services.MainService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;



public class Main {


    public Main() {}

    public static void main(String[] args) throws ParseException, SQLException {
        List<User> listOfUsers = new ArrayList<>();
        User loggedinuser = null;
        Data data = new Data(listOfUsers, loggedinuser);
        UserandAuthenticationService authenticationService = new UserandAuthenticationService(data);
        MainService mainService = new MainService(data);
        JdbcSettings J = JdbcSettings.getJdbcSettings();
        AuditService.getInstance().logAction("openingProject");

        mainService.startapp();

        mainService.app();  // + methods for admin


    }
}

