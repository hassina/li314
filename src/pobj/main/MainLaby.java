package pobj.main;

import java.io.IOException;

import pobj.algogen.Environnement;
import pobj.algogen.Population;
import pobj.algogen.adapter.agent.LabyEnvironnementAdapter;
import pobj.algogen.adapter.agent.PopulationFactory;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;

public class MainLaby {

	public static void main(String[] args) {

		String labyFile = args[0];
		int nbSteps = Integer.parseInt(args[1]);
		int nbRules = Integer.parseInt(args[2]);
		int nbGen = Integer.parseInt(args[3]);

		if (args.length != 4) {
			System.err.println("args needed : labyFile nbSteps nbRules nbGen");
			System.exit(1);
		}
		try {
			Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);

			Population pop = PopulationFactory.createRandomPopulation(10,
					nbRules);

			Environnement cible = new LabyEnvironnementAdapter(laby, nbSteps);
			for (int i = 0; i < nbGen; i++) {
				pop = pop.evoluer(cible);

				System.out.print("[gen " + i + " ]\t");
				System.out.println(pop.toStringDebug(cible));
			}

		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe" + e);
			System.exit(1);
		}

	}
}
