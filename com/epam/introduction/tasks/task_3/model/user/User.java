package com.epam.introduction.tasks.task_3.model.user;

import com.epam.introduction.tasks.task_3.util.encryption.Encoder;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.io.*;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final Encoder ENCODER = Encoder.instance();

    private boolean isAdmin;
    private String login;
    private String password;
    private String encryptedPassword;

    public User(String login, String password, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        try {
            encryptedPassword = ENCODER.encrypt(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User(String login, String password) {
        this(login, password, false);
    }

    private User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    @XmlElement(name = "encrypted-password")
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
        try {
            password = ENCODER.decrypt(encryptedPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPassword() {
        return password;
    }

    @XmlTransient
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @XmlElement(name = "admin-status")
    public void setAdmin(boolean admin) {
        isAdmin = admin;
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
        if (!password.equals(user.password)) return false;
        return encryptedPassword.equals(user.encryptedPassword);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + encryptedPassword.hashCode();
        return result;
    }
}