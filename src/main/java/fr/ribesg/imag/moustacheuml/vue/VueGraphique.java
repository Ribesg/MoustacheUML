package fr.ribesg.imag.moustacheuml.vue;

import fr.ribesg.imag.moustacheuml.controleur.ControleurEspaceDeTravail;
import fr.ribesg.imag.moustacheuml.modele.Diagramme;
import fr.ribesg.imag.moustacheuml.modele.DiagrammeClasses;
import fr.ribesg.imag.moustacheuml.modele.boite.*;
import fr.ribesg.imag.moustacheuml.modele.lien.*;
import fr.ribesg.imag.moustacheuml.vue.jgraphx.SwingGraph;
import fr.ribesg.imag.moustacheuml.vue.popup.PopupCreerClasse;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

	// TODO TO BE REMOVED
	public Diagramme test() {
		Diagramme diagramme = new DiagrammeClasses();

		Classe classe1 = new Classe(0, 0, "Voiture");

		classe1.getAttributs().add(new Attribut("uneChaine", TypePrimitif.CHAINE, Visibilite.PRIVE));
		classe1.getAttributs().add(new Attribut("unEntier", TypePrimitif.ENTIER, Visibilite.PROTEGE));
		classe1.getAttributs().add(new Attribut("unBooleen", TypePrimitif.BOOLEEN, Visibilite.PAQUETAGE));
		classe1.getAttributs().add(new Attribut("unReel", TypePrimitif.REEL, Visibilite.PUBLIC));

		classe1.getMethodes().add(new Methode("getUneChaine", null, TypePrimitif.CHAINE, Visibilite.PRIVE));
		classe1.getMethodes().add(new Methode("getUnEntier", null, TypePrimitif.ENTIER, Visibilite.PROTEGE));
		classe1.getMethodes().add(new Methode("getUnBooleen", null, TypePrimitif.BOOLEEN, Visibilite.PAQUETAGE));
		classe1.getMethodes().add(new Methode("getUnReel", null, TypePrimitif.REEL, Visibilite.PUBLIC));

		List<Parametre> params11 = new ArrayList<>();
		params11.add(new Parametre("laChaine", TypePrimitif.CHAINE));
		classe1.getMethodes().add(new Methode("setUneChaine", params11, TypePrimitif.CHAINE, Visibilite.PRIVE));

		List<Parametre> params12 = new ArrayList<>();
		params12.add(new Parametre("lEntier", TypePrimitif.ENTIER));
		classe1.getMethodes().add(new Methode("setUnEntier", params12, TypePrimitif.ENTIER, Visibilite.PROTEGE));

		List<Parametre> params13 = new ArrayList<>();
		params13.add(new Parametre("leBooleen", TypePrimitif.BOOLEEN));
		classe1.getMethodes().add(new Methode("setUnBooleen", params13, TypePrimitif.BOOLEEN, Visibilite.PAQUETAGE));

		List<Parametre> params14 = new ArrayList<>();
		params14.add(new Parametre("leReel", TypePrimitif.REEL));
		classe1.getMethodes().add(new Methode("setUnReel", params14, TypePrimitif.REEL, Visibilite.PUBLIC));

		diagramme.getBoites().add(classe1);

		Classe classe2 = new Classe(300, 300, "Personne");

		classe2.getAttributs().add(new Attribut("uneChaine", TypePrimitif.CHAINE, Visibilite.PRIVE));
		classe2.getAttributs().add(new Attribut("unEntier", TypePrimitif.ENTIER, Visibilite.PROTEGE));
		classe2.getAttributs().add(new Attribut("unBooleen", TypePrimitif.BOOLEEN, Visibilite.PAQUETAGE));
		classe2.getAttributs().add(new Attribut("unReel", TypePrimitif.REEL, Visibilite.PUBLIC));

		classe2.getMethodes().add(new Methode("getUneChaine", null, TypePrimitif.CHAINE, Visibilite.PRIVE));
		classe2.getMethodes().add(new Methode("getUnEntier", null, TypePrimitif.ENTIER, Visibilite.PROTEGE));
		classe2.getMethodes().add(new Methode("getUnBooleen", null, TypePrimitif.BOOLEEN, Visibilite.PAQUETAGE));
		classe2.getMethodes().add(new Methode("getUnReel", null, TypePrimitif.REEL, Visibilite.PUBLIC));

		List<Parametre> params21 = new ArrayList<>();
		params21.add(new Parametre("laChaine", TypePrimitif.CHAINE));
		classe2.getMethodes().add(new Methode("setUneChaine", params21, TypePrimitif.CHAINE, Visibilite.PRIVE));

		List<Parametre> params22 = new ArrayList<>();
		params22.add(new Parametre("lEntier", TypePrimitif.ENTIER));
		classe2.getMethodes().add(new Methode("setUnEntier", params22, TypePrimitif.ENTIER, Visibilite.PROTEGE));

		List<Parametre> params23 = new ArrayList<>();
		params23.add(new Parametre("leBooleen", TypePrimitif.BOOLEEN));
		classe2.getMethodes().add(new Methode("setUnBooleen", params23, TypePrimitif.BOOLEEN, Visibilite.PAQUETAGE));

		List<Parametre> params24 = new ArrayList<>();
		params24.add(new Parametre("leReel", TypePrimitif.REEL));
		classe2.getMethodes().add(new Methode("setUnReel", params24, TypePrimitif.REEL, Visibilite.PUBLIC));

		diagramme.getBoites().add(classe2);

		Lien lien = new Relation(classe1, classe2, new CardinaliteEtoile(), new CardinaliteUn(), "rôleSource", "rôleDestination", Navigabilite.SOURCE_DESTINATION);

		diagramme.getLiens().add(lien);

		return diagramme;
	}
}
