package com.yjc.www.view.panel;


import javax.swing.*;
import java.awt.*;

public class LoginJPanel extends JPanel {

    private JLabel lab_welcome = new JLabel("欢迎来到龙之谷！");

    private JLabel lab_account = new JLabel("账号");

    private JTextField jta_text = new JTextField();

    private JLabel lab_password = new JLabel("密码");

    private JPasswordField jtb_text = new JPasswordField();

    private JLabel lab_user = new JLabel("用户权限");

    private JComboBox jcb_user = new JComboBox();

    private JButton btn_login = new JButton("登录");

    private JLabel lab_register = new JLabel("没有账号？");

    private JButton btn_register = new JButton("注册账号");


    public JLabel getLab_welcome() {
        return lab_welcome;
    }

    public void setLab_welcome(JLabel lab_welcome) {
        this.lab_welcome = lab_welcome;
    }

    public JLabel getLab_register() {
        return lab_register;
    }

    public void setLab_register(JLabel lab_register) {
        this.lab_register = lab_register;
    }

    public JButton getBtn_register() {
        return btn_register;
    }

    public void setBtn_register(JButton btn_register) {
        this.btn_register = btn_register;
    }

    public JLabel getLab_user() {
        return lab_user;
    }

    public void setLab_user(JLabel lab_user) {
        this.lab_user = lab_user;
    }

    public JLabel getLab_account() {
        return lab_account;
    }

    public void setLab_account(JLabel lab_account) {
        this.lab_account = lab_account;
    }

    public JTextField getJta_text() {
        return jta_text;
    }

    public void setJta_text(JTextField jta_text) {
        this.jta_text = jta_text;
    }

    public JLabel getLab_password() {
        return lab_password;
    }

    public void setLab_password(JLabel lab_password) {
        this.lab_password = lab_password;
    }

    public JPasswordField getJtb_text() {
        return jtb_text;
    }

    public void setJtb_text(JPasswordField jtb_text) {
        this.jtb_text = jtb_text;
    }

    public JButton getBtn_login() {
        return btn_login;
    }

    public void setBtn_login(JButton btn_login) {
        this.btn_login = btn_login;
    }

    public JComboBox getJcb_user() {
        return jcb_user;
    }

    public void setJcb_user(JComboBox jcb_user) {
        this.jcb_user = jcb_user;
    }

    public LoginJPanel() {

        super();
        init();
        add(lab_welcome);
        add(lab_account);
        add(lab_password);
        add(jta_text);
        add(jtb_text);
        add(btn_login);
        add(lab_user);
        add(jcb_user);
        add(lab_register);
        add(btn_register);
        setLayout(null);
    }

    private void init() {

        lab_welcome.setSize(200,50);
        lab_welcome.setLocation(365,50);
        lab_welcome.setFont(new Font("微软雅黑",Font.BOLD,16));

        lab_account.setSize(200, 100);
        lab_account.setLocation(255, 130);

        jta_text.setSize(190, 30);
        jta_text.setLocation(350, 165);

        lab_password.setSize(200, 100);
        lab_password.setLocation(255, 190);

        jtb_text.setSize(190, 30);
        jtb_text.setLocation(350, 225);

        btn_login.setSize(120, 40);
        btn_login.setLocation(380, 340);

        lab_user.setSize(200, 100);
        lab_user.setLocation(250, 250);

        jcb_user.setSize(75, 30);
        jcb_user.setLocation(350, 285);
        jcb_user.addItem("-请选择-");
        jcb_user.addItem("驯龙高手");
        jcb_user.addItem("外邦人");
        jcb_user.addItem("龙妈");

        lab_register.setSize(100, 100);
        lab_register.setLocation(600, 340);

        btn_register.setSize(100,30);
        btn_register.setLocation(700,380);
    }

}
