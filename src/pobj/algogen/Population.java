package pobj.algogen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import pobj.util.Generateur;

/**
 * Classe de représentation de la Population
 * 
 */
public class Population implements Iterable<Individu> {

	private ArrayList<Individu> individus;

	/** Tableau dynamique des individus */

	/**
	 * Construit la population
	 */
	public Population() {
		individus = new ArrayList<Individu>();
	}

	/**
	 * Accède à la taille de la population
	 * 
	 * @return Taille de la population
	 */
	public int size() {
		return individus.size();
	}

	/**
	 * Ajoute un individu dans la population
	 * 
	 * @param individu
	 *            Individu à ajouter
	 */
	public void add(Individu individu) {
		individus.add(individu);
	}

	/**
	 * Evalue le fitness de chaque individu de la population dans
	 * l'environnement passé en paramètre
	 * 
	 * @param cible
	 *            Environnement dans lequel les individus sont évalués
	 */
	public void evaluer(Environnement cible) {
		// System.out.print("[eval   ]\t");
		for (int i = 0; i < individus.size(); i++) {
			double fit = cible.eval(individus.get(i));
			individus.get(i).setFitness(fit);
			// System.out.print(fit + "\t");
		}
		// System.out.print("\n[fit    ]\t");
		// for (int i = 0; i < individus.size(); i++) {
		// // System.out.print(individus.get(i).getFitness() + "\t");
		// }
		// System.out.println();
		Collections.sort(individus);
	}

	/**
	 * Reproduit une nouvelle population à partir de la population existante.
	 * Celle-ci est constitué des clones des premiers (selon leur fitness) 20%
	 * de la population initiale, et de nouveaux individus pour les 80% restant.
	 * Pour créer ces individus, des individus sont choisis aléatoirement parmis
	 * les 20% de la population initiale, puis sont croisés et mutés (taux 5%)
	 * 
	 * @return la nouvelle Population résultante de la reproduction de la
	 *         population existante
	 */
	public Population reproduire() {
		Population pop = new Population();
		int nb = (int) (individus.size() * 0.2);
		for (int i = 0; i < nb; i++) {
			pop.add(individus.get(i).clone());
		}
		Random rand = Generateur.getInstance();
		for (int i = 0; i < 4 * nb; i++) {
			Individu ind = pop.individus.get(rand.nextInt(nb)).croiser(
					pop.individus.get(rand.nextInt(nb)));
			if (rand.nextDouble() < 1) {
				ind.muter();
			}
			// Simplification des expressions arithmétiques (cf. TP précédent)
			// ind = ind.clone().simplifier());
			pop.add(ind);
		}
		return pop;
	}

	/**
	 * Permet de faire évoluer la Population en produisant une nouvelle
	 * génération. La fonction primordiale de la Population est de pouvoir
	 * evoluer. On passe un Environnement qui permettra de calculer le fitness
	 * des individus, afin de décider lesquels sont les plus aptes (survival of
	 * the fittest). On garde ici les 20% meilleurs et on les fait se reproduire
	 * pour générer la prochaine génération.
	 * 
	 * @param cible
	 *            l'objectif/problème à résoudre environnement conditionnant
	 *            l'évolution.
	 * @return une nouvelle Population, dont les membres sont tous nouveaux
	 *         (aucun individu de cette Population n'appartient à la Population
	 *         "this"). On doit assurer que le meilleur individu de cette
	 *         nouvelle Population est au moins aussi bon (en fitness) que le
	 *         meilleur individu de la Population prcécédente.
	 */
	public Population evoluer(Environnement cible) {
		evaluer(cible);
		Population nextgen = reproduire();
		nextgen.evaluer(cible);
		return nextgen;
	}

	@Override
	public Iterator<Individu> iterator() {
		return individus.iterator();
	}

	public Individu get(int index) {
		return individus.get(index);
	}

	public void mute(double d) {
		Random rand = Generateur.getInstance();
		for (Individu ind : individus) {
			if (rand.nextDouble() < d) {
				ind.muter();
			}
		}
	}

	public String toString() {
		String s = "";
		for (Individu ind : individus) {
			s += ind.getFitness() + "\t";
		}
		return s;
	}

}
