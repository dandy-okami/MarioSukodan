package com.formation.mario.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.formation.mario.controler.Controler;
import com.formation.mario.controler.Deplacement;

public class View extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 336798382721229187L;

	private ViewCarte viewCarte;

	private Controler controler;

	private JLabel gagne;

	private JLabel information;

	public View(Controler controler, List<Integer> listeLevel) {
		this.controler = controler;
		// Définit un titre pour notre fenêtre
		setTitle("MARIO-SOKOBAN");
		// Définit sa taille
		setSize(34 * controler.getLargeurTableau(),
				34 * controler.getHauteurTableau() + 40);
		// Nous demandons maintenant à notre objet de se positionner au centre
		setLocationRelativeTo(null);
		// Termine le processus lorsqu'on clique sur la croix rouge
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			setContentPane();
			viewCarte.setControler(controler);
		} catch (final IOException e) {
			e.printStackTrace();
		}

		// Et enfin, la rendre visible
		setVisible(true);
	}

	/**
	 * 
	 * @throws IOException
	 */
	private void setContentPane() throws IOException {
		viewCarte = new ViewCarte();
		viewCarte.setSize(340, 340);
		setResizable(false);
		// Définition de sa couleur de fond
		viewCarte.setBackground(Color.WHITE);
		viewCarte.setLayout(new BorderLayout());

		final JMenuBar menuBar = new JMenuBar();
		final JMenu menu1 = new JMenu("Fichier");
		final JMenuItem item1 = new JMenuItem("Rejouer");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controler.resetLevel();
			}
		});
		menu1.add(item1);

		final JMenu item2 = new JMenu("Niveau");

		final NiveauListener nl = new NiveauListener();
		for (final Integer i : controler.getListeNiveau()) {
			final JMenuItem niveau = new JMenuItemNiveau("Niveau " + i, i);
			item2.add(niveau);
			niveau.addActionListener(nl);
		}
		menu1.add(item2);

		final JMenuItem item3 = new JMenuItem("Fermer");
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu1.add(item3);
		menuBar.add(menu1);
		viewCarte.add(menuBar, BorderLayout.NORTH);

		gagne = new JLabel("Gagnée", JLabel.CENTER);
		final Font f = new Font("Serif", Font.PLAIN, 36);
		gagne.setFont(f);

		information = new JLabel(controler.getInformation());
		viewCarte.add(information, BorderLayout.SOUTH);

		this.addKeyListener(this);
		// On prévient notre JFrame que notre JPanel sera son content pane
		this.setContentPane(viewCarte);

	}

	/**
	 * Affiche un message de victoire
	 */
	public void afficherGagnee() {
		viewCarte.add(gagne, BorderLayout.CENTER);
	}

	/**
	 * Masque le message de victoire
	 */
	public void masquerGagnee() {

		viewCarte.remove(gagne);
	}

	/**
	 * Actualise la carte
	 * 
	 * @param cases
	 *            tableau qui contient le nom des fichiers à afficher. Null
	 *            s'il y a rien
	 */
	public void afficheCarte(String[][] cases) {
		setSize(34 * controler.getLargeurTableau(),
				34 * controler.getHauteurTableau() + 40);
		viewCarte.modifieTableau(cases);
		information.setText(controler.getInformation());
		viewCarte.repaint();

	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			System.out.println("Déplacement à gauche");
			controler.deplacementJoueur(Deplacement.GAUCHE);
			break;
		case 38:
			System.out.println("Déplacement en haut");
			controler.deplacementJoueur(Deplacement.HAUT);
			break;
		case 39:
			System.out.println("Déplacement à droite");
			controler.deplacementJoueur(Deplacement.DROITE);
			break;
		case 40:
			System.out.println("Déplacement en bas");
			controler.deplacementJoueur(Deplacement.BAS);
			break;
		default:

			break;
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setControler(Controler controler) {
		this.controler = controler;
		this.viewCarte.setControler(controler);
	}

	public class NiveauListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			final int level = ((JMenuItemNiveau) e.getSource()).getValue();
			controler.changeLevel(level);
		}
	}

}
