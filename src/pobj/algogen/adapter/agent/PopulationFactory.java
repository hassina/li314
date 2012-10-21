package pobj.algogen.adapter.agent;

import pobj.algogen.Population;
import pobj.algogen.adapter.arith.IndividuExpression;
import agent.control.ControlFactory;

/**
 * Classe de la fabrique de Population
 * 
 */
public class PopulationFactory {
	/**
	 * Génère une population aléatoire pour les expressions arithmétiques
	 * 
	 * @param size
	 *            Taille de la population
	 * @return la population générée
	 */
	public static Population createRandomPopulation(int size) {
		Population p = new Population();
		for (int i = 0; i < size; i++) {
			p.add(new IndividuExpression());
		}
		return p;
	}

	/**
	 * Génère une population aléatoire pour les contrôleurs d'individu
	 * 
	 * @param size
	 *            Taille de la population
	 * @param nbRules
	 *            Nombre de règles
	 * @return la population générée
	 */

	public static Population createRandomPopulation(int size, int nbRules) {
		Population p = new Population();
		for (int i = 0; i < size; i++) {
			p.add(new ControleurIndividuAdapter(ControlFactory
					.createControleur(nbRules)));
		}
		return p;
	}

}
