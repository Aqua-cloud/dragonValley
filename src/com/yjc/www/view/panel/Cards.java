package com.yjc.www.view.panel;

import javax.swing.*;
import java.awt.*;

public class Cards extends JPanel {

    private  LoginJPanel loginJPanel;

    private  RegisterJPanel registerJPanel;

    public LoginJPanel getLoginJPanel() {
        return loginJPanel;
    }

    public void setLoginJPanel(LoginJPanel loginJPanel) {
        this.loginJPanel = loginJPanel;
    }

    public RegisterJPanel getRegisterJPanel() {
        return registerJPanel;
    }

    public void setRegisterJPanel(RegisterJPanel registerJPanel) {
        this.registerJPanel = registerJPanel;
    }

    public Cards(){
        super(new CardLayout());
        add(this.loginJPanel,"loginJPanel");
        add(this.registerJPanel,"registerJPanel");
    }
}
