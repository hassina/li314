package pobj.algogen;

import java.util.Random;

import pobj.arith.EnvEval;

public class ValeurCible implements Environnement {
	private double value;
	private EnvEval env;

	// public ValeurCible(double value) {
	// super();
	// this.value = value;
	// env = new EnvEval(2);
	// }

	public ValeurCible() {
		Random r = new Random();
		value = r.nextDouble();
		env = new EnvEval(2);
	}

	@Override
	public double eval(Individu i) {
		return 1 / Math.pow(value - i.getValeurPropre().eval(env), 2);
	}

	public double getValue() {
		return value;
	}

	public EnvEval getEnv() {
		return env;
	}

	@Override
	public String toString() {
		return "ValeurCible [value=" + value + "]";
	}

}
