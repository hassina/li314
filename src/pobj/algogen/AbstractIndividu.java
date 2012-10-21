package pobj.algogen;

/**
 * Classe de représentation d'un Individu
 * 
 */
public abstract class AbstractIndividu implements Comparable<Individu>,
		Individu {

	private double fitness;

	@Override
	public void setFitness(double newFitness) {
		fitness = newFitness;
	}

	public double getFitness() {
		return fitness;
	}

	/**
	 * Compare deux individus selon leur fitness
	 */
	public int compareTo(Individu arg0) {
		return Double.compare(arg0.getFitness(), fitness);
	}

	public abstract AbstractIndividu clone();

}