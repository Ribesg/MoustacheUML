package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controleur.Controleur;

import javax.swing.*;

public class VueBarreDeStatut extends JTextField {

	private final Controleur controleur;

	public VueBarreDeStatut(Controleur controleur) {
		this.controleur = controleur;

		this.setText("Utilisez le menu pour créer un Diagramme");
		this.setEditable(false);

		this.setVisible(true);
	}
}
