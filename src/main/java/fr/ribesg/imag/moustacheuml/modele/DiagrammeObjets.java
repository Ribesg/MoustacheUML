package fr.ribesg.imag.moustacheuml.modele;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;
import fr.ribesg.imag.moustacheuml.modele.boite.Objet;

public class DiagrammeObjets extends Diagramme {

	private DiagrammeClasses diagrammeClasses;

	public DiagrammeObjets() {
		this.diagrammeClasses = null;
	}

	public DiagrammeObjets(DiagrammeClasses diagrammeClasses) {
		this.diagrammeClasses = diagrammeClasses;
	}

	public DiagrammeClasses getDiagrammeClasses() {
		return diagrammeClasses;
	}

	@Override
	public boolean estObjets() {
		return true;
	}

	@Override
	public boolean estClasses() {
		return false;
	}

	public boolean creerObjet(Classe classe, String nom, int x, int y) {
		if (nom == null || nom.isEmpty()) {
			return false;
		}
		for (Boite b : getBoites()) {
			if (b.getNom().equalsIgnoreCase(nom)) {
				return false;
			}
		}
		Objet objet = new Objet(x, y, null, classe, nom);
		getBoites().add(objet);
		notifierChangements();
		return true;
	}
}
