package pobj.main;

import pobj.algogen.Environnement;
import pobj.algogen.Population;
import pobj.algogen.PopulationFactory;
import pobj.algogen.ValeurCible;

public class PopulationArithMain {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err
					.println("Argument manquant (nombre d'individu dans la pop.)");
			return;
		}
		Population pop = PopulationFactory.createRandomPopulation(Integer
				.parseInt(args[0]));
		System.out.println(pop.toString());
		Environnement cible = new ValeurCible();

		for (int i = 0; i < 10; i++) {

			System.out.println("Valeur cible : "
					+ ((ValeurCible) cible).getValue());
			System.out.println("[Génération n° " + i + "]");
			pop = pop.evoluer(cible);
			System.out.println(pop.toStringWithEnv(((ValeurCible) cible)
					.getEnv()));
		}
	}
}
