package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controleur.ControleurEspaceDeTravail;
import fr.ribesg.imag.moustacheuml.modele.Diagramme;
import fr.ribesg.imag.moustacheuml.vue.jgraphx.SwingGraph;
import fr.ribesg.imag.moustacheuml.vue.popup.PopupCreerClasse;
import fr.ribesg.imag.moustacheuml.vue.popup.PopupCreerObjet;

import javax.swing.*;
import java.awt.*;

public class VueGraphique extends JPanel {

	private final ControleurEspaceDeTravail controleur;
	private final Diagramme modele;

	private final SwingGraph graph;

	public VueGraphique(ControleurEspaceDeTravail controleur, Diagramme modele) {
		this.controleur = controleur;
		this.controleur.setVue(this);

		this.modele = modele;
		this.modele.setObservateur(this);

		this.graph = new SwingGraph(controleur);

		this.setLayout(new BorderLayout());
		this.add(graph, BorderLayout.CENTER);

		afficher(modele);
	}

	public void mettreAJour() {
		afficher(modele);
	}

	public void afficher(Diagramme diagramme) {
		this.graph.afficherDiagramme(diagramme);
	}

	public void afficherMenuContextuel(int x, int y, JPopupMenu menu) {
		menu.show(this, x, y);
	}

	public void afficherCreerUneClasse(int x, int y) {
		new PopupCreerClasse(controleur, controleur.getControleur().getFenetrePrincipale(), x, y).setVisible(true);
	}

	public void afficherCreerUnObjet(int x, int y) {
		new PopupCreerObjet(controleur, controleur.getControleur().getFenetrePrincipale(), x, y).setVisible(true);
	}
}
