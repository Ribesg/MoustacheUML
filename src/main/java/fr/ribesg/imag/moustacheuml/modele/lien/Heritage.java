package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Heritage extends Lien {

	protected Heritage(Classe source, Classe destination) {
		super(source, destination, null, null, null, null, Navigabilite.SOURCE_DESTINATION);
	}
}
