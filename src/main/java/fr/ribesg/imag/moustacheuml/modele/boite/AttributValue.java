package fr.ribesg.imag.moustacheuml.modele.boite;

public class AttributValue {

	private final Attribut attribut;
	private final Valeur valeur;

	public AttributValue(Attribut attribut, Valeur valeur) {
		this.attribut = attribut;
		this.valeur = valeur;
	}

	public Attribut getAttribut() {
		return attribut;
	}

	public Valeur getValeur() {
		return valeur;
	}

	public String getChaine() {
		return attribut.getNom() + " = " + valeur.getValeur();
	}
}
