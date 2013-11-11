package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;

public class LienSansCardinalite extends Lien {

	/**
	 * Permet de construire un lien sans cardinalité ni rôle.
	 *
	 * @param source       source du lien
	 * @param destination  destination du lien
	 * @param type         type du lien
	 * @param navigabilite navigabilité du lien
	 */
	protected LienSansCardinalite(Boite source, Boite destination, TypeLien type, Navigabilite navigabilite) {
		super(source, destination, type, navigabilite);
	}
}
