package com.epam.introduction.tasks.task_1.model.user;

public class User {
    private boolean isAdmin;
    private String login;
    private String password;
    private String email;

    public User(String login, String password, boolean isAdmin, String email) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.email = email;
    }

    public User(String login, String password) {
        this(login, password, false, "miss");
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailNotSpecified() {
        return email.equals("miss");
    }

    public void grantAdministratorRights() {
        isAdmin = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return login;
    }

}