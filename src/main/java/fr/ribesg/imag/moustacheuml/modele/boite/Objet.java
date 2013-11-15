package fr.ribesg.imag.moustacheuml.modele.boite;

import java.util.List;

public class Objet extends Boite implements Valeur {

	private Classe classe;
	private List<AttributValue> attributsValues;

	public Objet(float posX, float posY, List<AttributValue> attributsValues, Classe classe, String nom) {
		super(posX, posY, nom);
		this.attributsValues = attributsValues;
		this.classe = classe;
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

	@Override
	public String getValeur() {
		return getNom();
	}

	@Override
	public String[] getChaines() {
		final String[] resultat = new String[2];
		resultat[0] = getNom() + " : " + (getClasse() == null ? "null" : getClasse().getChaine());

		if (attributsValues == null || attributsValues.isEmpty()) {
			resultat[1] = "";
		} else {
			resultat[1] = attributsValues.get(0).getChaine();
			for (int i = 1; i < attributsValues.size(); i++) {
				resultat[1] += '\n' + attributsValues.get(i).getChaine();
			}
		}

		return resultat;
	}

	@Override
	public String getId() {
		return "Objet=" + getNom() + ";" + (getClasse() == null ? "null" : getClasse().getId());
	}

	@Override
	public boolean estClasse() {
		return false;
	}

	@Override
	public boolean estObjet() {
		return true;
	}
}
