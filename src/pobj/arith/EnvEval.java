package pobj.arith;

import java.util.Arrays;

/**
 * Classe d'un Environnement d'évaluation
 * 
 */
public class EnvEval {

	private double[] variables;

	/** Tableau des variables de l'environnement */

	/**
	 * Construit un environnement d'évaluation
	 * 
	 * @param size
	 *            Taille du tableau des variables de l'environnement
	 */
	public EnvEval(int size) {
		variables = new double[size];
	}

	/**
	 * Définit une variable dans le tableau des variables
	 * 
	 * @param i
	 *            Rang de la variable à définir dans le tableau des variables
	 * @param value
	 *            Valeur de la variable à définir
	 */
	public void setVariable(int i, double value) {
		variables[i] = value;
	}

	/**
	 * Accesseur à la valeur d'une variable
	 * 
	 * @param i
	 *            Rang de la variable dans le tableau des variables
	 * @return Valeur de la variable dans le tableau des variables
	 */
	public double getValue(int i) {
		return variables[i];
	}

	public String toString() {
		return "EnvEval [variables=" + Arrays.toString(variables) + "]";
	}

}