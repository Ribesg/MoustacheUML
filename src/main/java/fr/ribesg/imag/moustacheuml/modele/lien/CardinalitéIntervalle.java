package fr.ribesg.imag.moustacheuml.modele.lien;

import java.util.regex.Pattern;

/**
 * Cette classe représente la cardinalité "1..2" ou "2..*".
 */
public class CardinalitéIntervalle extends Cardinalité {

	/**
	 * Cette expression régulière correspond à une chaine strictement égale à
	 * "*" OU à une chaine contenant n'importe quel nombre positif ou nul.
	 */
	private static final Pattern regexBorneSupérieure = Pattern.compile("^(\\*|\\d+)$");

	/**
	 * Une borne inférieure est toujours un nombre, positif.
	 */
	private final int borneInférieure;

	/**
	 * Une borne supérieure peut être un nombre ou "*".
	 */
	private final String borneSupérieure;

	public CardinalitéIntervalle(int borneInférieure, String borneSupérieure) {
		if (borneInférieure < 0 || borneSupérieure == null || !regexBorneSupérieure.matcher(borneSupérieure).matches()) {
			throw new IllegalArgumentException("L'une des borne au moins est incorrecte.");
		} else if (!"*".equals(borneSupérieure) && Integer.parseInt(borneSupérieure) < borneInférieure) {
			throw new IllegalArgumentException("Contrainte non respectée : borneSupérieure < borneInférieure");
		}
		this.borneInférieure = borneInférieure;
		this.borneSupérieure = borneSupérieure;
	}

	@Override
	public String toString() {
		return Integer.toString(borneInférieure) + ".." + borneSupérieure;
	}
}
