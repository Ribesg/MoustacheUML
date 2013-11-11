package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Composition extends Lien {

	public Composition(Boite source, Boite destination, Navigabilité navigabilité) {
		super(source, destination, navigabilité);
	}

	public Composition(Classe source, Classe destination, Cardinalité cardinalitéSource, Cardinalité cardinalitéDestination, String rôleSource, String rôleDestination, Navigabilité navigabilité) {
		super(source, destination, cardinalitéSource, cardinalitéDestination, rôleSource, rôleDestination, navigabilité);
	}
}
