package fr.ribesg.imag.moustacheuml.modele.boite;

public class Parametre {

	private String nom;
	private Type type;

	public Parametre(String nom, Type type) {
		this.nom = nom;
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
