package com.formation.mario.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.formation.mario.controler.Controler;

public class ViewCarte extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6189323613812774918L;
	private String[][] cases;
	private Controler controler;

	@Override
	public void paintComponent(Graphics g) {
		try {
			if (cases != null) {
				for (int i = 0; i < controler.getLargeurTableau(); i++) {
					for (int j = 0; j < controler.getHauteurTableau(); j++) {
						final String elt = cases[i][j];
						if (elt != null && !elt.isEmpty()) {
							final File file = new File("images/" + elt);
							if (file.exists()) {
								final Image img = ImageIO.read(file);
								g.drawImage(img, 34 * j, 34 * i + 20, this);
							}
						}
					}
				}
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Met à jour le tableau des fichiers images
	 * 
	 * @param cases
	 */
	public void modifieTableau(String[][] cases) {
		this.cases = cases;

	}

	public void setControler(Controler controler) {
		this.controler = controler;

	}

}
