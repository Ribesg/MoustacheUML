package fr.ribesg.imag.moustacheuml.modele.boite;

public class Attribut implements Visible {

	private String nom;
	private Type type;
	private Visibilite visibilite;

	public Attribut(String nom, Type type, Visibilite visibilite) {
		this.nom = nom;
		this.type = type;
		this.visibilite = visibilite;
	}

	public void setVisibilite(Visibilite visibilite) {
		this.visibilite = visibilite;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public Visibilite getVisibilite() {
		return visibilite;
	}
}
