import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MiscButtonHandler implements ActionListener{
	private Puzzle puzzle;
	public MiscButtonHandler(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}
	public void actionPerformed(ActionEvent event) 
	{
		JFrame miscFrame = new JFrame();
		if (event.getActionCommand() == "Save")
		{
			JLabel instruction = new JLabel("Please enter your desired save ID below");
			JTextField inputField = new JTextField();
			inputField.addActionListener(new SaveIDHandler(puzzle, miscFrame));
			miscFrame.add(instruction, BorderLayout.NORTH);
			miscFrame.add(inputField, BorderLayout.CENTER);
			miscFrame.pack();
			miscFrame.setVisible(true);
		}
		
		if (event.getActionCommand() == "Check")
		{
			boolean correct = this.puzzle.checkPuzzle();
			if (correct == true)
			{
				JLabel correctText = new JLabel("Congratulations, you solved the puzzle!");
				miscFrame.add(correctText, BorderLayout.CENTER);
			}else
			{
				JLabel incorrectText = new JLabel("Looks like this puzzle is incorrect, try again");
				miscFrame.add(incorrectText, BorderLayout.CENTER);
			}
			miscFrame.pack();
			miscFrame.setVisible(true);
		}
		
	}

}
