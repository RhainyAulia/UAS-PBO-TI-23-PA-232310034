package com.pbo.project.Page;

//import java.awt.EventQueue;			

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pbo.project.PrefensiFilm;
import com.pbo.project.User;
import com.pbo.project.connection.PreferensiDao;
import com.pbo.project.connection.UserDao;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
	
public class Login extends JFrame {
	public String state1;
	public int id_curr_user;
	private static final long serialVersionUID = 1L;
	private JPanel CP;
	private JTextField Username;
	private JPasswordField passwordField;
	protected Component frame;

	public static void main(String[] args) {
		new Login();
	}

	public Login() {
		setVisible(true);
		setTitle("Autentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 310);
		CP = new JPanel();
		CP.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(CP);
		CP.setLayout(new BorderLayout(0, 0));
		
		JPanel MainPanel = new JPanel();
		CP.add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(null);
		
		Username = new JTextField();
		Username.setBounds(92, 77, 211, 19);
		MainPanel.add(Username);
		Username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 79, 72, 13);
		MainPanel.add(lblNewLabel);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass.setBounds(10, 112, 72, 13);
		MainPanel.add(lblPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 110, 211, 19);
		MainPanel.add(passwordField);
		
		JLabel lblAutentfication = new JLabel("Autentification");
		lblAutentfication.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutentfication.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAutentfication.setBounds(95, 10, 208, 33);
		MainPanel.add(lblAutentfication);
		
		JButton btnPass = new JButton("Register");
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register regis = new Register();
				regis.setVisible(true);
				dispose();
			}
		});
		btnPass.setBounds(92, 161, 100, 21);
		MainPanel.add(btnPass);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Password = new String(passwordField.getPassword());
					if (Username.getText().isEmpty() || Password.isEmpty()) {
			            JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
		            }else {
		                boolean userFound = false;
		                boolean adminFound = false;
		                try {
		                    UserDao UserDb = new UserDao();
		                    List<User> usr = UserDb.findByUser();
		                    List<User> idUsr = new ArrayList<>();
		                    List<User> state = new ArrayList<>();
		                    for (int i = 0; i < usr.size(); i++) {
		                    	String usernamechck = new String(usr.get(i).getUsername());
		                    	String passchck = new String(usr.get(i).getPassword());
		                        if (Username.getText().equals(usernamechck) && Password.equals(passchck)){
		                        	idUsr = UserDb.selectId(Username.getText(), Password);
		                        	state = UserDb.selectId(Username.getText(), Password);
		                        }
		                    }
		                    for(int i = 0; i < idUsr.size(); i++) {
		                    	id_curr_user = idUsr.get(i).getId_user();
		                    }
		                    for(int j = 0; j < state.size(); j++) {
                        		state1 = state.get(j).getStatus();
                        	}
                        	if("user".equals(state1)) {
                        		userFound = true;
                        	}else if("admin".equals(state1)) {
                        		adminFound = true;
                        	}
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(frame, "Error during Login: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		                }
		                if (userFound) {
		                    PreferensiDao preferen = new PreferensiDao();
		    		        boolean preUser = false;
		    		        try {
		    		        	List<PrefensiFilm> preFilm = preferen.Added_Pre_User();
		    		        	for(int i = 0; i < preFilm.size(); i++) {
		    		        		if(id_curr_user == preFilm.get(i).getId_user()) {
		    		        			preUser = true;
		    		        		}
		    		        	}
		    		        	if(preUser == true) { 
		    		        		RecommendationPage RecPage = new RecommendationPage(id_curr_user);
				    		        RecPage.setVisible(true);
				    		        dispose();
		    		        	}else {
		    		        		SurveiPage survei =  new SurveiPage(id_curr_user);
		 		                    survei.setVisible(true);
		 		                    dispose();
		    		        	}
		    		        } catch (Exception e1) {
		    		            e1.printStackTrace();
		    		        }
		    		        
		    		       
		                }else if(adminFound) {
		                	admin_crud admin = new admin_crud();
                        	admin.setVisible(true);
                        	dispose();
		                }else {
		                    JOptionPane.showMessageDialog(frame, "Username atau Password yang Anda masukkan salah.", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            }
				}
		});
		btnLogin.setBounds(202, 161, 101, 21);
		MainPanel.add(btnLogin);
		
		JLabel lblForgetAcc = new JLabel("Forget Account?");
		lblForgetAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                UserDao UserDb = new UserDao();
				String email = JOptionPane.showInputDialog("Masukan Email Akun: ");
				String username = null, pass = null;
				try {
					List<User> usrEmail = UserDb.findUserbyEmail(email);
					if(usrEmail == null) {
						JOptionPane.showMessageDialog(frame, "Data User Tidak Ada", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						for(User usr : usrEmail) {
							username = usr.getUsername();
							pass = usr.getPassword();
						}
						JOptionPane.showMessageDialog(frame, "Username : " + username + "\nPassword : " + pass, "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblForgetAcc.setForeground(new Color(0, 0, 255));
		lblForgetAcc.setBounds(92, 138, 211, 13);
		MainPanel.add(lblForgetAcc);
	}
}
