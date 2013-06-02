import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MiscButtonHandler implements ActionListener{
	/**
	 * puzzle which the gui is displaying
	 */
	private Puzzle puzzle;
	/**
	 * puzzle containing this listener
	 */
	private Gui gui;

	public MiscButtonHandler(Puzzle puzzle, Gui gui)
	{
		this.puzzle = puzzle;
		this.gui = gui;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event) 
	{
		JFrame miscFrame = new JFrame();
		if (event.getActionCommand() == "Save")
		{
			//creating a frame to acquire save ID from user
			JTextField inputField = new JTextField();
			inputField.addActionListener(new SaveIDHandler(puzzle, miscFrame));
			inputField.setOpaque(false);
			inputField.setBorder(null);
			inputField.setSize(200,50);
			BackgroundPanel savebg = new BackgroundPanel(new ImageIcon("sudoku/images/savebackground.png").getImage());
			savebg.setLayout(new BorderLayout());
			savebg.add(inputField, BorderLayout.CENTER);
			miscFrame.setContentPane(savebg);
			miscFrame.setSize(400,300);
			miscFrame.setTitle("Saving");
			miscFrame.setVisible(true);	
		}
		
		if (event.getActionCommand() == "Check")
		{
			//calling checkPuzzle method to determine whether puzzle is solved
			boolean correct = this.puzzle.checkPuzzle();
			//displaying appropriate message
			if (correct == true)
			{
				JLabel correctText = new JLabel(new ImageIcon("sudoku/images/success.png"));
				miscFrame.add(correctText, BorderLayout.CENTER);
				miscFrame.setTitle("Success");
			}else
			{
				JLabel incorrectText = new JLabel(new ImageIcon("sudoku/images/failure.png"));
				miscFrame.add(incorrectText, BorderLayout.CENTER);
				miscFrame.setTitle("Unsuccessful");
			}
			miscFrame.pack();
			miscFrame.setVisible(true);
		}
		
		if (event.getActionCommand() == "Back")
		{
			//hiding puzzle and showing the starting screen again
			gui.hidePuzzle();
			gui.showStartScreen();
		}
		
		if (event.getActionCommand() == "Solve")
		{
			
			this.gui.hidePuzzle();
			Puzzle solution = new Puzzle();
			//obtain full solution fromd database
			solution = new PuzzleDatabase().getSolution(this.puzzle.getID());
			int x = 0;
			int y = 0;
			while (y < 9)
			{
				while (x < 9)
				{
					//insert solution where values can be changed
					if (this.puzzle.canBeChanged(x, y) == true)
					{
						this.puzzle.changeValueAtPosition(x, y, solution.getValueAtPosition(x, y));
					}
					x++;
				}
				if (x >= 9)
				{
					y++;
					x = 0;
				}
			}
			this.gui.setPuzzle(this.puzzle);
			//refresh the gui
			this.gui.showPuzzle();
		}
		
		if (event.getActionCommand() == "Reset")
		{
			this.gui.hidePuzzle();
			int x = 0;
			int y = 0;
			while (y < 9)
			{
				while (x < 9)
				{
					//setting value at position back to 0 if it is a changeable position
					if (this.puzzle.canBeChanged(x, y) == true)
					{
						this.puzzle.clearPosition(x, y);
					}
					x++;
				}
				if (x >= 9)
				{
					y++;
					x = 0;
				}
			}
			this.gui.setPuzzle(this.puzzle);
			//refresh the gui
			this.gui.showPuzzle();
		}
	}

}
