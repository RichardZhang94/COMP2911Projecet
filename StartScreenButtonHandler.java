import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
			BackgroundPanel loadbg = new BackgroundPanel(new ImageIcon("C:/sudoku/images/loadbackground.png").getImage());
			JFrame loadFrame = new JFrame();
			JTextField inputField = new JTextField();
			inputField.addActionListener(new LoadIDHandler(loadFrame, this.gui));
			inputField.setOpaque(false);
			loadbg.setLayout(new BorderLayout());
			loadbg.add(inputField, BorderLayout.CENTER);
			loadFrame.setContentPane(loadbg);
			loadFrame.setSize(400,300);
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
