package com.yjc.www.po;

public class Principal extends User {
    public Principal(int id, String username, String account, String phone, String password) {
        super(id, username, account, phone, password);
    }

    public Principal(){
        super();
    }

    @Override
    public String toString() {
        return "principal{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

