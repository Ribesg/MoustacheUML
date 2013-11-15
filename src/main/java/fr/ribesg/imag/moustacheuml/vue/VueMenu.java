package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controleur.Controleur;
import fr.ribesg.imag.moustacheuml.controleur.ControleurMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class VueMenu extends JMenuBar {

	private final ControleurMenu controleur;

	/**
	 * Le constructeur va ajouter les différents menus à la barre de menu.
	 */
	public VueMenu(Controleur controleur) {
		this.controleur = controleur.getControleurMenu();

		// Menu "Fichier"
		JMenu fichier = new JMenu("Fichier");

		// Menu "Fichier" - "Nouveau Diagramme de Classes"
		JMenuItem nouveauClasses = new JMenuItem("Nouveau Diagramme de Classes", KeyEvent.CTRL_DOWN_MASK + KeyEvent.VK_N);
		nouveauClasses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VueMenu.this.controleur.menuNouveauClasse();
			}
		});
		fichier.add(nouveauClasses);

		// Menu "Fichier" - "Nouveau Diagramme d'Objets"
		JMenuItem nouveauObjets = new JMenuItem("Nouveau Diagramme d'Objets", KeyEvent.CTRL_DOWN_MASK + KeyEvent.VK_T);
		nouveauObjets.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VueMenu.this.controleur.menuNouveauObjets();
			}
		});
		fichier.add(nouveauObjets);

		// Menu "Fichier" - "Ouvrir"
		JMenuItem ouvrir = new JMenuItem("Ouvrir", KeyEvent.CTRL_DOWN_MASK + KeyEvent.VK_O);
		ouvrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VueMenu.this.controleur.menuOuvrir();
			}
		});
		fichier.add(ouvrir);

		// Menu "Fichier" - "Enregistrer"
		JMenuItem enregistrer = new JMenuItem("Enregistrer", KeyEvent.CTRL_DOWN_MASK + KeyEvent.VK_S);
		enregistrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VueMenu.this.controleur.menuEnregistrer();
			}
		});
		fichier.add(enregistrer);

		// Menu "Fichier" - "Quitter"
		JMenuItem quitter = new JMenuItem("Quitter", KeyEvent.ALT_DOWN_MASK + KeyEvent.VK_F4);
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VueMenu.this.controleur.menuQuitter();
			}
		});
		fichier.add(quitter);

		this.add(fichier);
	}
}
