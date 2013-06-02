import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class Gui{

	/**
	 * temp variable for labels
	 */
	private JLabel label;
	/**
	 * temp variable for buttons
	 */
	private JButton button;
	/**
	 * value of the selected input
	 */
	private Integer inputToUse = 0;
	/**
	 * the start frame
	 */
	private JFrame startScreen;
	/**
	 * the in-game frame
	 */
	private JFrame sudokuGrid;
	/**
	 * label which inidcates selected input
	 */
	private JLabel inputIndicator;
	/**
	 * @param puzzle puzzle to be displayed with this gui
	 */
	public void setPuzzle(Puzzle puzzle)
	{
		//disabled buttons will have red text
		UIManager.put("Button.disabledText", Color.red);
		//initializing the sudoku grid
		JPanel sudokuGrid = new JPanel();
		sudokuGrid.setLayout(new GridLayout(9,9));
		sudokuGrid.setPreferredSize(new Dimension(500,500));
		Integer i = 1;
		Integer x = 0;
		Integer y = 0;
		GridButtonHandler gridButtonHandler = new GridButtonHandler(puzzle, this);
		//adding the input positions as buttons to the grid
		while (i <= 81)
		{
			//using the value from the puzzle as the text displayed on the button
			Integer value = puzzle.getValueAtPosition(x, y);
			button = new JButton(value.toString());
			button.setForeground(Color.blue);
			button.setBackground(Color.white);
			button.setOpaque(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			String label = "";
			label = label.concat(x.toString());
			label = label.concat(y.toString());
			button.setName(label);
			//unchangeable positions cannot be clicked
			if (puzzle.canBeChanged(x, y) == false)
			{
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
		//making room for the input label
		inputLabel.setLayout(new FlowLayout());
		inputLabel.setOpaque(false);
		inputLabel.setForeground(Color.white);
		inputLabel.add(label);
		JPanel inputGrid = new JPanel();
		//making the input grid
		inputGrid.setLayout(new GridLayout(3,3));
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
			button.setContentAreaFilled(false);
			button.setForeground(Color.green);
			button.setBorderPainted(false);
			button.setPreferredSize(new Dimension(40, 40));
			button.addActionListener(inputHandler);
			inputGrid.add(button);
			i++;
		}
		//input panel consists of the input grid and the input label
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(inputLabel, BorderLayout.NORTH);
		inputPanel.add(inputGrid, BorderLayout.CENTER);
		
		//making miscellaneous buttons
		JPanel miscButtons	= new JPanel();
		MiscButtonHandler miscButtonHandler = new MiscButtonHandler(puzzle, this);
		miscButtons.setLayout(new GridBagLayout());
		button = new JButton("Save");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		miscButtons.add(button);
		button = new JButton("Check");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		miscButtons.add(button);
		button = new JButton("Back");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		miscButtons.add(button);
		button = new JButton("Solve");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		miscButtons.add(button);
		button = new JButton("Reset");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		miscButtons.add(button);
		
		//creating label to indicate selected input
		JPanel inputIndicator = new JPanel();
		JLabel title = new JLabel("Selected Input:");
		title.setForeground(Color.green);
		JLabel input = new JLabel("0");
		input.setForeground(Color.green);
		inputIndicator.add(title, BorderLayout.NORTH);
		inputIndicator.add(input, BorderLayout.SOUTH);
		this.inputIndicator = input;
		
		//initializing the final frame with an image
		ImageIcon bg = new ImageIcon("sudoku/images/puzzlebackground.png");
		BackgroundPanel finalFrame = new BackgroundPanel(bg.getImage());
		sudokuGrid.setOpaque(false);
		inputPanel.setOpaque(false);
		miscButtons.setOpaque(false);
		inputIndicator.setOpaque(false);
		finalFrame.setLayout(new BorderLayout());
		//adding panels to the window
		finalFrame.add(sudokuGrid, BorderLayout.NORTH);	
		finalFrame.add(inputPanel, BorderLayout.EAST);
		finalFrame.add(miscButtons, BorderLayout.WEST);
		finalFrame.add(inputIndicator, BorderLayout.CENTER);
		finalFrame.setSize(700,700);	
		JFrame sudokuFrame = new JFrame("Sudoku - In Game");			//creating the sudoku window
		sudokuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//exit when the 'x' button is clicked
		sudokuFrame.add(finalFrame);
		sudokuFrame.pack();
		sudokuFrame.setResizable(false);
		this.sudokuGrid = sudokuFrame;
	}
	/**
	 * displays the current puzzle
	 */
	public void showPuzzle()
	{
		this.sudokuGrid.setVisible(true);
	}
	/**
	 * hides the current puzzle
	 */
	public void hidePuzzle()
	{
		this.sudokuGrid.setVisible(false);
	}
	/**
	 * initializes the start screen
	 */
	public void createStartScreen()
	{
		BackgroundPanel finalFrame = new BackgroundPanel(new ImageIcon("sudoku/images/startscreen.png").getImage());
		finalFrame.setPreferredSize(new Dimension(1000, 573));	
		finalFrame.setLayout(null);	//using absolute positioning
		JFrame startScreen = new JFrame("Sudoku - Start Screen");
		button = new JButton("Load game");
		Dimension buttonSize = button.getPreferredSize();
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.addActionListener(new StartScreenButtonHandler(this));
		button.setBounds(275, 400, buttonSize.width, buttonSize.height);
		finalFrame.add(button, BorderLayout.WEST);
		button = new JButton("New game");
		button.setBackground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false); 
		button.addActionListener(new StartScreenButtonHandler(this));
		button.setBounds(560, 400, buttonSize.width, buttonSize.height);
		finalFrame.add(button, BorderLayout.EAST);
		startScreen.add(finalFrame);
		startScreen.setSize(1000,573);
		this.startScreen = startScreen;
	}
	/**
	 * displays the start screen
	 */
	public void showStartScreen()
	{
		this.startScreen.setVisible(true);
	}
	/**
	 * hide the start screen
	 */
	public void hideStartScreen()
	{
		this.startScreen.setVisible(false);
	}
	/**
	 * @param input the input to set
	 */
	public void setInputToUse (Integer input)
	{
		this.inputToUse = input;
	}
	/**
	 * @return the input currrently selected
	 */
	public Integer getInputToUse()
	{
		return this.inputToUse;
	}
	/**
	 * @param input the required input to display
	 */
	public void setInputIndicator(String input)
	{
		this.inputIndicator.setText(input);
	}
}
