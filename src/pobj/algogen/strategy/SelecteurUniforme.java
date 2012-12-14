package pobj.algogen.strategy;

import java.util.Random;

import pobj.algogen.Individu;
import pobj.algogen.Population;

public class SelecteurUniforme implements IndivSelecteur {

	@Override
	public Individu getRandom(Population pop) {
		Random r = new Random();
		return pop.get(r.nextInt(pop.size()));
	}

}
