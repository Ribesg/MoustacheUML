package fr.ribesg.imag.moustacheuml.modele;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;
import fr.ribesg.imag.moustacheuml.modele.boite.Stereotype;

import java.util.HashSet;
import java.util.Set;

public class DiagrammeClasses extends Diagramme {

	private Set<DiagrammeObjets> diagrammesObjets;

	public DiagrammeClasses() {
		super();
		this.diagrammesObjets = new HashSet<>();
	}

	@Override
	public boolean estObjets() {
		return false;
	}

	@Override
	public boolean estClasses() {
		return true;
	}

	public boolean creerClasse(Stereotype stereotype, String nom, int x, int y) {
		if (nom == null || nom.isEmpty()) {
			return false;
		}
		for (Boite b : getBoites()) {
			if (b.getNom().equalsIgnoreCase(nom)) {
				return false;
			}
		}
		Classe classe = new Classe(x, y, nom);
		classe.setStereotype(stereotype);
		getBoites().add(classe);
		notifierChangements();
		return true;
	}

	public Set<DiagrammeObjets> getDiagrammesObjets() {
		return diagrammesObjets;
	}
}
