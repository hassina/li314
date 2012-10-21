package pobj.main;

import pobj.algogen.Individu;
import pobj.algogen.Population;
import pobj.algogen.adapter.agent.PopulationFactory;

public class MainDebug {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Population pop = PopulationFactory.createRandomPopulation(10, 10);
		//
		// for (int i = 0; i < 10; i++) {
		// pop.get(i).setFitness(i);
		// }
		//
		// for (Individu individu : pop) {
		// System.out.println(individu.getFitness());
		// }

		// expr
		Population pop2 = PopulationFactory.createRandomPopulation(10);

		for (int i = 0; i < 10; i++) {
			pop2.get(i).setFitness(i);
		}

		for (Individu individu : pop2) {
			System.out.print(individu.getFitness() + " ");
		}

		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.print(pop2.get(i).getFitness() + " ");
		}

	}

}
