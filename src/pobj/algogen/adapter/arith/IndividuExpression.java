package pobj.algogen.adapter.arith;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.Individu;
import pobj.arith.Expression;
import pobj.arith.Operator;

public class IndividuExpression extends AbstractIndividu {
	private Expression valeurPropre;

	public IndividuExpression() {
		setFitness(0.0);
		valeurPropre = ExpressionFactory.createRandomExpression();
	}

	public IndividuExpression(Expression valeurPropre) {
		setFitness(0.0);
		this.valeurPropre = valeurPropre;
	}

	public Expression getValeurPropre() {
		return valeurPropre;
	}

	@Override
	public String toString() {
		return "IndividuExpression [valeurPropre=" + valeurPropre + "]";
	}

	public IndividuExpression croiser(Individu ind) {
		IndividuExpression indExpr = (IndividuExpression) ind;
		if (valeurPropre.equals(indExpr.valeurPropre)) {
			return this;
		}
		return new IndividuExpression(ExpressionFactory.createOperateurBinaire(
				Operator.DIV,
				ExpressionFactory.createOperateurBinaire(Operator.PLUS,
						valeurPropre, indExpr.getValeurPropre()),
				ExpressionFactory.createConstante(2)));

	}

	public void muter() {
		valeurPropre = ExpressionFactory.createRandomExpression();
	}

	public IndividuExpression clone() {
		return new IndividuExpression(valeurPropre);
	}

}
