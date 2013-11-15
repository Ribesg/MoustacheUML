package fr.ribesg.imag.moustacheuml.vue.popup;

import fr.ribesg.imag.moustacheuml.controleur.ControleurEspaceDeTravail;
import fr.ribesg.imag.moustacheuml.modele.DiagrammeObjets;
import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.boite.Classe;
import fr.ribesg.imag.moustacheuml.vue.FenetrePrincipale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupCreerObjet extends JDialog {

	private final ControleurEspaceDeTravail controleur;

	public PopupCreerObjet(ControleurEspaceDeTravail controleur, FenetrePrincipale maitre, final int x, final int y) {
		super(maitre, "Créer un Objet", true);
		this.controleur = controleur;

		final JPanel panel = new JPanel(new GridLayout(3, 2));
		this.add(panel);

		JLabel classeLabel = new JLabel("Classe :");
		panel.add(classeLabel);

		if (this.controleur.getModele().estObjets() &&
				((DiagrammeObjets) this.controleur.getModele()).getDiagrammeClasses() != null) {
			final JComboBox<String> classes = new JComboBox<>();
			for (Boite boite : ((DiagrammeObjets) this.controleur.getModele()).getDiagrammeClasses().getBoites()) {
				classes.addItem(boite.getNom());
			}
			panel.add(classes);
		} else {
			final JTextField classe = new JTextField();
			panel.add(classe);
		}

		JLabel nomLabel = new JLabel("Nom :");
		panel.add(nomLabel);

		final JTextField nom = new JTextField();
		// nom.setPreferredSize(new Dimension(150, (int) nom.getSize().getHeight()));
		panel.add(nom);

		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component classeComponent = panel.getComponent(1);
				String nomClasse;
				if (classeComponent instanceof JTextField) {
					nomClasse = ((JTextField) classeComponent).getText();
				} else {
					nomClasse = (String) ((JComboBox) classeComponent).getSelectedItem();
				}
				Classe classe = null;
				if (((DiagrammeObjets) PopupCreerObjet.this.controleur.getModele()).getDiagrammeClasses() != null) {
					for (Boite boite : ((DiagrammeObjets) PopupCreerObjet.this.controleur.getModele()).getDiagrammeClasses().getBoites()) {
						if (boite.getNom().equalsIgnoreCase(nomClasse)) {
							classe = (Classe) boite;
							break;
						}
					}
				}
				boolean succes = PopupCreerObjet.this.controleur.creerObjet(classe, nom.getText(), x, y);
				if (succes) {
					PopupCreerObjet.this.dispose();
				} else {
					PopupCreerObjet.this.controleur.getControleur().erreur("Nom d'objet invalide ou déjà utilisé !");
				}
			}
		});
		panel.add(ok);

		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopupCreerObjet.this.dispose();
			}
		});
		panel.add(annuler);

		this.pack();
		this.setLocationRelativeTo(this.getParent());
	}
}
