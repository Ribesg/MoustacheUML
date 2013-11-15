package fr.ribesg.imag.moustacheuml.utils;

/**
 * On se sert de cette classe pour créer des identifiants de cellules
 * permettant de savoir de quel type elles sont.
 * Le fait qu'on doive utiliser un tel système vient d'une limitation
 * de la librairie JGraphX, et non d'un choix d'implémentation.
 */
public class IdUtils {

	private static final char SEPARATOR = '.';
	private static final char PREFIX_ATTRIBUT = 'A';
	private static final char PREFIX_BOITE = 'B';
	private static final char PREFIX_LIEN = 'L';
	private static final char PREFIX_METHODE = 'M';

	public static String prefixeAttribut(String aPrefixer) {
		return "" + PREFIX_ATTRIBUT + SEPARATOR + aPrefixer;
	}

	public static String prefixeBoite(String aPrefixer) {
		return "" + PREFIX_BOITE + SEPARATOR + aPrefixer;
	}

	public static String prefixeLien(String aPrefixer) {
		return "" + PREFIX_LIEN + SEPARATOR + aPrefixer;
	}

	public static String prefixeMethode(String aPrefixer) {
		return "" + PREFIX_METHODE + SEPARATOR + aPrefixer;
	}

	public static boolean estAttribut(String id) {
		return id != null && id.startsWith(Character.toString(PREFIX_ATTRIBUT) + SEPARATOR);
	}

	public static boolean estBoite(String id) {
		return id != null && id.startsWith(Character.toString(PREFIX_BOITE) + SEPARATOR);
	}

	public static boolean estLien(String id) {
		return id != null && id.startsWith(Character.toString(PREFIX_LIEN) + SEPARATOR);
	}

	public static boolean estMethode(String id) {
		return id != null && id.startsWith(Character.toString(PREFIX_METHODE) + SEPARATOR);
	}

	public static String deprefixe(String id) {
		return id == null ? null : id.substring(2);
	}
}
