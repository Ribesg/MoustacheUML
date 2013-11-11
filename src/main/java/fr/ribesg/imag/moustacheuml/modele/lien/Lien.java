package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;

/**
 * Cette classe représente un lien entre deux boites.
 */
public abstract class Lien {

	private final Boite source;

	private final Boite destination;

	private Navigabilite navigabilite;

	private final TypeLien type;

	/**
	 * Permet de construire un lien "simple", sans cardinalité ni rôle.
	 * Principalement utilisé par la classe Objet.
	 *
	 * @param source       source du lien
	 * @param destination  destination du lien
	 * @param type         type tu lien
	 * @param navigabilite navigabilité du lien
	 */
	protected Lien(Boite source, Boite destination, TypeLien type, Navigabilite navigabilite) {
		this.source = source;

		this.destination = destination;

		this.type = type;

		this.navigabilite = navigabilite;
	}

	public Boite getSource() {
		return source;
	}

	public Boite getDestination() {
		return destination;
	}

	public TypeLien getType() {
		return type;
	}

	public Navigabilite getNavigabilite() {
		return navigabilite;
	}

	public void setNavigabilite(Navigabilite navigabilite) {
		this.navigabilite = navigabilite;
	}
}
