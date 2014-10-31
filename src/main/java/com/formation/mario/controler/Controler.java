package com.formation.mario.controler;

import java.util.List;

public interface Controler {

	/**
	 * 
	 * @param deplacement
	 */
	public void deplacementJoueur(Deplacement deplacement);

	/**
	 * recharge la carte
	 */
	public void resetLevel();

	/**
	 * 
	 * @param level
	 */
	public void changeLevel(int level);

	/**
	 * 
	 * @return le nombre de case du tableau en largeur
	 */
	public int getLargeurTableau();

	/**
	 * 
	 * @return le nombre de case du tableau en hauteur
	 */
	public int getHauteurTableau();

	/**
	 * renvoi la liste des niveaux
	 * 
	 * @return
	 */
	public List<Integer> getListeNiveau();

	/**
	 * Affiche les information en bas de page
	 * 
	 * @return
	 */
	public String getInformation();
}
