package pobj.arith;

/**
 * Classe de représentation d'un opérateur binaire
 */
public class OperateurBinaire implements Expression {

	private Operator op;
	/** Opérateur */
	private Expression left;
	/** Expression de gauche */
	private Expression right;

	/** Expression de droite */

	/**
	 * Construit un opérateur binaire
	 * 
	 * @param op
	 *            Opérateur
	 * @param left
	 *            Expression de gauche
	 * @param right
	 *            Expression de droite
	 */
	public OperateurBinaire(Operator op, Expression left, Expression right) {
		super();
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public double eval(EnvEval e) {
		switch (op) {
		case DIV:
			return left.eval(e) / right.eval(e);
		case MINUS:
			return left.eval(e) - right.eval(e);
		case MULT:
			return left.eval(e) * right.eval(e);
		case PLUS:
			return left.eval(e) + right.eval(e);
		default:
			System.err.println("Erreur : opérateur invalide");
			return -1;
		}
	}

	/**
	 * Accesseur à l'expression de gauche
	 * 
	 * @return Expression de gauche
	 */
	public Expression getLeft() {
		return left;
	}

	/**
	 * Accesseur à l'expression de droite
	 * 
	 * @return Expression de droite
	 */
	public Expression getRight() {
		return right;
	}

	public String toString() {
		return "(" + left + " " + op + " " + right + ")";
	}
}
