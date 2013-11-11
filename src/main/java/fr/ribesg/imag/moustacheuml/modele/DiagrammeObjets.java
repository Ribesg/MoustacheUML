package fr.ribesg.imag.moustacheuml.modele;

public class DiagrammeObjets extends Diagramme {

	private DiagrammeClasses diagrammeClasses;

	public DiagrammeObjets() {
		this.diagrammeClasses = null;
	}

	public DiagrammeObjets(DiagrammeClasses diagrammeClasses) {
		this.diagrammeClasses = diagrammeClasses;
	}

	public DiagrammeClasses getDiagrammeClasses() {
		return diagrammeClasses;
	}
}
