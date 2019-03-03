package hws.hw7.entities;

public class Users {

    public static Users PITER = new Users("epam", "1234", "PITER CHAILOVSKII");

    String login;
    String password;
    String fullName;

    Users(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

}
