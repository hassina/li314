package pobj.arith;

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

		/* génération d'une expression aléatoire */
		Expression eRand = ExpressionFactory.createRandomExpression();

		/* affichage de l'expression et de son évaluation */
		System.out.println(eRand + " = " + eRand.eval(env));
	}
}
