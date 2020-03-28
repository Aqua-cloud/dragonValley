package com.yjc.www.view.panel;

import com.yjc.www.dto.Msg;

import javax.swing.*;

public class VisitorJPanel extends JPanel{

	private JLabel lab_account = new JLabel();

	public JLabel getLab_account() {
		return lab_account;
	}

	public void setLab_account(JLabel lab_account) {
		this.lab_account = lab_account;
	}
	
	
	public VisitorJPanel(Msg msg) {
			
			super();
			// TODO Auto-generated constructor stub
			init(msg.getResult());
			add(lab_account);
			setLayout(null);
		}
	
	private void init(String text){
			
			lab_account.setSize(200,100);  
			lab_account. setLocation(400,130);
	        lab_account.setText(text);
		}
}
