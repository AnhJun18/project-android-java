package com.example.caculator;

public class User {
    private String login, avatar_url;

    public User() {
    }

    public User(String login, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}
