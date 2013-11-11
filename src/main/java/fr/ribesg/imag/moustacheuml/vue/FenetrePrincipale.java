package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controlleur.Controlleur;

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

	private final Controlleur controlleur;

	private final VueMenu vueMenu;
	private final VueGraphique vueGraphique;
	private final VueBarreDeStatut vueBarreDeStatut;

	public FenetrePrincipale(Controlleur controlleur) {
		this.controlleur = controlleur;

		this.vueMenu = new VueMenu(controlleur);
		this.vueGraphique = new VueGraphique(controlleur);
		this.vueBarreDeStatut = new VueBarreDeStatut(controlleur);

		this.setTitle("MoustacheUML");

		this.setJMenuBar(vueMenu);
		this.add(vueGraphique, BorderLayout.CENTER);
		this.add(vueBarreDeStatut, BorderLayout.PAGE_END);

		this.setMinimumSize(new Dimension(800, 600));
		this.setPreferredSize(new Dimension(1280, 720));
		this.pack();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				FenetrePrincipale.this.controlleur.quitter();
			}
		});
	}
}
