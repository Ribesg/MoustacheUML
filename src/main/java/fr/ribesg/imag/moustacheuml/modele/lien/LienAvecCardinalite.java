package fr.ribesg.imag.moustacheuml.modele.lien;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;

public class LienAvecCardinalite extends Lien {

	private Cardinalite cardinaliteSource;
	private String roleSource;

	private Cardinalite cardinaliteDestination;
	private String roleDestination;

	/**
	 * Permet de construire un lien "simple", sans cardinalité ni rôle.
	 * Principalement utilisé par la classe Objet.
	 *
	 * @param source       source du lien
	 * @param destination  destination du lien
	 * @param navigabilite navigabilité du lien
	 */
	protected LienAvecCardinalite(Boite source, Boite destination, TypeLien type, Navigabilite navigabilite) {
		super(source, destination, type, navigabilite);

		this.cardinaliteSource = null;
		this.roleSource = null;

		this.cardinaliteDestination = null;
		this.roleDestination = null;
	}

	/**
	 * Permet de construire un lien "simple", sans cardinalité ni rôle.
	 * Principalement utilisé par la classe Objet.
	 *
	 * @param source            source du lien
	 * @param destination       destination du lien
	 * @param type              type du lien
	 * @param cardinaliteSource cardinalité coté Source
	 * @param roleSource        rôle coté Source
	 * @param navigabilite      navigabilité du lien
	 */
	protected LienAvecCardinalite(Classe source, Classe destination, TypeLien type, Cardinalite cardinaliteSource, String roleSource, Navigabilite navigabilite) {
		super(source, destination, type, navigabilite);

		this.cardinaliteSource = cardinaliteSource;
		this.roleSource = roleSource;

		this.cardinaliteDestination = null;
		this.roleDestination = null;
	}

	/**
	 * Permet de construire un lien "simple", sans cardinalité ni rôle.
	 * Principalement utilisé par la classe Objet.
	 *
	 * @param source                 source du lien
	 * @param destination            destination du lien
	 * @param type                   type du lien
	 * @param cardinaliteSource      cardinalité coté Source
	 * @param roleSource             rôle coté Source
	 * @param cardinaliteDestination cardinalité coté Destination
	 * @param roleDestination        rôle coté Destination
	 * @param navigabilite           navigabilité du lien
	 */
	protected LienAvecCardinalite(Classe source, Classe destination, TypeLien type, Cardinalite cardinaliteSource, Cardinalite cardinaliteDestination, String roleSource, String roleDestination, Navigabilite navigabilite) {
		super(source, destination, type, navigabilite);

		this.cardinaliteSource = cardinaliteSource;
		this.roleSource = roleSource;

		this.cardinaliteDestination = cardinaliteDestination;
		this.roleDestination = roleDestination;
	}


	public Cardinalite getCardinaliteSource() {
		return cardinaliteSource;
	}

	public void setCardinaliteSource(Cardinalite cardinaliteSource) {
		this.cardinaliteSource = cardinaliteSource;
	}

	public String getRoleSource() {
		return roleSource;
	}

	public void setRoleSource(String rôleSource) {
		this.roleSource = rôleSource;
	}

	public Cardinalite getCardinaliteDestination() {
		return cardinaliteDestination;
	}

	public void setCardinaliteDestination(Cardinalite cardinaliteDestination) {
		this.cardinaliteDestination = cardinaliteDestination;
	}

	public String getRoleDestination() {
		return roleDestination;
	}

	public void setRoleDestination(String rôleDestination) {
		this.roleDestination = rôleDestination;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (cardinaliteSource != null ? cardinaliteSource.hashCode() : 0);
		result = 31 * result + (roleSource != null ? roleSource.hashCode() : 0);
		result = 31 * result + (cardinaliteDestination != null ? cardinaliteDestination.hashCode() : 0);
		result = 31 * result + (roleDestination != null ? roleDestination.hashCode() : 0);
		return result;
	}
}