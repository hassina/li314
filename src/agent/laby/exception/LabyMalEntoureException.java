package agent.laby.exception;

import java.awt.Point;

public class LabyMalEntoureException extends LabyErroneException {

	private static final long serialVersionUID = 1L;

	public LabyMalEntoureException(Point point) {
		super(point, "Laby mal entouré");
	}

}
