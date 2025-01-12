package com.pbo.project.Page;

import java.awt.Component;	
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.pbo.project.Feedback;
import com.pbo.project.connection.FeedbackDao;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeedbackPage extends JFrame {
	JTextArea FeedBack;
	private static final long serialVersionUID = 1L;
	protected static final Component frame = null;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedbackPage frame = new FeedbackPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FeedbackPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFeedbackPage = DefaultComponentFactory.getInstance().createLabel("Feedback Page");
		lblFeedbackPage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFeedbackPage.setBounds(10, 10, 192, 26);
		contentPane.add(lblFeedbackPage);
		
		JLabel lblNewLabel = new JLabel("Feedback :");
		lblNewLabel.setBounds(10, 61, 97, 13);
		contentPane.add(lblNewLabel);
		
		FeedBack = new JTextArea();
		FeedBack.setLineWrap(true);
		FeedBack.setBounds(81, 55, 273, 105);
		contentPane.add(FeedBack);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FeedBack.getText().isEmpty()) {
		              JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
		          } else {
		        	  try {
		        		  Login log = new Login();
		        		  RecommendationPage Rec = new RecommendationPage();
		            	  Feedback fdback = new Feedback();
		            	  FeedbackDao fdDao = new FeedbackDao();
		            	  fdback.setFeedback(FeedBack.getText());
		            	  fdDao.insertFeedback(log.id_curr_user, Rec.id_film_select, fdback);
		        	  }catch(Exception ex) {
		        		  ex.printStackTrace();
		        		  JOptionPane.showMessageDialog(null, "Error during registration : " + ex.getMessage());
		        	  }
		          }
			}
		});
		btnSubmit.setBounds(269, 178, 85, 21);
		contentPane.add(btnSubmit);
	}
}
