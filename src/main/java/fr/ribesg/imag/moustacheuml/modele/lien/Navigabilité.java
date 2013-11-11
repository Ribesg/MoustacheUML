package fr.ribesg.imag.moustacheuml.modele.lien;

public enum Navigabilité {

	/**
	 * Navigabilité dans les deux sens
	 */
	BIDIRECTIONELLE,

	/**
	 * Navigabilité "naturelle"
	 */
	SOURCE_DESTINATION,

	/**
	 * Navigabilité utilisée lorsqu'un lien navigable dans un seul sens
	 * est modifié et que sa navigabilité est inversée
	 */
	DESTINATION_SOURCE
}
