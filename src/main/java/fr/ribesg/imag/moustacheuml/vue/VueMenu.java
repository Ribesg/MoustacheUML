package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controlleur.Controlleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class VueMenu extends JMenuBar {

	private final Controlleur controlleur;

	/**
	 * Le constructeur va ajouter les différents menus à la barre de menu.
	 */
	public VueMenu(Controlleur controlleur) {
		this.controlleur = controlleur;

		// Menu "Fichier"
		JMenu fichier = new JMenu("Fichier");

		// Menu "Fichier" - "Nouveau"
		JMenuItem nouveau = new JMenuItem("Nouveau", KeyEvent.CTRL_DOWN_MASK + KeyEvent.VK_N);
		nouveau.setEnabled(false);
		nouveau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Appeler une méthode du Controlleur
			}
		});
		fichier.add(nouveau);

		// Menu "Fichier" - "Ouvrir"
		JMenuItem ouvrir = new JMenuItem("Ouvrir", KeyEvent.CTRL_DOWN_MASK + KeyEvent.VK_O);
		ouvrir.setEnabled(false);
		ouvrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Appeler une méthode du Controlleur
			}
		});
		fichier.add(ouvrir);

		// Menu "Fichier" - "Enregistrer"
		JMenuItem enregistrer = new JMenuItem("Enregistrer", KeyEvent.CTRL_DOWN_MASK + KeyEvent.VK_S);
		enregistrer.setEnabled(false);
		enregistrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Appeler une méthode du Controlleur
			}
		});
		fichier.add(enregistrer);

		this.add(fichier);
	}
}
