package com.yjc.www.po;

public class User {
     int id ;
     String username;
     String account;
     String phone;
     String password;

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String username, String account, String phone, String password) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.phone = phone;
        this.password = password;
    }

    public User(){

    }
}
