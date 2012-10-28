package pobj.main;

import java.io.IOException;

import pobj.algogen.Environnement;
import pobj.algogen.Population;
import pobj.algogen.adapter.agent.LabyEnvironnementAdapter;
import pobj.algogen.adapter.agent.PopulationFactory;
import pobj.config.AlgoGenParameter;
import pobj.config.Configuration;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;

public class MainConfiguration {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("arg needed : configurationFile");
			System.exit(1);
		}
		Configuration cfg;
		try {
			Configuration.chargerConfiguration(args[0]);
			cfg = Configuration.getInstance();
			System.err.println(cfg.toString());
			Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe(cfg
					.getParameterValue(AlgoGenParameter.LABY_FILE));
			Population pop = PopulationFactory.createRandomPopulation(Integer
					.parseInt(cfg
							.getParameterValue(AlgoGenParameter.TAILLE_POP)),
					Integer.parseInt(cfg
							.getParameterValue(AlgoGenParameter.NB_RULES)));
			Environnement cible = new LabyEnvironnementAdapter(laby,
					Integer.parseInt(cfg
							.getParameterValue(AlgoGenParameter.NB_STEPS)));

			int nbGen = Integer.parseInt(cfg
					.getParameterValue(AlgoGenParameter.NB_GEN));
			for (int i = 0; i < nbGen; i++) {
				pop = pop.evoluer(cible);
				System.out.print("[gen " + i + " ]\t");
				System.out.println(pop.toString());
			}
		} catch (IOException e) {
			System.err.println("Le fichier n'a pas pu être chargé.");
			System.exit(1);
		}

		/* sauvegarde de la configuration */
		// try {
		// Configuration.sauverConfiguration("default.cfg", cfg);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}
}
