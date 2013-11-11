package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Relation extends LienAvecCardinalite {

	public Relation(Boite source, Boite destination, Navigabilite navigabilite) {
		super(source, destination, TypeLien.RELATION, navigabilite);
	}

	public Relation(Classe source, Classe destination, Cardinalite cardinaliteSource, Cardinalite cardinaliteDestination, String rôleSource, String rôleDestination, Navigabilite navigabilite) {
		super(source, destination, TypeLien.RELATION, cardinaliteSource, cardinaliteDestination, rôleSource, rôleDestination, navigabilite);
	}
}
