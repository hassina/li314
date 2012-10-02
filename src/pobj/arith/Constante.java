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

	public boolean equals(Object o) {
		return value == ((Constante) o).getValue();
	}

}
