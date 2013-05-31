import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MiscButtonHandler implements ActionListener{
	private Puzzle puzzle;
	private Gui gui;
	public MiscButtonHandler(Puzzle puzzle, Gui gui)
	{
		this.puzzle = puzzle;
		this.gui = gui;
	}
	public void actionPerformed(ActionEvent event) 
	{
		JFrame miscFrame = new JFrame();
		if (event.getActionCommand() == "Save")
		{
			JTextField inputField = new JTextField();
			inputField.addActionListener(new SaveIDHandler(puzzle, miscFrame));
			inputField.setOpaque(false);
			inputField.setBorder(null);
			inputField.setSize(200,50);
			BackgroundPanel savebg = new BackgroundPanel(new ImageIcon("C:/sudoku/images/savebackground.png").getImage());
			savebg.setLayout(new BorderLayout());
			savebg.add(inputField, BorderLayout.CENTER);
			miscFrame.setContentPane(savebg);
			miscFrame.setSize(400,300);
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
		
		if (event.getActionCommand() == "Back")
		{
			gui.hidePuzzle();
			gui.showStartScreen();
		}
		
	}

}
