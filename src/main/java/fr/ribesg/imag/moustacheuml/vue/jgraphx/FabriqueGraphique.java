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
		try {
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
					30);
			Object v2 = graph.insertVertex(parent, null, "World!",
					240, 150, 80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2);
		} finally {
			graph.getModel().endUpdate();
		}

		return graph;
	}
}
