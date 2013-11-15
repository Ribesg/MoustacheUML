package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * La fenêtre principale du programme.
 * Elle contient trois vues :
 * - La barre de menu
 * - Le graphique
 * - La barre de statut
 */
public class FenetrePrincipale extends JFrame {

	private final Controleur controleur;

	private final VueMenu vueMenu;
	private final VueEspacesDeTravail vueEspacesDeTravail;
	private final VueBarreDeStatut vueBarreDeStatut;

	public FenetrePrincipale(Controleur controleur) {
		this.controleur = controleur;

		this.vueMenu = new VueMenu(controleur);
		this.vueEspacesDeTravail = new VueEspacesDeTravail(controleur);
		this.vueBarreDeStatut = new VueBarreDeStatut(controleur);

		this.setTitle("MoustacheUML");

		this.setJMenuBar(vueMenu);
		this.add(vueEspacesDeTravail, BorderLayout.CENTER);
		this.add(vueBarreDeStatut, BorderLayout.PAGE_END);

		this.setMinimumSize(new Dimension(800, 600));
		this.setPreferredSize(new Dimension(1280, 720));
		this.pack();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				FenetrePrincipale.this.controleur.quitter();
			}
		});
	}

	public VueBarreDeStatut getVueBarreDeStatut() {
		return vueBarreDeStatut;
	}

	public VueEspacesDeTravail getVueEspacesDeTravail() {
		return vueEspacesDeTravail;
	}

	public VueMenu getVueMenu() {
		return vueMenu;
	}
}
