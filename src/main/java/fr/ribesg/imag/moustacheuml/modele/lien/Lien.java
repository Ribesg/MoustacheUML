package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

/**
 * Cette classe représente un lien entre deux boites.
 */
public abstract class Lien {

	private final Boite source;
	private Cardinalite cardinaliteSource;
	private String rôleSource;

	private final Boite destination;
	private Cardinalite cardinaliteDestination;
	private String rôleDestination;

	private Navigabilite navigabilite;

	/**
	 * Permet de construire un lien "simple", sans cardinalité ni rôle.
	 * Principalement utilisé par la classe Objet.
	 *
	 * @param source       source du lien
	 * @param destination  destination du lien
	 * @param navigabilite navigabilité du lien
	 */
	protected Lien(Boite source, Boite destination, Navigabilite navigabilite) {
		this.source = source;
		this.cardinaliteSource = null;
		this.rôleSource = null;

		this.destination = destination;
		this.cardinaliteDestination = null;
		this.rôleDestination = null;

		this.navigabilite = navigabilite;
	}

	/**
	 * Permet de construire un lien plus complexe, avec potentiellement
	 * cardinalités et rôles de chaque coté du lien.
	 * Ne peut être utilisé par la classe Objet.
	 *
	 * @param source                 source du lien
	 * @param destination            destination du lien
	 * @param cardinaliteSource      cardinalité au niveau de la source du
	 *                               lien
	 * @param cardinaliteDestination cardinalité au niveau de la destination
	 *                               du lien
	 * @param rôleSource             rôle au niveau de la source du lien
	 * @param rôleDestination        rôle au niveau de la destination du
	 *                               lien
	 * @param navigabilite           navigabilité du lien
	 */
	protected Lien(Classe source, Classe destination, Cardinalite cardinaliteSource, Cardinalite cardinaliteDestination, String rôleSource, String rôleDestination, Navigabilite navigabilite) {
		this.source = source;
		this.cardinaliteSource = cardinaliteSource;
		this.rôleSource = rôleSource;

		this.destination = destination;
		this.cardinaliteDestination = cardinaliteDestination;
		this.rôleDestination = rôleDestination;

		this.navigabilite = navigabilite;
	}

	public Boite getSource() {
		return source;
	}

	public Cardinalite getCardinaliteSource() {
		return cardinaliteSource;
	}

	public void setCardinaliteSource(Cardinalite cardinaliteSource) {
		this.cardinaliteSource = cardinaliteSource;
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

	public Cardinalite getCardinaliteDestination() {
		return cardinaliteDestination;
	}

	public void setCardinaliteDestination(Cardinalite cardinaliteDestination) {
		this.cardinaliteDestination = cardinaliteDestination;
	}

	public String getRôleDestination() {
		return rôleDestination;
	}

	public void setRôleDestination(String rôleDestination) {
		this.rôleDestination = rôleDestination;
	}

	public Navigabilite getNavigabilite() {
		return navigabilite;
	}

	public void setNavigabilite(Navigabilite navigabilite) {
		this.navigabilite = navigabilite;
	}
}
