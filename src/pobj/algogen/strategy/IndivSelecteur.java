package pobj.algogen.strategy;

import pobj.algogen.Individu;
import pobj.algogen.Population;

public interface IndivSelecteur {
	Individu getRandom(Population pop);
}
