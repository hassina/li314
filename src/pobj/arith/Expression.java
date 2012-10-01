package pobj.arith;

/**
 * Interface d'une Expression
 * 
 */
public interface Expression {
	/**
	 * Evalue l'expression
	 * 
	 * @param e
	 *            Ebvironnement d'évaluation
	 * @return Résultat de l'évaluation
	 */
	public double eval(EnvEval e);

	/**
	 * Simplifie l'expression
	 * @return Résultat de la simplification de l'expression
	 */
	public Expression simplifier();
}
