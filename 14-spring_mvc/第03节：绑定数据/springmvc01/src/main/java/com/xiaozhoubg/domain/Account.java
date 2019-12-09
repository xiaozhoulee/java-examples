package com.xiaozhoubg.domain;


import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
    private String username;
    private String password;
    private Double money;
    private User user;
    private List<User2> list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User2> getList() {
        return list;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public void setList(List<User2> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                ", list=" + list +
                '}';
    }
}
