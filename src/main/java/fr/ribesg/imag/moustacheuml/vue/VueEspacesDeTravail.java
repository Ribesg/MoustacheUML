package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controleur.Controleur;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VueEspacesDeTravail extends JTabbedPane {

	private final List<VueGraphique> espacesDeTravail;
	private int espaceDeTravailCourant;

	private final Controleur controleur;

	public VueEspacesDeTravail(Controleur controleur) {
		this.controleur = controleur;
		this.espacesDeTravail = new ArrayList<>();
		this.espaceDeTravailCourant = -1;
	}
}
