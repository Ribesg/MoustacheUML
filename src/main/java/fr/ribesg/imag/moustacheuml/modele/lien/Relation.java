package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Relation extends Lien {

	public Relation(Boite source, Boite destination, Navigabilite navigabilite) {
		super(source, destination, navigabilite);
	}

	public Relation(Classe source, Classe destination, Cardinalite cardinaliteSource, Cardinalite cardinaliteDestination, String rôleSource, String rôleDestination, Navigabilite navigabilite) {
		super(source, destination, cardinaliteSource, cardinaliteDestination, rôleSource, rôleDestination, navigabilite);
	}
}
