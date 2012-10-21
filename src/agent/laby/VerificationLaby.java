package agent.laby;

import java.awt.Point;

import agent.laby.exception.CaseDepartNonVideException;
import agent.laby.exception.LabyErroneException;
import agent.laby.exception.LabyMalEntoureException;

public class VerificationLaby {

	/**
	 * Vérifie que la case de départ est vide et que le labyrinthe est bien
	 * entouré
	 * 
	 * @param l
	 *            Labyrinthe
	 * @throws LabyErroneException
	 *             Exception d'un labyrinthe erroné
	 */
	public static void verifierConditions(Labyrinthe l)
			throws LabyErroneException {
		estCaseInitialeVide(l);
		estEntoureDeMurs(l);
	}

	private static void estCaseInitialeVide(Labyrinthe l)
			throws CaseDepartNonVideException {
		Point p = l.getPositionInitiale();
		if (l.getContenuCase(p) == ContenuCase.MUR) {
			throw new CaseDepartNonVideException(p);
		}
	}

	/**
	 * Vérifie qu'un labyrinthe est entouré de murs
	 * 
	 * @param l
	 *            Labyrinthe
	 * @throws LabyMalEntoureException
	 *             Exception d'un labyrinthe mal entouré
	 */
	private static void estEntoureDeMurs(Labyrinthe l)
			throws LabyMalEntoureException {
		int imax = l.Xsize() - 1;
		int jmax = l.Ysize() - 1;
		for (int i = 0; i < l.Xsize(); i++) {
			if (l.getContenuCase(i, jmax) != ContenuCase.MUR)
				throw new LabyMalEntoureException(new Point(i, jmax));
			if (l.getContenuCase(i, 0) != ContenuCase.MUR)
				throw new LabyMalEntoureException(new Point(i, 0));
		}
		for (int j = 0; j < l.Ysize(); j++) {
			if (l.getContenuCase(0, j) != ContenuCase.MUR)
				throw new LabyMalEntoureException(new Point(0, j));
			if (l.getContenuCase(imax, j) != ContenuCase.MUR)
				throw new LabyMalEntoureException(new Point(imax, j));
		}
	}

	/**
	 * Corrige un labyrinthe
	 * 
	 * @param l
	 *            Labyrinthe à corriger
	 * @return Nombre de corrections effectuées
	 */
	public static int corrigerLabyrinthe(Labyrinthe l) {
		int nbErr = 0;
		boolean loop = true;
		while (loop) {
			try {
				loop = false;
				verifierConditions(l);
			} catch (LabyErroneException e) {
				nbErr++;
				if (e instanceof LabyMalEntoureException) {
					l.setContenuCase(e.getPoint(), ContenuCase.MUR);
				} else {
					if (e instanceof CaseDepartNonVideException) {
						l.setContenuCase(e.getPoint(), ContenuCase.VIDE);
					}
				}
				loop = true;
			}
		}
		return nbErr;
	}
}
