package fr.ribesg.imag.moustacheuml.vue.popup;

import fr.ribesg.imag.moustacheuml.controleur.Controleur;
import fr.ribesg.imag.moustacheuml.vue.FenetrePrincipale;

import javax.swing.*;

public class PopupNonImplemente extends JDialog {

	private final Controleur controleur;

	public PopupNonImplemente(Controleur controleur, FenetrePrincipale maitre, String contenu) {
		super(maitre, "Fonctionnalité non-implémentée", true);
		this.controleur = controleur;

		JPanel panel = new JPanel();
		this.add(panel);

		JLabel contenuLabel = new JLabel(contenu);
		panel.add(contenuLabel);

		this.pack();
		this.setLocationRelativeTo(this.getParent());
	}
}
