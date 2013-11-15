package fr.ribesg.imag.moustacheuml.controleur;

import fr.ribesg.imag.moustacheuml.modele.Diagramme;
import fr.ribesg.imag.moustacheuml.vue.FenetrePrincipale;
import fr.ribesg.imag.moustacheuml.vue.VueGraphique;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controleur {

	private final FenetrePrincipale fenetrePrincipale;

	private final ControleurMenu controleurMenu;
	private final List<ControleurEspaceDeTravail> controleursEspacesDeTravail;

	public Controleur() {
		this.controleurMenu = new ControleurMenu(this);
		this.controleursEspacesDeTravail = new ArrayList<>();

		this.fenetrePrincipale = new FenetrePrincipale(this);
	}

	public ControleurMenu getControleurMenu() {
		return controleurMenu;
	}

	public List<ControleurEspaceDeTravail> getControleursEspacesDeTravail() {
		return controleursEspacesDeTravail;
	}

	public void montrerFenetrePrincipale() {
		this.fenetrePrincipale.setVisible(true);
	}

	public void cacherFenetrePrincipale() {
		this.fenetrePrincipale.setVisible(false);
	}

	public FenetrePrincipale getFenetrePrincipale() {
		return fenetrePrincipale;
	}

	public void erreur(String message) {
		fenetrePrincipale.getVueBarreDeStatut().setText(message);
		fenetrePrincipale.getVueBarreDeStatut().setForeground(Color.RED);
	}

	public void quitter() {
		this.fenetrePrincipale.dispose();
		System.exit(0);
	}

	public ControleurEspaceDeTravail nouvelEspaceDeTravail(String nom, Diagramme diagramme) {
		ControleurEspaceDeTravail controleurEspaceDeTravail = new ControleurEspaceDeTravail(this, diagramme);
		controleursEspacesDeTravail.add(controleurEspaceDeTravail);
		fenetrePrincipale.getVueEspacesDeTravail().addTab(nom, new VueGraphique(controleurEspaceDeTravail, diagramme));
		return controleurEspaceDeTravail;
	}
}
