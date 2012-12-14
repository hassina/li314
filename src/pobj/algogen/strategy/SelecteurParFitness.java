package pobj.algogen.strategy;

import java.util.Random;

import pobj.algogen.Individu;
import pobj.algogen.Population;

public class SelecteurParFitness implements IndivSelecteur {

	@Override
	public Individu getRandom(Population pop) {
		Random r = new Random();
		Double lim = r.nextDouble() * pop.getSommeFitnesses();
		Double accu = 0.0;
		for (Individu ind : pop) {
			if (accu >= lim) {
				return ind;
			}
			accu += ind.getFitness();
		}
		return pop.get(pop.size()-1);
	}
}
