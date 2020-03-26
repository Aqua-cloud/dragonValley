package com.yjc.www.po;

public class Visitor extends User {

    public Visitor(int id, String username, String account, String phone, String password) {
        super(id, username, account, phone, password);
    }

    public Visitor(){
        super();
    }

    @Override
    public String toString() {
        return "visitor{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
