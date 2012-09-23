package pobj.arith;

/**
 * Classe de représentation d'une variable
 */
public class Variable implements Expression {

	private int rang;

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

}
