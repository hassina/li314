package pobj.algogen;

/**
 * Classe de la fabrique de Population
 * 
 */
public class PopulationFactory {
	/**
	 * Génère une population aléatoire
	 * 
	 * @param size
	 *            Taille de la population
	 * @return la population générée
	 */
	public static Population createRandomPopulation(int size) {
		Population p = new Population();
		for (int i = 0; i < size; i++) {
			p.add(new Individu());
		}
		return p;
	}
}
