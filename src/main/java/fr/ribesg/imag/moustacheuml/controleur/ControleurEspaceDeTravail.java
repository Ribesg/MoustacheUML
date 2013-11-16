package fr.ribesg.imag.moustacheuml.controleur;

import fr.ribesg.imag.moustacheuml.modele.Diagramme;
import fr.ribesg.imag.moustacheuml.modele.DiagrammeClasses;
import fr.ribesg.imag.moustacheuml.modele.DiagrammeObjets;
import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;
import fr.ribesg.imag.moustacheuml.modele.boite.Objet;
import fr.ribesg.imag.moustacheuml.modele.boite.Stereotype;
import fr.ribesg.imag.moustacheuml.modele.lien.Navigabilite;
import fr.ribesg.imag.moustacheuml.modele.lien.Relation;
import fr.ribesg.imag.moustacheuml.utils.IdUtils;
import fr.ribesg.imag.moustacheuml.vue.VueGraphique;
import fr.ribesg.imag.moustacheuml.vue.popup.MenuContextuel;
import fr.ribesg.imag.moustacheuml.vue.popup.PopupNonImplemente;

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
		// FIXME Gestion basique, sans passer par une popup, pour l'instant
		if (getModele().estClasses()) {
			String source = creerLienBoites[0].split("=")[1];
			String destination = creerLienBoites[1].split("=")[1];
			Classe sourceClasse = null;
			Classe destinationClasse = null;
			for (Boite boite : getModele().getBoites()) {
				if (boite.getNom().equalsIgnoreCase(source)) {
					sourceClasse = (Classe) boite;
				} else if (boite.getNom().equalsIgnoreCase(destination)) {
					destinationClasse = (Classe) boite;
				}
			}
			getModele().getLiens().add(new Relation(sourceClasse, destinationClasse, null, null, null, null, Navigabilite.BIDIRECTIONELLE));
		} else {
			String source = creerLienBoites[0].split("=")[1].split(";")[0];
			String destination = creerLienBoites[1].split("=")[1].split(";")[0];
			Objet sourceObjet = null;
			Objet destinationObjet = null;
			for (Boite boite : getModele().getBoites()) {
				if (boite.getNom().equalsIgnoreCase(source)) {
					sourceObjet = (Objet) boite;
				} else if (boite.getNom().equalsIgnoreCase(destination)) {
					destinationObjet = (Objet) boite;
				}
			}
			getModele().getLiens().add(new Relation(sourceObjet, destinationObjet, Navigabilite.BIDIRECTIONELLE));
		}
		getModele().notifierChangements();
	}

	public void menuContextuelCreerClasse(int x, int y) {
		vue.afficherCreerUneClasse(x, y);
	}

	public void menuContextuelCreerObjet(int x, int y) {
		vue.afficherCreerUnObjet(x, y);
	}

	public void menuContextuelModifierClasse(int x, int y, String boiteAModifier) {
		nonImplemente("La fonction de modification de Classe n'est pas encore implémentée");
	}

	public void menuContextuelModifierObjet(int x, int y, String boiteAModifier) {
		nonImplemente("La fonction de modification d'Objet n'est pas encore implémentée");
	}

	public void menuContextuelModifierAttributsClasse(int x, int y, String boiteAModifier) {
		nonImplemente("La fonction de modification d'attributs de Classe n'est pas encore implémentée");
	}

	public void menuContextuelModifierMethodesClasse(int x, int y, String boiteAModifier) {
		nonImplemente("La fonction de modification de méthodes de Classe n'est pas encore implémentée");
	}

	public void menuContextuelModifierAttributsObjet(int x, int y, String boiteAModifier) {
		nonImplemente("La fonction de modification d'attributs d'Objet n'est pas encore implémentée");
	}

	public void menuContextuelModifierLien(int x, int y, String lienAModifier) {
		nonImplemente("La fonction de modification de Lien n'est pas encore implémentée");
	}

	private void nonImplemente(String contenu) {
		new PopupNonImplemente(controleur, controleur.getFenetrePrincipale(), contenu).setVisible(true);
	}

	// Les méthodes suivantes gèrent la modification du modèle

	public void deplacementDeBoites(double dx, double dy, List<String> deplacees) {
		getModele().deplacementDeBoites(dx, dy, deplacees);
	}

	public boolean creerClasse(Stereotype stereotype, String nom, int x, int y) {
		return ((DiagrammeClasses) getModele()).creerClasse(stereotype, nom, x, y);
	}

	public boolean creerObjet(Classe classe, String nom, int x, int y) {
		return ((DiagrammeObjets) getModele()).creerObjet(classe, nom, x, y);
	}
}
