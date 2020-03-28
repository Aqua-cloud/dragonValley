package com.yjc.www.view;

import com.yjc.www.po.Visitor;
import com.yjc.www.service.IVisitorService;
import com.yjc.www.service.impl.VisitorServiceImpl;
import com.yjc.www.test.VisitorTest;
import com.yjc.www.view.panel.LoginJPanel;
import com.yjc.www.view.panel.RegisterJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterJFrame extends IndexJFrame {


    public RegisterJFrame(String title) throws HeadlessException {
        super(title);


        //提交注册事件监听
        IndexJFrame.registerJPanel.getBtn_login().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = registerJPanel.getJta_text().getText();
                String password = registerJPanel.getJtb_text().getText();
                String phone = registerJPanel.getJtc_text().getText();

                Visitor visitor = new Visitor();
                visitor.setUsername(userName);
                visitor.setPassword(password);
                visitor.setPhone(phone);

                IVisitorService service = new VisitorServiceImpl();
                String account = service.register(visitor);
                if (account != null) {
                    JOptionPane.showMessageDialog(null, "注册成功！你的账号为" +account, null, JOptionPane.PLAIN_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(null, "用户名已存在！", null, JOptionPane.ERROR_MESSAGE, null);
                }
            }
        });

        //返回事件监听
        IndexJFrame.registerJPanel.getBtn_return().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndexJFrame indexJFrame = new IndexJFrame("龙之谷 登录");

                RegisterJFrame.super.setVisible(false);
                indexJFrame.setVisible(true);
            }
        });
    }
}
