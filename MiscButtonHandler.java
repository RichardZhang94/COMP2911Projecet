import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class MiscButtonHandler implements ActionListener{
	private Puzzle puzzle;
	public MiscButtonHandler(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Save")
		{
			this.puzzle.savePuzzle();
		}
		
		if (event.getActionCommand() == "Check")
		{
			boolean correct = this.puzzle.checkPuzzle();
			JFrame checkFrame = new JFrame();
			checkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			if (correct == true)
			{
				JLabel correctText = new JLabel("Congratulations, you solved the puzzle!");
				checkFrame.add(correctText, BorderLayout.CENTER);
			}else
			{
				JLabel incorrectText = new JLabel("Looks like this puzzle is incorrect, try again");
				checkFrame.add(incorrectText, BorderLayout.CENTER);
			}
			checkFrame.pack();
			checkFrame.setVisible(true);
		}
		
	}

}
