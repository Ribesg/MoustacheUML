package fr.ribesg.imag.moustacheuml.controleur;

import fr.ribesg.imag.moustacheuml.modele.Diagramme;
import fr.ribesg.imag.moustacheuml.modele.DiagrammeClasses;
import fr.ribesg.imag.moustacheuml.modele.boite.Stereotype;
import fr.ribesg.imag.moustacheuml.utils.IdUtils;
import fr.ribesg.imag.moustacheuml.vue.VueGraphique;
import fr.ribesg.imag.moustacheuml.vue.popup.MenuContextuel;

import java.util.*;

/**
 * Représente l'espace de travail d'un seul diagramme.
 */
public class ControleurEspaceDeTravail extends Observable {

	private Controleur controleur;
	private Diagramme modele;
	private VueGraphique vue;

	public ControleurEspaceDeTravail(Controleur controleur, Diagramme modele) {
		this.controleur = controleur;
		this.modele = modele;
	}

	public Controleur getControleur() {
		return controleur;
	}

	public Diagramme getModele() {
		return modele;
	}

	public VueGraphique getVue() {
		return vue;
	}

	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	public void setModele(Diagramme modele) {
		this.modele = modele;
	}

	public void setVue(VueGraphique vue) {
		this.vue = vue;
	}

	/**
	 * Gère l'ouverture du menu contextuel
	 */
	public void clicDroit(int x, int y, String clique, Set<String> selection) {
		boolean clicSurLeFond = clique == null;

		// Détecter si on a sélectionné 2 boites pour créer un lien
		// Récupérer ces deux boites si existantes
		boolean creerLien = false;
		String[] creerLienBoites = null;
		Set<String> boitesSelectionnees = new HashSet<>();
		for (String s : selection) {
			if (IdUtils.estBoite(s)) {
				boitesSelectionnees.add(s);
			}
		}
		if (boitesSelectionnees.size() == 2) {
			creerLien = true;
			Iterator<String> it = boitesSelectionnees.iterator();
			creerLienBoites = new String[]{it.next(), it.next()};
		}

		// Modifier Boite
		boolean modifierBoite = IdUtils.estBoite(clique);
		String boiteAModifier = IdUtils.deprefixe(clique);

		// Modifier Attributs
		boolean modifierAttributs = IdUtils.estAttribut(clique);
		if (modifierAttributs) {
			modifierBoite = true;
			boiteAModifier = IdUtils.deprefixe(clique);
		}

		// Modifier Methodes
		boolean modifierMethodes = false;
		if (modele.estClasses()) {
			modifierMethodes = IdUtils.estMethode(clique);
			if (modifierMethodes) {
				modifierBoite = true;
				boiteAModifier = IdUtils.deprefixe(clique);
			}
		}

		// Modifier Lien
		boolean modifierLien = IdUtils.estLien(clique);
		String lienAModifier = clique;

		MenuContextuel menu = new MenuContextuel(x, y, this, clicSurLeFond, creerLien, creerLienBoites,
				modifierBoite, modifierAttributs, modifierMethodes, boiteAModifier, modifierLien, lienAModifier);

		vue.afficherMenuContextuel(x, y, menu);
	}

	// Les prochaines méthodes récupèrent les évenements lors de
	// clics dans le menu contextuel et ouvre les popups
	// appropriées.

	public void menuContextuelCreerLien(int x, int y, String[] creerLienBoites) {
		// TODO Implement method
	}

	public void menuContextuelCreerClasse(int x, int y) {
		vue.afficherCreerUneClasse(x, y);
	}

	public void menuContextuelCreerObjet(int x, int y) {
		// TODO Implement method
	}

	public void menuContextuelModifierClasse(int x, int y, String boiteAModifier) {
		// TODO Implement method
	}

	public void menuContextuelModifierObjet(int x, int y, String boiteAModifier) {
		// TODO Implement method
	}

	public void menuContextuelModifierAttributsClasse(int x, int y, String boiteAModifier) {
		// TODO Implement method
	}

	public void menuContextuelModifierMethodesClasse(int x, int y, String boiteAModifier) {
		// TODO Implement method
	}

	public void menuContextuelModifierAttributsObjet(int x, int y, String boiteAModifier) {
		// TODO Implement method
	}

	public void menuContextuelModifierLien(int x, int y, String lienAModifier) {
		// TODO Implement method
	}

	// Les méthodes suivantes gèrent la modification du modèle

	public void deplacementDeBoites(double dx, double dy, List<String> deplacees) {
		getModele().deplacementDeBoites(dx, dy, deplacees);
	}

	public boolean creerClasse(Stereotype stereotype, String nom, int x, int y) {
		return ((DiagrammeClasses) getModele()).creerClasse(stereotype, nom, x, y);
	}
}
