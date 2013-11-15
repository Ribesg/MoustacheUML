package fr.ribesg.imag.moustacheuml.modele.boite;

public enum TypePrimitif implements Type {

	ENTIER,
	REEL,
	BOOLEEN,
	CHAINE;

	@Override
	public String getChaine() {
		return this.name().toLowerCase();
	}
}
