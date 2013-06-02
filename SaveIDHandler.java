import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SaveIDHandler implements ActionListener{
	/**
	 * puzzle being displayed by the gui
	 */
	private Puzzle puzzle;
	/**
	 * frame which contains this listener
	 */
	private JFrame parentFrame;
	public SaveIDHandler(Puzzle puzzle, JFrame parentFrame)
	{
		this.puzzle = puzzle;
		this.parentFrame = parentFrame;
	}
	public void actionPerformed(ActionEvent event) {
		//calling save method on current puzzle
		this.puzzle.setPuzzleName(event.getActionCommand());
		this.puzzle.savePuzzle();
		//notifying user that save was successful
		JFrame frame = new JFrame("Saved");
		frame.add(new JLabel(new ImageIcon("sudoku/images/saved.png")));
		frame.pack();
		parentFrame.setVisible(false);
		frame.setVisible(true);
	}

}
