package com.yjc.www.view;


import com.yjc.www.dto.Msg;
import com.yjc.www.service.impl.MasterServiceImpl;
import com.yjc.www.service.impl.PrincipalServiceImpl;
import com.yjc.www.service.impl.VisitorServiceImpl;

import com.yjc.www.view.panel.LoginJPanel;
import com.yjc.www.view.panel.RegisterJPanel;
import com.yjc.www.view.panel.VisitorJPanel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexJFrame extends JFrame {


    private LoginJPanel loginJPanel = new LoginJPanel();
    static RegisterJPanel registerJPanel = new RegisterJPanel();



    public static void main(String[] args) {
        new IndexJFrame("龙之谷 登录").setVisible(true);

    }

    public IndexJFrame(String title) throws HeadlessException {
        super(title);
        //设置JFrame
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        //展示loginJPanel
        getContentPane().add(loginJPanel);


        //登录事件监听
        loginJPanel.getBtn_login().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //获取用户填入信息
                String account = loginJPanel.getJta_text().getText();
                String password = loginJPanel.getJtb_text().getText();
                String user = (String) loginJPanel.getJcb_user().getSelectedItem();


                Msg msg = null;

                //用户权限判断
                switch (user) {
                    case "-请选择-": {
                        JOptionPane.showMessageDialog(null, "请选择用户权限", null, JOptionPane.ERROR_MESSAGE, null);
                        loginJPanel.getJta_text().setText("");
                        loginJPanel.getJtb_text().setText("");
                        break;
                    }
                    case "外邦人": {
                        msg = new VisitorServiceImpl().login(password,account);
                        break;
                    }
                    case "龙妈": {
                        msg = new PrincipalServiceImpl().login(account, password);
                        break;
                    }

                    case "驯龙高手": {
                        msg = new MasterServiceImpl().login(account, password);
                        break;
                    }
                }

                if ("登录成功".equals(msg.getResult())) {
                    //跳转至VisitorJFrame
                    VisitorJFrame visitorJFrame = new VisitorJFrame("首页");
                    visitorJFrame.getContentPane().add(new VisitorJPanel(msg));

                    IndexJFrame.super.setVisible(false);
                    visitorJFrame.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, msg.getResult(), null, JOptionPane.ERROR_MESSAGE, null);
                    loginJPanel.getJta_text().setText("");
                    loginJPanel.getJtb_text().setText("");
                    loginJPanel.getJcb_user().setSelectedItem("-请选择-");
                }
            }

        }
        );

        //注册事件监听
        loginJPanel.getBtn_register().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterJFrame registerJFrame = new RegisterJFrame("龙之谷 注册");
                registerJFrame.getContentPane().add(registerJPanel);

                IndexJFrame.super.setVisible(false);
                registerJFrame.setVisible(true);
            }
        });


    }
}
