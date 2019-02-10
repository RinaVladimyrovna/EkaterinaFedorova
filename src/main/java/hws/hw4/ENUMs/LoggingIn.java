package hws.hw4.ENUMs;

public enum LoggingIn {
    USER("epam", "1234", "PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String name;

    LoggingIn(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
