package pobj.main;

import pobj.algogen.Environnement;
import pobj.algogen.Population;
import pobj.algogen.PopulationFactory;
import pobj.algogen.ValeurCible;

/**
 * Classe main de test de la Population
 */
public class PopulationMain {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err
					.println("Argument manquant (nombre d'individu dans la pop.)");
			return;
		}
		Population pop = PopulationFactory.createRandomPopulation(Integer
				.parseInt(args[0]));
		System.out.println(pop.toString());
		double value = 0.5;
		Environnement cible = new ValeurCible();
		System.out.println("Valeur cible : " + value);
		for (int i = 0; i < 10; i++) {
			System.out.println("[Génération n° " + i + "]");
			pop = pop.evoluer(cible);
			System.out.println(pop.toString());
		}
	}
}
