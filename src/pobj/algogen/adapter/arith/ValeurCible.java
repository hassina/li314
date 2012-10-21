package pobj.algogen.adapter.arith;

import java.util.Random;

import pobj.algogen.Environnement;
import pobj.algogen.Individu;
import pobj.arith.EnvEval;

public class ValeurCible implements Environnement {
	private double cible;
	private EnvEval env;

	public ValeurCible() {
		Random r = new Random();
		cible = r.nextDouble();
		env = ExpressionFactory.createRandomEnvironnement();
	}

	public double eval(Individu ind) {
		return 1 / Math.pow(cible
				- ((IndividuExpression) ind).getValeurPropre().eval(env), 2);
	}

	public String toString() {
		return "ValeurCible [value=" + cible + "]";
	}

	/**
	 * @deprecated
	 * 
	 * @return
	 */
	public double getValue() {
		return cible;
	}

	/**
	 * @deprecated
	 * @return
	 */
	public EnvEval getEnv() {
		return env;
	}

}
