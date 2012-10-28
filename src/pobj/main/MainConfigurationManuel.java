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

public class MainConfigurationManuel {

	public static void main(String[] args) {

		Configuration cfg = Configuration.getInstance();
		cfg.setParameterValue(AlgoGenParameter.LABY_FILE, "default.mze");
		cfg.setParameterValue(AlgoGenParameter.NB_STEPS, "100");
		cfg.setParameterValue(AlgoGenParameter.NB_RULES, "10");
		cfg.setParameterValue(AlgoGenParameter.NB_GEN, "100");
		cfg.setParameterValue(AlgoGenParameter.TAILLE_POP, "10");

		try {
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

			// long res = 0;
			int nbGen = Integer.parseInt(cfg
					.getParameterValue(AlgoGenParameter.NB_GEN));
			for (int i = 0; i < nbGen; i++) {

				// Chrono sw = new Chrono();
				pop = pop.evoluer(cible);
				// res += sw.stop2();
				System.out.print("[gen " + i + " ]\t");
				System.out.println(pop.toString());
			}
			// res /= nbGen;
			// System.out.println("Temps moyen pour une génération : " + res);
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
