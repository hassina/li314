package pobj.algogen.adapter.evolution;

import pobj.algogen.Individu;
import pobj.algogen.Population;
import pobj.algogen.strategy.IndivSelecteur;
import pobj.util.Generateur;

public class EvolutionGenerationnelle implements IEvolution {

	private IndivSelecteur selecteur;

	public EvolutionGenerationnelle(IndivSelecteur selecteur) {
		this.selecteur = selecteur;
	}

	@Override
	public Population reproduire(Population pop, double ratio) {
		Population next = new Population(pop.getEvolution());
		int nb = (int) (pop.size() * 0.2);
		for (int i = 0; i < nb; i++) {
			next.add(pop.get(i).clone());
		}
		Generateur rand = Generateur.getInstance();
		for (int i = 0; i < 4 * nb; i++) {
			// Individu ind = next.get(rand.nextInt(nb)).croiser(
			// next.get(rand.nextInt(nb)));
			Individu ind = selecteur.getRandom(next).croiser(
					selecteur.getRandom(pop));
			if (rand.nextDouble() < ratio) {
				ind.muter();
			}
			next.add(ind);
		}
		return next;
	}

}
