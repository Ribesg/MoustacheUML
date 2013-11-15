package fr.ribesg.imag.moustacheuml.vue.jgraphx;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.handler.mxGraphHandler;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphSelectionModel;
import fr.ribesg.imag.moustacheuml.controleur.ControleurEspaceDeTravail;
import fr.ribesg.imag.moustacheuml.modele.Diagramme;
import fr.ribesg.imag.moustacheuml.modele.boite.Boite;
import fr.ribesg.imag.moustacheuml.modele.lien.Lien;
import fr.ribesg.imag.moustacheuml.modele.lien.TypeLien;
import fr.ribesg.imag.moustacheuml.utils.IdUtils;
import org.apache.commons.lang.StringEscapeUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.*;

public class SwingGraph extends mxGraphComponent {

	private static final String MONOSPACED_FONT = mxConstants.STYLE_FONTFAMILY + "=" + "Lucida Console" + ";";
	private static final String ALIGN_LEFT = mxConstants.STYLE_ALIGN + "=" + mxConstants.ALIGN_LEFT + ";";

	private final ControleurEspaceDeTravail controleur;

	private final Map<String, Object> idCelluleMap;

	public SwingGraph(ControleurEspaceDeTravail controleur) {
		super(new mxGraph() {
			@Override
			public boolean isCellMovable(Object cell) {
				final mxIGraphModel modele = this.getModel();
				if (modele.isVertex(modele.getParent(cell))) {
					return false;
				} else if (modele.isEdge(cell)) {
					return false;
				}
				return true;
			}
		});

		this.controleur = controleur;

		this.idCelluleMap = new HashMap<>();

		// Permet la sélection en rectangle
		new mxRubberband(this) {
			// On surcharge quelque méthodes pour empêcher l'interaction
			// du clic droit, réservé au menu contextuel

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() != MouseEvent.BUTTON3) {
					super.mousePressed(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() != MouseEvent.BUTTON3) {
					super.mouseReleased(e);
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (e.getButton() != MouseEvent.BUTTON3) {
					super.mouseDragged(e);
				}
			}
		};

		// Contraintes sur le graphe
		this.getGraphHandler().setRemoveCellsFromParent(false);
		this.setFoldingEnabled(false);
		this.getGraph().setAllowDanglingEdges(false);
		this.getGraph().setEdgeLabelsMovable(false);
		this.setConnectable(false);
		this.getGraph().setCellsResizable(false);
		this.getGraph().setAutoSizeCells(true);
		this.getGraph().setCellsEditable(false);
		this.getGraph().setHtmlLabels(true);

		// Gestion du zoom
		this.getGraphControl().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON2) {
					zoomActual();
				}
			}
		});

		this.getGraphControl().addMouseWheelListener(new MouseAdapter() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() > 0) {
					zoomIn();
				} else {
					zoomOut();
				}
			}
		});

		// Gestion du clic droit
		this.getGraphControl().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					gererClicDroit(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					gererClicDroit(e);
				}
			}

			private void gererClicDroit(MouseEvent e) {
				Object celluleCliquee = getCellAt(e.getX(), e.getY(), true);
				String idCelluleCliquee = celluleCliquee == null ? null : ((mxCell) celluleCliquee).getId();

				mxGraphSelectionModel modeleSelection = getGraph().getSelectionModel();

				Set<String> idsSelection = new HashSet<>();
				for (Object cell : modeleSelection.getCells()) {
					idsSelection.add(((mxCell) cell).getId());
				}

				e.consume();

				SwingGraph.this.controleur.clicDroit(e.getX(), e.getY(), idCelluleCliquee, idsSelection);
			}
		});

		// Gère le déplacement de boites.
		// Ce Listener récupère les boites déplacées et envoie les informations au contrôleur.
		this.getGraph().addListener(mxEvent.CELLS_MOVED, new mxEventSource.mxIEventListener() {
			@Override
			public void invoke(Object sender, mxEventObject evt) {
				List<String> deplacees = new ArrayList<>();
				double dx = (double) evt.getProperty("dx");
				double dy = (double) evt.getProperty("dy");
				Object[] cellulesObjet = (Object[]) evt.getProperty("cells");
				for (Object celluleObjet : cellulesObjet) {
					mxCell cellule = (mxCell) celluleObjet;
					deplacees.add(IdUtils.deprefixe(cellule.getId()));
				}
				SwingGraph.this.controleur.deplacementDeBoites(dx, dy, deplacees);
				getGraph().refresh();
				getGraph().repaint();
			}
		});
	}

	/**
	 * Un mxGraphHandler modifié pour ne pas considérer les clics droits.
	 * Cela empêche la modification de la sélection par le clic droit, qu'on
	 * réserve au menu contextuel.
	 * <p/>
	 * On gère aussi les modifications du modèle, au niveau de la position
	 * des boites.
	 */
	@Override
	protected mxGraphHandler createGraphHandler() {
		return new mxGraphHandler(this) {

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() != MouseEvent.BUTTON3) {
					super.mousePressed(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() != MouseEvent.BUTTON3) {
					super.mouseReleased(e);
				}
			}
		};
	}

	public void afficherDiagramme(Diagramme diagramme) {
		mxGraph graph = this.getGraph();

		graph.setModel(new mxGraphModel(null));

		graph.getModel().beginUpdate();

		Object parent = graph.getDefaultParent();

		for (Boite boite : diagramme.getBoites()) {
			String[] chaines = boite.getChaines();

			String titre = StringEscapeUtils.escapeHtml(chaines[0]);
			double largeurTitre = largeurCellule(StringEscapeUtils.unescapeHtml(titre));
			String styleTitre = mxConstants.STYLE_SHAPE + "=" + mxConstants.SHAPE_SWIMLANE + ";" + MONOSPACED_FONT;
			if (boite.estObjet()) {
				styleTitre += mxConstants.STYLE_FONTSTYLE + "=" + mxConstants.FONT_UNDERLINE + ";";
			}

			String attributs = chaines[1];
			double largeurAttributs = largeurCellule(attributs);

			String methodes = chaines.length > 2 ? chaines[2] : "";
			double largeurMethodes = largeurCellule(methodes);

			double largeur = Math.max(largeurTitre, Math.max(largeurAttributs, largeurMethodes));

			Object swimlane = graph.insertVertex(parent, IdUtils.prefixeBoite(boite.getId()), titre, boite.getPosX(), boite.getPosY(), largeur, 0, styleTitre);
			graph.insertVertex(swimlane, IdUtils.prefixeAttribut(boite.getId()), attributs, 0, graph.getStartSize(swimlane).getHeight(), largeur, hauteurCellule(attributs), MONOSPACED_FONT + ALIGN_LEFT);
			if (!methodes.isEmpty()) {
				graph.insertVertex(swimlane, IdUtils.prefixeMethode(boite.getId()), methodes, 0, graph.getStartSize(swimlane).getHeight() + hauteurCellule(attributs), largeur, hauteurCellule(methodes), MONOSPACED_FONT + ALIGN_LEFT);
			}

			idCelluleMap.put(boite.getId(), swimlane);
		}

		for (Lien lien : diagramme.getLiens()) {
			TypeLien type = lien.getType();
			String style;
			switch (type) {
				// Ce switch contiendra différents cas pour les différents types de liens
				default:
					style = mxConstants.STYLE_ENDARROW + "=" + mxConstants.ARROW_OPEN + ";";
					style += mxConstants.STYLE_STARTARROW + "=" + mxConstants.ARROW_OPEN + ";";
					break;
			}
			Object lienGraph = graph.insertEdge(parent, IdUtils.prefixeLien(lien.getId()), null, idCelluleMap.get(lien.getSource().getId()), idCelluleMap.get(lien.getDestination().getId()), style);

			idCelluleMap.put(lien.getId(), lienGraph);
		}

		graph.getModel().endUpdate();
	}

	/**
	 * Calcule la hauteur nécessaire pour faire renter le texte.
	 */
	private double hauteurCellule(String chaine) {
		int result = 1;
		for (char c : chaine.toCharArray()) {
			if (c == '\n') {
				result++;
			}
		}
		return result * 12 + 5;
	}

	/**
	 * Calcule la largeur nécessaire pour faire renter le texte.
	 */
	private double largeurCellule(String chaine) {
		if (chaine.isEmpty()) {
			return 0;
		}
		double max = Integer.MIN_VALUE;
		for (String s : chaine.split("\n")) {
			if (s.length() > max) {
				max = s.length();
			}
		}
		return max * 7 + 7.5;
	}
}
