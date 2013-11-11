package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class Implementation extends LienSansCardinalite {

	protected Implementation(Classe source, Classe destination) {
		super(source, destination, TypeLien.IMPLEMENTATION, Navigabilite.SOURCE_DESTINATION);
	}
}
