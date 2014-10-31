package com.formation.mario.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LevelUtil {

	public static Integer[][] chargerLevel(int level) {
		final String fichier = "level/" + level + ".lvl";
		Integer[][] tableau = null;
		try {
			final InputStream ips = new FileInputStream(fichier);
			final InputStreamReader ipsr = new InputStreamReader(ips);
			final BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			int j = 0;
			final int tailleTableauHauteur = Integer.parseInt(br.readLine());
			final int tailleTableauLargeur = Integer.parseInt(br.readLine());
			tableau = new Integer[tailleTableauHauteur][tailleTableauLargeur];
			while ((ligne = br.readLine()) != null) {
				for (int i = 0; i < tailleTableauLargeur; i++) {
					tableau[j][i] = Integer.parseInt(ligne.substring(i, i + 1));
				}
				j++;
			}
			br.close();
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
		return tableau;
	}

	public static Integer[] listeFichier() {
		final File file = new File("level");
		final File[] files = file.listFiles();
		final Integer[] result = new Integer[files.length];
		int i = 0;
		for (final File elt : files) {
			final int niveau = Integer.parseInt(elt.getName().substring(0,
					elt.getName().indexOf('.')));
			result[i] = niveau;
			i++;
		}

		return result;

	}
}
