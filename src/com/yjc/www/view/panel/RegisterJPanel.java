package com.yjc.www.view.panel;


import javax.swing.*;
import java.awt.*;

public class RegisterJPanel extends JPanel {

    private JLabel lab_welcome = new JLabel("注册新账号");

    private JLabel lab_account = new JLabel("用户名");

    private JTextField jta_text = new JTextField();

    private JLabel lab_password = new JLabel("密码");

    private JTextField jtb_text = new JTextField();

    private JLabel lab_phone = new JLabel("手机号");

    private JTextField jtc_text = new JTextField();

    private JButton btn_login = new JButton("注册");

    private JButton btn_return = new JButton("返回");


    public void setLab_password(JLabel lab_password) {
        this.lab_password = lab_password;
    }

    public JTextField getJtb_text() {
        return jtb_text;
    }

    public JButton getBtn_return() {
        return btn_return;
    }

    public void setBtn_return(JButton btn_return) {
        this.btn_return = btn_return;
    }

    public JLabel getLab_welcome() {
        return lab_welcome;
    }

    public void setLab_welcome(JLabel lab_welcome) {
        this.lab_welcome = lab_welcome;
    }

    public void setJtb_text(JTextField jtb_text) {
        this.jtb_text = jtb_text;
    }

    public JLabel getLab_phone() {
        return lab_phone;
    }

    public void setLab_phone(JLabel lab_phone) {
        this.lab_phone = lab_phone;
    }

    public JTextField getJtc_text() {
        return jtc_text;
    }

    public void setJtc_text(JTextField jtc_text) {
        this.jtc_text = jtc_text;
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

    public void setBtn_login(JButton btn_login) {
        this.btn_login = btn_login;
    }

    public JButton getBtn_login() {
        return btn_login;
    }

    public RegisterJPanel() {

        super();
        init();
        add(lab_welcome);
        add(lab_account);
        add(lab_password);
        add(lab_phone);
        add(jta_text);
        add(jtb_text);
        add(jtc_text);
        add(btn_login);
        add(btn_return);
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

        lab_phone.setSize(200, 100);
        lab_phone.setLocation(255, 250);

        jtc_text.setSize(190, 30);
        jtc_text.setLocation(350, 285);

        btn_login.setSize(120, 40);
        btn_login.setLocation(380, 350);

        btn_return.setSize(100,30);
        btn_return.setLocation(700,380);

    }

}
