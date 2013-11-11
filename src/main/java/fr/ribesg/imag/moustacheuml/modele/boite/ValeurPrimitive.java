package fr.ribesg.imag.moustacheuml.modele.boite;

public class ValeurPrimitive implements Valeur {

	private String valeur;

	public ValeurPrimitive(String valeur) {
		this.valeur = valeur;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
}
