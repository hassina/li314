package agent.laby.exception;

import java.awt.Point;

public class CaseDepartNonVideException extends LabyErroneException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaseDepartNonVideException(Point point) {
		super(point, "Case départ non vide");
	}

}
