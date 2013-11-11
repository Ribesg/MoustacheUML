package fr.ribesg.imag.moustacheuml.modele;

import java.util.HashSet;
import java.util.Set;

public class DiagrammeClasses extends Diagramme {

	private Set<DiagrammeObjets> diagrammesObjets;

	public DiagrammeClasses() {
		this.diagrammesObjets = new HashSet<>();
	}

	public Set<DiagrammeObjets> getDiagrammesObjets() {
		return diagrammesObjets;
	}
}
