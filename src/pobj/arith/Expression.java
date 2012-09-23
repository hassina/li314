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
}
