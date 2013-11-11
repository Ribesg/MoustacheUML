package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

/**
 * Cette classe représente un lien entre deux boites.
 */
public abstract class Lien {

	private final Boite source;
	private Cardinalité cardinalitéSource;
	private String rôleSource;

	private final Boite destination;
	private Cardinalité cardinalitéDestination;
	private String rôleDestination;

	private Navigabilité navigabilité;

	/**
	 * Permet de construire un lien "simple", sans cardinalité ni rôle.
	 * Principalement utilisé par la classe Objet.
	 *
	 * @param source       source du lien
	 * @param destination  destination du lien
	 * @param navigabilité navigabilité du lien
	 */
	protected Lien(Boite source, Boite destination, Navigabilité navigabilité) {
		this.source = source;
		this.cardinalitéSource = null;
		this.rôleSource = null;

		this.destination = destination;
		this.cardinalitéDestination = null;
		this.rôleDestination = null;

		this.navigabilité = navigabilité;
	}

	/**
	 * Permet de construire un lien plus complexe, avec potentiellement
	 * cardinalités et rôles de chaque coté du lien.
	 * Ne peut être utilisé par la classe Objet.
	 *
	 * @param source                 source du lien
	 * @param destination            destination du lien
	 * @param cardinalitéSource      cardinalité au niveau de la source du
	 *                               lien
	 * @param cardinalitéDestination cardinalité au niveau de la destination
	 *                               du lien
	 * @param rôleSource             rôle au niveau de la source du lien
	 * @param rôleDestination        rôle au niveau de la destination du
	 *                               lien
	 * @param navigabilité           navigabilité du lien
	 */
	protected Lien(Classe source, Classe destination, Cardinalité cardinalitéSource, Cardinalité cardinalitéDestination, String rôleSource, String rôleDestination, Navigabilité navigabilité) {
		this.source = source;
		this.cardinalitéSource = cardinalitéSource;
		this.rôleSource = rôleSource;

		this.destination = destination;
		this.cardinalitéDestination = cardinalitéDestination;
		this.rôleDestination = rôleDestination;

		this.navigabilité = navigabilité;
	}

	public Boite getSource() {
		return source;
	}

	public Cardinalité getCardinalitéSource() {
		return cardinalitéSource;
	}

	public void setCardinalitéSource(Cardinalité cardinalitéSource) {
		this.cardinalitéSource = cardinalitéSource;
	}

	public String getRôleSource() {
		return rôleSource;
	}

	public void setRôleSource(String rôleSource) {
		this.rôleSource = rôleSource;
	}

	public Boite getDestination() {
		return destination;
	}

	public Cardinalité getCardinalitéDestination() {
		return cardinalitéDestination;
	}

	public void setCardinalitéDestination(Cardinalité cardinalitéDestination) {
		this.cardinalitéDestination = cardinalitéDestination;
	}

	public String getRôleDestination() {
		return rôleDestination;
	}

	public void setRôleDestination(String rôleDestination) {
		this.rôleDestination = rôleDestination;
	}

	public Navigabilité getNavigabilité() {
		return navigabilité;
	}

	public void setNavigabilité(Navigabilité navigabilité) {
		this.navigabilité = navigabilité;
	}
}
