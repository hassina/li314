package pobj.algogen.adapter.evolution;

import pobj.algogen.Population;

public interface IEvolution {
	Population reproduire(Population pop, double ratio);
}
