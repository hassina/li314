package agent.laby.exception;

import java.awt.Point;

public class LabyErroneException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point point;

	/**
	 * Construit une exception de labyrinthe erroné
	 * 
	 * @param point
	 *            Position liée à l'erreur dans le labyrinthe
	 * @param str
	 *            Message d'erreur
	 */
	public LabyErroneException(Point point, String str) {
		super("[" + point.x + "; " + point.y + "] " + str);
		this.point = point;
	}

	/**
	 * Accesseur à l'attribut Point
	 * 
	 * @return Point lié à l'erreur
	 */
	public Point getPoint() {
		return point;
	}

}
