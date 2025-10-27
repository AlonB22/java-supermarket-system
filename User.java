public abstract class User {
    protected String userName;
    protected String password;

    public User(String userName, String password) {
        setUserName(userName);
        setPassword(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return userName;
    }
}
