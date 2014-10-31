package com.formation.mario.view;

import javax.swing.JMenuItem;

public class JMenuItemNiveau extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4924020969071190831L;

	private final int value;

	public JMenuItemNiveau(String label, int value) {
		super(label);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
