package utility;

import DataBase.JdbcSettings;
import model.User;
import services.AuditService;
import services.AuthenticationService;
import services.MainService;

import java.text.ParseException;
import java.util.*;



public class Main {


    public Main() {}

    public static void main(String[] args) throws ParseException {
        List<User> listOfUsers = new ArrayList<>();
        User loggedinuser = null;
        Data data = new Data(listOfUsers, loggedinuser);
        AuthenticationService authenticationService = new AuthenticationService(data);
        MainService mainService = new MainService(data);
        JdbcSettings J = JdbcSettings.getJdbcSettings();
        AuditService.getInstance().logAction("openingProject");

        mainService.startapp();

        mainService.authentication();  // + methods for admin


    }
}

