package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Aggregation extends LienAvecCardinalite {

	public Aggregation(Boite source, Boite destination, Navigabilite navigabilite) {
		super(source, destination, TypeLien.AGGREGATION, navigabilite);
	}

	public Aggregation(Classe source, Classe destination, Cardinalite cardinaliteSource, Cardinalite cardinaliteDestination, String rôleSource, String rôleDestination, Navigabilite navigabilite) {
		super(source, destination, TypeLien.AGGREGATION, cardinaliteSource, cardinaliteDestination, rôleSource, rôleDestination, navigabilite);
	}
}
