package pobj.arith;

/**
 * Classe d'une constante
 * 
 */
public class Constante implements Expression {
	private final double value;

	/** Valeur de la constante */

	/**
	 * Construit une constante
	 * 
	 * @param value
	 *            Valeur de la constante
	 */
	public Constante(double value) {
		super();
		this.value = value;
	}

	public double eval(EnvEval e) {
		return value;
	}

	/**
	 * Accesseur à la valeur de la constante
	 * 
	 * @return Valeur de la constante
	 */
	public double getValue() {
		return value;
	}

	public String toString() {
		return "" + value;
	}

	public Expression simplifier() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Constante other = (Constante) obj;
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value))
			return false;
		return true;
	}

}
