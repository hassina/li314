package pobj.algogen;

/**
 * Interface de représentation d'un Environnement
 */
public interface Environnement {
	/**
	 * Evalue un individu
	 * 
	 * @param i
	 *            Individu à évaluer
	 * @return Fitness de l'individu
	 */
	public double eval(Individu i);

}
