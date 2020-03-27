package com.yjc.www.view.panel;


import com.yjc.www.service.IMasterService;
import com.yjc.www.service.IPrincipalService;
import com.yjc.www.service.IVisitorService;

import javax.swing.*;

public class LoginJPanel extends JPanel {

    private JLabel lab_account = new JLabel("用户名");

    private JTextField jta_text;

    private JLabel lab_password = new JLabel("密码");

    private JPasswordField jtb_text;

    private JLabel lab_user = new JLabel("用户权限");

    private JComboBox jcb_user = new JComboBox();

    private JButton btn_login = new JButton("登录");


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
        add(lab_account);
        add(lab_password);
        add(jta_text);
        add(jtb_text);
        add(btn_login);
        add(lab_user);
        jcb_user.addItem("-请选择-");
        jcb_user.addItem("驯龙高手");
        jcb_user.addItem("外邦人");
        jcb_user.addItem("龙妈");
        add(jcb_user);
        setLayout(null);
    }

    private void init() {

        lab_account.setSize(200, 100);
        lab_account.setLocation(250, 130);

        jta_text = new JTextField();
        jta_text.setSize(190, 30);
        jta_text.setLocation(350, 165);

        lab_password.setSize(200, 100);
        lab_password.setLocation(255, 190);

        jtb_text = new JPasswordField();
        jtb_text.setSize(190, 30);
        jtb_text.setLocation(350, 225);

        btn_login.setSize(120, 40);
        btn_login.setLocation(380, 340);

        lab_user.setSize(200, 100);
        lab_user.setLocation(250, 250);

        jcb_user.setSize(75,30);
        jcb_user.setLocation(350,285);

    }

}
