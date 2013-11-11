package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Composition extends LienAvecCardinalite {

	public Composition(Boite source, Boite destination, Navigabilite navigabilite) {
		super(source, destination, TypeLien.COMPOSITION, navigabilite);
	}

	public Composition(Classe source, Classe destination, Cardinalite cardinaliteSource, Cardinalite cardinaliteDestination, String rôleSource, String rôleDestination, Navigabilite navigabilite) {
		super(source, destination, TypeLien.COMPOSITION, cardinaliteSource, cardinaliteDestination, rôleSource, rôleDestination, navigabilite);
	}
}
