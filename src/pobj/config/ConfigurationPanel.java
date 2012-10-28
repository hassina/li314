package pobj.config;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ConfigurationPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel panel = new JPanel();
	private static HashMap<String, JTextField> refs = new HashMap<String, JTextField>();
	private static HashMap<String, JLabel> labels = new HashMap<String, JLabel>();
	private static ArrayList<String> noms = new ArrayList<String>();

	public ConfigurationPanel() {
		super("Configuration");
		add(panel, BorderLayout.CENTER);
		initForm();
		pack();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	private void put(String str) {
		labels.put(str, new JLabel(str));
		refs.put(str, new JTextField(20));
		noms.add(str);
	}

	private void initAll() {
		put(AlgoGenParameter.LABY_FILE);
		put(AlgoGenParameter.NB_STEPS);
		put(AlgoGenParameter.NB_RULES);
		put(AlgoGenParameter.NB_GEN);
		put(AlgoGenParameter.TAILLE_POP);
	}

	private void initForm() {
		panel.setLayout(new GridLayout(refs.size(), 2));
		initAll();
		for (String str : noms) {
			panel.add(labels.get(str));
			panel.add(refs.get(str));
		}

		final JTextField tFileName = new JTextField("default.cfg", 20);
		panel.add(tFileName);
		JButton btnSave = new JButton("Sauvegarder");
		panel.add(btnSave);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					for (String str : noms) {
						Configuration.getInstance().setParameterValue(str,
								refs.get(str).getText());

					}
					Configuration.sauverConfiguration(tFileName.getText(),
							Configuration.getInstance());

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public static void main(String[] args) {
		new ConfigurationPanel();
	}
}