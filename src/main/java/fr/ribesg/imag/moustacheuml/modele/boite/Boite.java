package fr.ribesg.imag.moustacheuml.modele.boite;

/**
 * Cette classe représente une boite d'un diagramme.
 */
public abstract class Boite {

	private float posX;
	private float posY;
	private String nom;

	protected Boite(float posX, float posY, String nom) {
		this.posX = posX;
		this.posY = posY;
		this.nom = nom;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public void deplacer(double dx, double dy) {
		this.posX += dx;
		this.posY += dy;
	}

	public String getNom() {
		return nom;
	}

	public abstract boolean estClasse();

	public abstract boolean estObjet();

	public abstract String[] getChaines();

	public abstract String getId();
}
