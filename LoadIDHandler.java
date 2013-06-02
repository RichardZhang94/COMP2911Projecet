import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class LoadIDHandler implements ActionListener {
	/**
	 * frame which contains this button
	 */
	private JFrame parentFrame;
	/**
	 * gui contain the parent frame
	 */
	private Gui gui;

	public LoadIDHandler(JFrame parentFrame, Gui gui) {
		this.parentFrame = parentFrame;
		this.gui = gui;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event) {
		//calling load method and changing the puzzle to the result
		Puzzle loadedPuzzle = new Puzzle();
		loadedPuzzle.setPuzzleName(event.getActionCommand());
		loadedPuzzle.loadPuzzle(event.getActionCommand());
		this.parentFrame.setVisible(false);
		this.gui.hideStartScreen();
		this.gui.setPuzzle(loadedPuzzle);
		this.gui.showPuzzle();
	}

}
