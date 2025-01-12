package com.pbo.project.Page;		

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pbo.project.User;
import com.pbo.project.connection.UserDao;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Component frame = null;
	private JPanel CP1;
	private JComboBox Status;
	private JTextField FN1;
	private JTextField Email;
	private JTextField Password;

//	public static void main(String[] args) {
//		new Register();
//	}
	
	public Register() {
		setVisible(true);
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 319);
		CP1 = new JPanel();
		CP1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(CP1);
		CP1.setLayout(new BorderLayout(0, 0));
		
		JPanel RegPnl = new JPanel();
		CP1.add(RegPnl, BorderLayout.CENTER);
		RegPnl.setLayout(null);
		
		JLabel lblUrname = new JLabel("Username");
		lblUrname.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblUrname.setBounds(10, 93, 57, 13);
		RegPnl.add(lblUrname);
		
		FN1 = new JTextField();
		FN1.setBounds(75, 90, 259, 19);
		RegPnl.add(FN1);
		FN1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEmail.setBounds(10, 119, 45, 13);
		RegPnl.add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(75, 116, 259, 19);
		RegPnl.add(Email);
		Email.setColumns(10);
		
		JLabel lblPass = new JLabel("Status");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblPass.setBounds(10, 145, 57, 13);
		RegPnl.add(lblPass);

		String[] State = {"admin", "user"};
		Status = new JComboBox(State);
		Status.setBounds(75, 145, 259, 19);
		RegPnl.add(Status);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(75, 171, 259, 19);
		RegPnl.add(Password);
		
		JLabel lblPass_1 = new JLabel("Password");
		lblPass_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblPass_1.setBounds(10, 174, 57, 13);
		RegPnl.add(lblPass_1);
		
		JLabel lblTitle = new JLabel("Register");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(115, 24, 149, 46);
		RegPnl.add(lblTitle);
		
		JButton btnRegis = new JButton("Registration");
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FN1.getText().isEmpty() || Email.getText().isEmpty() || Password.getText().isEmpty()) {
		              JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
		          } else {
		        	  try {
		            	  User usr = new User();
		            	  UserDao user = new UserDao();
		            	  usr.setUsername(FN1.getText());
		            	  usr.setEmail(Email.getText());
		            	  usr.setStatus(Status.getSelectedItem().toString());
		            	  usr.setPassword(Password.getText());
		            	  user.insertUser(usr);
		        	  }catch(Exception ex) {
		        		  ex.printStackTrace();
		        		  JOptionPane.showMessageDialog(null, "Error during registration : " + ex.getMessage());
		        	  }
		        	  Login log = new Login();
		        	  log.setVisible(true);
		        	  dispose();
		          }
			}
		});
		btnRegis.setBounds(238, 203, 96, 21);
		RegPnl.add(btnRegis);
	}
}
