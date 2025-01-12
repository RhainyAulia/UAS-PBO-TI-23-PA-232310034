package com.pbo.project.Page;

import java.awt.Component;
import java.awt.EventQueue;		

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pbo.project.PrefensiFilm;
import com.pbo.project.connection.PreferensiDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class SurveiPage extends JFrame {
	public int getId;
	private static final long serialVersionUID = 1L;
	protected static final Component frame = null;
	private JPanel contentPane;
	private JTextField ActorField;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SurveiPage frame = new SurveiPage(getId);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public SurveiPage(int id_curr_user) {
		setVisible(true);
		setTitle("Survei Recomendation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGenre = new JLabel("Genre Film Favorite :");
		lblGenre.setBounds(10, 10, 374, 13);
		contentPane.add(lblGenre);
		
		JLabel lblActor = new JLabel("Actor/Actress Favorite : ");
		lblActor.setBounds(10, 119, 152, 13);
		contentPane.add(lblActor);
		
		JCheckBox chckHorror = new JCheckBox("Horror");
		chckHorror.setBounds(6, 29, 93, 21);
		contentPane.add(chckHorror);
		
		JCheckBox chckAction = new JCheckBox("Action");
		chckAction.setBounds(101, 29, 93, 21);
		contentPane.add(chckAction);
		
		JCheckBox chckThriller = new JCheckBox("Thriller");
		chckThriller.setBounds(196, 29, 93, 21);
		contentPane.add(chckThriller);
		
		JCheckBox chckComedy = new JCheckBox("Comedy");
		chckComedy.setBounds(6, 52, 93, 21);
		contentPane.add(chckComedy);
		
		JCheckBox chckMusical = new JCheckBox("Musical");
		chckMusical.setBounds(101, 52, 93, 21);
		contentPane.add(chckMusical);
		
		JCheckBox chckRomance = new JCheckBox("Romance");
		chckRomance.setBounds(196, 52, 93, 21);
		contentPane.add(chckRomance);
		
		JCheckBox chckScifi = new JCheckBox("Sci-fi");
		chckScifi.setBounds(6, 75, 93, 21);
		contentPane.add(chckScifi);
		
		JCheckBox chckDrama = new JCheckBox("Drama");
		chckDrama.setBounds(101, 75, 93, 21);
		contentPane.add(chckDrama);
		
		JCheckBox chckFantasy = new JCheckBox("Fantasy");
		chckFantasy.setBounds(196, 75, 93, 21);
		contentPane.add(chckFantasy);

		JCheckBox chckbxSuperhero = new JCheckBox("Superhero");
		chckbxSuperhero.setBounds(291, 75, 93, 21);
		contentPane.add(chckbxSuperhero);

		ActorField = new JTextField();
		ActorField.setBounds(10, 142, 255, 19);
		contentPane.add(ActorField);
		ActorField.setColumns(10);
	

        JLabel resultLabel = new JLabel("");
        contentPane.add(resultLabel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ArrayList<String> row1 = new ArrayList<>();

		        // Collect selected genres
		        if (chckHorror.isSelected()) row1.add(chckHorror.getText());
		        if (chckAction.isSelected()) row1.add(chckAction.getText());
		        if (chckFantasy.isSelected()) row1.add(chckFantasy.getText());
		        if (chckDrama.isSelected()) row1.add(chckDrama.getText());
		        if (chckScifi.isSelected()) row1.add(chckScifi.getText());
		        if (chckRomance.isSelected()) row1.add(chckRomance.getText());
		        if (chckMusical.isSelected()) row1.add(chckMusical.getText());
		        if (chckThriller.isSelected()) row1.add(chckThriller.getText());
		        if (chckComedy.isSelected()) row1.add(chckComedy.getText());
		        if (chckbxSuperhero.isSelected()) row1.add(chckbxSuperhero.getText());

		        // Process ActorField input
		        String actorInput = ActorField.getText().trim();
		        System.out.println("ActorField input: " + actorInput);

		        if (actorInput.isEmpty()) {
		            System.out.println("ActorField is empty. Assigning default values.");
		            actorInput = ", "; // Provide default input to avoid split errors
		        }

		        String[] actorFav = actorInput.split(",");
		        ArrayList<String> actorFav1 = new ArrayList<>();

		        // Safely add actors to the list
		        for (String actor : actorFav) {
		            String trimmedActor = actor.trim();
		            if (!trimmedActor.isEmpty()) { // Avoid empty entries
		                actorFav1.add(trimmedActor);
		            }
		        }

		        System.out.println("Actor array size: " + actorFav1.size());
		        System.out.println("Actor list: " + actorFav1);

		        if (actorFav1.isEmpty()) {
		            System.out.println("No valid actors entered!");
		            return;
		        }
		        PreferensiDao preferen = new PreferensiDao();
		        try {
		        	preferen.insertPreferen(row1, actorFav1, id_curr_user);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
		        
		        RecommendationPage RecPage = new RecommendationPage(id_curr_user);
		        RecPage.setVisible(true);
		        dispose();
		    }
		});
		btnSubmit.setBounds(370, 286, 103, 21);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("(Maks: 2, Pisahkan Dengan ',')");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 8));
		lblNewLabel.setBounds(143, 120, 93, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(Maks: 2)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 8));
		lblNewLabel_1.setBounds(143, 10, 93, 13);
		contentPane.add(lblNewLabel_1);
	}
}

