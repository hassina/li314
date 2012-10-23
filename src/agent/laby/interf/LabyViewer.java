package agent.laby.interf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import pobj.algogen.Environnement;
import pobj.algogen.Population;
import pobj.algogen.adapter.agent.ControleurIndividuAdapter;
import pobj.algogen.adapter.agent.LabyEnvironnementAdapter;
import pobj.algogen.adapter.agent.PopulationFactory;
import agent.Simulation;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;
import agent.laby.interf.usercontrol.LabySliderPanel;

public class LabyViewer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LabyActivePanel centerPanel;
	private int nbPas;
	private JPanel sidePanel;
	private LabySliderPanel sliderPanel;
	private JTextArea descriptions;
	private IControleur controleur;
	private Labyrinthe laby;
	private Simulation simu;

	public LabyViewer(Labyrinthe laby, IControleur controleur, int nbPas) {
		super("Laby Viewer");
		this.laby = laby;
		this.controleur = controleur;
		this.nbPas = nbPas;
		this.simu = new Simulation(laby, controleur);
		createCenterPanel();
		createSidePanel();
		simu.addObserver(centerPanel);
		initJFrameSettings();
	}

	public LabyViewer(Labyrinthe laby) {
		super("Laby Viewer");
		this.laby = laby;
		this.nbPas = laby.getNbPoints();
		createCenterPanel();
		createSidePanel();
		initJFrameSettings();
	}

	private void initJFrameSettings() {
		setSize(900, 450);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Crée le MazePanel responsable d'afficher le Maze courant.
	 */
	private void createCenterPanel() {
		centerPanel = new LabyActivePanel(laby.clone());
		getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * Crée le panneau latéral, ses boutons et associe les actions appropriées
	 * aux boutons.
	 */
	private void createSidePanel() {
		Border loweredetched = BorderFactory
				.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder title;
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

		descriptions = new JTextArea();
		descriptions.setText("Laby Viewer\n");
		descriptions.setEditable(false);

		JScrollPane descriptionSP = new JScrollPane(descriptions);

		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setLayout(new BorderLayout());
		descriptionPanel.add(descriptionSP, BorderLayout.CENTER);
		title = BorderFactory.createTitledBorder(loweredetched,
				"Description du contrôleur");
		descriptionPanel.setBorder(title);

		sidePanel.add(descriptionPanel);

		sliderPanel = new LabySliderPanel();
		sidePanel.add(sliderPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		title = BorderFactory.createTitledBorder(loweredetched, "Menu");
		buttonPanel.setBorder(title);

		final JButton playButton = new JButton("Jouer");
		playButton.setIcon(new ImageIcon("res/control.png"));
		playButton.setEnabled(false);
		buttonPanel.add(playButton);

		JButton generatePopulationButton = new JButton(
				"Générer une nouvelle population");
		generatePopulationButton.setIcon(new ImageIcon("res/user--plus.png"));
		buttonPanel.add(generatePopulationButton);

		sidePanel.add(buttonPanel);

		// Les actions sur les boutons, cette forme anonyme évite les
		// getSource() dans actionPerformed
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// L'action consiste démarrer la simulation
				new Thread(new Runnable() {
					@Override
					public void run() {
						Labyrinthe labyClone = laby.clone();
						centerPanel.setLaby(labyClone);
						simu = new Simulation(labyClone, controleur);
						simu.addObserver(centerPanel);
						simu.mesurePerf(nbPas);
					}
				}).start();
			}
		});

		generatePopulationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// L'action consiste démarrer la simulation
				new Thread(new Runnable() {
					@Override
					public void run() {
						playButton.setEnabled(false);
						controleur = processFittest(laby,
								sliderPanel.getPopSliderValue(), nbPas, 10,
								sliderPanel.getGenSliderValue());
						descriptions.setText(controleur.toString());
						playButton.setEnabled(true);
					}
				}).start();
			}
		});

		getContentPane().add(sidePanel, BorderLayout.EAST);
	}

	/**
	 * Getter
	 * 
	 * @return : le labyrinthe
	 */
	public Labyrinthe getLaby() {
		return laby;
	}

	public static IControleur processFittest(Labyrinthe laby, int nbIndividu,
			int nbPas, int nbRules, int nbGen) {
		Population pop = PopulationFactory.createRandomPopulation(nbIndividu,
				nbRules);
		Environnement cible = new LabyEnvironnementAdapter(laby, nbPas);
		for (int i = 0; i < nbGen; i++) {
			pop = pop.evoluer(cible);
			System.out.print("[gen " + i + " ]\t");
			System.out.println(pop.toString());
		}
		return ((ControleurIndividuAdapter) pop.get(0)).getValeurPropre();
	}

	/**
	 * Méthode principale
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String labyFile = args[0];
		// int nbPas = Integer.parseInt(args[1]);
		// int nbRules = Integer.parseInt(args[2]);
		// int nbGen = Integer.parseInt(args[3]);
		if (args.length != 4) {
			System.err.println("args needed : labyFile nbSteps nbRules nbGen");
			System.exit(1);
		}

		try {
			Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);

			new LabyViewer(laby);

		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe" + e);
			System.exit(1);
		}

	}
}
