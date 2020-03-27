package com.yjc.www.view;

import com.yjc.www.dto.Msg;
import com.yjc.www.service.IVisitorService;
import com.yjc.www.service.impl.MasterServiceImpl;
import com.yjc.www.service.impl.PrincipalServiceImpl;
import com.yjc.www.service.impl.VisitorServiceImpl;
import com.yjc.www.view.panel.IndexJPanel;
import com.yjc.www.view.panel.LoginJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexJFrame extends JFrame {


    private LoginJPanel loginJPanel = new LoginJPanel();


    public static void main(String[] args) {

        new IndexJFrame("龙之谷 登录").setVisible(true);

    }

    public IndexJFrame(String title) throws HeadlessException {
        super(title);
        //
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        loginJPanel.getBtn_login().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = loginJPanel.getJta_text().getText();
                String password = loginJPanel.getJtb_text().getText();
                String user = (String) loginJPanel.getJcb_user().getSelectedItem();


                Msg msg = null;
                System.out.println(msg);

                switch (user) {
                    case "-请选择-": {
                        System.out.println("adsfg");
                        JOptionPane.showMessageDialog(null, "请选择用户权限", null, JOptionPane.ERROR_MESSAGE, null);
                        loginJPanel.getJta_text().setText("");
                        loginJPanel.getJtb_text().setText("");
                        break;
                    }
                    case "外邦人": {
                        msg = new VisitorServiceImpl().login(userName, password);
                        break;
                    }
                    case "龙妈": {
                        msg = new PrincipalServiceImpl().login(userName, password);
                        break;
                    }

                    case "驯龙高手": {
                        msg = new MasterServiceImpl().login(userName, password);
                        break;
                      }
                }

                System.out.println(msg);
                System.out.println(user);
                if ("登录成功".equals(msg.getResult())) {

                    System.out.println(msg);
                    remove(loginJPanel);
                    getContentPane().add(new IndexJPanel(msg.getResult()));
                    getContentPane().validate();

                } else {

                    JOptionPane.showMessageDialog(null, msg.getResult(), null, JOptionPane.ERROR_MESSAGE, null);
                    loginJPanel.getJta_text().setText("");
                    loginJPanel.getJtb_text().setText("");
                    loginJPanel.getJcb_user().setSelectedItem("-请选择-");
                }
            }
        });

        getContentPane().add(loginJPanel);
    }

}
