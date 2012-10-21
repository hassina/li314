package pobj.algogen;

public interface Individu extends Comparable<Individu> {

	/**
	 * Modifie le fitness
	 * 
	 * @param newFitness
	 *            Nouvelle valeur du fitness
	 */
	public abstract void setFitness(double newFitness);

	/**
	 * Accesseur pour l'attribut fitness
	 * 
	 * @return le fitness
	 */
	public abstract double getFitness();

	/**
	 * Mute un individu en redéfinissant sa valeurPropre aléatoirement
	 */
	public abstract void muter();

	/**
	 * Croise deux individus en créant un nouvel individu dont la valeurPropre
	 * est égale à la moyenne des deux individus
	 * 
	 * @param autre
	 *            IIndividu avec lequel le croisement est effectuée
	 * @return le nouvel individu résultant du croisement
	 */
	public abstract Individu croiser(Individu autre);

	public abstract Individu clone();

}