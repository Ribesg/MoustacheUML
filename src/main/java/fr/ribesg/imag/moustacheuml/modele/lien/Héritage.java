package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Héritage extends Lien {

	protected Héritage(Classe source, Classe destination) {
		super(source, destination, null, null, null, null, Navigabilité.SOURCE_DESTINATION);
	}
}
