package fr.ribesg.imag.moustacheuml.modele.boite;

import java.util.List;

public class Objet extends Boite implements Valeur {

	private Classe classe;
	private String nom;
	private List<AttributValue> attributsValues;

	public Objet(List<AttributValue> attributsValues, Classe classe, String nom) {
		this.attributsValues = attributsValues;
		this.classe = classe;
		this.nom = nom;
	}

	public List<AttributValue> getAttributsValues() {
		return attributsValues;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String getValeur() {
		return this.getNom();
	}
}
