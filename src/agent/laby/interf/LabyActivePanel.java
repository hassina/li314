package agent.laby.interf;

import java.awt.event.ActionEvent;

import pobj.obs.ISimpleObserver;
import agent.laby.Labyrinthe;

public class LabyActivePanel extends LabyPanel implements ISimpleObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LabyActivePanel(Labyrinthe laby) {
		super(laby);
	}

	@Override
	public void update() {
		// ralentir l'affichage
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// forcer l'affichage à se rafraichir
		updateGraphics();
	}

	public void actionPerformed(ActionEvent e) {
		// requalifier le type de la source
		CaseButton c = (CaseButton) e.getSource();
		// mettre à jour le Maze à la position concernée
		laby.setPositionInitiale(c.getPosition());

	}
}
