import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class LoadIDHandler implements ActionListener {
	private JFrame parentFrame;
	private Gui gui;
	public LoadIDHandler(JFrame parentFrame, Gui gui) {
		this.parentFrame = parentFrame;
		this.gui = gui;
	}

	public void actionPerformed(ActionEvent event) {
		Puzzle loadedPuzzle = new Puzzle();
		loadedPuzzle.loadPuzzle(event.getActionCommand());
		this.parentFrame.setVisible(false);
		this.gui.setPuzzle(loadedPuzzle);
		this.gui.showPuzzle();
	}

}
