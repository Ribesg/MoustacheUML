package fr.ribesg.imag.moustacheuml.modele;

import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.lien.Lien;

import java.util.HashSet;
import java.util.Set;

/**
 * Cette classe représente une diagramme : un ensemble de boites et de liens.
 */
public abstract class Diagramme {

	private final Set<Boite> boites;
	private final Set<Lien> liens;

	protected Diagramme() {
		this.boites = new HashSet<>();
		this.liens = new HashSet<>();
	}
}
