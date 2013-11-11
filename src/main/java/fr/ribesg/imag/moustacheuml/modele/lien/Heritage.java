package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Heritage extends LienSansCardinalite {

	protected Heritage(Classe source, Classe destination) {
		super(source, destination, TypeLien.HERITAGE, Navigabilite.SOURCE_DESTINATION);
	}
}
