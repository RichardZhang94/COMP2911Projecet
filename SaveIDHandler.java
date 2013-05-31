import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class SaveIDHandler implements ActionListener{
	private Puzzle puzzle;
	private JFrame parentFrame;
	public SaveIDHandler(Puzzle puzzle, JFrame parentFrame)
	{
		this.puzzle = puzzle;
		this.parentFrame = parentFrame;
	}
	public void actionPerformed(ActionEvent event) {
		this.puzzle.setPuzzleName(event.getActionCommand());
		this.puzzle.savePuzzle();
		JFrame frame = new JFrame();
		frame.add(new JLabel("Puzzle saved!"));
		frame.pack();
		parentFrame.setVisible(false);
		frame.setVisible(true);
	}

}
