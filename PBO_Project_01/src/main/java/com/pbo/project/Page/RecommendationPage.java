package com.pbo.project.Page;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.pbo.project.Film;
import com.pbo.project.PrefensiFilm;
import com.pbo.project.connection.FilmsDao;
import com.pbo.project.connection.PreferensiDao;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RecommendationPage extends JFrame {
	public String id_film_select, genre1, genre2, actorFav;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

//	public static void main(String[] args) {
//		 new RecommendationPage(2);
//	}

	public RecommendationPage(int id_curr_user) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		DefaultTableModel TModel = new DefaultTableModel();
		TModel.addColumn("Id Film");
        TModel.addColumn("Nama Film");
        TModel.addColumn("Genre");
        TModel.addColumn("Actor");
        TModel.addColumn("Director");
        TModel.addColumn("Link_Film");

        FilmsDao films = new FilmsDao();
        PreferensiDao referensi = new PreferensiDao();
        try {
			List<PrefensiFilm> referens = referensi.showRecFilm(id_curr_user);
			for(int i = 0; i < referens.size(); i++) {
				if(i == 0) {
					genre1 = referens.get(i).getPre_genre();
				}else if(i == 1) {
					genre2 =referens.get(i).getPre_genre();
				}
				actorFav = referens.get(i).getPre_actor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
            List<Film> film = films.showRecFilm(genre1, genre2, actorFav);
            for (Film film1 : film) {
                TModel.addRow(new Object[] {
	            		film1.getId_film(),
	                    film1.getName_Film(),
	                    film1.getGenre(),
	                    film1.getActor(),
	                    film1.getDirector(),
	                    film1.getLink()
	            	});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		JTable tableFilm = new JTable(TModel);
		tableFilm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tableFilm.getSelectedRow();
                if (selectedRow >= 0) {
                	String id = (String) TModel.getValueAt(selectedRow, 0);
                	id_film_select = id;
                	System.out.println(id_film_select);
//                	FeedbackPage feedback = new FeedbackPage();
//                	feedback.setVisible(true);
//                	dispose();
                }
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(tableFilm);
		contentPane.add(scrollPane);
	}

}
