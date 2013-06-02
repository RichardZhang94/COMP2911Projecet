import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class GridButtonHandler implements ActionListener{
	/**
	 * the puzzle being displayed on the gui containing this listener
	 */
	private Puzzle puzzle;
	/**
	 * the gui displaying this listener
	 */
	private Gui gui;
	
	/**
	 * @param puzzle
	 * @param gui
	 */
	public GridButtonHandler (Puzzle puzzle, Gui gui)
	{
		this.puzzle = puzzle;
		this.gui = gui;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event) {
		//obtaining the x and y coordinates of the button from the label
		JButton source = (JButton) event.getSource();
		String newValue = this.gui.getInputToUse().toString();
		source.setText(newValue);
		//coordinates are in the label of the button
		String label = source.getName();
		char[] coordinates = label.toCharArray();
		int xCoordinate = coordinates[0] - 48;
		int yCoordinate = coordinates[1] - 48;
		System.out.println("setting (" + xCoordinate + ", " + yCoordinate + ") to " + this.gui.getInputToUse());
		//changing required value
		this.puzzle.changeValueAtPosition(xCoordinate, yCoordinate, this.gui.getInputToUse());
	}

}
