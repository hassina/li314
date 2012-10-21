package pobj.algogen.adapter.agent;

import pobj.algogen.Environnement;
import pobj.algogen.Individu;
import agent.Simulation;
import agent.laby.Labyrinthe;

public class LabyEnvironnementAdapter implements Environnement {

	private Labyrinthe laby;
	private int nbSteps;

	public LabyEnvironnementAdapter(Labyrinthe laby, int nbSteps) {
		this.laby = laby;
		this.nbSteps = nbSteps;
	}

	@Override
	public double eval(Individu ind) {
		Simulation s = new Simulation(laby.clone(),
				((ControleurIndividuAdapter) ind).getValeurPropre());
		int perf = s.mesurePerf(nbSteps);
		return perf;
	}
}
