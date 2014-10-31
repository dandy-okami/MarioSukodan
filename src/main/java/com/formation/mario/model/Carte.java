package com.formation.mario.model;

import java.util.List;

import com.formation.mario.controler.Deplacement;

public interface Carte {

	/**
	 * Permet de mettre à jour la carte lors d'un déplacement
	 * 
	 * @param deplacement
	 */
	public void deplacement(Deplacement deplacement);
	

	/**
	 * Permet de modifier le contenu d'une case
	 * 
	 * @param i
	 * @param j
	 * @param type
	 */
	public void modifieCase(int i, int j, TypeCase type);

	/**
	 * @return un tableau avec le nom des fichier images de chaque case
	 */
	public String[][] getTableauImage();
		
	/**
	 * @param level
	 */
	public void chargerLevel(int level);

	/**
	 * 
	 * @return true si la partie est gagnée
	 */
	public Boolean testVictoire();

	/**
	 * renvoi la liste des niveaux
	 * 
	 * @return
	 */
	public List<Integer> getListeNiveau();

	/**
	 * @return le numero du niveau
	 */
	public int getNiveau();

}
