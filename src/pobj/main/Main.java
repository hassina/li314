package pobj.main;

import pobj.algogen.adapter.arith.ExpressionFactory;
import pobj.arith.EnvEval;
import pobj.arith.Expression;

/**
 * Classe principal du programme
 * 
 */
public class Main {

	public static void main(String[] args) {

		/* création d'un environnement */
		EnvEval env = new EnvEval(3);
		env.setVariable(0, 10);
		env.setVariable(1, 20);
		env.setVariable(2, 30);

		double avg = 0;
		for (int i = 0; i < 20; i++) {

			/* génération d'une expression aléatoire */
			Expression eRand = ExpressionFactory.createRandomExpression();

			/* affichage de l'expression et de son évaluation */
			avg += eRand.eval(env);
			System.out.println(eRand + " = " + eRand.eval(env));

		}
		avg /= 20;
		System.out.println("Moyenne : " + avg);

	}
}
