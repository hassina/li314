package pobj.arith;

import java.util.Random;

/**
 * Classe de la fabrique d'expression
 */
public class ExpressionFactory {

	private static final int MAXVARIABLE = 2;
	/** Constante */
	private static Random generateur = new Random();

	/** Générateur de nombre aléatoire */

	/**
	 * Un constructeur pour des expressions binaires usuelles: +,-,*,/
	 * 
	 * @param op
	 *            le type de l'opérande, {@link Operator}, PLUS,MOINS,MULT,DIV
	 * @param left
	 *            operande gauche
	 * @param right
	 *            operande droite
	 * @return une expression binaire
	 */
	public static Expression createOperateurBinaire(Operator op,
			Expression left, Expression right) {
		return new OperateurBinaire(op, left, right);

	}

	/**
	 * Un constructeur d'expressions constantes.
	 * 
	 * @param constant
	 *            sa valeur
	 * @return une constante
	 */
	public static Expression createConstante(double constant) {
		return new Constante(constant);
	}

	/**
	 * Un constructeur de variables, identifiées par un entier compris entre 0
	 * et MAXVARIABLES. La demande de création de variables d'indice plus grand
	 * entraine un accroissement de MAXVARIABLE (attribut static).
	 * 
	 * @param id
	 *            l'indice de la variable
	 * @return une Variable
	 */
	public static Expression createVariable(int id) {
		return new Variable(id);
	}

	/**
	 * Génère une expression aléatoire
	 * 
	 * @return Une expression générée aléatoirement.
	 */

	public static Expression createRandomExpression() {
		// cte var opbin (+ * -)

		return createRandomExpresssionRec(generateur.nextInt(3));
	}

	/**
	 * Fonction récursive de génération d'expression aléatoire
	 * 
	 * @param profondeur
	 *            Profondeur de l'expression à générer
	 * @return Une expression générée aléatoirement.
	 */
	private static Expression createRandomExpresssionRec(int profondeur) {

		int rand = generateur.nextInt(2);

		if (profondeur == 0) {
			if (rand == 0) {
				return createConstante(generateur.nextDouble());
			} else {
				return new Variable(generateur.nextInt(MAXVARIABLE));
			}
		}
		rand = generateur.nextInt(3);
		switch (rand) {
		case 0:
			return new OperateurBinaire(Operator.MINUS,
					createRandomExpresssionRec(profondeur - 1),
					createRandomExpresssionRec(profondeur - 1));
		case 1:
			return new OperateurBinaire(Operator.MULT,
					createRandomExpresssionRec(profondeur - 1),
					createRandomExpresssionRec(profondeur - 1));
		default:
			return new OperateurBinaire(Operator.PLUS,
					createRandomExpresssionRec(profondeur - 1),
					createRandomExpresssionRec(profondeur - 1));
		}

	}

	/**
	 * Génère un environnement d'évaluation aléatoire, en supposant qu'il n'y a
	 * pas plus de MAXVARIABLES.
	 * 
	 * @return Un environnement généré aléatoirement.
	 */
	public static EnvEval createRandomEnvironnement() {
		EnvEval env = new EnvEval(MAXVARIABLE);
		for (int i = 0; i < MAXVARIABLE; i++) {
			env.setVariable(i, generateur.nextDouble());
		}
		return env;
	}

}
