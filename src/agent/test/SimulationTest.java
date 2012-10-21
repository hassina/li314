package agent.test;

import junit.framework.TestCase;
import agent.Simulation;
import agent.control.ControlFactory;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;

public class SimulationTest extends TestCase {

	private Simulation simuTest;

	protected void setUp() throws Exception {
		super.setUp();
		Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe("default.mze");
		IControleur sc = ControlFactory.createControleurDroitier();
		simuTest = new Simulation(laby, sc);
	}

	public void testSimulation() {
		System.out.println(simuTest.getScore());
	}

	public void testMesurePerf() {
		assertTrue(simuTest.mesurePerf(20) == 12);

	}

}
