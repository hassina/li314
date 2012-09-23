package pobj.algogen;

import java.util.Random;

/**
 * Classe de représentation d'un Individu
 * 
 */
public class Individu implements Comparable<Individu> {
	private double valeurPropre;
	private double fitness;

	/**
	 * Construit un individu
	 */
	public Individu() {
		super();
		Random r = new Random();
		this.valeurPropre = r.nextDouble();
		fitness = 0;
	}

	/**
	 * Construit un individu
	 * 
	 * @param valeurPropre
	 *            Valeur propre de l'individu
	 */
	public Individu(double valeurPropre) {
		this.valeurPropre = valeurPropre;
		fitness = 0;
	}

	public Individu(Individu individu) {
		// cloneur
		this(individu.valeurPropre);
	}

	public String toString() {
		return "[vP=" + valeurPropre + ", fit=" + fitness + "]\n";
	}

	/**
	 * Modifie le fitness
	 * 
	 * @param newFitness
	 *            Nouvelle valeur du fitness
	 */
	public void setFitness(double newFitness) {
		fitness = newFitness;
	}

	/**
	 * Accesseur pour l'attribut valeurPropre
	 * 
	 * @return la valeur propre
	 */
	public double getValeurPropre() {
		return valeurPropre;
	}

	/**
	 * Accesseur pour l'attribut fitness
	 * 
	 * @return le fitness
	 */
	public double getFitness() {
		return fitness;
	}

	/**
	 * Compare deux individus selon leur fitness
	 */
	public int compareTo(Individu arg0) {
		return Double.compare(arg0.getFitness(), fitness);
	}

	/**
	 * Mute un individu en redéfinissant sa valeurPropre aléatoirement
	 */
	public void muter() {
		Random r = new Random();
		valeurPropre = r.nextDouble();
	}

	/**
	 * Croise deux individus en créant un nouvel individu dont la valeurPropre
	 * est égale à la moyenne des deux individus
	 * 
	 * @param autre Individu avec lequel le croisement est effectuée
	 * @return le nouvel individu résultant du croisement
	 */
	public Individu croiser(Individu autre) {
		return new Individu((this.valeurPropre + autre.valeurPropre) / 2);
	}
}
