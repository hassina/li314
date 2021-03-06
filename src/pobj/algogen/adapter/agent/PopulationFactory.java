package pobj.algogen.adapter.agent;

import pobj.algogen.Population;
import pobj.algogen.adapter.arith.IndividuExpression;
import pobj.algogen.adapter.evolution.IEvolution;
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
	public static Population createRandomPopulation(int size,
			IEvolution evolution) {
		Population p = new Population(evolution);
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

	public static Population createRandomPopulation(int size, int nbRules,
			IEvolution evolution) {
		Population p = new Population(evolution);
		for (int i = 0; i < size; i++) {
			p.add(new ControleurIndividuAdapter(ControlFactory
					.createControleur(nbRules)));
		}
		return p;
	}

}
