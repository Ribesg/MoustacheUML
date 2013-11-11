package fr.ribesg.imag.moustacheuml;

import fr.ribesg.imag.moustacheuml.controlleur.Controlleur;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Ribesg
 */
public class Main {

	/**
	 * Cette méthode est le point d'entrée du programme.
	 * Elle lance le programme en appelant {@link #Main(String[])} et
	 * s'occupe de récupérer toutes les erreurs possibles et de les afficher.
	 *
	 * @param args les arguments passés au programme
	 */
	public static void main(String[] args) {
		try {
			new Main(args);
		} catch (final Throwable t) {
			// On affiche toute exception entrainant la fin du programme.
			JDialog errorDialog = new JDialog(new JFrame(), "MoustacheUML - Erreur Fatale");

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);
			String errorStackTrace = sw.toString();

			JTextPane errorText = new JTextPane();
			errorText.setText(errorStackTrace);
			errorText.setEditable(false);

			errorDialog.add(errorText);
			errorDialog.pack();
			errorDialog.setVisible(true);
			errorDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			errorDialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					System.exit(0);
				}
			});
		}
	}

	/**
	 * Le constructeur de la classe Main.
	 * C'est ici que le programme démarre.
	 *
	 * @param args les arguments passés au programme
	 */
	public Main(String[] args) {
		Controlleur controlleur = new Controlleur();
		controlleur.montrerFenetrePrincipale();
	}
}
