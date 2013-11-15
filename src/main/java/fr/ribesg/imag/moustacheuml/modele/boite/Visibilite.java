package fr.ribesg.imag.moustacheuml.modele.boite;

public enum Visibilite {
	PAQUETAGE('~'),
	PRIVE('-'),
	PROTEGE('#'),
	PUBLIC('+');

	private final char caractere;

	private Visibilite(char caractere) {
		this.caractere = caractere;
	}

	public char getCaractere() {
		return caractere;
	}
}
