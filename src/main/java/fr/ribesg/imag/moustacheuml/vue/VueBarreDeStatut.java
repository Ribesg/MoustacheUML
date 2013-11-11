package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controlleur.Controlleur;

import javax.swing.*;

public class VueBarreDeStatut extends JTextField {

	private final Controlleur controlleur;

	public VueBarreDeStatut(Controlleur controlleur) {
		this.controlleur = controlleur;

		this.setText("Hello Wolrd!");
		this.setEditable(false);

		this.setVisible(true);
	}
}
