package fr.ribesg.imag.moustacheuml.vue;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import fr.ribesg.imag.moustacheuml.controlleur.Controlleur;
import fr.ribesg.imag.moustacheuml.vue.jgraphx.FabriqueGraphique;

public class VueGraphique extends mxGraphComponent {

	private final Controlleur controlleur;

	public VueGraphique(Controlleur controlleur) {
		super(new mxGraph());

		this.controlleur = controlleur;

		this.setGraph(FabriqueGraphique.get());
	}

}
