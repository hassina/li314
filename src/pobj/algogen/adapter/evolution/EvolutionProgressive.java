package pobj.algogen.adapter.evolution;

import pobj.algogen.Individu;
import pobj.algogen.Population;
import pobj.algogen.strategy.IndivSelecteur;

public class EvolutionProgressive implements IEvolution {

	private IndivSelecteur selecteur;

	public EvolutionProgressive(IndivSelecteur selecteur) {
		this.selecteur = selecteur;
	}

	@Override
	public Population reproduire(Population pop, double ratio) {
		if (pop.size() < 2) {
			System.err
					.println("Pas assez d'individus dans la population pour la faire évoluer");
			return pop;
		}
		Individu ind1 = selecteur.getRandom(pop);
		Individu ind2 = selecteur.getRandom(pop);
		pop.removeLast();
		pop.add(ind1.croiser(ind2));
		return pop;
	}

}
