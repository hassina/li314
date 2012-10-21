package pobj.arith;

import pobj.algogen.adapter.arith.ExpressionFactory;

/**
 * Classe de représentation d'un opérateur binaire
 */
public class OperateurBinaire implements Expression {

	private final Operator op;
	/** Opérateur */
	private final Expression left;
	/** Expression de gauche */
	private final Expression right;

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

	public Expression simplifier() {
		if (left instanceof Constante && right instanceof Constante) {
			EnvEval env = new EnvEval(0);
			return ExpressionFactory.createConstante(this.eval(env));
		}
		return ExpressionFactory.createOperateurBinaire(op, left.simplifier(),
				right.simplifier());

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperateurBinaire other = (OperateurBinaire) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (op != other.op)
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

}
