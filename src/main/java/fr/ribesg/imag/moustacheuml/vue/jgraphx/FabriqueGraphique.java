package fr.ribesg.imag.moustacheuml.vue.jgraphx;

import com.mxgraph.view.mxGraph;

public class FabriqueGraphique {

	/**
	 * TEST METHOD
	 */
	public static mxGraph get() {
		final mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();



		graph.getModel().endUpdate();

		return graph;
	}
}
