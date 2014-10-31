package com.formation.mario.model;

import java.util.ArrayList;
import java.util.List;

import com.formation.mario.controler.Deplacement;

public class CarteImp implements Carte {
	private TypeCase caseJeu;
	private TypeCase[][] tab = new TypeCase[10][10];
	private int posMarioH;
	private int posMarioV;
	private int posCaisseH;
	private int posCaisseV;

	public CarteImp() {
		super();
		remplircase();
	}

	public TypeCase remplircase() {
		Integer[][] t = LevelUtil.chargerLevel(1);
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				System.out.print(t[i][j]);
				tab[i][j] = TypeCase.getType(t[i][j]);

			}
			System.out.println();
		}

		return caseJeu;
	}

	@Deprecated
	public void afficheCase() {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
			}
		}
	}

	public String[][] getTableauImage() {
		String[][] tabFichier = new String[10][10];
		for (int i = 0; i < tabFichier.length; i++) {
			for (int j = 0; j < tabFichier.length; j++) {

				TypeCase wall = tab[i][j];
				tabFichier[i][j] = wall.getFichier();
			}
		}
		return tabFichier;
	}

	public TypeCase getCaseJeu() {
		return caseJeu;
	}

	public TypeCase setCaseJeu(TypeCase caseJeu) {
		return this.caseJeu = caseJeu;
	}

	public void rechercheMario() {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if (tab[i][j] == TypeCase.MARIO_BAS
						|| tab[i][j] == TypeCase.MARIO_HAUT
						|| tab[i][j] == TypeCase.MARIO_GAUCHE
						|| tab[i][j] == TypeCase.MARIO_DROITE) {
					posMarioH = i;
					posMarioV = j;
					System.out.println(i + " " + j);

				}
			}
		}
	}

	public void rechercheCaisse() {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if (tab[i][j] == TypeCase.CAISSE) {
					posCaisseH = i;
					posCaisseV = j;
					System.out.println(i + " " + j);
				}
			}
		}
	}
	

	public void deplacement(Deplacement deplacement) {
		rechercheMario();
		rechercheCaisse();
		switch (deplacement) {
		case HAUT:
			if (tab[posMarioH - 1][posMarioV] == TypeCase.RIEN) {
				tab[posMarioH][posMarioV] = TypeCase.RIEN;
				tab[posMarioH - 1][posMarioV] = TypeCase.MARIO_HAUT;

			}
			if (tab[posMarioH - 1][posMarioV] == TypeCase.CAISSE) {

				tab[posCaisseH - 1][posCaisseV] = TypeCase.CAISSE;
				tab[posCaisseH][posCaisseV] = TypeCase.RIEN;
			}

			break;
		case BAS:
			if (tab[posMarioH + 1][posMarioV] == TypeCase.RIEN) {
				tab[posMarioH][posMarioV] = TypeCase.RIEN;
				tab[posMarioH + 1][posMarioV] = TypeCase.MARIO_BAS;
			}
			if (tab[posMarioH + 1][posMarioV] == TypeCase.CAISSE) {
				tab[posCaisseH + 1][posCaisseV] = TypeCase.CAISSE;
				tab[posCaisseH][posCaisseV] = TypeCase.RIEN;
			}

			break;
		case DROITE:
			if (tab[posMarioH][posMarioV + 1] == TypeCase.RIEN) {
				tab[posMarioH][posMarioV] = TypeCase.RIEN;
				tab[posMarioH][posMarioV + 1] = TypeCase.MARIO_DROITE;
			}
			if (tab[posMarioH][posMarioV + 1] == TypeCase.CAISSE) {
				tab[posCaisseH][posCaisseV + 1] = TypeCase.CAISSE;
				tab[posCaisseH][posCaisseV] = TypeCase.RIEN;
			}

			break;
		case GAUCHE:
			if (tab[posMarioH][posMarioV - 1] == TypeCase.RIEN) {
				tab[posMarioH][posMarioV] = TypeCase.RIEN;
				tab[posMarioH][posMarioV - 1] = TypeCase.MARIO_GAUCHE;
			}
			if (tab[posMarioH][posMarioV - 1] == TypeCase.CAISSE) {
				tab[posCaisseH][posCaisseV] = TypeCase.RIEN;
				tab[posCaisseH][posCaisseV - 1] = TypeCase.CAISSE;
			}

			break;
		default:
			break;
		}
	}

	public void modifieCase(int i, int j, TypeCase type) {

	}

	public void chargerLevel(int level) {
		// TODO Auto-generated method stub

	}

	public Boolean testVictoire() {
		
		return Boolean.FALSE;
	}

	public List<Integer> getListeNiveau() {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>();
	}

	public int getNiveau() {
		// TODO Auto-generated method stub
		return 0;
	}

}
