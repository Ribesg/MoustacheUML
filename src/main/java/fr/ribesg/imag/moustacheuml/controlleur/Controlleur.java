package fr.ribesg.imag.moustacheuml.controlleur;

import fr.ribesg.imag.moustacheuml.vue.FenêtrePrincipale;

public class Controlleur {

	private final FenêtrePrincipale fenêtrePrincipale;

	public Controlleur() {
		this.fenêtrePrincipale = new FenêtrePrincipale(this);
	}

	public void montrerFenêtrePrincipale() {
		this.fenêtrePrincipale.setVisible(true);
	}

	public void cacherFenêtrePrincpale() {
		this.fenêtrePrincipale.setVisible(false);
	}

	public void quitter() {
		this.fenêtrePrincipale.dispose();
		System.exit(0);
	}
}
