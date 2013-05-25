import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class StartScreenButtonHandler implements ActionListener {
	private Gui gui;
	public StartScreenButtonHandler(Gui gui)
	{
		this.gui = gui;
	}
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Load game")
		{
			JFrame loadFrame = new JFrame();
			JLabel instruction = new JLabel("Please enter your save ID below and press enter");
			JTextField inputField = new JTextField();
			inputField.addActionListener(new LoadIDHandler(loadFrame, this.gui));
			loadFrame.add(instruction, BorderLayout.NORTH);
			loadFrame.add(inputField, BorderLayout.CENTER);
			loadFrame.pack();
			loadFrame.setVisible(true);
		}
		if (event.getActionCommand() == "New game")
		{
			PuzzleDatabase puzzles = new PuzzleDatabase();
			gui.setPuzzle(puzzles.getPuzzle());
			gui.showPuzzle();
			gui.hideStartScreen();
		}

	}

}
