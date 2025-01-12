package com.pbo.project.Page;

import javax.swing.JFrame;		
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.pbo.project.Film;
import com.pbo.project.connection.ConnectionDb;
import com.pbo.project.connection.FilmsDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class admin_crud extends JFrame {

	private DefaultTableModel TModel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Nama_Film;
	private JTextField Genre;
	private JTextField Actor;
	private JTextField Director;
	private JTextField Link_Film;
	private JTextField ActorS;
	private JTextField NamafilmS;
	private JTextField DirectorS;
	private JTable table;
	JComboBox<String> Id_film, GenreS;
	protected Component frame;
	
//	public static void main(String[] args) {
//		new admin_crud();
//	}

	public admin_crud() {
		setVisible(true);
		setTitle("ADMIN CONTROL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 715, 240);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton CheckCon = new JButton("Check Connection");
		CheckCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connect = new ConnectionDb().Connectdb();
					JOptionPane.showMessageDialog(null, "Berhasil Terkoneksi");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		CheckCon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CheckCon.setBounds(271, 12, 142, 26);
		panel_1.add(CheckCon);
		
		JLabel lblFilmControl = new JLabel("Film Control");
		lblFilmControl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFilmControl.setBounds(10, 47, 71, 13);
		panel_1.add(lblFilmControl);
		
		JLabel lblNamaFilm = new JLabel("Nama Film");
		lblNamaFilm.setBounds(22, 67, 71, 13);
		panel_1.add(lblNamaFilm);
		
		Nama_Film = new JTextField();
		Nama_Film.setBounds(96, 64, 222, 19);
		panel_1.add(Nama_Film);
		Nama_Film.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(22, 92, 71, 13);
		panel_1.add(lblGenre);
		
		Genre = new JTextField();
		Genre.setColumns(10);
		Genre.setBounds(96, 89, 222, 19);
		panel_1.add(Genre);
		
		JLabel lblActor = new JLabel("Actor");
		lblActor.setBounds(22, 116, 71, 13);
		panel_1.add(lblActor);
		
		Actor = new JTextField();
		Actor.setColumns(10);
		Actor.setBounds(96, 113, 222, 19);
		panel_1.add(Actor);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setBounds(22, 141, 71, 13);
		panel_1.add(lblDirector);
		
		Director = new JTextField();
		Director.setColumns(10);
		Director.setBounds(96, 138, 222, 19);
		panel_1.add(Director);
		
		JLabel lblLink_Film = new JLabel("Link Film");
		lblLink_Film.setBounds(22, 167, 71, 13);
		panel_1.add(lblLink_Film);
		
		Link_Film = new JTextField();
		Link_Film.setColumns(10);
		Link_Film.setBounds(96, 164, 222, 19);
		panel_1.add(Link_Film);
		
		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Nama_Film.getText().isEmpty() || Genre.getText().isEmpty() || Actor.getText().isEmpty() || Director.getText().isEmpty() || Link_Film.getText().isEmpty()) {
		              JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
		          } else {
		        	  try {
		            	  Film film = new Film();
		            	  FilmsDao films = new FilmsDao();
		            	  film.setName_Film(Nama_Film.getText());
		            	  film.setGenre(Genre.getText());
		            	  film.setActor(Actor.getText());
		            	  film.setDirector(Director.getText());
		            	  film.setLink(Link_Film.getText());
		            	  films.insertFilm(film);
		        	  }catch(Exception ex) {
		        		  ex.printStackTrace();
		        		  JOptionPane.showMessageDialog(null, "Error during registration : " + ex.getMessage());
		        	  }
		          }
			}
		});
		Add.setBounds(22, 207, 71, 21);
		panel_1.add(Add);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 255, 715, 412);
		
		TModel = new DefaultTableModel(
			new Object[][] {},
			new String[] {"Id Film", "Film Name", "Genre", "Actor", "Director", "Link Film"}
		);
		contentPane.add(panel);
		table = new JTable(TModel);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                	Nama_Film.setText((String) TModel.getValueAt(selectedRow, 1));
                    Genre.setText((String) TModel.getValueAt(selectedRow, 2));
                    Actor.setText((String) TModel.getValueAt(selectedRow, 3));
                    Director.setText((String) TModel.getValueAt(selectedRow, 4));
                    Link_Film.setText((String) TModel.getValueAt(selectedRow, 5));
                }
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(21, 10, 672, 397);
		panel.setLayout(null);
		panel.add(scrollPane);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSelectedProduct();
			}
		});
		Update.setBounds(103, 207, 71, 21);
		panel_1.add(Update);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSelectedProduct();
			}
		});
		Delete.setBounds(184, 207, 71, 21);
		panel_1.add(Delete);
		
		JButton New = new JButton("New");
		New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_crud();
				dispose();
			}
		});
		New.setBounds(265, 207, 71, 21);
		panel_1.add(New);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearch.setBounds(408, 48, 71, 13);
		panel_1.add(lblSearch);
		
		JLabel lblNamaFilmS = new JLabel("Nama Film");
		lblNamaFilmS.setBounds(420, 96, 71, 13);
		panel_1.add(lblNamaFilmS);
		
		JLabel lblGenreS = new JLabel("Genre");
		lblGenreS.setBounds(420, 121, 71, 13);
		panel_1.add(lblGenreS);
		
		JLabel lblActorS = new JLabel("Actor");
		lblActorS.setBounds(420, 145, 71, 13);
		panel_1.add(lblActorS);
		
		JLabel lblDirectorS = new JLabel("Director");
		lblDirectorS.setBounds(420, 170, 71, 13);
		panel_1.add(lblDirectorS);
		
		JLabel lblIdFilm = new JLabel("Id Film");
		lblIdFilm.setBounds(418, 70, 71, 13);
		panel_1.add(lblIdFilm);
		
		String genre[] = {"","Musical", "Comedy", "Horror", "Sci-Fi", "Drama", "Thriller", "Superhero", "Romance", "Action", "Fantasy"};
		GenreS = new JComboBox(genre);
		GenreS.setBounds(501, 115, 183, 21);
		panel_1.add(GenreS);
		
		String id[] = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", 
				"42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", 
				"63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80"
				, "81", "82", "83", "84", "85", "86", "87", "88", "89", "90"};
		Id_film = new JComboBox(id);
		Id_film.setBounds(501, 66, 183, 21);
		panel_1.add(Id_film);
		
		NamafilmS = new JTextField();
		NamafilmS.setBounds(501, 92, 183, 19);
		panel_1.add(NamafilmS);
		NamafilmS.setColumns(10);
		
		ActorS = new JTextField();
		ActorS.setBounds(501, 141, 183, 19);
		panel_1.add(ActorS);
		ActorS.setColumns(10);
		
		DirectorS = new JTextField();
		DirectorS.setBounds(501, 164, 183, 19);
		panel_1.add(DirectorS);
		DirectorS.setColumns(10);
		
		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Id_film.getSelectedItem().toString() == "" && GenreS.getSelectedItem().toString() == "" && NamafilmS.getText().isEmpty() 
						&& ActorS.getText().isEmpty() && DirectorS.getText().isEmpty()) {
					try {
			            FilmsDao films = new FilmsDao();
			            List<Film> film = films.showFilm();
			            TModel.setRowCount(0);
			            
			            for (Film film1 : film) {
			            	TModel.addRow(new Object[] {
			            		film1.getId_film(),
			                    film1.getName_Film(),
			                    film1.getGenre(),
			                    film1.getActor(),
			                    film1.getDirector(),
			                    film1.getLink()
			            	});
			            }} catch (Exception ex) {
			                ex.printStackTrace();
			                JOptionPane.showMessageDialog(null, "Error during fetching data: " + ex.getMessage());
			            }
				}else {
					Film film = new Film();
					
					film.setId_film(Id_film.getSelectedItem().toString());
					film.setName_Film(NamafilmS.getText());
					film.setGenre(GenreS.getSelectedItem().toString());
					film.setActor(ActorS.getText());
					film.setDirector(DirectorS.getText());
					try {
						FilmsDao films = new FilmsDao();
			            List<Film> film1 = films.searchFilm1(film);
			            TModel.setRowCount(0);
			            
			            for (Film film11 : film1) {
			            	TModel.addRow(new Object[] {
			            		film11.getId_film(),
			                    film11.getName_Film(),
			                    film11.getGenre(),
			                    film11.getActor(),
			                    film11.getDirector(),
			                    film11.getLink()
			            	});
			            }
		            } catch (Exception e1) {
		                e1.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error during fetching data: " + e1.getMessage());
		            }
		       }
			}
		});
		Search.setBounds(599, 207, 85, 21);
		panel_1.add(Search);
		
		
		LoadDatabase();
	}
	
	public void LoadDatabase() {
		if(Id_film.getSelectedItem().toString() == "" && GenreS.getSelectedItem().toString() == "" && NamafilmS.getText().isEmpty() 
				&& ActorS.getText().isEmpty() && DirectorS.getText().isEmpty()) {
			try {
	            FilmsDao films = new FilmsDao();
	            List<Film> film = films.showFilm();
	            TModel.setRowCount(0);
	            
	            for (Film film1 : film) {
	            	TModel.addRow(new Object[] {
	            		film1.getId_film(),
	                    film1.getName_Film(),
	                    film1.getGenre(),
	                    film1.getActor(),
	                    film1.getDirector(),
	                    film1.getLink()
	            	});
	            }} catch (Exception ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error during fetching data: " + ex.getMessage());
	            }
		}
    }

	private void updateSelectedProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                String id = (String) TModel.getValueAt(selectedRow, 0);
                String nameFilm = Nama_Film.getText();
                String genreFilm = Genre.getText();
                String actorFilm = Actor.getText();
                String director = Director.getText();
                String linkFilm = Link_Film.getText();

                Film film = new Film();
                film.setId_film(id);
                film.setName_Film(nameFilm);
                film.setGenre(genreFilm);
                film.setActor(actorFilm);
                film.setDirector(director);
                film.setLink(linkFilm);

                FilmsDao films = new FilmsDao();
                films.updated(film);

                TModel.setValueAt(nameFilm, selectedRow, 1);
                TModel.setValueAt(genreFilm, selectedRow, 2);
                TModel.setValueAt(actorFilm, selectedRow, 3);
                TModel.setValueAt(director, selectedRow, 4);
                TModel.setValueAt(linkFilm, selectedRow, 5);

                clearInputFields();
                JOptionPane.showMessageDialog(null, "Product updated successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed to update product: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row selected!");
        }
    }
    
    private void deleteSelectedProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                String id = (String) TModel.getValueAt(selectedRow, 0);
                FilmsDao dao = new FilmsDao();
                dao.removeFilm(id);

                TModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Product deleted successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed to delete product: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row selected!");
        }
    }
    
    private void clearInputFields() {
    	Nama_Film.setText("");
        Genre.setText("");
        Actor.setText("");
        Director.setText("");
        Link_Film.setText("");
    }
}
