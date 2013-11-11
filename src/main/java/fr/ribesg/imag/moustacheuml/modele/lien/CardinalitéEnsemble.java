package fr.ribesg.imag.moustacheuml.modele.lien;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Cette classe représente une cardinalité du type "{0, 2, 4}"
 */
public class CardinalitéEnsemble extends Cardinalité {

	private final SortedSet<Integer> valeurs;


	public CardinalitéEnsemble(Collection<Integer> valeurs) {
		if (valeurs == null || valeurs.size() < 2) {
			throw new IllegalArgumentException("Ceci n'est pas un ensemble valide");
		}
		this.valeurs = new TreeSet<>();
		this.valeurs.addAll(valeurs);
	}

	@Override
	public String toString() {
		StringBuilder résultat = new StringBuilder("{");
		Iterator<Integer> it = this.valeurs.iterator();
		résultat.append(Integer.toString(it.next()));
		while (it.hasNext()) {
			résultat.append(", ");
			résultat.append(Integer.toString(it.next()));
		}
		résultat.append('}');
		return résultat.toString();
	}
}
