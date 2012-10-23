package agent.laby.interf.usercontrol;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class LabySliderPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSlider popSlider;
	private JSlider genSlider;

	public LabySliderPanel() {
		popSlider = new JSlider(0, 100, 10);
		initPopSlider();
		genSlider = new JSlider(0, 1000, 500);
		initGenSlider();
		initPanel();

	}

	private void initPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border loweredetched = BorderFactory
				.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder title = BorderFactory.createTitledBorder(loweredetched,
				"Nombre d'individus");
		JPanel psp = new JPanel();
		psp.add(popSlider, BorderLayout.CENTER);
		psp.setBorder(title);

		title = BorderFactory.createTitledBorder(loweredetched,
				"Nombre de générations");
		JPanel gsp = new JPanel();
		gsp.add(genSlider, BorderLayout.CENTER);
		gsp.setBorder(title);

		add(psp);
		add(gsp);
	}

	private void initPopSlider() {
		popSlider.setMajorTickSpacing(25);
		popSlider.setMinorTickSpacing(5);
		popSlider.setPaintTicks(true);
		popSlider.setPaintLabels(true);
	}

	private void initGenSlider() {
		genSlider.setMajorTickSpacing(250);
		genSlider.setMinorTickSpacing(50);
		genSlider.setPaintTicks(true);
		genSlider.setPaintLabels(true);
	}

	public int getPopSliderValue() {
		return popSlider.getValue();
	}

	public int getGenSliderValue() {
		return genSlider.getValue();
	}

}
