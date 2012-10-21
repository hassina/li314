package pobj.arith;

/**
 * Classe de représentation d'une variable
 */
public class Variable implements Expression {

	private final int rang;

	/** Rang de la variable dans l'environnement */

	/**
	 * Construit une variable
	 * 
	 * @param rang
	 *            Rang de la variable dans l'environnement
	 */
	public Variable(int rang) {
		super();
		this.rang = rang;
	}

	public double eval(EnvEval e) {
		return e.getValue(rang);
	}

	public String toString() {
		return "var[" + rang + "]";
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
		Variable other = (Variable) obj;
		if (rang != other.rang)
			return false;
		return true;
	}

}
