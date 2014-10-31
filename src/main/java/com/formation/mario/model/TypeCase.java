package com.formation.mario.model;

public enum TypeCase {
	RIEN(0, "0.png"), MUR(1, "10113.jpg"), CAISSE(2, "10114.jpg"), CAISSE_OK(3,
			"10117.jpg"), OBJECTIF(4, "10118.png"), MARIO_HAUT(5, "48.gif"), MARIO_BAS(
			6, "45.gif"), MARIO_GAUCHE(7, "47.gif"), MARIO_DROITE(8, "46.gif");

	Integer value;

	String fichier;

	TypeCase(Integer value, String fichier) {
		this.value = value;
		this.fichier = fichier;
	}

	public Integer getValue() {
		return value;
	}

	public String getFichier() {
		return fichier;
	}

	public static TypeCase getType(int typeCase) {

		switch (typeCase) {
		case 0:
			return TypeCase.RIEN;
		case 1:
			return TypeCase.MUR;
		case 2:
			return TypeCase.CAISSE;
		case 3:
			return TypeCase.CAISSE_OK;
		case 4:
			return TypeCase.OBJECTIF;
		case 5:
			return TypeCase.MARIO_HAUT;
		case 6:
			return TypeCase.MARIO_BAS;
		case 7:
			return TypeCase.MARIO_GAUCHE;
		case 8:
			return TypeCase.MARIO_DROITE;
		default:
			throw new IllegalArgumentException();
		}
	}
}
