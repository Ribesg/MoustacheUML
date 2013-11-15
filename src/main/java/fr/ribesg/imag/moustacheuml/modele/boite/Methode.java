package fr.ribesg.imag.moustacheuml.modele.boite;

import java.util.List;

public class Methode implements Visible {

	private String nom;
	private Type typeRetour;
	private List<Parametre> parametres;

	private Visibilite visibilite;

	public Methode(String nom, List<Parametre> parametres, Type typeRetour, Visibilite visibilite) {
		this.nom = nom;
		this.parametres = parametres;
		this.typeRetour = typeRetour;
		this.visibilite = visibilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Parametre> getParametres() {
		return parametres;
	}

	public void setParametres(List<Parametre> parametres) {
		this.parametres = parametres;
	}

	public Type getTypeRetour() {
		return typeRetour;
	}

	public void setTypeRetour(Type typeRetour) {
		this.typeRetour = typeRetour;
	}

	public void setVisibilite(Visibilite visibilite) {
		this.visibilite = visibilite;
	}

	@Override
	public Visibilite getVisibilite() {
		return visibilite;
	}

	public String getChaine() {
		final StringBuilder resultat = new StringBuilder();
		resultat.append(getVisibilite().getCaractere());
		resultat.append(' ');
		resultat.append(getNom());
		resultat.append('(');
		if (parametres != null && !parametres.isEmpty()) {
			final Parametre premierParametre = parametres.get(0);
			resultat.append(premierParametre.getNom()).append(" : ").append(premierParametre.getType().getChaine());
			for (int i = 1; i < parametres.size(); i++) {
				resultat.append(", ").append(premierParametre.getNom()).append(" : ").append(premierParametre.getType().getChaine());
			}
		}
		resultat.append(") : ");
		resultat.append(getTypeRetour() == null ? "void" : getTypeRetour().getChaine());
		return resultat.toString();
	}
}
