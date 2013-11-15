package fr.ribesg.imag.moustacheuml.controleur;

import fr.ribesg.imag.moustacheuml.modele.DiagrammeClasses;
import fr.ribesg.imag.moustacheuml.modele.DiagrammeObjets;
import fr.ribesg.imag.moustacheuml.vue.popup.PopupNonImplemente;

public class ControleurMenu {

	private final Controleur controleur;

	public ControleurMenu(Controleur controleur) {
		this.controleur = controleur;
	}

	public void menuNouveauClasse() {
		this.controleur.nouvelEspaceDeTravail("Nouveau Diagramme de Classe", new DiagrammeClasses());
	}

	public void menuNouveauObjets() {
		this.controleur.nouvelEspaceDeTravail("Nouveau Diagramme d'Objets", new DiagrammeObjets());
	}

	public void menuOuvrir() {
		nonImplemente("La fonction de chargement n'est pas encore implémentée.");
	}

	public void menuEnregistrer() {
		nonImplemente("La fonction de sauvegarde n'est pas encore implémentée.");
	}

	public void menuQuitter() {
		// TODO Gestion de la sauvegarde avant fermeture
		controleur.quitter();
	}

	private void nonImplemente(String contenu) {
		new PopupNonImplemente(controleur, controleur.getFenetrePrincipale(), contenu).setVisible(true);
	}
}
