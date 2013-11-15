package fr.ribesg.imag.moustacheuml.vue.popup;

import fr.ribesg.imag.moustacheuml.controleur.ControleurEspaceDeTravail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuContextuel extends JPopupMenu implements ActionListener {

	private static final String CREER_LIEN = "Créer un lien";
	private static final String CREER_CLASSE = "Créer une classe";
	private static final String CREER_OBJET = "Créer une objet";
	private static final String MODIFIER_CLASSE = "Modifier la classe %%";
	private static final String MODIFIER_OBJET = "Modifier l'objet %%";
	private static final String MODIFIER_ATTRIBUTS_CLASSE = "Modifier les attributs de la classe %%";
	private static final String MODIFIER_ATTRIBUTS_OBJET = "Modifier les attributs de l'objet %%";
	private static final String MODIFIER_METHODES_CLASSE = "Modifier les méthodes de la classe %%";
	private static final String MODIFIER_LIEN = "Modifier le lien";

	private final ControleurEspaceDeTravail controleur;

	private final String[] creerLienBoites;
	private final String boiteAModifier;
	private final String lienAModifier;

	private final int x;
	private final int y;

	public MenuContextuel(int x, int y,
	                      ControleurEspaceDeTravail controleur, boolean clicSurLeFond,
	                      boolean creerLien, String[] creerLienBoites,
	                      boolean modifierBoite, boolean modifierAttributs,
	                      boolean modifierMethodes, String boiteAModifier,
	                      boolean modifierLien, String lienAModifier) {
		this.controleur = controleur;

		this.x = x;
		this.y = y;

		// Sauvegarde d'informations sur les options
		this.creerLienBoites = creerLienBoites;
		this.boiteAModifier = boiteAModifier;
		this.lienAModifier = lienAModifier;

		// Affichage ou non des options en fonction du contexte
		if (creerLien) {
			add(creerElementDeMenu(CREER_LIEN));
		}

		if (modifierLien) {
			add(creerElementDeMenu(MODIFIER_LIEN));
		}
		if (modifierBoite) {
			if (controleur.getModele().estObjets()) {
				if (modifierAttributs) {
					add(creerElementDeMenu(MODIFIER_ATTRIBUTS_OBJET.replace("%%", boiteAModifier.split("=")[1].split(";")[0])));
					add(creerElementDeMenu(MODIFIER_OBJET.replace("%%", boiteAModifier.split("=")[1].split(";")[0])));
				} else {
					add(creerElementDeMenu(MODIFIER_OBJET.replace("%%", boiteAModifier.split("=")[1].split(";")[0])));
					add(creerElementDeMenu(MODIFIER_ATTRIBUTS_OBJET.replace("%%", boiteAModifier.split("=")[1].split(";")[0])));
				}
			} else {
				if (modifierAttributs) {
					add(creerElementDeMenu(MODIFIER_ATTRIBUTS_CLASSE.replace("%%", boiteAModifier.split("=")[1])));
					add(creerElementDeMenu(MODIFIER_CLASSE.replace("%%", boiteAModifier.split("=")[1])));
				} else if (modifierMethodes) {
					add(creerElementDeMenu(MODIFIER_METHODES_CLASSE.replace("%%", boiteAModifier.split("=")[1])));
					add(creerElementDeMenu(MODIFIER_CLASSE.replace("%%", boiteAModifier.split("=")[1])));
				} else {
					add(creerElementDeMenu(MODIFIER_CLASSE.replace("%%", boiteAModifier.split("=")[1])));
					add(creerElementDeMenu(MODIFIER_ATTRIBUTS_CLASSE.replace("%%", boiteAModifier.split("=")[1])));
					add(creerElementDeMenu(MODIFIER_METHODES_CLASSE.replace("%%", boiteAModifier.split("=")[1])));
				}
			}
		}

		if (clicSurLeFond) {
			if (controleur.getModele().estObjets()) {
				add(creerElementDeMenu(CREER_OBJET));
			} else {
				add(creerElementDeMenu(CREER_CLASSE));
			}
		}

		// Récupération de l'item sélectionné

	}

	private JMenuItem creerElementDeMenu(String texte) {
		JMenuItem elem = new JMenuItem(texte);
		elem.addActionListener(this);
		return elem;
	}

	private boolean estElementDeMenu(String element, String compare) {
		return element.startsWith(compare.split("%%")[0]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (estElementDeMenu(action, CREER_LIEN)) {
			controleur.menuContextuelCreerLien(x, y, creerLienBoites);
		} else if (estElementDeMenu(action, CREER_CLASSE)) {
			controleur.menuContextuelCreerClasse(x, y);
		} else if (estElementDeMenu(action, CREER_OBJET)) {
			controleur.menuContextuelCreerObjet(x, y);
		} else if (estElementDeMenu(action, MODIFIER_CLASSE)) {
			controleur.menuContextuelModifierClasse(x, y, boiteAModifier);
		} else if (estElementDeMenu(action, MODIFIER_OBJET)) {
			controleur.menuContextuelModifierObjet(x, y, boiteAModifier);
		} else if (estElementDeMenu(action, MODIFIER_ATTRIBUTS_CLASSE)) {
			controleur.menuContextuelModifierAttributsClasse(x, y, boiteAModifier);
		} else if (estElementDeMenu(action, MODIFIER_METHODES_CLASSE)) {
			controleur.menuContextuelModifierMethodesClasse(x, y, boiteAModifier);
		} else if (estElementDeMenu(action, MODIFIER_ATTRIBUTS_OBJET)) {
			controleur.menuContextuelModifierAttributsObjet(x, y, boiteAModifier);
		} else if (estElementDeMenu(action, MODIFIER_LIEN)) {
			controleur.menuContextuelModifierLien(x, y, lienAModifier);
		} else {
			throw new IllegalArgumentException(action);
		}
	}
}
