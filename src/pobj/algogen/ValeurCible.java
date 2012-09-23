package pobj.algogen;

import java.util.Random;

public class ValeurCible implements Environnement {
	private double value;

	@Override
	public double eval(Individu i) {
		return 1 / Math.pow(value - i.getValeurPropre(), 2);
	}

	public ValeurCible(double value) {
		super();
		this.value = value;
	}

	public ValeurCible() {
		Random r = new Random();
		value = r.nextDouble();
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "ValeurCible [value=" + value + "]";
	}

}
