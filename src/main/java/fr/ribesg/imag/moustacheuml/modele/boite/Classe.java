package fr.ribesg.imag.moustacheuml.modele.boite;

public class Classe extends Boite implements Type, Visible {

	private String nom;
	private Visibilite visibilite;

	public Classe(String nom, Visibilite visibilite) {
		this.nom = nom;
		this.visibilite = visibilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setVisibilite(Visibilite visibilite) {
		this.visibilite = visibilite;
	}

	@Override
	public Visibilite getVisibilite() {
		return visibilite;
	}
}
