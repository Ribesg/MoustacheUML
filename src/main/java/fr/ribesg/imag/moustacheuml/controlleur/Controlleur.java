package fr.ribesg.imag.moustacheuml.controlleur;

import fr.ribesg.imag.moustacheuml.vue.FenetrePrincipale;

public class Controlleur {

	private final FenetrePrincipale fenetrePrincipale;

	public Controlleur() {
		this.fenetrePrincipale = new FenetrePrincipale(this);
	}

	public void montrerFenetrePrincipale() {
		this.fenetrePrincipale.setVisible(true);
	}

	public void cacherFenetrePrincipale() {
		this.fenetrePrincipale.setVisible(false);
	}

	public void quitter() {
		this.fenetrePrincipale.dispose();
		System.exit(0);
	}
}
