package fr.ribesg.imag.moustacheuml.modele.lien;

/**
 * Cette classe représente une cardinalité qui pourra être associée à un lien.
 */
public abstract class Cardinalité {

	/**
	 * On aura besoin de cette méthode standard dans la Vue.
	 * On la met ici, en abstrait, pour forcer les sous-classes à
	 * l'implémenter.
	 *
	 * @return une chaine représentant cette Cardinalité
	 */
	@Override
	public abstract String toString();
}
