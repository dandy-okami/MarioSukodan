package com.formation.mario.controler;

import java.util.List;

import com.formation.mario.model.Carte;
import com.formation.mario.model.CarteImp;
import com.formation.mario.view.View;

public class ControlerImpl implements Controler {

	private final Carte carte;
	private final View view;

	public ControlerImpl() {
		this.carte = new CarteImp();
		this.view = new View(this, null);
		initialiseCarte();
		view.afficheCarte(carte.getTableauImage());
	}

	@Deprecated
	private void initialiseCarte() {
		carte.chargerLevel(1);
	}

	public void deplacementJoueur(Deplacement deplacement) {
		carte.deplacement(deplacement);
		view.afficheCarte(carte.getTableauImage());
		if (carte.testVictoire()) {
			view.afficherGagnee();
		}
	}

	public void resetLevel() {
		System.out.println("Remise à zéro du niveau");
		view.masquerGagnee();
		carte.chargerLevel(1);
		view.afficheCarte(carte.getTableauImage());
	}

	public void changeLevel(int level) {
		System.out.println("Changement de niveau : " + level);
		carte.chargerLevel(level);
		view.afficheCarte(carte.getTableauImage());

	}

	public int getLargeurTableau() {
		return 10;
	}

	public int getHauteurTableau() {
		return 10;
	}

	public List<Integer> getListeNiveau() {
		return carte.getListeNiveau();
	}

	public String getInformation() {
		return "Niveau " + carte.getNiveau();
	}

}
