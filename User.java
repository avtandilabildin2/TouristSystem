package tour_system_v_0_2;

public abstract class   User {
    protected String login;
    protected String password;
    protected UserType userType;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", userType=" + userType +
                '}';
    }
}
