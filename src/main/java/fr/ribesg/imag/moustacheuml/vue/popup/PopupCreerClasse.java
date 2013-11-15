package fr.ribesg.imag.moustacheuml.vue.popup;

import fr.ribesg.imag.moustacheuml.controleur.ControleurEspaceDeTravail;
import fr.ribesg.imag.moustacheuml.modele.boite.Stereotype;
import fr.ribesg.imag.moustacheuml.vue.FenetrePrincipale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupCreerClasse extends JDialog {

	private final ControleurEspaceDeTravail controleur;

	public PopupCreerClasse(ControleurEspaceDeTravail controleur, FenetrePrincipale maitre, final int x, final int y) {
		super(maitre, "Créer une Classe", true);
		this.controleur = controleur;

		JPanel panel = new JPanel(new GridLayout(3, 2));
		this.add(panel);

		JLabel stereotypesLabel = new JLabel("Stereotype :");
		panel.add(stereotypesLabel);

		final JComboBox<String> stereotypes = new JComboBox<>();
		stereotypes.addItem("aucun");
		for (Stereotype stereotype : Stereotype.values()) {
			stereotypes.addItem(stereotype.name().toLowerCase());
		}
		stereotypes.setSelectedIndex(0);

		panel.add(stereotypes);

		JLabel nomLabel = new JLabel("Nom :");
		panel.add(nomLabel);

		final JTextField nom = new JTextField();
		nom.setPreferredSize(new Dimension(150, (int) nom.getSize().getHeight()));
		panel.add(nom);

		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Stereotype stereotype;
				try {
					stereotype = Stereotype.valueOf(((String) stereotypes.getSelectedItem()).toUpperCase());
				} catch (IllegalArgumentException ex) {
					stereotype = null;
				}
				boolean succes = PopupCreerClasse.this.controleur.creerClasse(stereotype, nom.getText(), x, y);
				if (succes) {
					PopupCreerClasse.this.dispose();
				} else {
					PopupCreerClasse.this.controleur.getControleur().erreur("Nom de classe invalide ou déjà utilisé !");
				}
			}
		});
		panel.add(ok);

		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopupCreerClasse.this.dispose();
			}
		});
		panel.add(annuler);

		this.pack();
		this.setLocationRelativeTo(this.getParent());
	}
}
