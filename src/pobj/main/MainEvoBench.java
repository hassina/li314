package pobj.main;

import java.io.IOException;

import pobj.algogen.Environnement;
import pobj.algogen.Population;
import pobj.algogen.adapter.agent.LabyEnvironnementAdapter;
import pobj.algogen.adapter.agent.PopulationFactory;
import pobj.algogen.adapter.evolution.IEvolution;
import pobj.config.AlgoGenParameter;
import pobj.config.Configuration;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;

public class MainEvoBench {

	public static void main(String[] args) {
		// Generateur.getInstance().setSeed(0);

		if (args.length != 1
				|| ((args[0].compareTo("--gen") != 0) && (args[0]
						.compareTo("--prog") != 0))) {
			System.err
					.println("usage : java -classpath bin pobj.main.MainEvoBench [--gen] [--prog]");
			return;
		}

		Configuration cfg = Configuration.getInstance();
		cfg.setParameterValue(AlgoGenParameter.LABY_FILE, "default.mze");
		cfg.setParameterValue(AlgoGenParameter.NB_STEPS, "103");
		cfg.setParameterValue(AlgoGenParameter.NB_RULES, "10");
		cfg.setParameterValue(AlgoGenParameter.NB_GEN, "1000");
		cfg.setParameterValue(AlgoGenParameter.TAILLE_POP, "200");
		if (args[0].compareTo("--gen") == 0) {
			cfg.setParameterValue(AlgoGenParameter.EVO_GEN, "true");
			cfg.setParameterValue(AlgoGenParameter.SELECT_UNI, "true");
		} else {
			cfg.setParameterValue(AlgoGenParameter.EVO_GEN, "false");
			cfg.setParameterValue(AlgoGenParameter.SELECT_UNI, "false");

		}
		try {
			Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe(cfg
					.getParameterValue(AlgoGenParameter.LABY_FILE));

			IEvolution evolution = Population.buildEvolution(Boolean
					.parseBoolean(cfg
							.getParameterValue(AlgoGenParameter.SELECT_UNI)),
					Boolean.parseBoolean(cfg
							.getParameterValue(AlgoGenParameter.EVO_GEN)));
			double moyenne = 0;
			int nbBreak = 0;
			int nbIter = 1000;
			double moyenneFitness = 0;

			for (int k = 0; k < nbIter; k++) {
				Population pop = PopulationFactory
						.createRandomPopulation(
								Integer.parseInt(cfg
										.getParameterValue(AlgoGenParameter.TAILLE_POP)),
								Integer.parseInt(cfg
										.getParameterValue(AlgoGenParameter.NB_RULES)),
								evolution);
				Environnement cible = new LabyEnvironnementAdapter(laby,
						Integer.parseInt(cfg
								.getParameterValue(AlgoGenParameter.NB_STEPS)));
				int nbGen = Integer.parseInt(cfg
						.getParameterValue(AlgoGenParameter.NB_GEN));

				for (int i = 0; i < nbGen; i++) {
					pop = pop.evoluer(cible);
					// System.out.print("[gen " + i + " ]\t");
					// System.out.println(pop.toString());
					if (pop.get(0).getFitness() == laby.getNbPoints()) {
						System.out
								.println("Individu optimal atteint au bout de "
										+ i + " générations.");
						moyenne += i;
						nbBreak++;
						break;
					}
				}
				System.out.println("Fitness du fittest : "
						+ pop.get(0).getFitness());
				moyenneFitness += pop.get(0).getFitness();
			}
			System.out.println("Individu optimal atteint au bout de " + moyenne
					/ nbBreak + " générations (moyenne sur " + nbIter
					+ " benchs).");
			System.out.println("Fitness du fitness (moyenne sur " + nbIter
					+ " benchs) : " + moyenneFitness / nbIter);

		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe" + e);
			System.exit(1);
		}
		// sauvegarde de la configuration
		try {
			Configuration.sauverConfiguration("default.cfg", cfg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
