package pobj.algogen.adapter.agent;

import agent.control.ControlFactory;
import agent.control.IControleur;
import pobj.algogen.AbstractIndividu;
import pobj.algogen.Individu;

public class ControleurIndividuAdapter extends AbstractIndividu {

	private IControleur controleur; // la valeur propre

	public ControleurIndividuAdapter(IControleur controleur) {
		setFitness(0.0);
		this.controleur = controleur;
	}

	public ControleurIndividuAdapter(int nbRules) {
		setFitness(0.0);
		controleur = ControlFactory.createControleur(nbRules);
	}

	public IControleur getValeurPropre() {
		return controleur;
	}

	@Override
	public Individu croiser(Individu autre) {
		double proba = 0.25;
		ControleurIndividuAdapter cia = (ControleurIndividuAdapter) autre;
		return new ControleurIndividuAdapter(controleur.creeFils(cia
				.getValeurPropre().clone(), proba));
	}

	@Override
	public void muter() {
		double proba = 0.25;
		controleur.muter(proba);
	}

	@Override
	public ControleurIndividuAdapter clone() {
		return new ControleurIndividuAdapter(controleur.clone());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControleurIndividuAdapter other = (ControleurIndividuAdapter) obj;
		if (controleur == null) {
			if (other.controleur != null)
				return false;
		} else if (!controleur.equals(other.controleur))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ControleurIndividuAdapter [controleur=" + controleur + "]";
	}

}
