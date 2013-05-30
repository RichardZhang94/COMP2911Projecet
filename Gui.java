import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Gui{

	private JLabel label;
	private JButton button;
	private Integer inputToUse = 0;
	private JFrame startScreen;
	private JFrame sudokuGrid;
	private JLabel inputIndicator;
	public void setPuzzle(Puzzle puzzle)
	{
		JPanel sudokuGrid = new JPanel();	//making the sudoku grid
		sudokuGrid.setLayout(new GridLayout(9,9));
		sudokuGrid.setPreferredSize(new Dimension(500,500));
		Integer i = 1;
		Integer x = 0;
		Integer y = 0;
		GridButtonHandler gridButtonHandler = new GridButtonHandler(puzzle, this);
		while (i <= 81)
		{
			Integer value = puzzle.getValueAtPosition(x, y);
			button = new JButton(value.toString());
			button.setForeground(Color.blue);
			button.setBackground(Color.white);
			button.setOpaque(false);
			button.setBorderPainted(false);
			String label = "";
			label = label.concat(x.toString());
			label = label.concat(y.toString());
			button.setName(label);
			if (puzzle.canBeChanged(x, y) == false)	//unchangeable buttons will be red and cannot be clicked
			{
				button.setForeground(Color.red);
				button.setEnabled(false);
			}
			button.setPreferredSize(new Dimension(30, 30));
			button.addActionListener(gridButtonHandler);
			sudokuGrid.add(button);
			i++;
			if (x < 8)
			{
				x++;
			}
			else
			{
				x = 0;
				y++;
			}
		}
		JPanel inputLabel = new JPanel();
		label = new JLabel("");
		inputLabel.setLayout(new FlowLayout());		//making room for the input label
		inputLabel.setOpaque(false);
		inputLabel.setForeground(Color.white);
		inputLabel.add(label);
		JPanel inputGrid = new JPanel();
		inputGrid.setLayout(new GridLayout(3,3));	//making the input grid
		inputGrid.setPreferredSize(new Dimension(200,200));
		inputGrid.setOpaque(false);
		InputHandler inputHandler = new InputHandler(this);
		i = 1;
		while (i <= 9)
		{
			String s = i.toString();
			button = new JButton(s);
			button.setBackground(Color.white);
			button.setOpaque(false);
			button.setForeground(Color.green);
			button.setBorderPainted(false);
			button.setPreferredSize(new Dimension(40, 40));
			button.addActionListener(inputHandler);
			inputGrid.add(button);
			i++;
		}
		JPanel inputPanel = new JPanel();			//input panel consists of the input grid and the input label
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(inputLabel, BorderLayout.NORTH);
		inputPanel.add(inputGrid, BorderLayout.CENTER);
		
		JPanel miscButtons	= new JPanel();			//making miscellaneous buttons
		MiscButtonHandler miscButtonHandler = new MiscButtonHandler(puzzle, this);
		miscButtons.setLayout(new GridBagLayout());
		button = new JButton("Save");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setBorderPainted(false);
		miscButtons.add(button);
		button = new JButton("Check");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setBorderPainted(false);
		miscButtons.add(button);
		button = new JButton("Back");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setBorderPainted(false);
		miscButtons.add(button);
		
		JPanel inputIndicator = new JPanel();
		JLabel title = new JLabel("Selected Input:");
		title.setForeground(Color.green);
		JLabel input = new JLabel("0");
		input.setForeground(Color.green);
		inputIndicator.add(title, BorderLayout.NORTH);
		inputIndicator.add(input, BorderLayout.SOUTH);
		this.inputIndicator = input;
		
		ImageIcon bg = new ImageIcon("C:/sudoku/images/puzzlebackground.png");
		BackgroundPanel finalFrame = new BackgroundPanel(bg.getImage());
		sudokuGrid.setOpaque(false);
		inputPanel.setOpaque(false);
		miscButtons.setOpaque(false);
		inputIndicator.setOpaque(false);
		finalFrame.setLayout(new BorderLayout());
		finalFrame.add(sudokuGrid, BorderLayout.NORTH);				//adding panels to the window
		finalFrame.add(inputPanel, BorderLayout.EAST);
		finalFrame.add(miscButtons, BorderLayout.WEST);
		finalFrame.add(inputIndicator, BorderLayout.CENTER);
		finalFrame.setSize(700,700);	
		JFrame sudokuFrame = new JFrame("Sudoku - In Game");			//creating the sudoku window
		sudokuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//exit when the 'x' button is clicked
		sudokuFrame.add(finalFrame);
		sudokuFrame.pack();
		this.sudokuGrid = sudokuFrame;
	}
	public void showPuzzle()
	{
		this.sudokuGrid.setVisible(true);
	}
	public void hidePuzzle()
	{
		this.sudokuGrid.setVisible(false);
	}
	public void createStartScreen()
	{
		JPanel startScreenButtons = new JPanel();	//creating the panel which contains the start screen buttons
		startScreenButtons.setPreferredSize(new Dimension(500, 100));
		button = new JButton("Load game");
		button.addActionListener(new StartScreenButtonHandler(this));
		startScreenButtons.add(button, BorderLayout.WEST);
		button = new JButton("New game");
		button.addActionListener(new StartScreenButtonHandler(this));
		startScreenButtons.add(button, BorderLayout.EAST);
		JFrame startScreen = new JFrame("Sudoku - Start Screen");
		startScreen.add(startScreenButtons);
		ImageIcon background = new ImageIcon("C:/sudoku/images/startscreenbackground.png");
		JLabel backgroundImage = new JLabel(background);
		startScreen.add(backgroundImage, BorderLayout.NORTH);
		startScreen.pack();
		this.startScreen = startScreen;
	}
	public void showStartScreen()
	{
		this.startScreen.setVisible(true);
	}
	public void hideStartScreen()
	{
		this.startScreen.setVisible(false);
	}
	public void setInputToUse (Integer input)
	{
		this.inputToUse = input;
	}
	public Integer getInputToUse()
	{
		return this.inputToUse;
	}
	public void setInputIndicator(String input)
	{
		this.inputIndicator.setText(input);
	}
}
