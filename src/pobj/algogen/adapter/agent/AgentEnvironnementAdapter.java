package pobj.algogen.adapter.agent;

import agent.Simulation;
import agent.control.IControleur;
import agent.laby.Labyrinthe;
import pobj.algogen.Environnement;
import pobj.algogen.Individu;

public class AgentEnvironnementAdapter implements Environnement {

	private Labyrinthe laby;
	private IControleur controleur;

	public AgentEnvironnementAdapter(Labyrinthe laby, IControleur controleur) {
		this.laby = laby;
		this.controleur = controleur;
	}

	@Override
	public double eval(Individu i) {
		Simulation sim = new Simulation(laby.clone(), controleur);
		// TODO Solution temporaire (à revoir au TP 9)
		return sim.mesurePerf(laby.getNbPoints());
	}

}
