package fr.ribesg.imag.moustacheuml.modele;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.lien.Lien;
import fr.ribesg.imag.moustacheuml.vue.VueGraphique;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Cette classe représente une diagramme : un ensemble de boites et de liens.
 */
public abstract class Diagramme {

	private final Set<Boite> boites;
	private final Set<Lien> liens;

	private VueGraphique observateur;

	protected Diagramme() {
		this.boites = new HashSet<>();
		this.liens = new HashSet<>();
	}

	public Set<Boite> getBoites() {
		return boites;
	}

	public Set<Lien> getLiens() {
		return liens;
	}

	public void setObservateur(VueGraphique observateur) {
		this.observateur = observateur;
	}

	public void notifierChangements() {
		this.observateur.mettreAJour();
	}

	public void deplacementDeBoites(double dx, double dy, List<String> deplacees) {
		for (Boite boite : boites) {
			for (String deplacee : deplacees) {
				if (boite.getId().equals(deplacee)) {
					boite.deplacer(dx, dy);
					break;
				}
			}
		}
	}

	public abstract boolean estObjets();

	public abstract boolean estClasses();
}
