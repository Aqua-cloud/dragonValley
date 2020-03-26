package com.yjc.www.po;

public class Master extends User {
    public Master(int id, String username, String account, String phone, String password) {
        super(id, username, account, phone, password);
    }

    public Master(){
        super();
    }

    @Override
    public String toString() {
        return "master{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
