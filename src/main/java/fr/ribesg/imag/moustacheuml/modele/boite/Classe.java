package fr.ribesg.imag.moustacheuml.modele.boite;

import java.util.ArrayList;
import java.util.List;

public class Classe extends Boite implements Type {
	private Stereotype stereotype;
	private List<Attribut> attributs;
	private List<Methode> methodes;

	public Classe(float posX, float posY, String nom) {
		super(posX, posY, nom);
		this.attributs = new ArrayList<>();
		this.methodes = new ArrayList<>();
	}

	public Stereotype getStereotype() {
		return stereotype;
	}

	public void setStereotype(Stereotype stereotype) {
		this.stereotype = stereotype;
	}

	public List<Attribut> getAttributs() {
		return attributs;
	}

	public List<Methode> getMethodes() {
		return methodes;
	}

	@Override
	public String[] getChaines() {
		final String[] resultat = new String[3];
		if (getStereotype() == null) {
			resultat[0] = "";
		} else {
			resultat[0] = "<<" + getStereotype().name().toLowerCase() + ">>\n";
		}
		resultat[0] += getNom();

		if (attributs.isEmpty()) {
			resultat[1] = "";
		} else {
			resultat[1] = attributs.get(0).getChaine();
			for (int i = 1; i < attributs.size(); i++) {
				resultat[1] += '\n' + attributs.get(i).getChaine();
			}
		}

		if (methodes.isEmpty()) {
			resultat[2] = "";
		} else {
			resultat[2] = methodes.get(0).getChaine();
			for (int i = 1; i < methodes.size(); i++) {
				resultat[2] += '\n' + methodes.get(i).getChaine();
			}
		}

		return resultat;
	}

	@Override
	public String getId() {
		return "Classe=" + getNom();
	}

	@Override
	public String getChaine() {
		return getNom();
	}

	@Override
	public boolean estClasse() {
		return true;
	}

	@Override
	public boolean estObjet() {
		return false;
	}
}
