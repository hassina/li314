package pobj.algogen.adapter.arith;

import pobj.algogen.Environnement;
import pobj.algogen.Population;
import pobj.algogen.adapter.agent.PopulationFactory;
import pobj.algogen.adapter.evolution.EvolutionGenerationnelle;
import pobj.algogen.strategy.SelecteurUniforme;

public class PopulationArithMain {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err
					.println("Argument manquant (nombre d'individu dans la pop.)");
			return;
		}
		Population pop = PopulationFactory.createRandomPopulation(Integer
				.parseInt(args[0]), new EvolutionGenerationnelle(new SelecteurUniforme()));
		System.out.println(pop.toString());
		Environnement cible = new ValeurCible();

		for (int i = 0; i < 10; i++) {
			System.out.print("[Génération n° " + i + "]");
			pop = pop.evoluer(cible);
			System.out.println(pop.toString());
		}
	}
}
